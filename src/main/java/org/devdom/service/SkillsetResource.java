package org.devdom.service;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.devdom.model.dao.CategoryDao;
import org.devdom.model.dao.SkillsDao;
import org.devdom.model.dto.Pagination;
import org.devdom.model.dto.Skills;
import org.devdom.model.dto.Skillset;

/**
 *
 * @author Carlos Vásquez Polanco
 */

@Path("/skill")
public class SkillsetResource {
    
    Skillset skillset = new Skillset();
    SkillsDao skillsDao = new SkillsDao();
    CategoryDao category = new CategoryDao();
    private final int ROWS_PER_PAGE = 10;
    private int from = 0;
    private int to = 0;
    private int rowCount = 0;
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("by/category/id/{id}")
    public Skillset findSkillsByCategoryId(@PathParam("id") int id,
                                           @HeaderParam("Accept") String acceptHeader
                                            ){

        int currentPage = 1; //Siempre se llama la primera página desde este método

        from = (currentPage==1)?0:currentPage*ROWS_PER_PAGE;
        to = (from+ROWS_PER_PAGE);
        
        List<Skills> skills = skillsDao.findSkillsByCategoryId(id);
        rowCount = skills.size();
        
        to = (to>rowCount)?rowCount:to;
        
        skills = skills.subList(from,to); 
        Pagination pagination = new Pagination(currentPage,ROWS_PER_PAGE,id,rowCount,acceptHeader);
        
        skillset.setPagination(pagination);
        skillset.setCategory(category.findCategoryById(id));
        skillset.setSkills(skills);
        return skillset;

   }
   
}
