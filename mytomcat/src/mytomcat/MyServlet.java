package mytomcat;

public abstract class MyServlet {
	void doGet(MyRequest request, MyResponse response) {
	}

	void doPost(MyRequest request, MyResponse response) {
	}

	void service(MyRequest request, MyResponse response) {
		if (request.getMethod().equalsIgnoreCase("POST")) {

			doGet(request, response);

		} else if (request.getMethod().equalsIgnoreCase("GET")) {

			doPost(request, response);

		}
	}
}
