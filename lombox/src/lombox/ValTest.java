package lombox;

import java.util.ArrayList;
import java.util.HashMap;

import lombok.val;
/**
 * val最终局部变量
 * @author yrz
 *
 */
public class ValTest {
	public String example() {
		
	    val example = new ArrayList<String>();
	    example.add("Hello, World!");
	    val foo = example.get(0);
	    return foo.toLowerCase();
	  }
	  
	  public void example2() {
	    val map = new HashMap<Integer, String>();
	    map.put(0, "zero");
	    map.put(5, "five");
	    for (val entry : map.entrySet()) {
	      System.out.printf("%d: %s\n", entry.getKey(), entry.getValue());
	    }
	  }
}
