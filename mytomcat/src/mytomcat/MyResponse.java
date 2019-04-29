package mytomcat;

import java.io.IOException;
import java.io.OutputStream;

/**
 * 模拟浏览器响应过程
 * 
 * @author yrz
 *
 */
public class MyResponse {
	private OutputStream outputStream;

	public MyResponse(OutputStream outputStream) {

		this.outputStream = outputStream;

	}

	public void write(String content) throws IOException {

		// outputStream.
		StringBuffer httpResponse = new StringBuffer();
		httpResponse.append("HTTP/1.1 200 OK\n").append("Content-Type:text/html\n").append("\r\n")
				.append("<html><body>").append(content).append("</body></html>");

		outputStream.write(httpResponse.toString().getBytes());
	}
}
