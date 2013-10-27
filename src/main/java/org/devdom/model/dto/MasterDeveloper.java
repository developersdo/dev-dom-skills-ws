package org.devdom.model.dto;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Carlos Vásquez Polanco
 */
@Entity
@XmlRootElement
public class MasterDeveloper implements Serializable {
    
    @Id
    private final Long id = 1L;
    
    @OneToMany
    private List<Skills> skills;
    
    @OneToMany
    private List<Developer> developers;
    
    @OneToOne
    private Pagination pagination;

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @return the skills
     */
    public List<Skills> getSkills() {
        return skills;
    }

    /**
     * @param skills the skills to set
     */
    public void setSkills(List<Skills> skills) {
        this.skills = skills;
    }

    /**
     * @return the developers
     */
    public List<Developer> getDevelopers() {
        return developers;
    }

    /**
     * @param developers the developers to set
     */
    public void setDevelopers(List<Developer> developers) {
        this.developers = developers;
    }

    /**
     * @return the pagination
     */
    public Pagination getPagination() {
        return pagination;
    }

    /**
     * @param pagination the pagination to set
     */
    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }
    
    
}
