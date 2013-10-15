package org.devdom.service;

import org.devdom.model.dao.CategoryDao;
import org.devdom.model.dto.Category;
import java.util.List;
import javax.persistence.NoResultException;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/** 
 * Clase CategoryResource.
 * 
 * @author      Carlos Vásquez Polanco
 */
@Path("/category")
public class CategoryResource {

    CategoryDao category = new CategoryDao();
    
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public List<Category> index(){
        return category.findCategoriesSortById("desc");
    }
    
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("/find/{query}")
    public List<Category> findCategories(@PathParam("query") @DefaultValue("all") String query,
                                        @QueryParam("q") @DefaultValue("") String name){

        if(query.toLowerCase().equals("all")){
            return category.findCategoriesSortById("desc");
        }else if(query.toLowerCase().equals("name")){
            return category.findCategoriesByName(name);
        }
        return category.findCategoriesSortById("desc");

    }

    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("/sort-by/{field}/{sort}")
    public List<Category> findCategoriesSortById(@PathParam("field") @DefaultValue("id") String field,
                                                 @PathParam("sort") @DefaultValue("ASC") String sort) {

        if(field.toLowerCase().equals("id")){
            return category.findCategoriesSortById(sort);
        }else if(field.toLowerCase().equals("name")){
            return category.findCategoriesSortByName(sort);
        }
        return category.findCategoriesSortByName(sort);
        
    }
    
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("/id/{category_id}")
    public Response findCategoryById(@PathParam("category_id") @DefaultValue("0") int categoryId){
        
        try{
            return Response.ok(category.findCategoryById(categoryId)).build();
        }catch(NoResultException ex){
            return Response.status(Response.Status.NOT_FOUND)                        
                    .entity("Sin resultados")
                    .type(MediaType.TEXT_PLAIN)
                    .build();
        }
    }
}