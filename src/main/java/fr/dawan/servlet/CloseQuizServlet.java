package fr.dawan.servlet;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.dawan.bean.Classe;
import fr.dawan.bean.Quiz;
import fr.dawan.bean.Student;
import fr.dawan.dao.ClasseDao;

@WebServlet("/professor/create_quiz/close")
public class CloseQuizServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CloseQuizServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("dans la servlet"); //=============================================
		Quiz quiz= (Quiz) request.getSession().getAttribute("quiz");
		if(quiz != null) {
			EntityManagerFactory eef= Persistence.createEntityManagerFactory("FormulaireCompetence");
			EntityManager em= eef.createEntityManager();
			ClasseDao dao= new ClasseDao();
			Classe classe= new Classe(); //=============================================
			classe.setId(3);  //=============================================
			List<Student> students= dao.findStudentById(classe, em, false); 
			for (Student student : students) {
				student.setQuiz(quiz);
				dao.saveOrUpdate(quiz, em, false);
			}
			
			em.close();
			eef.close();
			
			request.getSession().setAttribute("quiz", null);
		}
		
		String url= request.getContextPath()+"/professor/";
		response.sendRedirect( url );
		return;
	}
}
