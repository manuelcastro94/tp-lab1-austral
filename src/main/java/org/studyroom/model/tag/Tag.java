package org.studyroom.model.tag;

import org.studyroom.model.question.Question;

import javax.persistence.*;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Federico F. Favale
 * Date: 25/04/2014
 * Time: 16:18
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "TAG", schema = "PUBLIC", catalog = "PUBLIC")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Basic
    @Column(name = "TAG")
    private String tag;
    @ManyToMany
    @JoinColumn(name = "QUESTION")
    private List<Question> questions;

    public Tag(String tag) {
        this.tag = tag;
    }

    public Tag() {
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
