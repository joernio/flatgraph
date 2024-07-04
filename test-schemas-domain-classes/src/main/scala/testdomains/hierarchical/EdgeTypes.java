package testdomains.hierarchical;

import java.util.HashSet;
import java.util.Set;

public class EdgeTypes {


public static final String CONNECTED_TO = "connected_to";

public static Set<String> ALL = new HashSet<String>() {{
add(CONNECTED_TO);
}};

}