package org.devdom.service;

import org.devdom.model.dao.CategoryDao;
import org.devdom.model.dto.Category;
import java.util.List;
import javax.persistence.NoResultException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/** 
 * Clase CategoryResource.
 * 
 * @author      Carlos Vásquez Polanco
 * @version     %I%, %G%
 * @since       0.1
 */
@Path("/category")
public class CategoryResource {
    
    CategoryDao category = new CategoryDao();
    private final int PAGE_SIZE = 50;

    @GET
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public List<Category> index(){
        return category.findAll(1,PAGE_SIZE);
    }

    @GET
    @Path("/findAll/{pageNumber}")
    @Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public List<Category> findAll(@PathParam("pageNumber") @DefaultValue("1") int pageNumber) {
        return category.findAll(pageNumber, PAGE_SIZE);
    }

    
    @GET
    @Path("/findByCategoryID/{categoryId}")
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Response findByCategoryID(@PathParam("categoryId") Integer categoryId) {
        try{
            return Response.status(Response.Status.OK).entity(category.findByCategoryId(categoryId)).build();
        }catch(NoResultException ex){            
            return Response.status(Response.Status.NOT_FOUND)
                        .entity(ex.getMessage())
                        .type(MediaType.TEXT_PLAIN)
                        .build();
        }
    }
    
    @GET
    @Path("/findByCategoryName/{categoryName}")
    @Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public List<Category> findByCategoryName(@PathParam("categoryName") String categoryName){
        return category.findByCategoryName(categoryName);
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public Response count() {
        return Response.status(Response.Status.OK).entity(String.valueOf(category.count())).build();
    }
    
}