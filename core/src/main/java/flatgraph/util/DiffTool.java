package flatgraph.util;

import flatgraph.*;
import java.util.*;

import scala.collection.IterableOnce;
import scala.jdk.javaapi.CollectionConverters;

public class DiffTool {

  /** compare two graphs element by element
   * identity of nodes is given by their id, i.e. if the graphs have the same nodes/edges/properties, but use different
   * node ids, a lot of differences will be reported and the results will be useless
   */
  public static List<String> compare(Graph graph1, Graph graph2) {
    final List<String> diff = new ArrayList<>();
    if (graph1.nodeCount() != graph2.nodeCount()) {
      diff.add(String.format("node count differs: graph1=%d, graph2=%d", graph1.nodeCount(), graph2.nodeCount()));
    }
    
    SortedSet<Long> nodeIds = new TreeSet<>();
    graph1.allNodes().foreach(node -> nodeIds.add(node.id()));
    graph2.allNodes().foreach(node -> nodeIds.add(node.id()));

    nodeIds.forEach(nodeId -> {
      final GNode node1 = graph1.node(nodeId);
      final GNode node2 = graph2.node(nodeId);
      if (node1 == null) diff.add(String.format("node %s only exists in graph2", node2));
      else if (node2 == null) diff.add(String.format("node %s only exists in graph1", node1));
      else {
        if (!node1.label().equals(node2.label()))
          diff.add(String.format("different label for nodeId=%d; graph1=%s, graph2=%s ", nodeId, node1.label(), node2.label()));

        final String context = "nodeId=" + nodeId;
        compareProperties(properties(node1), properties(node2), diff, context);
        compareEdges(outEdges(node1), outEdges(node2), diff, context + ".outE");
      }
    });

    return diff;
  }
  
  private static Iterator<Edge> outEdges(GNode node) {
    return CollectionConverters.asJava(Accessors.getEdgesOut(node).iterator());
  }

  private static Map<String, Object> properties(GNode node) {
    Map<String, Object> properties = new HashMap<>();
    CollectionConverters.asJava(Accessors.getNodeProperties(node).iterator())
            .forEachRemaining(keyValue -> properties.put(keyValue._1, keyValue._2));
    return properties;
  }

  private static void compareProperties(Map<String, Object> properties1, Map<String, Object> properties2, List<String> diff, String context) {
    SortedSet<String> propertyKeys = new TreeSet<>();
    propertyKeys.addAll(properties1.keySet());
    propertyKeys.addAll(properties2.keySet());

    propertyKeys.forEach(key ->
      compareProperty(key, properties1.get(key),properties2.get(key), diff, context)
    );
  }

  private static void compareProperty(String key, Object value1, Object value2, List<String> diff, String context) {
    if (value1 != null && value2 != null) {
      if (value1 instanceof IterableOnce<?> && value2 instanceof IterableOnce<?>) {
        if (!iterablesEqual((IterableOnce<?>) value1, (IterableOnce<?>) value2)) {
          diff.add(String.format("%s; property '%s' has different values: graph1='%s', graph2='%s'", context, key, value1, value2));
        }
      } else if (value1.getClass().isArray() && value2.getClass().isArray()) { // both values are arrays
        if (!arraysEqual(value1, value2)) {
          diff.add(String.format("%s; property '%s' has different values: graph1='%s', graph2='%s'", context, key, value1, value2));
        }
      } else if (!value1.equals(value2)) { // not both values are arrays
        diff.add(String.format("%s; property '%s' has different values: graph1='%s', graph2='%s'", context, key, value1, value2));
      }
    } else if (value1 == null && value2 != null) {
      diff.add(String.format("%s; property '%s' -> '%s' only exists in graph2", context, key, value2));
    } else if (value1 != null && value2 == null) {
      diff.add(String.format("%s; property '%s' -> '%s' only exists in graph1", context, key, value1));
    } 
  }

