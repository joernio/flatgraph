package testdomains.generic;

import java.util.HashSet;
import java.util.Set;

public class NodeTypes {


public static final String NODE_A = "node_a";


public static final String NODE_B = "node_b";

public static Set<String> ALL = new HashSet<String>() {{
add(NODE_A);
add(NODE_B);
}};

}