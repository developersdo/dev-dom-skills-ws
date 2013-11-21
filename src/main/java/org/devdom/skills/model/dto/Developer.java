package org.devdom.skills.model.dto;

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
 *
 * @author Carlos Vásquez Polanco
 */
@Entity
@XmlRootElement
@NamedStoredProcedureQueries({
    @NamedStoredProcedureQuery( name="Developer.findDevelopersBySkillId", 
                                procedureName="findDevelopersBySkillId",
                                returnsResultSet=true,
                                resultClass=Developer.class,
                                parameters={@StoredProcedureParameter(queryParameter="skill_id",
                                                                      name="skill_id",
                                                                      direction=Direction.IN,
                                                                      type=String.class)}
                                ),
    @NamedStoredProcedureQuery( name="Developer.findDeveloperById", 
                                procedureName="findDeveloperById",
                                returnsResultSet=true,
                                resultClass=Developer.class,
                                parameters={@StoredProcedureParameter(queryParameter="id",
                                                                      name="developer_id",
                                                                      direction=Direction.IN,
                                                                      type=String.class)}
                                ),
    @NamedStoredProcedureQuery( name="Developer.findAllDevelopers", 
                                procedureName="findAllDevelopers",
                                returnsResultSet=true,
                                resultClass=Developer.class
                                ),
    @NamedStoredProcedureQuery( name="Developer.findAllDevelopersByFilters", 
                                procedureName="findAllDevelopersByFilters",
                                returnsResultSet=true,
                                resultClass=Developer.class,
                                parameters={@StoredProcedureParameter(queryParameter="first_name",
                                                                      name="first_name",
                                                                      direction=Direction.IN,
                                                                      type=String.class),
                                            @StoredProcedureParameter(queryParameter="last_name",
                                                                      name="last_name",
                                                                      direction=Direction.IN,
                                                                      type=String.class),
                                            @StoredProcedureParameter(queryParameter="sort",
                                                                      name="sort",
                                                                      direction=Direction.IN,
                                                                      type=String.class),
                                            @StoredProcedureParameter(queryParameter="limit",
                                                                      name="limit",
                                                                      direction=Direction.IN,
                                                                      type=Integer.class)}
                                ),
    @NamedStoredProcedureQuery( name="Developer.findDevelopersByUniversityId", 
                                procedureName="findDevelopersByUniversityId",
                                returnsResultSet=true,
                                resultClass=Developer.class,
                                parameters={@StoredProcedureParameter(queryParameter="university_id",
                                                                      name="university_id",
                                                                      direction=Direction.IN,
                                                                      type=String.class)}
                                )
})
public class Developer implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;
    
    @Column(name = "pic")
    private String picture;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the picture
     */
    public String getPicture() {
        return picture;
    }

    /**
     * @param picture the picture to set
     */
    public void setPicture(String picture) {
        this.picture = picture;
    }
    
    
}
