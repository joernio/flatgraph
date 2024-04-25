package flatgraph.testdomains.gratefuldead;

import java.util.HashSet;
import java.util.Set;

public class NodeTypes {


public static final String Artist = "Artist";


public static final String Song = "Song";

public static Set<String> ALL = new HashSet<String>() {{
add(Artist);
add(Song);
}};

}