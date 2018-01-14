package com.pais.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;

@Component(
	    immediate = true,
	    property = {
	        "osgi.http.whiteboard.context.path=/",
	        "osgi.http.whiteboard.servlet.name=com.pais.servlet.MiServlet",
	        "osgi.http.whiteboard.servlet.pattern=/miservlet",
	        },
	    service = Servlet.class)
public class MiServlet extends HttpServlet {
	private static final long serialVersionUID = -1970334471631842726L;

	// Invocar http://localhost:8080/o/miservlet -> [Peticion GET]
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Peticion doGet Servlet...!");
		resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Response Servlet GET</title>");
        // Enviar un Alert de JavaScript como pruba
        out.println("<script type=\"text/javascript\">");
        out.println("console.log('Mensaje desde Java a la consola del navegador...!');");
        out.println("</script>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Respuesta .. peticion doGet Servlet...!!</h1>");
        out.println("<p><%= System.out.println('Prueba de Expresiones JAVA dentro del HTML') %></p>");
        out.println("<p>Hora actual: <%= new java.util.Date()%></p>");
        out.println("<br>");
        out.println("<h2>Realizar una peticion POST</h1>");
        out.println("<hr>");
        out.println("<form action='miservlet' method='post'>");
        out.println("<lb>");
        out.println("<strong>Pais:  </strong> <input name='pais' />");
        out.println("<input type='submit' />");
        out.println("</form>");
        out.println("</body>");       
        out.println("</html>");
     }

	// Invocar http://localhost:8080/o/miservlet -> [Peticion POST]
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Peticion doPost Servlet...!");
		
		resp.setContentType("text/html");
		String pais = req.getParameter("pais");
		PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Response Servlet POST</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Respuesta .. peticion doPOST Servlet...!!</h1>");
        out.println("<hr>");
        out.println("<lb>");
        out.println("<strong>Pais:</strong>" + pais);        
        out.println("</body>");       
        out.println("</html>");
		
	}

}
