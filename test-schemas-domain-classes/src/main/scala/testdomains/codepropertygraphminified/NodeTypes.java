package testdomains.codepropertygraphminified;

import java.util.HashSet;
import java.util.Set;

public class NodeTypes {


public static final String CALL = "CALL";


public static final String METHOD = "METHOD";

public static Set<String> ALL = new HashSet<String>() {{
add(CALL);
add(METHOD);
}};

}