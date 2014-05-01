package org.studyroom.model.entity;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: Federico F. Favale
 * Date: 16/04/2014
 * Time: 08:38
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "ANSWER", schema = "PUBLIC", catalog = "PUBLIC")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "ANSWER")
    private String answer;
    @ManyToOne(cascade = CascadeType.ALL)
    private Question question;
    @OneToOne
    @JoinColumn(name = "USER")
    private User user;

    public Answer(Question question, String answer, User user) {
        this.question = question;
        this.answer = answer;
        this.user = user;
        question.response(this);
    }

    public Answer() {
    }

    @Override
    public String toString() {
        return answer != null ? answer : "";
    }


     /*getters and setters*/

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
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
}
