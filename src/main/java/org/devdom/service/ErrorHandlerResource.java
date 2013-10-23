package org.devdom.service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.devdom.controller.exceptions.NotFoundException;

/**
 *
 * @author Carlos Vasquez Polanco
 */
public class ErrorHandlerResource extends HttpServlet{
    
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        HttpServletResponse httpServletResponse = (HttpServletResponse) resp;
        
        int status = httpServletResponse.getStatus();
        String contentType = httpServletResponse.getContentType();
        throw new NotFoundException();

    }
    
}
