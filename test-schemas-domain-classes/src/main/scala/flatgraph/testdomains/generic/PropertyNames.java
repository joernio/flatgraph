package flatgraph.testdomains.generic;

import java.util.HashSet;
import java.util.Set;

public class PropertyNames {


public static final String int_list = "int_list";


public static final String int_mandatory = "int_mandatory";


public static final String int_optional = "int_optional";


public static final String string_list = "string_list";


public static final String string_mandatory = "string_mandatory";


public static final String string_optional = "string_optional";

public static Set<String> ALL = new HashSet<String>() {{
add(int_list);
add(int_mandatory);
add(int_optional);
add(string_list);
add(string_mandatory);
add(string_optional);
}};

}