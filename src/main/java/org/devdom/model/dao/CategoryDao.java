package org.devdom.model.dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import org.devdom.controller.exceptions.NonexistentEntityException;
import org.devdom.controller.exceptions.RollbackFailureException;
import org.devdom.model.dto.Category;

/**
 * Clase CategoryDao.
 * 
 * 
 * 
 * @author      Carlos Vásquez Polanco
 * @version     %I%, %G% 
 * @since       0.1
 */
public class CategoryDao implements Serializable {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public void create(Category category) throws RollbackFailureException, Exception {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(category);
            em.getTransaction().commit();
        } catch (Exception ex) {
            try {
                em.getTransaction().rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("Hubo un error al relizar el rollback a la transaccion.", re);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Category category) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            category = em.merge(category);
            em.getTransaction().commit();
        } catch (Exception ex) {
            try {
                em.getTransaction().rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("Hubo un error al relizar el rollback a la transaccion.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = category.getOptionCategoryId();
                if (findByCategoryId(id) == null) {
                    throw new NonexistentEntityException("La categoria con el id " + id + " no existe");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void delete(Integer id) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em = getEntityManager();
            Category category;
            try {
                category = em.getReference(Category.class, id);
                category.getOptionCategoryId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("La categoria con id " + id + " no existe", enfe);
            }
            em.remove(category);
            em.getTransaction().commit();
        } catch (Exception ex) {
            try {
                em.getTransaction().rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("Hubo un error al relizar el rollback a la transaccion.", re);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Category> findAll(int pageNumber,int pageSize){
        EntityManager em = getEntityManager();
        try {
            return (List<Category>) em.createNamedQuery("Category.findAll")
                    .setFirstResult(pageNumber*pageSize)
                    .setMaxResults(pageSize)
                    .getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public Category findByCategoryId(int id){
        EntityManager em = getEntityManager();
        try{
            return (Category) em.createNamedQuery("Category.findByOptionCategoryId")
                    .setParameter("optionCategoryId", id)
                    .getSingleResult();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public List<Category> findByCategoryName(String categoryName){
        EntityManager em = getEntityManager();
        try{
            return (List<Category>) em.createNamedQuery("Category.findByName")
                    .setParameter("name", categoryName)
                    .getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public String count(){
        EntityManager em = getEntityManager();
        try{
            return String.valueOf(em.createNamedQuery("Category.count").getSingleResult());
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

}
