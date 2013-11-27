package org.devdom.skills.model.dto;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Carlos Vásquez Polanco
 */
@Entity
@Table(name = "skillset_quiz_questions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SkillsetQuizQuestions.findAll", query = "SELECT s FROM SkillsetQuizQuestions s"),
    @NamedQuery(name = "SkillsetQuizQuestions.findById", query = "SELECT s FROM SkillsetQuizQuestions s WHERE s.id = :id"),
    @NamedQuery(name = "SkillsetQuizQuestions.findByQuestion", query = "SELECT s FROM SkillsetQuizQuestions s WHERE s.question = :question"),
    @NamedQuery(name = "SkillsetQuizQuestions.findByCreationDate", query = "SELECT s FROM SkillsetQuizQuestions s WHERE s.creationDate = :creationDate"),
    @NamedQuery(name = "SkillsetQuizQuestions.findBySkillId", query = "SELECT s FROM SkillsetQuizQuestions s WHERE s.skillId = :skillId"),
    @NamedQuery(name = "SkillsetQuizQuestions.findByOwner", query = "SELECT s FROM SkillsetQuizQuestions s WHERE s.owner = :owner"),
    @NamedQuery(name = "SkillsetQuizQuestions.findByParent", query = "SELECT s FROM SkillsetQuizQuestions s WHERE s.parent = :parent"),
    @NamedQuery(name = "SkillsetQuizQuestions.findByQuizzId", query = "SELECT s FROM SkillsetQuizQuestions s WHERE s.quizzId = :quizzId")})
public class SkillsetQuizQuestions implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "question")
    private String question;
    @Column(name = "creation_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    @Basic(optional = false)
    @Column(name = "skill_id")
    private int skillId;
    @Basic(optional = false)
    @Column(name = "owner")
    private int owner;
    @Basic(optional = false)
    @Column(name = "parent")
    private int parent;
    @Basic(optional = false)
    @Column(name = "quizz_id")
    private int quizzId;

    public SkillsetQuizQuestions() {
    }

    public SkillsetQuizQuestions(Integer id) {
        this.id = id;
    }

    public SkillsetQuizQuestions(Integer id, int skillId, int owner, int parent, int quizzId) {
        this.id = id;
        this.skillId = skillId;
        this.owner = owner;
        this.parent = parent;
        this.quizzId = quizzId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public int getSkillId() {
        return skillId;
    }

    public void setSkillId(int skillId) {
        this.skillId = skillId;
    }

    public int getOwner() {
        return owner;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }

    public int getParent() {
        return parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }

    public int getQuizzId() {
        return quizzId;
    }

    public void setQuizzId(int quizzId) {
        this.quizzId = quizzId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SkillsetQuizQuestions)) {
            return false;
        }
        SkillsetQuizQuestions other = (SkillsetQuizQuestions) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.devdom.skills.model.dto.SkillsetQuizQuestions[ id=" + id + " ]";
    }
    
}
