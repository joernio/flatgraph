package testdomains.generic;

import java.util.HashSet;
import java.util.Set;

public class PropertyNames {


public static final String INT_LIST = "int_list";


public static final String INT_MANDATORY = "int_mandatory";


public static final String INT_OPTIONAL = "int_optional";


public static final String STRING_LIST = "string_list";


public static final String STRING_MANDATORY = "string_mandatory";


public static final String STRING_OPTIONAL = "string_optional";

public static Set<String> ALL = new HashSet<String>() {{
add(INT_LIST);
add(INT_MANDATORY);
add(INT_OPTIONAL);
add(STRING_LIST);
add(STRING_MANDATORY);
add(STRING_OPTIONAL);
}};

}