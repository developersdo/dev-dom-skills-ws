package org.devdom.service;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import org.devdom.model.dao.CategoryDao;
import org.devdom.model.dao.DeveloperDao;
import org.devdom.model.dto.MasterDeveloper;

/**
 *
 * @author Carlos Vasquez
 */

@Path("/developer")
public class DeveloperResource {
    
    CategoryDao categoryDao = new CategoryDao();
    DeveloperDao developerDao = new DeveloperDao();
    
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public MasterDeveloper index(@PathParam("id") int id,
                                                 @HeaderParam("Accept") String acceptHeader,
                                                 @Context UriInfo uri
                                            ){
        
        String path = categoryDao.getRealPath(uri.getAbsolutePath().toString());
        
        return developerDao.findAllDevelopers(acceptHeader, path);
        
    }
    
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("page/{page}")
    public MasterDeveloper findAllDeveloperByPage(@PathParam("id") int id,
                                                 @PathParam("page") @DefaultValue("1") int page,
                                                 @HeaderParam("Accept") String acceptHeader,
                                                 @Context UriInfo uri
                                            ){
        
        String path = categoryDao.getRealPath(uri.getAbsolutePath().toString());

        return developerDao.findAllDevelopers(acceptHeader, path, page);
        
    }
}
