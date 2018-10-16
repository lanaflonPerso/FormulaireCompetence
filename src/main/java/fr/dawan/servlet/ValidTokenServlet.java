package fr.dawan.servlet;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.dawan.bean.Student;
import fr.dawan.ctrl.CtrlStudent;
import fr.dawan.dao.GenericDao;

@WebServlet("/public/inscription/valid")
public class ValidTokenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String JPS = "/WEB-INF/form/ValidToken.jsp";
       
    public ValidTokenServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(JPS).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String token= request.getParameter("token");
		String password= request.getParameter("password");
		String confirm= request.getParameter("confirm");

		CtrlStudent ctrl= new CtrlStudent();
		ctrl.ctrlTokenAndPassword(token, password, confirm);
		
		if(!ctrl.isError()) {
			EntityManagerFactory eef= Persistence.createEntityManagerFactory("FormulaireCompetence");
			EntityManager em= eef.createEntityManager();
			GenericDao dao= new GenericDao();
			Student student= ctrl.getStudent();
			student.setToken("");
			dao.saveOrUpdate(student, em, true);
			
			HttpSession session = request.getSession();
			session.setAttribute("user", student);
	
			String url= request.getContextPath()+"/student";
			response.sendRedirect( url );
			return;
		} else {
			request.setAttribute("ctrl", ctrl);
		}		
		doGet(request, response);
	}
}