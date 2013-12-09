package org.devdom.skills.model.dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import org.devdom.skills.util.EntityManagerFactory;
import javax.persistence.Persistence;
import org.devdom.skills.model.dto.Category;
import org.devdom.skills.model.dto.MasterCategory;
import org.devdom.skills.model.dto.Pagination;
import org.devdom.skills.util.IPagination;

/**
 * Clase CategoryDao.
 * 
 * @author      Carlos Vásquez Polanco
 */
public class CategoryDao implements Serializable {

    private final int ROWS_PER_PAGE = IPagination.ROWS_PER_PAGE;
    private final EntityManagerFactory emf;
    private final MasterCategory masterCategory = new MasterCategory();
    private int currentPage = 1;
    private int from = 0;
    private int to = 0;

    private int rowCount = 0;
    
    public CategoryDao(){
        emf = new EntityManagerFactory();
    }

    public EntityManager getEntityManager(){
        return emf.getEntityManager();
    }

    public String getRealPath(String path){
        return (path.lastIndexOf("/")==(path.length()-1))?path.substring(0, path.lastIndexOf("/")):path;
    }

    public MasterCategory getMasterCategorySortById(String sort,String acceptHeader, String url){

        return getMasterCategorySortById(sort,acceptHeader,url,1);
        
    }

    public MasterCategory getMasterCategorySortById(String sort, String acceptHeader, String url, int page){
        
        String path = getRealPath(url);
        currentPage = page;
        
        from = (currentPage-1)*ROWS_PER_PAGE;
        to = (from+ROWS_PER_PAGE);
        
        List<Category> category = findCategoriesSortById("desc");
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
    
    public MasterCategory getMasterCategorySortByName(String sort,String acceptHeader, String url){

        return getMasterCategorySortByName(sort,acceptHeader,url,1);
        
    }
    
    public MasterCategory getMasterCategorySortByName(String sort, String acceptHeader, String url, int page){
        
        String path = getRealPath(url);
        currentPage = page;

        from = (currentPage-1)*ROWS_PER_PAGE;
        to = (from+ROWS_PER_PAGE);
        
        List<Category> category = findCategoriesSortById("desc");
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

    private List<Category> findCategoriesSortById(String sort){
        EntityManager em = emf.getEntityManager();
        try{
            return (List<Category>) em.createNamedQuery("Category.findCategoriesSortById")
                    .setParameter("sort", sort)
                    .getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    private List<Category> findCategoriesSortByName(String sort){
        EntityManager em = emf.getEntityManager();
        try{
            return (List<Category>) em.createNamedQuery("Category.findCategoriesSortByName")
                    .setParameter("sort", sort)
                    .getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Category> findCategoriesByName(String name) {
        EntityManager em = emf.getEntityManager();
        try{
            return (List<Category>) em.createNamedQuery("Category.findCategoriesByName")
                    .setParameter("name",name)
                    .getResultList();
        }finally{
            if (em != null) {
                em.close();
            }
        }
    }
    
    public MasterCategory getMasterCategoryById(int categoryId, String acceptHeader, String path) {

        return this.getMasterCategoryById(categoryId, acceptHeader, path,1);
    }
    
    public MasterCategory getMasterCategoryById(int id, String acceptHeader, String path, int page){
        
        currentPage = page;
        from = (currentPage-1)*ROWS_PER_PAGE;
        to = (from+ROWS_PER_PAGE);
        
        List<Category> category = this.findCategoryById(id);
        
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
            
    public List<Category> findCategoryById(int id){
        EntityManager em = emf.getEntityManager();
        try{
            return (List<Category>) em.createNamedQuery("Category.findCategoryById")
                    .setParameter("category_id", id)
                    .getResultList();
        }finally{
            if (em != null) {
                em.close();
            }
        }
    }

}
