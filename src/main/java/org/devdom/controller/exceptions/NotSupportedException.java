package org.devdom.controller.exceptions;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

/**
 *
 * @author Carlos Vasquez Polanco
 */
public class NotSupportedException extends WebApplicationException {
    
    private static final long serialVersionUID = 4351720088030656859L;
    private int errorCode;
    private String message;

    public NotSupportedException(String message){
         super(Response.status(Status.NOT_FOUND)
                       .entity(message+"otro texto").type(MediaType.TEXT_PLAIN)
                       .build());
    }

    /**
     * @return the errorCode
     */
    public int getErrorCode() {
        return errorCode;
    }

    /**
     * @param errorCode the errorCode to set
     */
    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
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