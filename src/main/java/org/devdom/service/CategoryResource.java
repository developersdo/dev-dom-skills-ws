package org.devdom.service;

import org.devdom.model.dao.CategoryDao;
import org.devdom.model.dto.Category;
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
import org.devdom.model.dto.MasterCategory;
import org.devdom.model.dto.Pagination;
import org.devdom.util.IPagination;

/** 
 * 
 * @author      Carlos Vásquez Polanco
 */
@Path("/category")
public class CategoryResource {

    private final int ROWS_PER_PAGE = IPagination.ROWS_PER_PAGE;
    private int from = 0;
    private int to = 0;
    private int rowCount = 0;
    private int currentPage = 1;
    
    CategoryDao categoryDao = new CategoryDao();
    MasterCategory masterCategory = new MasterCategory();
    
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public MasterCategory index(@HeaderParam("Accept") String acceptHeader,
                                @Context UriInfo uri){
        
        String path = categoryDao.getRealPath(uri.getAbsolutePath().toString());
        currentPage = 1;

        from = (currentPage-1)*ROWS_PER_PAGE;
        to = (from+ROWS_PER_PAGE);
        
        List<Category> category = categoryDao.findCategoriesSortById("desc");
        rowCount = category.size();
        
        to = (to>rowCount)?rowCount:to;
        
        category = category.subList(from, to);
        
        Pagination pagination = new Pagination();
        pagination.setPositionCurrentPage(currentPage);
        pagination.setRowsPerPages(ROWS_PER_PAGE);
        pagination.setResourceId(0);
        pagination.setTotalRow(rowCount);
        pagination.setDataType(acceptHeader);
        pagination.setAbsolutePath(path);
        pagination.generate();
        
        masterCategory.setCategory(category);
        masterCategory.setPagination(pagination);

        return masterCategory;
        
    }
    
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("/page/{page}")
    public MasterCategory findCategoriesByPage(@PathParam("page") @DefaultValue("1") int page,
                                                             @HeaderParam("Accept") String acceptHeader,
                                                             @Context UriInfo uri){

        String path = categoryDao.getRealPath(uri.getAbsolutePath().toString());
        currentPage = page;

        from = (currentPage-1)*ROWS_PER_PAGE;
        to = (from+ROWS_PER_PAGE);
        
        List<Category> category = categoryDao.findCategoriesSortById("desc");
        rowCount = category.size();
        
        to = (to>rowCount)?rowCount:to;
        
        category = category.subList(from, to);
        
        Pagination pagination = new Pagination();
        pagination.setPositionCurrentPage(currentPage);
        pagination.setRowsPerPages(ROWS_PER_PAGE);
        pagination.setResourceId(0);
        pagination.setTotalRow(rowCount);
        pagination.setDataType(acceptHeader);
        pagination.setAbsolutePath(path);
        pagination.generate();
        
        masterCategory.setCategory(category);
        masterCategory.setPagination(pagination);

        return masterCategory;

    }
    
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("/find/{query}")
    public MasterCategory findCategories(@PathParam("query") @DefaultValue("all") String query,
                                                             @HeaderParam("Accept") String acceptHeader,
                                                             @QueryParam("q") @DefaultValue("") String name,
                                                             @Context UriInfo uri){

        String path = categoryDao.getRealPath(uri.getAbsolutePath().toString());
        currentPage = 1;

        from = (currentPage-1)*ROWS_PER_PAGE;
        to = (from+ROWS_PER_PAGE);
        List<Category> category = null;
        
        if(query.toLowerCase().equals("all")){
            category = categoryDao.findCategoriesSortById("desc");
        }else if(query.toLowerCase().equals("name")){
            category = categoryDao.findCategoriesByName(name);
        }
        rowCount = category.size();
        
        to = (to>rowCount)?rowCount:to;
        category = category.subList(from, to);
        
        Pagination pagination = new Pagination();
        pagination.setPositionCurrentPage(currentPage);
        pagination.setRowsPerPages(ROWS_PER_PAGE);
        pagination.setTotalRow(rowCount);
        pagination.setDataType(acceptHeader);
        pagination.setAbsolutePath(path);
        pagination.generate();

        masterCategory.setCategory(category);
        masterCategory.setPagination(pagination);
        
        return masterCategory;

    }

    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("/sort-by/{field}/{sort}")
    public MasterCategory findCategoriesSortById(@PathParam("field") @DefaultValue("id") String field,
                                                 @HeaderParam("Accept") String acceptHeader,
                                                 @PathParam("sort") @DefaultValue("ASC") String sort,
                                                 @Context UriInfo uri) {
        
        String path = categoryDao.getRealPath(uri.getAbsolutePath().toString());
        currentPage = 1;

        from = (currentPage-1)*ROWS_PER_PAGE;
        to = (from+ROWS_PER_PAGE);
        List<Category> category = null;
        
        if(field.toLowerCase().equals("id")){
            category = categoryDao.findCategoriesSortById(sort);
        }else if(field.toLowerCase().equals("name")){
            category = categoryDao.findCategoriesSortByName(sort);
        }else{
            category = categoryDao.findCategoriesSortByName(sort);
        }
        
        rowCount = category.size();
        
        to = (to>rowCount)?rowCount:to;
        category = category.subList(from, to);
        
        Pagination pagination = new Pagination();
        pagination.setPositionCurrentPage(currentPage);
        pagination.setRowsPerPages(ROWS_PER_PAGE);
        pagination.setResourceId(0);
        pagination.setTotalRow(rowCount);
        pagination.setDataType(acceptHeader);
        pagination.setAbsolutePath(path);
        pagination.generate();
        
        masterCategory.setCategory(category);
        masterCategory.setPagination(pagination);
        
        return masterCategory;
        
    }
    
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("/sort-by/{field}/{sort}/page/{page}")
    public MasterCategory findCategoriesSortByIdAndPage(@PathParam("field") @DefaultValue("id") String field,
                                                 @HeaderParam("Accept") String acceptHeader,
                                                 @PathParam("sort") @DefaultValue("ASC") String sort,
                                                 @PathParam("page") @DefaultValue("1") int page,
                                                 @Context UriInfo uri) {
        
        String path = categoryDao.getRealPath(uri.getAbsolutePath().toString());
        currentPage = page;

        from = (currentPage-1)*ROWS_PER_PAGE;
        to = (from+ROWS_PER_PAGE);

        List<Category> category = null;
        
        if(field.toLowerCase().equals("id")){
            category = categoryDao.findCategoriesSortById(sort);
        }else if(field.toLowerCase().equals("name")){
            category = categoryDao.findCategoriesSortByName(sort);
        }else{
            category = categoryDao.findCategoriesSortByName(sort);
        }
        
        rowCount = category.size();
        
        to = (to>rowCount)?rowCount:to;
        category = category.subList(from, to);
        
        Pagination pagination = new Pagination();
        pagination.setPositionCurrentPage(currentPage);
        pagination.setRowsPerPages(ROWS_PER_PAGE);
        pagination.setResourceId(0);
        pagination.setTotalRow(rowCount);
        pagination.setDataType(acceptHeader);
        pagination.setAbsolutePath(path);
        pagination.generate();
        
        masterCategory.setCategory(category);
        masterCategory.setPagination(pagination);
        
        return masterCategory;
        
    }
    
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("/id/{category_id}")
    public MasterCategory findCategoryById(@PathParam("category_id") @DefaultValue("0") int categoryId,
                                    @HeaderParam("Accept") String acceptHeader,
                                    @Context UriInfo uri){
        
        String path = categoryDao.getRealPath(uri.getAbsolutePath().toString());
        currentPage = 1;

        from = (currentPage-1)*ROWS_PER_PAGE;
        to = (from+ROWS_PER_PAGE);
        
        List<Category> category = categoryDao.findCategoryById(categoryId);
        
        Pagination pagination = new Pagination();
        pagination.setPositionCurrentPage(currentPage);
        pagination.setRowsPerPages(ROWS_PER_PAGE);
        pagination.setResourceId(0);
        pagination.setTotalRow(rowCount);
        pagination.setDataType(acceptHeader);
        pagination.setAbsolutePath(path);
        pagination.generate();
        
        masterCategory.setCategory(category);
        masterCategory.setPagination(pagination);
        
        return masterCategory;

    }
}