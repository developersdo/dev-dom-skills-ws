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
public class SkillsetQuizQuestionVotesPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "question_id")
    private int questionId;
    @Basic(optional = false)
    @Column(name = "user_id")
    private int userId;

    public SkillsetQuizQuestionVotesPK() {
    }

    public SkillsetQuizQuestionVotesPK(int questionId, int userId) {
        this.questionId = questionId;
        this.userId = userId;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
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
        hash += (int) questionId;
        hash += (int) userId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SkillsetQuizQuestionVotesPK)) {
            return false;
        }
        SkillsetQuizQuestionVotesPK other = (SkillsetQuizQuestionVotesPK) object;
        if (this.questionId != other.questionId) {
            return false;
        }
        if (this.userId != other.userId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.devdom.skills.model.dto.SkillsetQuizQuestionVotesPK[ questionId=" + questionId + ", userId=" + userId + " ]";
    }
    
}
