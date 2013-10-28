package org.devdom.skills.model.dto;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Carlos Vasquez Polanco
 */
@Entity
@XmlRootElement
public class ErrorHandler implements Serializable {
    
    @Id
    private final Long id = 1L;
    private String message;

    public Long getId() {
        return id;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }  
    
}
