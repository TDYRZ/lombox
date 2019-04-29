package mytomcat;

import java.io.InputStream;

import lombok.Data;

/**
 * ����url��method
 * @author yrz
 *
 */
@Data
public class MyRequest {
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	@Override
	public String toString() {
		return "MyRequest [url=" + url + ", method=" + method + "]";
	}
	private String url;
	private String method;
	public MyRequest(InputStream inputStream)throws Exception {
		String content="";
		byte byArr[]=new byte[1024];
	   int len=0;
	   if(( len=inputStream.read(byArr)) > -1) {
		   content = new String(byArr,0,len);
	   }
	   //��ȡhttp��Ϣͷ
	   String httpHead=content.split("\n")[0];
	   //��ȡurl
		url=httpHead.split("\\s")[1];
		//��ȡ����ʽ
		method=httpHead.split("\\s")[0];
		System.out.println(this);
	}
}
