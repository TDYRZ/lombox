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
	// ָ���˿�
	private int port=8080;

	// ��ʼ���˿�
	public MyTomcat(int port) {
		this.port = port;
	}

	// �����Զ���tomcat
	public void startMyTomcat() {
		// ��ʼ���Զ���servlet����
		initServletMapping();
		
		//�ͻ���������ģ��ͨ��
		
		ServerSocket serverSocket=null;
		try {
			serverSocket=new ServerSocket(port);
			System.out.println("tomcat is start");
			
			//�ͻ��˷�������
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
	 * ��ӳ����Ϣ��ŵ�map�� @Title: initServletMapping @Description:
	 * TODO(������һ�仰�����������������) @param �趨�ļ� @author:yrz @data: 2019��4��29��
	 * ����4:46:40 @return void �������� @throws
	 */
	public void initServletMapping() {
		for (ServletMapping servletMapping : ServletMappingConfig.ServletMapping) {
			urlServletMap.put(servletMapping.getUrl(), servletMapping.getClazz());
		}
	}

	/**
	 * ����ַ���ָ��servlet @Title: dispatch @Description:
	 * TODO(������һ�仰�����������������) @param @param request @param @param response
	 * �趨�ļ� @author:yrz @data: 2019��4��29�� ����4:49:28 @return void �������� @throws
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
