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

import fr.dawan.bean.Student;
import fr.dawan.ctrl.CtrlStudent;
import fr.dawan.dao.GenericDao;
import fr.dawan.helper.Token;

@WebServlet("/public/inscription")
public class InscriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String JPS = "/WEB-INF/form/InscriptionForm.jsp";
       
    public InscriptionServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(JPS).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstname= request.getParameter("firstname");
		String lastname= request.getParameter("lastname");
		String email= request.getParameter("email");
		String birthDate= request.getParameter("birthDate");
		
		CtrlStudent ctrlS= new CtrlStudent(firstname, lastname, email, birthDate);
		
		if(!ctrlS.isError()) {
			EntityManagerFactory eef= Persistence.createEntityManagerFactory("FormulaireCompetence");
			EntityManager em= eef.createEntityManager();
			GenericDao dao= new GenericDao();
			Student student= ctrlS.getStudent();
			student.setToken(Token.getToken());
			
			dao.saveOrUpdate(student, em, true);
	
			String url= request.getContextPath()+"/public/inscription/valid";
			response.sendRedirect( url );
			return;
		} else {
			request.setAttribute("ctrl", ctrlS);
			request.setAttribute("student", ctrlS.getStudent());
		}
		
		doGet(request, response);
	}

}
