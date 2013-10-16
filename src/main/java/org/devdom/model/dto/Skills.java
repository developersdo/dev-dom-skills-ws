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
 * Clase Skills.
 * 
 * @author      Carlos Vásquez Polanco
 */
@Entity
@XmlRootElement
@NamedStoredProcedureQueries({
    @NamedStoredProcedureQuery( name="Skills.findSkillsByCategoryId", 
                                procedureName="findSkillsByCategoryId",
                                returnsResultSet=true,
                                resultClass=Skills.class,
                                parameters={@StoredProcedureParameter(queryParameter="category_id",
                                                                      name="category_id",
                                                                      direction=Direction.IN,
                                                                      type=Integer.class)}
                                ),
    @NamedStoredProcedureQuery( name="Skills.findSkillsById", 
                                procedureName="findSkillsById",
                                returnsResultSet=true,
                                resultClass=Skills.class,
                                parameters={@StoredProcedureParameter(queryParameter="skill_id",
                                                                      name="skill_id",
                                                                      direction=Direction.IN,
                                                                      type=Integer.class)}
                                )
})
public class Skills implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "votes")
    private Integer votes;

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the votes
     */
    public Integer getVotes() {
        return votes;
    }

    /**
     * @param votes the votes to set
     */
    public void setVotes(Integer votes) {
        this.votes = votes;
    }

}
