package testdomains.hierarchical;

import java.util.HashSet;
import java.util.Set;

public class NodeTypes {


public static final String node_x = "node_x";


public static final String node_y = "node_y";

public static Set<String> ALL = new HashSet<String>() {{
add(node_x);
add(node_y);
}};

}