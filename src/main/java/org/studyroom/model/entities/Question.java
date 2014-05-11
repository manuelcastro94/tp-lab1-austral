package org.studyroom.model.entities;

import org.studyroom.control.dao.TagDao;
import org.studyroom.control.utilities.HibernateUtil;

import javax.persistence.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Federico F. Favale
 * Date: 16/04/2014
 * Time: 08:42
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "QUESTION", schema = "PUBLIC", catalog = "PUBLIC")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id", nullable = false, insertable = true, updatable = true, unique = true)
    private long id;
    @Column(name = "QUESTION")
    private String question;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "CLOSED")
    private boolean closed;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Answer> answers = new LinkedList<Answer>();
    @ManyToOne(cascade = CascadeType.ALL)
    private User user;
    @ManyToMany(fetch = FetchType.LAZY, targetEntity = Tag.class, mappedBy = "questions", cascade = CascadeType.ALL)
    private List<Tag> tags = new LinkedList<Tag>();

    public Question(String title, String question, User user) {
        this.title = title;
        this.question = question;
        user.addQuestion(this);
        this.user = user;
    }

    public Question(long id, String title, String question, User user, Tag... tags) {
        this.id = id;
        this.title = title;
        this.question = question;
        user.addQuestion(this);
        this.user = user;
        addTags(tags);
        closed = false;
    }

    public Question(long id, String title, String question, User user, String... tags) {
        this.id = id;
        this.title = title;
        this.question = question;
        user.addQuestion(this);
        this.user = user;
        generateTags(tags);
        closed = false;
    }

    public Question(String title, String question, User user, String... tags) {
        this.title = title;
        this.question = question;
        user.addQuestion(this);
        this.user = user;
        generateTags(tags);
        closed = false;
    }

    public Question() {
    }

    public static void OrderByNoAnswersFirst(List<Question> questions) {
        Collections.sort(questions, new Comparator<Question>() {
            @Override
            public int compare(Question question1, Question question2) {
                return question1.getAnswers().size() - question2.getAnswers().size();
            }
        });
    }

    public static void OrderByMoreAnswersFirst(List<Question> questions) {
        Collections.sort(questions, new Comparator<Question>() {
            @Override
            public int compare(Question question1, Question question2) {
                return question2.getAnswers().size() - question1.getAnswers().size();
            }
        });
    }

    @Override
    public String toString() {
        return question != null ? user + " " + question : "";
    }

    public void response(Answer answer) {
        answers.add(answer);
    }

    public void addTags(Tag... tags) {
        for (Tag tag : tags) {
            this.tags.add(tag);
            tag.addQuestion(this);
        }
    }

    public void deleteAllTags() {
        for (Tag tag : tags) {
            tag.deleteQuestion(this);
            TagDao.getInstance().addTag(HibernateUtil.getGuestSession(), tag);
        }
        tags = new LinkedList<Tag>();
    }

    public void generateTags(String[] tags) {
        for (String strTag : tags) {
            Tag tag = new Tag(strTag);
            if (TagDao.getInstance().getTag(HibernateUtil.getGuestSession(), tag.getTag()) == null) {
                addTags(tag);
                TagDao.getInstance().addTag(HibernateUtil.getGuestSession(), tag);
            } else {
                addTags(TagDao.getInstance().getTag(HibernateUtil.getGuestSession(), tag.getTag()));
            }
        }
    }

    /*getters and setters*/

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tag) {
        this.tags = tag;
    }

}
