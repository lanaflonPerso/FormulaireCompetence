package fr.dawan.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.dawan.ctrl.CtrlStudent;

@WebServlet("/public/connection")
public class connectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String JPS = "/WEB-INF/form/ConnectionForm.jsp";
	
    public connectionServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("isProfessor", false);
		request.getRequestDispatcher(JPS).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email= request.getParameter("email");
		String password= request.getParameter("password");
		
		CtrlStudent ctrl= new CtrlStudent();
		ctrl.ctrlEmailAndPassword(email, password);
		if(!ctrl.isError()) {
			HttpSession session = request.getSession();
			session.setAttribute("user", ctrl.getStudent());
	
			String url= request.getContextPath()+"/student";
			response.sendRedirect( url );
			return;
		} else {
			request.setAttribute("ctrl", ctrl);	
		}
		doGet(request, response);
	}
}
