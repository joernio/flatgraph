package testdomains.gratefuldead;

import java.util.HashSet;
import java.util.Set;

public class NodeTypes {


public static final String ARTIST = "artist";


public static final String SONG = "song";

public static Set<String> ALL = new HashSet<String>() {{
add(ARTIST);
add(SONG);
}};

}