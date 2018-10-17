package fr.dawan.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.dawan.bean.Quiz;
import fr.dawan.ctrl.CtrlQuestionQuiz;

@WebServlet("/professor/create_quiz/question")
public class CreateQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String JSP = "/WEB-INF/form/InscriptionForm.jsp";
	
    public CreateQuestionServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(JSP).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Quiz quiz= (Quiz) session.getAttribute("quiz");
		
		if(quiz != null) {
//			CtrlQuestionQuiz ctrl= new CtrlQuestionQuiz(request, quiz);
		}
		
		
		doGet(request, response);
	}

}
