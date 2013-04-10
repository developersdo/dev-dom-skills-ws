package org.devdom.model.dto;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Clase Vote.
 * 
 * 
 * 
 * @author      Carlos Vásquez Polanco
 * @version     %I%, %G%
 * @since       0.1
 */
@Entity
@Table(name = "skillset_option_vote")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vote.findAll", query = "SELECT v FROM Vote v"),
    @NamedQuery(name = "Vote.findByFbOptionId", query = "SELECT v FROM Vote v WHERE v.votePK.fbOptionId = :fbOptionId"),
    @NamedQuery(name = "Vote.findByFbUid", query = "SELECT v FROM Vote v WHERE v.votePK.fbUid = :fbUid")})
public class Vote implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected VotePK votePK;

    public Vote() {
    }

    public Vote(VotePK votePK) {
        this.votePK = votePK;
    }

    public Vote(long fbOptionId, long fbUid) {
        this.votePK = new VotePK(fbOptionId, fbUid);
    }

    public VotePK getVotePK() {
        return votePK;
    }

    public void setVotePK(VotePK votePK) {
        this.votePK = votePK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (votePK != null ? votePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vote)) {
            return false;
        }
        Vote other = (Vote) object;
        if ((this.votePK == null && other.votePK != null) || (this.votePK != null && !this.votePK.equals(other.votePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.devdom.model.beans.Vote[ votePK=" + votePK + " ]";
    }
    
}
