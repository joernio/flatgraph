package testdomains.gratefuldead;

import java.util.HashSet;
import java.util.Set;

public class PropertyNames {


public static final String NAME = "name";


public static final String PERFORMANCES = "performances";


public static final String SONGTYPE = "songType";


public static final String WEIGHT = "weight";

public static Set<String> ALL = new HashSet<String>() {{
add(NAME);
add(PERFORMANCES);
add(SONGTYPE);
add(WEIGHT);
}};

}