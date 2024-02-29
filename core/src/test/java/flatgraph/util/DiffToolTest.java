//package flatgraph.util;
//
//import org.junit.Test;
//import flatgraph.Graph;
//import flatgraph.GNode;
//// TODO cleanup
////import flatgraph.testdomains.simple.SimpleDomain;
////import flatgraph.testdomains.simple.TestEdge;
////import flatgraph.testdomains.simple.TestNode;
//
//import java.util.Arrays;
//import java.util.List;
//
//import static org.junit.Assert.assertTrue;
//
//public class DiffToolTest {
//    public void returnSomeDifferencesIfOneGraphHasMoreNodeProperties() {
////        TODO reenable
//        assertTrue(false);
////        Graph graph0 = SimpleDomain.newGraph();
////        Node g0n0 = graph0.addNode(TestNode.LABEL, TestNode.INT_PROPERTY, 0);
////        Node g0n1 = graph0.addNode(TestNode.LABEL, TestNode.INT_PROPERTY, 1);
////        g0n0.addEdge(TestEdge.LABEL, g0n1, TestEdge.LONG_PROPERTY, 1l);
////
////        Graph graph1 = SimpleDomain.newGraph();
////        Node g1n0 = graph1.addNode(TestNode.LABEL);
////        Node g1n1 = graph1.addNode(TestNode.LABEL);
////        g1n0.addEdge(TestEdge.LABEL, g1n1, TestEdge.LONG_PROPERTY, 1l);
////
////        List<String> diffRes = DiffTool.compare(graph0, graph1);
////        assertTrue(!diffRes.isEmpty());
////
////        List<String> diffRes2 = DiffTool.compare(graph1, graph0);
////
////        assertTrue(!diffRes2.isEmpty());
////        // TODO: ideally we would diffRes == diffRes2 but right not it will not work as the returned strings are different
////        assertTrue(diffRes.size() == diffRes2.size());
//    }
//
//    @Test
//    public void returnSomeDifferencesIfOneGraphHasMoreEdges() {
//        assertTrue(false); 
////        TODO reenable
////        Graph graph0 = SimpleDomain.newGraph();
////        Node g0n0 = graph0.addNode(TestNode.LABEL);
////        Node g0n1 = graph0.addNode(TestNode.LABEL);
////        g0n0.addEdge(TestEdge.LABEL, g0n1, TestEdge.LONG_PROPERTY, 1l);
////
////        Graph graph1 = SimpleDomain.newGraph();
////        graph1.addNode(TestNode.LABEL);
////        graph1.addNode(TestNode.LABEL);
////
////        List<String> diffRes = DiffTool.compare(graph0, graph1);
////        assertTrue(!diffRes.isEmpty());
////
////        List<String> diffRes2 = DiffTool.compare(graph1, graph0);
////
////        assertTrue(!diffRes2.isEmpty());
////        // TODO: ideally we would diffRes == diffRes2 but right not it will not work as the returned strings are different
////        assertTrue(diffRes.size() == diffRes2.size());
//    }
//
//}
