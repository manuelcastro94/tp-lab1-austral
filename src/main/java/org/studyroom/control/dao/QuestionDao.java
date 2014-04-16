package org.studyroom.control.dao;

import org.hibernate.Session;
import org.studyroom.model.question.Question;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Federico F. Favale
 * Date: 16/04/2014
 * Time: 10:05
 * To change this template use File | Settings | File Templates.
 */
public class QuestionDao extends DataAO {

    private static QuestionDao ourInstance = new QuestionDao();

    private QuestionDao() {
    }

    public static QuestionDao getInstance() {
        return ourInstance;
    }

    public void addQuestion(Session session, Question question) {
        super.beginTransaction(session);
        session.save(question);
        super.endTransaction(session);
    }

    public List<Question> getQuestions(Session session) {
        return (List<Question>) session.createCriteria(Question.class).list();
    }
}
