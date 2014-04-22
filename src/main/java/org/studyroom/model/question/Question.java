package org.studyroom.model.question;

import org.studyroom.model.answer.Answer;
import org.studyroom.model.user.User;

import javax.persistence.*;
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
    @Column(name = "ID", unique = true, nullable = false)
    private long id;
    @Basic
    @Column(name = "QUESTION")
    private String question;
    @OneToMany
    @Column(name = "ANSWERS")
    private List<Answer> answers;
    @ManyToOne
    @JoinColumn(name = "USER")
    private User user;


    public Question(String question, User user) {
        this.question = question;
        this.user = user;
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

    /*getters and setters*/

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
}
