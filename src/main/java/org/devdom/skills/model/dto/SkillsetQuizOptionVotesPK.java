package org.devdom.skills.model.dto;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Carlos Vásquez Polanco
 */
@Embeddable
public class SkillsetQuizOptionVotesPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "option_id")
    private int optionId;
    @Basic(optional = false)
    @Column(name = "user_id")
    private int userId;

    public SkillsetQuizOptionVotesPK() {
    }

    public SkillsetQuizOptionVotesPK(int optionId, int userId) {
        this.optionId = optionId;
        this.userId = userId;
    }

    public int getOptionId() {
        return optionId;
    }

    public void setOptionId(int optionId) {
        this.optionId = optionId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) optionId;
        hash += (int) userId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SkillsetQuizOptionVotesPK)) {
            return false;
        }
        SkillsetQuizOptionVotesPK other = (SkillsetQuizOptionVotesPK) object;
        if (this.optionId != other.optionId) {
            return false;
        }
        if (this.userId != other.userId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.devdom.skills.model.dto.SkillsetQuizOptionVotesPK[ optionId=" + optionId + ", userId=" + userId + " ]";
    }
    
}
