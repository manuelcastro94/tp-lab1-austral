package org.studyroom.model.entity;

import javax.persistence.*;
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
    @Column(name = "CLOSED")
    private boolean closed;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Answer> answers = new LinkedList<Answer>();
    @ManyToOne(cascade = CascadeType.ALL)
    private User user;
    @ManyToMany(fetch = FetchType.LAZY, targetEntity = Tag.class, mappedBy = "questions", cascade = CascadeType.ALL)
    private List<Tag> tags = new LinkedList<Tag>();

    public Question(String question, User user) {
        this.question = question;
        this.user = user;
    }

    public Question(String question, User user, Tag... tags) {
        this.question = question;
        this.user = user;
        addTags(tags);
        closed = false;
    }

    public Question() {
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

    /*getters and setters*/

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
