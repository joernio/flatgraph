package flatgraph.testdomains.gratefuldead;

import java.util.HashSet;
import java.util.Set;

public class PropertyNames {


public static final String Name = "Name";


public static final String performances = "performances";


public static final String SongType = "SongType";


public static final String weight = "weight";

public static Set<String> ALL = new HashSet<String>() {{
add(Name);
add(performances);
add(SongType);
add(weight);
}};

}