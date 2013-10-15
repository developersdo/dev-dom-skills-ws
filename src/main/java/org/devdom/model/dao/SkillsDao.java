package org.devdom.model.dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.devdom.model.dto.Category;
import org.devdom.model.dto.Skills;

/**
 * Clase Skills.
 * 
 * @author      Carlos Vásquez Polanco
 */
public class SkillsDao implements Serializable{
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
    
    
    public EntityManager getEntityManager(){
        return emf.createEntityManager();
    }
    
    public List<Skills> findSkillsByCategoryId(int category_id, int currentPage, int rows){
        
        EntityManager em = emf.createEntityManager();
        List<Skills> skills = null; 
        try{
            int firstResult = (currentPage==1)?0:((currentPage-1)*rows)+1;
            skills = em.createNamedQuery("Skills.findSkillsByCategoryId")
                                    .setParameter("category_id",category_id)
                                    .setMaxResults(rows)
                                    .setFirstResult(firstResult)
                                    .getResultList();
        }catch(Exception ex){
            ex.printStackTrace();
        }

        return skills;
    }
    
}
