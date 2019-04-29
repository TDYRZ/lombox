package mytomcat;

import java.util.ArrayList;
import java.util.List;
/**
 * 设置要映射的servlet名称，路劲，真实servlet类路劲
 * @author yrz
 *
 */
public class ServletMappingConfig {
	public static List<ServletMapping> ServletMapping = new ArrayList<ServletMapping>();

	static {

		// servlet-name,url-pattern,servlet-class
		ServletMapping.add(new ServletMapping("findSon", "/son", "mytomcat.MySonServlet"));

	}
}
