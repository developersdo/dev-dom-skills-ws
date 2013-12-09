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
@Table(name = "skillset_quiz")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SkillsetQuiz.findAll", query = "SELECT s FROM SkillsetQuiz s"),
    @NamedQuery(name = "SkillsetQuiz.findByQuizId", query = "SELECT s FROM SkillsetQuiz s WHERE s.quizId = :quizId"),
    @NamedQuery(name = "SkillsetQuiz.findByName", query = "SELECT s FROM SkillsetQuiz s WHERE s.name = :name"),
    @NamedQuery(name = "SkillsetQuiz.findByCreationDate", query = "SELECT s FROM SkillsetQuiz s WHERE s.creationDate = :creationDate"),
    @NamedQuery(name = "SkillsetQuiz.findByOwner", query = "SELECT s FROM SkillsetQuiz s WHERE s.owner = :owner")})
public class SkillsetQuiz implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "quiz_id")
    private Integer quizId;
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "creation_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    @Basic(optional = false)
    @Column(name = "owner")
    private int owner;

    public SkillsetQuiz() {
    }

    public SkillsetQuiz(Integer quizId) {
        this.quizId = quizId;
    }

    public SkillsetQuiz(Integer quizId, Date creationDate, int owner) {
        this.quizId = quizId;
        this.creationDate = creationDate;
        this.owner = owner;
    }

    public Integer getQuizId() {
        return quizId;
    }

    public void setQuizId(Integer quizId) {
        this.quizId = quizId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public int getOwner() {
        return owner;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (quizId != null ? quizId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SkillsetQuiz)) {
            return false;
        }
        SkillsetQuiz other = (SkillsetQuiz) object;
        if ((this.quizId == null && other.quizId != null) || (this.quizId != null && !this.quizId.equals(other.quizId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.devdom.skills.model.dto.SkillsetQuiz[ quizId=" + quizId + " ]";
    }
    
}
