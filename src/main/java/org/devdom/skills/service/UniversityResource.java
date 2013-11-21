package org.devdom.skills.service;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import org.devdom.skills.model.dao.CategoryDao;
import org.devdom.skills.model.dao.UniversityDao;
import org.devdom.skills.model.dto.MasterUniversity;

/**
 *
 * @author Carlos Vásquez Polanco
 */
@Path("/university")
public class UniversityResource {
    
    CategoryDao categoryDao = new CategoryDao();
    UniversityDao universityDao = new UniversityDao();
    
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public MasterUniversity findAllUniversity(@HeaderParam("Accept") String acceptHeader,
                                              @Context UriInfo uri){

        String path = categoryDao.getRealPath(uri.getAbsolutePath().toString());

        return universityDao.getAllUniversities(acceptHeader, path);

    }
    
    @GET
    @Path("page/{page}")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public MasterUniversity findAllUniversityAndPage(@HeaderParam("Accept") String acceptHeader,
                                                     @PathParam("page") int page,
                                                     @Context UriInfo uri){

        String path = categoryDao.getRealPath(uri.getAbsolutePath().toString());

        return universityDao.getAllUniversities(acceptHeader, path, page);

    }
    
}
