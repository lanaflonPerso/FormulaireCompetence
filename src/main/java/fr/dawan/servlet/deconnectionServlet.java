package fr.dawan.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/public/deconnection")
public class deconnectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public deconnectionServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().invalidate();
		String url= request.getContextPath()+"/public/connection";
		response.sendRedirect( url );
		return;
	}

}
