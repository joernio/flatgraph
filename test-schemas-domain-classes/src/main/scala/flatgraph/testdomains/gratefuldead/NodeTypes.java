package flatgraph.testdomains.gratefuldead;

import java.util.HashSet;
import java.util.Set;

public class NodeTypes {


public static final String artist = "artist";


public static final String song = "song";

public static Set<String> ALL = new HashSet<String>() {{
add(artist);
add(song);
}};

}