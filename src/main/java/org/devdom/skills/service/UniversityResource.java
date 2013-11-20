package org.devdom.skills.service;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
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
public class UniversityResource {
    
    CategoryDao categoryDao = new CategoryDao();
    UniversityDao universityDao = new UniversityDao();
    
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public MasterUniversity index(@HeaderParam("Accept") String acceptHeader,
                                 @Context UriInfo uri){

        String path = categoryDao.getRealPath(uri.getAbsolutePath().toString());

        return universityDao.getAllUniversities(acceptHeader, path);

    }
    
}