  private static boolean iterablesEqual(IterableOnce<?> values1, IterableOnce<?> values2) {
    scala.collection.Iterator<?> iterator1 = values1.iterator();
    scala.collection.Iterator<?> iterator2 = values2.iterator();
    while (iterator1.hasNext() || iterator2.hasNext()) {
      if ((iterator1.hasNext() && !iterator2.hasNext()) || (!iterator1.hasNext() && iterator2.hasNext()) ) {
        // different sizes
        return false;
      }

      Object value1 = iterator1.next();
      Object value2 = iterator2.next();
      if (value1 instanceof GNode && value2 instanceof GNode) {
        // special equality handling for GNodes: we don't want to override GNode.equals, which by default should take 
        // the graph into account by default - yet here we explicitly need to ignore it...
        GNode node1 = (GNode) value1;
        GNode node2 = (GNode) value2;
        if ((node1.nodeKind != node2.nodeKind) || node1.seq() != node2.seq()) {
          return false;
        }
      } else if (!value1.equals(value2)) {
        return false;
      }
    }
    return true;
  }

  /**
   * Compare given objects, assuming they are both arrays of the same type.
   * This is required because arrays don't support `.equals`, and is quite lengthy because java has one array type for each data type
   */
  public static boolean arraysEqual(Object value1, Object value2) {
    // need to check all array types unfortunately
    if (value1 instanceof Object[] && value2 instanceof Object[]) {
      return Arrays.deepEquals((Object[]) value1, (Object[]) value2);
    } else if (value1 instanceof boolean[] && value2 instanceof int[]) {
      return Arrays.equals((boolean[]) value1, (boolean[]) value2);
    } else if (value1 instanceof byte[] && value2 instanceof byte[]) {
      return Arrays.equals((byte[]) value1, (byte[]) value2);
    } else if (value1 instanceof char[] && value2 instanceof char[]) {
      return Arrays.equals((char[]) value1, (char[]) value2);
    } else if (value1 instanceof short[] && value2 instanceof short[]) {
      return Arrays.equals((short[]) value1, (short[]) value2);
    } else if (value1 instanceof int[] && value2 instanceof int[]) {
      return Arrays.equals((int[]) value1, (int[]) value2);
    } else if (value1 instanceof long[] && value2 instanceof long[]) {
      return Arrays.equals((long[]) value1, (long[]) value2);
    } else if (value1 instanceof float[] && value2 instanceof float[]) {
      return Arrays.equals((float[]) value1, (float[]) value2);
    } else if (value1 instanceof double[] && value2 instanceof double[]) {
      return Arrays.equals((double[]) value1, (double[]) value2);
    } else {
      throw new AssertionError(String.format(
        "unable to compare given objects (%s of type %s; %s of type %s)",
        value1, value1.getClass(), value2, value2.getClass()));
    }
  }

  private static void compareEdges(Iterator<Edge> edges1, Iterator<Edge> edges2, List<String> diff, String context) {
    List<Edge> edges1Sorted = sort(edges1);
    List<Edge> edges2Sorted = sort(edges2);

    if (edges1Sorted.size() != edges2Sorted.size()) {
      diff.add(String.format("%s; different number of edges: graph1=%d, graph2=%d", context, edges1Sorted.size(), edges2Sorted.size()));
    } else {
      Iterator<Edge> edges1SortedIter = edges1Sorted.iterator();
      Iterator<Edge> edges2SortedIter = edges2Sorted.iterator();
      while (edges1SortedIter.hasNext()) {
        Edge edge1 = edges1SortedIter.next();
        Edge edge2 = edges2SortedIter.next();

        if (!edge1.label().equals(edge2.label()))
          diff.add(String.format("%s; different label for sorted edges; graph1=%s, graph2=%s ", context, edge1.label(), edge2.label()));
        else {
          compareProperty("EDGE_PROPERTY", edge1.property(), edge2.property(), diff, String.format("%s; edge label = %s", context, edge1.label()));
        }
      }
    }
  }

  private static List<Edge> sort(Iterator<Edge> edges) {
    List<Edge> edgesSorted = new LinkedList();
    edges.forEachRemaining(edgesSorted::add);
    edgesSorted.sort(Comparator.comparing(edge ->
      String.format("%s %s", edge.label(), edge.property())
    ));
    return edgesSorted;
  }


}
