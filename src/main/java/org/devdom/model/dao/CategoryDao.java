package org.devdom.model.dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.devdom.model.dto.Category;

/**
 * Clase CategoryDao.
 * 
 * @author      Carlos Vásquez Polanco
 */
public class CategoryDao implements Serializable {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
    
    public EntityManager getEntityManager(){
        return emf.createEntityManager();
    }

    public List<Category> findCategoriesSortById(String sort){
        EntityManager em=emf.createEntityManager();
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
    
    public List<Category> findCategoriesSortByName(String sort){
        EntityManager em=emf.createEntityManager();
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
        EntityManager em=emf.createEntityManager();
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

}
