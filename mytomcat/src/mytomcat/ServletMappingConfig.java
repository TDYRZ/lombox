package mytomcat;

import java.util.ArrayList;
import java.util.List;
/**
 * ����Ҫӳ���servlet���ƣ�·������ʵservlet��·��
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
