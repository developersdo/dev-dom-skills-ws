package org.devdom.skills.model.dto;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
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
@Table(name = "skillset_quiz_option_votes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SkillsetQuizOptionVotes.findAll", query = "SELECT s FROM SkillsetQuizOptionVotes s"),
    @NamedQuery(name = "SkillsetQuizOptionVotes.findByOptionId", query = "SELECT s FROM SkillsetQuizOptionVotes s WHERE s.skillsetQuizOptionVotesPK.optionId = :optionId"),
    @NamedQuery(name = "SkillsetQuizOptionVotes.findByUserId", query = "SELECT s FROM SkillsetQuizOptionVotes s WHERE s.skillsetQuizOptionVotesPK.userId = :userId"),
    @NamedQuery(name = "SkillsetQuizOptionVotes.findByCreationDate", query = "SELECT s FROM SkillsetQuizOptionVotes s WHERE s.creationDate = :creationDate")})
public class SkillsetQuizOptionVotes implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SkillsetQuizOptionVotesPK skillsetQuizOptionVotesPK;
    @Basic(optional = false)
    @Column(name = "creation_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    public SkillsetQuizOptionVotes() {
    }

    public SkillsetQuizOptionVotes(SkillsetQuizOptionVotesPK skillsetQuizOptionVotesPK) {
        this.skillsetQuizOptionVotesPK = skillsetQuizOptionVotesPK;
    }

    public SkillsetQuizOptionVotes(SkillsetQuizOptionVotesPK skillsetQuizOptionVotesPK, Date creationDate) {
        this.skillsetQuizOptionVotesPK = skillsetQuizOptionVotesPK;
        this.creationDate = creationDate;
    }

    public SkillsetQuizOptionVotes(int optionId, int userId) {
        this.skillsetQuizOptionVotesPK = new SkillsetQuizOptionVotesPK(optionId, userId);
    }

    public SkillsetQuizOptionVotesPK getSkillsetQuizOptionVotesPK() {
        return skillsetQuizOptionVotesPK;
    }

    public void setSkillsetQuizOptionVotesPK(SkillsetQuizOptionVotesPK skillsetQuizOptionVotesPK) {
        this.skillsetQuizOptionVotesPK = skillsetQuizOptionVotesPK;
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
        hash += (skillsetQuizOptionVotesPK != null ? skillsetQuizOptionVotesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SkillsetQuizOptionVotes)) {
            return false;
        }
        SkillsetQuizOptionVotes other = (SkillsetQuizOptionVotes) object;
        if ((this.skillsetQuizOptionVotesPK == null && other.skillsetQuizOptionVotesPK != null) || (this.skillsetQuizOptionVotesPK != null && !this.skillsetQuizOptionVotesPK.equals(other.skillsetQuizOptionVotesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.devdom.skills.model.dto.SkillsetQuizOptionVotes[ skillsetQuizOptionVotesPK=" + skillsetQuizOptionVotesPK + " ]";
    }
    
}
