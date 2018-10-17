package fr.dawan.ctrl;

import javax.servlet.http.HttpServletRequest;

import fr.dawan.bean.Question;
import fr.dawan.bean.Quiz;
import fr.dawan.bean.Response;

public class CtrlQuestionQuiz extends Ctrl{
	
	private final int LENGTH_TITLE_QUESTION_MIN= 10;
	private final int LENGTH_TITLE_QUESTION_MAX= 3000;
	
	private Question question;
	private Quiz quiz;
	private int nbrChoix;
	private String msgTitleQuestion;
	private String msgQuestion;

	public CtrlQuestionQuiz(HttpServletRequest request, Quiz quiz) {
		question= new Question();
		this.quiz= quiz;
		ctrlTitleQuestion(request.getParameter("titleQuestion"));
		question.setTitleQuestion(request.getParameter("titleQuestion"));
		ctrlChoix(request);
		System.out.println("question dans CTRL= "+question);
		this.quiz.setQuestion(question);
	}
	
	private void ctrlChoix(HttpServletRequest request) {
		boolean goodResponse= false;
		
		ctrlNbrChoix(request.getParameter("nbrChoix"));
		System.out.println("on vas rentrer dans la boucle! car error= "+error); //============================================================
		if(!error) {
			for (int i = 1; i < nbrChoix+1; i++) {
				Response res= new Response();
				res.setValue(request.getParameter("choix"+i));
				System.out.println("request.getParameter(\"choix\"+i)= "+request.getParameter("choix"+i) ); //==================================
				if(request.getParameter("checkChoix"+i) != null) {
					System.out.println("la bonne reponse est= "+"choix"+i); //=========================================================
					res.setValid(true);
					goodResponse= true;
				} else {
					res.setValid(false);
				}
				question.setResponse(res);
			}
		}
		
		if (!goodResponse) {
			msgQuestion= "il doit avoir une bonne reponse dans le questionnaire!";
			error= true;
		}
	}
	
	private void ctrlNbrChoix(String nbr) {
		System.out.println("on verifie si nbr est un nombre: "+nbr); //=================================================
		try {
			nbrChoix= Integer.valueOf(nbr);
		} catch (Exception e) {
			error= true;
		}
	}
	
	private void ctrlTitleQuestion(String titleQuestion) {
		if (titleQuestion.length() < LENGTH_TITLE_QUESTION_MIN || titleQuestion.length() > LENGTH_TITLE_QUESTION_MAX) {
			msgTitleQuestion= "doit avoir entre "+LENGTH_TITLE_QUESTION_MIN+" et "+LENGTH_TITLE_QUESTION_MAX;
			error= true;
		}
	}

	
	//********************Getters / Setters******************
	public Quiz getQuiz() {
		return quiz;
	}
	public int getNbrChoix() {
		return nbrChoix;
	}
	public String getMsgTitleQuestion() {
		return msgTitleQuestion;
	}
	public String getMsgQuestion() {
		return msgQuestion;
	}

	//********************Override***************************
	@Override
	public String toString() {
		return "CtrlQuestionQuiz [question=" + question + ", quiz="
				+ quiz + ", nbrChoix=" + nbrChoix + ", msgTitleQuestion=" + msgTitleQuestion + ", msgQuestion="
				+ msgQuestion + ", toString()=" + super.toString() + "]";
	}
}
