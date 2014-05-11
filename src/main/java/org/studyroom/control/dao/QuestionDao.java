package org.studyroom.control.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.studyroom.model.entity.Question;
import org.studyroom.model.entity.User;

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

    public static Question editQuestion(Question question, User user, String title, String questionStr, String[] tags) {
        question.deleteAllTags();
        question.setUser(user);
        question.setTitle(title);
        question.setQuestion(questionStr);
        question.generateTags(tags);
        return question;
    }

    public static Question makeQuestion(User user, String title, String questionStr, String[] tags) {
        return new Question(title, questionStr, user, tags);
    }

    public void addQuestion(Session session, Question question) {
        System.out.println(question.getQuestion());
        super.beginTransaction(session);
        session.save(question);
        super.endTransaction(session);
    }

    public List<Question> getQuestions(Session session) {
        return (List<Question>) session.createCriteria(Question.class).list();
    }

    public Question getQuestion(Session session, long id) {
        super.beginTransaction(session);
        Query query = session.createQuery("select question from Question question where question.id= :yourid");
        query.setParameter("yourid", id);
        super.endTransaction(session);
        return (Question) query.uniqueResult();
    }
}
