package org.devdom.model.dto;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Clase Skillset.
 * 
 * 
 * 
 * @author      Carlos Vásquez Polanco
 * @version     %I%, %G%
 * @since       0.1
 */
@Entity
@Table(name = "skillset_option")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Skillset.findAll", query = "SELECT s FROM Skillset s"),
    @NamedQuery(name = "Skillset.findByOptionId", query = "SELECT s FROM Skillset s WHERE s.optionId = :optionId"),
    @NamedQuery(name = "Skillset.findByName", query = "SELECT s FROM Skillset s WHERE s.name = :name"),
    @NamedQuery(name = "Skillset.findByVotes", query = "SELECT s FROM Skillset s WHERE s.votes = :votes"),
    @NamedQuery(name = "Skillset.findById", query = "SELECT s FROM Skillset s WHERE s.id = :id"),
    @NamedQuery(name = "Skillset.findByOptionCategoryId", query = "SELECT s FROM Skillset s WHERE s.optionCategoryId = :optionCategoryId"),
    @NamedQuery(name = "Skillset.findByImageIcon", query = "SELECT s FROM Skillset s WHERE s.imageIcon = :imageIcon")})
public class Skillset implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "option_id")
    private long optionId;
    @Column(name = "name")
    private String name;
    @Column(name = "votes")
    private Integer votes;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "option_category_id")
    private Integer optionCategoryId;
    @Column(name = "menu_visibility")
    private Character menuVisibility;
    @Column(name = "image_icon")
    private String imageIcon;

    public Skillset() {
    }

    public Skillset(Integer id) {
        this.id = id;
    }

    public Skillset(Integer id, long optionId) {
        this.id = id;
        this.optionId = optionId;
    }

    public long getOptionId() {
        return optionId;
    }

    public void setOptionId(long optionId) {
        this.optionId = optionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getVotes() {
        return votes;
    }

    public void setVotes(Integer votes) {
        this.votes = votes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOptionCategoryId() {
        return optionCategoryId;
    }

    public void setOptionCategoryId(Integer optionCategoryId) {
        this.optionCategoryId = optionCategoryId;
    }

    public Character getMenuVisibility() {
        return menuVisibility;
    }

    public void setMenuVisibility(Character menuVisibility) {
        this.menuVisibility = menuVisibility;
    }

    public String getImageIcon() {
        return imageIcon;
    }

    public void setImageIcon(String imageIcon) {
        this.imageIcon = imageIcon;
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
        if (!(object instanceof Skillset)) {
            return false;
        }
        Skillset other = (Skillset) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.devdom.model.Skillset[ id=" + id + " ]";
    }
    
}
