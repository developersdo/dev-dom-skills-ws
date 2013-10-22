package org.devdom.model.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.devdom.model.dto.MasterSkillset;
import org.devdom.model.dto.Pagination;
import org.devdom.model.dto.Skills;

/**
 * Clase SkillsDao.
 * 
 * @author      Carlos Vásquez Polanco
 */
public class SkillsDao{
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
    
    MasterSkillset skillset = new MasterSkillset();
    CategoryDao category = new CategoryDao();
    private final int ROWS_PER_PAGE = 10;
    private int from = 0;
    private int to = 0;
    private int rowCount = 0;
    private int currentPage = 1;
    
    public EntityManager getEntityManager(){
        return emf.createEntityManager();
    }
    
    public MasterSkillset getSkillsByCategoryId(int id, String acceptHeader, String path) {
        
        return getSkillsByCategoryId(id,acceptHeader,path,1);
    }

    public MasterSkillset getSkillsByCategoryId(int categoryId, String acceptHeader, String path, int page){
        
        currentPage = page;
        from = (currentPage-1)*ROWS_PER_PAGE;
        to = (from+ROWS_PER_PAGE);
        
        List<Skills> skills = this.findSkillsByCategoryId(categoryId);
        rowCount = skills.size();
        
        to = (to>rowCount)?rowCount:to;
        
        skills = skills.subList(from,to); 
        
        Pagination pagination = new Pagination();
        pagination.setPositionCurrentPage(currentPage);
        pagination.setRowsPerPages(ROWS_PER_PAGE);
        pagination.setResourceId(0);
        pagination.setTotalRow(rowCount);
        pagination.setDataType(acceptHeader);
        pagination.setAbsolutePath(path);
        pagination.generate();
        
        skillset.setPagination(pagination);
        skillset.setCategory(category.findCategoryById(categoryId));
        skillset.setSkills(skills);
        
        return skillset;
        
    }

    private List<Skills> findSkillsByCategoryId(int category_id){
        
        EntityManager em = emf.createEntityManager();
        List<Skills> skills = null; 
        try{

            skills = em.createNamedQuery("Skills.findSkillsByCategoryId")
                       .setParameter("category_id",category_id)
                       .getResultList();

        }catch(Exception ex){
            ex.printStackTrace();
        }

        return skills;
    }
    
    public List<Skills> findSkillsById(int id){

        EntityManager em = emf.createEntityManager();
        
        List<Skills> skills = null; 
        
        try{
            skills = em.createNamedQuery("Skills.findSkillsById")
                 .setParameter("skill_id",id)
                 .getResultList();
         }catch(Exception ex){
            ex.printStackTrace();
        }

        return skills;

    }

}
