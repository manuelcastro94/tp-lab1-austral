package org.studyroom.model.entity;

import javax.persistence.*;
import java.util.LinkedList;
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
    @Column(name = "tag_id", nullable = false, insertable = true, updatable = true)
    private long id;
    @Column
    private String tag;
    @ManyToMany(fetch = FetchType.LAZY, targetEntity = Question.class, cascade = CascadeType.ALL)
    @JoinTable(name = "QUESTION_TAG", joinColumns = {@JoinColumn(name = "TAG_ID", referencedColumnName = "tag_id")}, inverseJoinColumns = {@JoinColumn(name = "QUESTION_ID", referencedColumnName = "question_id")})
    private List<Question> questions = new LinkedList<Question>();

    public Tag(String tag) {
        this.tag = tag;
    }

    public Tag() {
    }

    @Override
    public String toString() {
        return tag;
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    /*getters and setters*/

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
