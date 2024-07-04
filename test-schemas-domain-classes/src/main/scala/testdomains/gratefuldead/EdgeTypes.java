package testdomains.gratefuldead;

import java.util.HashSet;
import java.util.Set;

public class EdgeTypes {


public static final String FOLLOWEDBY = "followedBy";


public static final String SUNGBY = "sungBy";


public static final String WRITTENBY = "writtenBy";

public static Set<String> ALL = new HashSet<String>() {{
add(FOLLOWEDBY);
add(SUNGBY);
add(WRITTENBY);
}};

}