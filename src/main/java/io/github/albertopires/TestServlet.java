package io.github.albertopires;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/**
 * Servlet implementation class EclipseServlet
 */
@WebServlet("/teste")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(TestServlet.class);
	private static int count = 0;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TestServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");

		PrintWriter out = response.getWriter();
		InputStream in  = request.getInputStream();
		try {
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Test Servlet</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Test Servlet (2017030301) at " + request.getContextPath() + "</h1>");
			out.println("<pre>");
			out.println("" + new Date());
			out.println("</pre>");
			response.setHeader("dsfail", "false");
			count++;
			int tmp_count = count;

			for (int i = 0; i < 1000; i++) {
				try {
					LOGGER.info("Waiting... " + tmp_count);
					Thread.sleep(3000);
//					out.println(" ");
//					response.flushBuffer();
					in.available();
				} catch (Exception e) {
					e.printStackTrace();
					LOGGER.info("Sleep Execption");
					return;
				}
			}
			out.println("<pre>");
			out.println("" + new Date());
			out.println("</pre>");
			out.println("</body>");
			out.println("</html>");
		} finally {
			out.close();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
