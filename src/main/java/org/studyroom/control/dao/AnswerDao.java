package org.studyroom.control.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.studyroom.model.entities.Answer;
import org.studyroom.model.entities.Question;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Federico F. Favale
 * Date: 22/04/2014
 * Time: 21:35
 * To change this template use File | Settings | File Templates.
 */
public class AnswerDao extends DataAO {
    private static AnswerDao ourInstance = new AnswerDao();

    private AnswerDao() {
    }

    public static AnswerDao getInstance() {
        return ourInstance;
    }

    public List<Answer> getAnswers(Session session) {
        return (List<Answer>) session.createCriteria(Answer.class).list();
    }

    public Answer getAnswer(Session session, long id) {
        super.beginTransaction(session);
        Query query = session.createQuery("select answer from Answer answer where answer.id= :yourid");
        query.setParameter("yourid", id);
        super.endTransaction(session);
        return (Answer) query.uniqueResult();
    }

    public void addAnswer(Session session, Answer answer) {
        super.beginTransaction(session);
        session.save(answer);
        super.endTransaction(session);
    }

    public List<Answer> getAnswers(Session session, Question question) {
        super.beginTransaction(session);
        Query query = session.createQuery("select question from Answer answer where question.answers= :yourAnswer");
        query.setParameter("yourAnswer", question);
        super.endTransaction(session);
        System.out.println((List<Answer>) session.createCriteria(Answer.class).list());
        return (List<Answer>) session.createCriteria(Answer.class).list();
    }
}
