package fr.dawan.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.dawan.ctrl.CtrlProfessor;

@WebServlet("/public/connection/professor")
public class connectionProfessorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String JPS = "/WEB-INF/form/ConnectionForm.jsp";
       
    public connectionProfessorServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("isProfessor", true);
		request.getRequestDispatcher(JPS).forward(request, response);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email= request.getParameter("email");
		String password= request.getParameter("password");
		
		CtrlProfessor ctrl= new CtrlProfessor();
		ctrl.ctrlEmailAndPassword(email, password);
		if(!ctrl.isError()) {
			HttpSession session = request.getSession();
			session.setAttribute("isProfessor", true);
			session.setAttribute("isAdmin", ctrl.getProfessor().isAdministrator());
			session.setAttribute("user", ctrl.getProfessor());
	
			String url= request.getContextPath()+"/private/student";
			response.sendRedirect( url );
			return;
		} else {
			request.setAttribute("ctrl", ctrl);	
		}
		doGet(request, response);
	}

}
