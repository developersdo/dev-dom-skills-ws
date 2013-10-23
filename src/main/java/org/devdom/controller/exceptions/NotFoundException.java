package org.devdom.controller.exceptions;

import com.sun.jersey.api.Responses;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import org.devdom.model.dto.ErrorHandler;

/**
 *
 * @author Carlos Vasquez Polanco
 */
public class NotFoundException extends WebApplicationException {
    
    public NotFoundException(){
        super(Responses.notFound().build());
    }
    
    public Response NotFoundException(String message, String mediaType){
        
        ErrorHandler error = new ErrorHandler();
        error.setMessage(message);

        return Response.status(Status.NOT_FOUND).entity(error).type(mediaType).build();
    }
}
