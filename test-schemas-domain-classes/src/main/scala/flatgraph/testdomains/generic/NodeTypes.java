package flatgraph.testdomains.generic;

import java.util.HashSet;
import java.util.Set;

public class NodeTypes {


public static final String node_a = "node_a";


public static final String node_b = "node_b";

public static Set<String> ALL = new HashSet<String>() {{
add(node_a);
add(node_b);
}};

}