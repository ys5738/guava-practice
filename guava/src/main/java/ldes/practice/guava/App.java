package ldes.practice.guava;

import java.util.HashMap;
import java.util.Map;

import com.google.common.hash.Hashing;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Map<String, Object> params = new HashMap<>();
    	params.put("a", 123);
    	params.put("b", "Asc");
    	params.put("c", "asdaw123");
    	System.out.println(params.toString());
        System.out.println();
    }
}
