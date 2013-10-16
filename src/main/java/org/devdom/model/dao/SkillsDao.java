package org.devdom.model.dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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
    
    public List<Skills> findSkillsByCategoryId(int category_id){
        
        EntityManager em = emf.createEntityManager();
        List<Skills> skills = null; 
        try{

            skills = em.createNamedQuery("Skills.findSkillsByCategoryId")
                       .setParameter("category_id",category_id)
                       .getResultList();                       
                        /* 
                         setMaxResults() no funciona correctamente, 
                         * ahora se creará una sub-lista,
						 * es el workaround para la
                         * delimitación de páginas a mostrar en JPA 
                         * usando stored Procedures  
                         */

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
