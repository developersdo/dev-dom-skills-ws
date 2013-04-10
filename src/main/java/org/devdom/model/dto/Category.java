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
 * Clase Category.
 * 
 * 
 * 
 * @author      Carlos Vásquez Polanco
 * @version     %I%, %G%
 * @since       0.1
 */
@Entity
@Table(name = "skillset_option_category")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Category.findAll", query = "SELECT c FROM Category c"),
    @NamedQuery(name = "Category.findByOptionCategoryId", query = "SELECT c FROM Category c WHERE c.optionCategoryId = :optionCategoryId"),
    @NamedQuery(name = "Category.findByName", query = "SELECT c FROM Category c WHERE c.name = :name"),
    @NamedQuery(name = "Category.findByDescCategory", query = "SELECT c FROM Category c WHERE c.descCategory = :descCategory"),
    @NamedQuery(name = "Category.findBySource", query = "SELECT c FROM Category c WHERE c.source = :source"),
    @NamedQuery(name = "Category.count", query = "SELECT count(c) FROM Category c")})
public class Category implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "option_category_id")
    private Integer optionCategoryId;
    @Column(name = "name")
    private String name;
    @Column(name = "desc_category")
    private String descCategory;
    @Column(name = "source")
    private String source;

    public Category() {
    }

    public Category(Integer optionCategoryId) {
        this.optionCategoryId = optionCategoryId;
    }

    public Integer getOptionCategoryId() {
        return optionCategoryId;
    }

    public void setOptionCategoryId(Integer optionCategoryId) {
        this.optionCategoryId = optionCategoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescCategory() {
        return descCategory;
    }

    public void setDescCategory(String descCategory) {
        this.descCategory = descCategory;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (optionCategoryId != null ? optionCategoryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Category)) {
            return false;
        }
        Category other = (Category) object;
        if ((this.optionCategoryId == null && other.optionCategoryId != null) || (this.optionCategoryId != null && !this.optionCategoryId.equals(other.optionCategoryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.devdom.model.beans.Category[ optionCategoryId=" + optionCategoryId + " ]";
    }
    
}
