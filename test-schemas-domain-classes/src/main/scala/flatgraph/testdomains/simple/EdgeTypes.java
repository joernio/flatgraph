package flatgraph.testdomains.simple;

import java.util.HashSet;
import java.util.Set;

public class EdgeTypes {


public static final String connectedTo = "connectedTo";

public static Set<String> ALL = new HashSet<String>() {{
add(connectedTo);
}};

}