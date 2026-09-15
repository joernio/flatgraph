package testdomains.generic;

import java.util.HashSet;
import java.util.Set;

public class EdgeTypes {


public static final String ANOTHER_EDGE = "another_edge";


public static final String CONNECTED_TO = "connected_to";

public static Set<String> ALL = new HashSet<String>() {{
add(ANOTHER_EDGE);
add(CONNECTED_TO);
}};

}