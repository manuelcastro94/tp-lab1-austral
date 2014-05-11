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
    @Column(name = "UP")
    private int up;
    @Column(name = "DOWN")
    private int down;
    @Column(name = "MARKED")
    private boolean marked;
    @ManyToOne(cascade = CascadeType.ALL)
    private Question question;
    @OneToOne
    @JoinColumn(name = "USER")
    private User user;

    public Answer(Question question, String answer, User user) {
        this.question = question;
        this.answer = answer;
        user.addAnswer(this);
        this.user = user;
        question.response(this);
        up = 0;
        down = 0;
        marked = false;
    }

    public Answer() {
    }

    public void voteUp() {
        up++;
    }

    public void voteDown() {
        down++;
    }

    public int getDifference() {
        return up - down;
    }

    @Override
    public String toString() {
        return answer != null ? answer : "";
    }


     /*getters and setters*/

    public boolean isMarked() {
        return marked;
    }

    public void setMarked(boolean valid) {
        this.marked = valid;
    }

    public int getUp() {
        return up;
    }

    public void setUp(int up) {
        this.up = up;
    }

    public int getDown() {
        return down;
    }

    public void setDown(int down) {
        this.down = down;
    }

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
