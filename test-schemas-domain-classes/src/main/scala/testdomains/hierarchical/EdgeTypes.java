package testdomains.hierarchical;

import java.util.HashSet;
import java.util.Set;

public class EdgeTypes {


public static final String connected_to = "connected_to";

public static Set<String> ALL = new HashSet<String>() {{
add(connected_to);
}};

}