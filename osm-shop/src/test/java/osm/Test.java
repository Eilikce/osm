package osm;

import com.eilikce.osm.util.StringUtil;

public class Test {
	public static void main(String[] args) {
		String x = "asdf";
//		Integer i = StringUtil.IntegerParse(x);
		Float i = StringUtil.FloatParse(x);
		System.out.println(i);
	}
}
