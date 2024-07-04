package testdomains.hierarchical;

import java.util.HashSet;
import java.util.Set;

public class NodeTypes {


public static final String NODE_X = "node_x";


public static final String NODE_Y = "node_y";

public static Set<String> ALL = new HashSet<String>() {{
add(NODE_X);
add(NODE_Y);
}};

}