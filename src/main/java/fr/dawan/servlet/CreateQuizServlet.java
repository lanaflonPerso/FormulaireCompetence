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

import fr.dawan.bean.Professor;
import fr.dawan.bean.Quiz;
import fr.dawan.ctrl.CtrlQuiz;
import fr.dawan.dao.GenericDao;

@WebServlet("/professor/create_quiz")
public class CreateQuizServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String JSP = "/WEB-INF/form/CreateQuizForm.jsp";
       
    public CreateQuizServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		request.getRequestDispatcher(JSP).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name= request.getParameter("name");
		String competence= request.getParameter("competence");
		String dateDebut= request.getParameter("dateDebut");
		String dateFin= request.getParameter("dateFin");
		
		CtrlQuiz ctrl= new CtrlQuiz();
		ctrl.createQuiz(name, competence, dateDebut, dateFin);
		
		if(!ctrl.isError()) {
			Quiz quiz= ctrl.getQuiz();
			Professor prof= (Professor) request.getSession().getAttribute("user");
			quiz.setAuthor(prof); 
			
			EntityManagerFactory eef= Persistence.createEntityManagerFactory("FormulaireCompetence");
			EntityManager em= eef.createEntityManager();
			GenericDao dao= new GenericDao();
			System.out.println("quiz= "+quiz); //////////////////////////////////////////////////////////////////////
			dao.saveOrUpdate(quiz, em, true);
			
			HttpSession session = request.getSession();
			session.setAttribute("quiz", quiz);
			
			String url= request.getContextPath()+"/professor/create_quiz/question";
			response.sendRedirect( url );
			eef.close();
			return;
		} else {
			request.setAttribute("ctrl", ctrl);
			request.setAttribute("quiz", ctrl.getQuiz());
		}
		doGet(request, response);
	}
}
