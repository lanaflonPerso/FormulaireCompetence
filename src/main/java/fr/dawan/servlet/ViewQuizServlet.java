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

import fr.dawan.bean.Quiz;
import fr.dawan.dao.GenericDao;

@WebServlet("/professor/view_quiz")
public class ViewQuizServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String JSP = "/WEB-INF/view/ViewQuiz.jsp";	
	
    public ViewQuizServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("id") != null) {		
			int id= 0;
			try {
				id= Integer.valueOf(request.getParameter("id"));
				GenericDao dao= new GenericDao();
				
				EntityManagerFactory eef= Persistence.createEntityManagerFactory("FormulaireCompetence");
				EntityManager em= eef.createEntityManager();
				Quiz quiz= dao.findById(Quiz.class, id, em, false);
				request.getSession().setAttribute("quiz", quiz);
				System.out.println(quiz.getQuestions()); //====================================================
			} catch (Exception e) {
				// TODO Ajouter une redirection 404
			}
		} else {
			if(request.getSession().getAttribute("quiz") != null) {
				System.out.println("on prend celui en session!"); //======================================================
				
			} else {
				System.out.println("REDIRECTION"); //======================================================
				// TODO Ajouter une redirection 404
			}
		}
		
		request.getRequestDispatcher(JSP).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
