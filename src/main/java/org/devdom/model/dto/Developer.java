package org.devdom.model.dto;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Carlos Vásquez Polanco
 */
@Entity
@XmlRootElement
public class Developer implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "first_name")
    private Integer firstName;

    @Column(name = "last_name")
    private Integer lastName;
    
    @Column(name = "pic_cover")
    private Integer picture;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the firstName
     */
    public Integer getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(Integer firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public Integer getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(Integer lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the picture
     */
    public Integer getPicture() {
        return picture;
    }

    /**
     * @param picture the picture to set
     */
    public void setPicture(Integer picture) {
        this.picture = picture;
    }
    
    
}
