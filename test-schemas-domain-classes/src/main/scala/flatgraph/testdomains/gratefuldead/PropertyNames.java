package flatgraph.testdomains.gratefuldead;

import java.util.HashSet;
import java.util.Set;

public class PropertyNames {


public static final String name = "name";


public static final String performances = "performances";


public static final String songType = "songType";


public static final String weight = "weight";

public static Set<String> ALL = new HashSet<String>() {{
add(name);
add(performances);
add(songType);
add(weight);
}};

}