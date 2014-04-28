package org.studyroom.control.servlet;

import org.codehaus.jackson.map.ObjectMapper;
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

        List<Question> questions = QuestionDao.getInstance().getQuestions(HibernateUtil.getGuestSession());
//        List<Answer> answers = AnswerDao.getInstance().getAnswers(HibernateUtil.getGuestSession());
//        for (Question question : questions){
//        for (Answer answer : answers){
//                if (answer.getQuestion().equals(question) && !question.getAnswers().contains(answer)){
//                    question.response(answer);
//                }
//            }
//        }
//
//        req.setAttribute("questions", questions);
//        ServletContext context = getServletContext();
//        RequestDispatcher rd = context.getRequestDispatcher("/home/home.jsp");
//        rd.forward(req, resp);

        // 2. initiate jackson mapper
        ObjectMapper mapper = new ObjectMapper();

        // 3. Convert received JSON to Article
//        Article article = mapper.readValue(json, Article.class);

        // 4. Set response type to JSON
        resp.setContentType("application/json");

        // 5. Add article to List<Article>
//        articles.add(article);

        // 6. Send List<Article> as JSON to client
//        mapper.writeValue(resp.getOutputStream(), questions);


        req.setAttribute("questions", questions);
        ServletContext context = getServletContext();
        RequestDispatcher rd = context.getRequestDispatcher("/home/home.jsp");
        rd.forward(req, resp);


    }
}
