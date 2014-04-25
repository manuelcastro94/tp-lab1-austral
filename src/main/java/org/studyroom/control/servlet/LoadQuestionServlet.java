package org.studyroom.control.servlet;

import org.studyroom.control.HibernateUtil;
import org.studyroom.control.dao.QuestionDao;
import org.studyroom.model.question.Question;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Federico F. Favale
 * Date: 16/04/2014
 * Time: 10:45
 * To change this template use File | Settings | File Templates.
 */
public class LoadQuestionServlet extends HttpServlet {

//    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
//            throws ServletException, IOException {
//        req.setAttribute("questions", QuestionDao.getInstance().getAnswers(HibernateUtil.getGuestSession()));
//        ServletContext context = getServletContext();
//        RequestDispatcher rd = context.getRequestDispatcher("/home/home.jsp");
//        rd.forward(req, resp);
//    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        List<Question> questions1 = QuestionDao.getInstance().getQuestions(HibernateUtil.getGuestSession());
        for (Question question : questions1) {
            System.out.println(question.getAnswers());
        }

//        List<Answer> answers = AnswerDao.getInstance().getAnswers(HibernateUtil.getGuestSession());
//        List<Question> questions = new ArrayList<Question>();
//        for (Answer answer : answers){
//            if (!questions.contains(answer.getQuestion())){
//                questions.add(answer.getQuestion());
//            }
//        }
//
//        req.setAttribute("questions", questions);
//        ServletContext context = getServletContext();
//        RequestDispatcher rd = context.getRequestDispatcher("/home/home.jsp");
//        rd.forward(req, resp);


        req.setAttribute("questions", QuestionDao.getInstance().getQuestions(HibernateUtil.getGuestSession()));
        ServletContext context = getServletContext();
        RequestDispatcher rd = context.getRequestDispatcher("/home/home.jsp");
        rd.forward(req, resp);
    }
}
