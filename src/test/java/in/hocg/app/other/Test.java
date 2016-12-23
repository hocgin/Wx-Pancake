package in.hocg.app.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by hocgin on 16-12-23.
 */
public class Test {
	
	@org.junit.Test
	public void t() {
		String ol = "hel";
		String[] split = ol.split("\\s+");
		
		List<String> list = new ArrayList<String>(Arrays.asList(split));
		list.remove(1);
		System.out.println("");
	}
}
