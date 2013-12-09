package org.devdom.skills.model.dto;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name = "skillset_quiz_options")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SkillsetQuizOptions.findAll", query = "SELECT s FROM SkillsetQuizOptions s"),
    @NamedQuery(name = "SkillsetQuizOptions.findById", query = "SELECT s FROM SkillsetQuizOptions s WHERE s.id = :id"),
    @NamedQuery(name = "SkillsetQuizOptions.findByName", query = "SELECT s FROM SkillsetQuizOptions s WHERE s.name = :name"),
    @NamedQuery(name = "SkillsetQuizOptions.findByQuestionId", query = "SELECT s FROM SkillsetQuizOptions s WHERE s.questionId = :questionId"),
    @NamedQuery(name = "SkillsetQuizOptions.findByOwner", query = "SELECT s FROM SkillsetQuizOptions s WHERE s.owner = :owner"),
    @NamedQuery(name = "SkillsetQuizOptions.findByParent", query = "SELECT s FROM SkillsetQuizOptions s WHERE s.parent = :parent"),
    @NamedQuery(name = "SkillsetQuizOptions.findByCreationDate", query = "SELECT s FROM SkillsetQuizOptions s WHERE s.creationDate = :creationDate")})
public class SkillsetQuizOptions implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "question_id")
    private int questionId;
    @Basic(optional = false)
    @Lob
    @Column(name = "correct")
    private byte[] correct;
    @Column(name = "owner")
    private Integer owner;
    @Basic(optional = false)
    @Lob
    @Column(name = "active")
    private byte[] active;
    @Basic(optional = false)
    @Column(name = "parent")
    private int parent;
    @Basic(optional = false)
    @Column(name = "creation_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    public SkillsetQuizOptions() {
    }

    public SkillsetQuizOptions(Integer id) {
        this.id = id;
    }

    public SkillsetQuizOptions(Integer id, int questionId, byte[] correct, byte[] active, int parent, Date creationDate) {
        this.id = id;
        this.questionId = questionId;
        this.correct = correct;
        this.active = active;
        this.parent = parent;
        this.creationDate = creationDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public byte[] getCorrect() {
        return correct;
    }

    public void setCorrect(byte[] correct) {
        this.correct = correct;
    }

    public Integer getOwner() {
        return owner;
    }

    public void setOwner(Integer owner) {
        this.owner = owner;
    }

    public byte[] getActive() {
        return active;
    }

    public void setActive(byte[] active) {
        this.active = active;
    }

    public int getParent() {
        return parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
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
        if (!(object instanceof SkillsetQuizOptions)) {
            return false;
        }
        SkillsetQuizOptions other = (SkillsetQuizOptions) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.devdom.skills.model.dto.SkillsetQuizOptions[ id=" + id + " ]";
    }
    
}
