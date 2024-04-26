package flatgraph.testdomains.simple;

import java.util.HashSet;
import java.util.Set;

public class PropertyNames {


public static final String intList = "intList";


public static final String intMandatory = "intMandatory";


public static final String intOptional = "intOptional";


public static final String stringList = "stringList";


public static final String stringMandatory = "stringMandatory";


public static final String stringOptional = "stringOptional";

public static Set<String> ALL = new HashSet<String>() {{
add(intList);
add(intMandatory);
add(intOptional);
add(stringList);
add(stringMandatory);
add(stringOptional);
}};

}