package org.devdom.skills.model.dto;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "skillset_quiz_question_votes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SkillsetQuizQuestionVotes.findAll", query = "SELECT s FROM SkillsetQuizQuestionVotes s"),
    @NamedQuery(name = "SkillsetQuizQuestionVotes.findByQuestionId", query = "SELECT s FROM SkillsetQuizQuestionVotes s WHERE s.skillsetQuizQuestionVotesPK.questionId = :questionId"),
    @NamedQuery(name = "SkillsetQuizQuestionVotes.findByUserId", query = "SELECT s FROM SkillsetQuizQuestionVotes s WHERE s.skillsetQuizQuestionVotesPK.userId = :userId"),
    @NamedQuery(name = "SkillsetQuizQuestionVotes.findByCreationDate", query = "SELECT s FROM SkillsetQuizQuestionVotes s WHERE s.creationDate = :creationDate")})
public class SkillsetQuizQuestionVotes implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SkillsetQuizQuestionVotesPK skillsetQuizQuestionVotesPK;
    @Column(name = "creation_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    public SkillsetQuizQuestionVotes() {
    }

    public SkillsetQuizQuestionVotes(SkillsetQuizQuestionVotesPK skillsetQuizQuestionVotesPK) {
        this.skillsetQuizQuestionVotesPK = skillsetQuizQuestionVotesPK;
    }

    public SkillsetQuizQuestionVotes(int questionId, int userId) {
        this.skillsetQuizQuestionVotesPK = new SkillsetQuizQuestionVotesPK(questionId, userId);
    }

    public SkillsetQuizQuestionVotesPK getSkillsetQuizQuestionVotesPK() {
        return skillsetQuizQuestionVotesPK;
    }

    public void setSkillsetQuizQuestionVotesPK(SkillsetQuizQuestionVotesPK skillsetQuizQuestionVotesPK) {
        this.skillsetQuizQuestionVotesPK = skillsetQuizQuestionVotesPK;
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
        hash += (skillsetQuizQuestionVotesPK != null ? skillsetQuizQuestionVotesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SkillsetQuizQuestionVotes)) {
            return false;
        }
        SkillsetQuizQuestionVotes other = (SkillsetQuizQuestionVotes) object;
        if ((this.skillsetQuizQuestionVotesPK == null && other.skillsetQuizQuestionVotesPK != null) || (this.skillsetQuizQuestionVotesPK != null && !this.skillsetQuizQuestionVotesPK.equals(other.skillsetQuizQuestionVotesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.devdom.skills.model.dto.SkillsetQuizQuestionVotes[ skillsetQuizQuestionVotesPK=" + skillsetQuizQuestionVotesPK + " ]";
    }
    
}
