package org.studyroom.model.entities;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * org.studyroom.model.entities.User: Federico F. Favale
 * Date: 04/04/2014
 * Time: 13:10
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "USER", schema = "PUBLIC", catalog = "PUBLIC")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true)
    private String email;
    @Column
    private String password;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Question> questions = new LinkedList<Question>();
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Answer> answers = new LinkedList<Answer>();
    @ElementCollection
    @CollectionTable(name = "VOTE_UP")
    @Column(name = "answerId")
    private List<Long> votedAnswersUp = new LinkedList<Long>();
    @ElementCollection
    @CollectionTable(name = "VOTE_DOWN")
    @Column(name = "answerId")
    private List<Long> votedAnswersDown = new LinkedList<Long>();
    @Column
    private int upVotes;
    @Column
    private int downVotes;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
        upVotes = 0;
        downVotes = 0;
    }

    public User() {
    }

    public void ask(Question question) {
        questions.add(question);
    }

    public void answer(Question question, Answer answer) {
        question.response(answer);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User that = (User) o;

        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = email != null ? email.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public void voteUp(Answer answer) {
        answer.voteUp();
        answer.getUser().votedUp();
        votedAnswersUp.add(answer.getId());
    }

    public void voteDown(Answer answer) {
        answer.voteDown();
        answer.getUser().votedDown();
        votedAnswersDown.add(answer.getId());
    }

    public boolean hasVoted(Answer answer) {
        return votedAnswersUp.contains(answer.getId()) || votedAnswersDown.contains(answer.getId());
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public void addAnswer(Answer answer) {
        answers.add(answer);
    }

    public void votedUp() {
        upVotes++;
    }

    public void votedDown() {
        downVotes++;
    }

    /*getters and setters*/

    public int getUpVotes() {
        return upVotes;
    }

    public void setUpVotes(int upVotes) {
        this.upVotes = upVotes;
    }

    public int getDownVotes() {
        return downVotes;
    }

    public void setDownVotes(int downVotes) {
        this.downVotes = downVotes;
    }

    public List<Long> getVotedAnswersUp() {
        return votedAnswersUp;
    }

    public void setVotedAnswersUp(List<Long> votedAnswersUp) {
        this.votedAnswersUp = votedAnswersUp;
    }

    public List<Long> getVotedAnswersDown() {
        return votedAnswersDown;
    }

    public void setVotedAnswersDown(List<Long> votedAnswersDown) {
        this.votedAnswersDown = votedAnswersDown;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
}
