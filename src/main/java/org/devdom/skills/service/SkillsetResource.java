package org.devdom.skills.service;

import java.util.List;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import org.devdom.skills.model.dao.CategoryDao;
import org.devdom.skills.model.dao.SkillsDao;
import org.devdom.skills.model.dto.Skills;
import org.devdom.skills.model.dto.MasterSkillset;

/**
 *
 * @author Carlos Vásquez Polanco
 */

@Path("/skill")
public class SkillsetResource {

    SkillsDao skillsDao = new SkillsDao();
    CategoryDao categoryDao = new CategoryDao();
    
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public MasterSkillset findAllSkills(@HeaderParam("Accept") String acceptHeader,
                                        @Context UriInfo uri
                                        ){

        String path = categoryDao.getRealPath(uri.getAbsolutePath().toString());

        return skillsDao.getAllSkills(acceptHeader, path);

    }
    
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("page/{page}")
    public MasterSkillset findAllSkills(@HeaderParam("Accept") String acceptHeader,
                                        @PathParam("page") int page,
                                        @Context UriInfo uri
                                        ){

        String path = categoryDao.getRealPath(uri.getAbsolutePath().toString());

        return skillsDao.getAllSkills(acceptHeader, path, page);

   }
    
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("by/category/id/{id}")
    public MasterSkillset findSkillsByCategoryId(@PathParam("id") int id,
                                                 @HeaderParam("Accept") String acceptHeader,
                                                 @Context UriInfo uri
                                            ){

        String path = categoryDao.getRealPath(uri.getAbsolutePath().toString());

        return skillsDao.getSkillsByCategoryId(id, acceptHeader, path);

   }

    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("by/category/id/{id}/page/{page}")
    public MasterSkillset findSkillsByCategoryIdAndPage(@PathParam("id") int id,
                                                        @PathParam("page") @DefaultValue("1") int page,
                                                        @HeaderParam("Accept") String acceptHeader,
                                                        @Context UriInfo uri){

        String path = categoryDao.getRealPath(uri.getAbsolutePath().toString());

        return skillsDao.getSkillsByCategoryId(id, acceptHeader, path, page);
        
    }
    
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("id/{id}")
    public List<Skills> findSkillsById(@PathParam("id") int id,
                                       @HeaderParam("Accept") String acceptHeader,
                                       @Context UriInfo uri){
        
        String path = uri.getAbsolutePath().toString();
        return skillsDao.findSkillsById(id);

    }
    
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("by/developer/id/{id}")
    public MasterSkillset findSkillsByDeveloperId(@PathParam("id") int id,
                                       @HeaderParam("Accept") String acceptHeader,
                                       @Context UriInfo uri){
        
        String path = uri.getAbsolutePath().toString();
        
        return skillsDao.getSkillsByDeveloperId(id, acceptHeader, path);
        
    }
    
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("by/developer/id/{id}/page/{page}")
    public MasterSkillset findSkillsByDeveloperIdAndPage(@PathParam("id") int id,
                                       @PathParam("page") @DefaultValue("1") int page,
                                       @HeaderParam("Accept") String acceptHeader,
                                       @Context UriInfo uri){
        
        String path = uri.getAbsolutePath().toString();
        
        return skillsDao.getSkillsByDeveloperId(id, acceptHeader, path, page);
        
    }
    
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("where")
    public MasterSkillset findAllSkillsByTopFilters(@DefaultValue("0") @QueryParam("category_id") int categoryId,
                                                    @DefaultValue("0") @QueryParam("votes_gt") int votesGt,
                                                    @DefaultValue("20") @QueryParam("limit") int limit,
                                                    @HeaderParam("Accept") String acceptHeader,
                                                    @Context UriInfo uri){

        String path = uri.getAbsolutePath().toString();

        return skillsDao.getAllSkillsByTopFilters(categoryId, votesGt, limit, acceptHeader, path);

    }
    
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("where/page/{page}")
    public MasterSkillset findAllSkillsByTopFiltersAndPage(@DefaultValue("0") @QueryParam("category_id") int categoryId,
                                                    @DefaultValue("0") @QueryParam("votes_gt") int votesGt,
                                                    @DefaultValue("20") @QueryParam("limit") int limit,
                                                    @DefaultValue("1") @PathParam("page") int page,
                                                    @HeaderParam("Accept") String acceptHeader,
                                                    @Context UriInfo uri){

        String path = uri.getAbsolutePath().toString();

        return skillsDao.getAllSkillsByTopFilters(categoryId, votesGt, limit, acceptHeader, path, page);

    }

}
