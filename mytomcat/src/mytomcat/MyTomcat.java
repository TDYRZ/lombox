package mytomcat;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketImpl;
import java.util.HashMap;
import java.util.Map;

public class MyTomcat {

	private Map<String, String> urlServletMap = new HashMap<String, String>();
	// 指定端口
	private int port=8080;

	// 初始化端口
	public MyTomcat(int port) {
		this.port = port;
	}

	// 启动自定义tomcat
	public void startMyTomcat() {
		// 初始化自定义servlet容器
		initServletMapping();
		
		//客户端与服务端模拟通信
		
		ServerSocket serverSocket=null;
		try {
			serverSocket=new ServerSocket(port);
			System.out.println("tomcat is start");
			
			//客户端发送请求
			while(true) {
				Socket socket= serverSocket.accept();
				InputStream inputStream=	socket.getInputStream();
				OutputStream outputStream=	socket.getOutputStream();
				dispatch(new MyRequest(inputStream), new MyResponse(outputStream));
				
				socket.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
				
	}

	/**
	 * 将映射信息存放到map中 @Title: initServletMapping @Description:
	 * TODO(这里用一句话描述这个方法的作用) @param 设定文件 @author:yrz @data: 2019年4月29日
	 * 下午4:46:40 @return void 返回类型 @throws
	 */
	public void initServletMapping() {
		for (ServletMapping servletMapping : ServletMappingConfig.ServletMapping) {
			urlServletMap.put(servletMapping.getUrl(), servletMapping.getClazz());
		}
	}

	/**
	 * 请求分发给指定servlet @Title: dispatch @Description:
	 * TODO(这里用一句话描述这个方法的作用) @param @param request @param @param response
	 * 设定文件 @author:yrz @data: 2019年4月29日 下午4:49:28 @return void 返回类型 @throws
	 */
	public void dispatch(MyRequest request, MyResponse response) {
		String clazz = urlServletMap.get(request.getUrl());

		try {
			Class myServletClazz = Class.forName(clazz);
			MyServlet myServlet = (MyServlet) myServletClazz.newInstance();
			myServlet.service(request, response);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void main(String[] args) {
		new MyTomcat(8080).startMyTomcat();
	}
}
