package flatgraph.testdomains.gratefuldead;

import java.util.HashSet;
import java.util.Set;

public class EdgeTypes {


public static final String followedBy = "followedBy";

public static Set<String> ALL = new HashSet<String>() {{
add(followedBy);
}};

}