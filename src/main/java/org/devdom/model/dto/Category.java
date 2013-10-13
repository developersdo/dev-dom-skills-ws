package org.devdom.model.dto;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;
import org.eclipse.persistence.annotations.Direction;
import org.eclipse.persistence.annotations.NamedStoredProcedureQueries;
import org.eclipse.persistence.annotations.NamedStoredProcedureQuery;
import org.eclipse.persistence.annotations.StoredProcedureParameter;

/**
 * Clase Category.
 * 
 * @author      Carlos Vásquez Polanco
 */
@Entity
@XmlRootElement
@NamedStoredProcedureQueries({
    @NamedStoredProcedureQuery( name="Category.findCategoriesSortById", 
                                procedureName="findCategoriesSortById",
                                returnsResultSet=true,
                                resultClass=Category.class,
                                parameters={@StoredProcedureParameter(queryParameter="sort",
                                                                      name="sort",
                                                                      direction=Direction.IN,
                                                                      type=String.class)}
                                ),
    @NamedStoredProcedureQuery( name="Category.findCategoriesSortByName", 
                                procedureName="findCategoriesSortByName",
                                returnsResultSet=true,
                                resultClass=Category.class,
                                parameters={@StoredProcedureParameter(queryParameter="sort",
                                                                      name="sort",
                                                                      direction=Direction.IN,
                                                                      type=String.class)}
                                ),
    @NamedStoredProcedureQuery(
                                name="Category.findCategoriesByName",
                                procedureName="findCategoriesByName",
                                returnsResultSet=true,
                                resultClass=Category.class,
                                parameters={@StoredProcedureParameter(queryParameter="name",
                                                                      name="name",
                                                                      direction=Direction.IN,
                                                                      type=String.class)}
                                )
})
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;

    public static Category getById(int id){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "skills")
    private Integer skills;

    public Category() {
    }

    public Category(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public Integer getSkills(){
        return skills;
    }

    public void setSkills(Integer skills){
        this.skills = skills;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Category)) {
            return false;
        }
        Category other = (Category) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.devdom.model.dto.Category[ id=" + id + " ]";
    }
    
}