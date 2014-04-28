package org.studyroom.model.question;

import org.studyroom.model.answer.Answer;
import org.studyroom.model.user.User;

import javax.persistence.*;
import java.util.ArrayList;
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
    private long id;
    @Column(name = "QUESTION")
    private String question;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Answer> answers = new ArrayList<Answer>();
    @ManyToOne(cascade = CascadeType.ALL)
    private User user;
//    @ManyToMany
//    @JoinColumn(name = "TAG")
//    private ArrayList tag = new ArrayList();

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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
