package org.devdom.model.dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import org.devdom.model.dto.User;

/**
 * Clase UserDao.
 * 
 * 
 * 
 * @author      Carlos Vásquez Polanco
 * @version     %I%, %G%
 * @since       0.2
 */
public class UserDao implements Serializable{

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
    private boolean persistUser = false;

    public UserDao(){
    
    }

    public EntityManager getEntityManager(){
        return emf.createEntityManager();
    }

    public UserDao(String firstName, String lastName, String picSmall, String picBig, String pic,
            String sex, String username, String picCover, String offsetY, Long uid){
            
            EntityManager em = emf.createEntityManager();
            try{
                em.getTransaction().begin();
                User user = new User(firstName,lastName,picSmall, picBig, pic,sex, username,picCover,offsetY, uid);
                user.setFirstName(firstName);
                user.setLastName(lastName);
                user.setPicSmall(picSmall);
                em.persist(user);
                em.getTransaction().commit();
                this.setPersisUser(Boolean.TRUE);
            }catch(PersistenceException ex){
                this.setPersisUser(Boolean.FALSE);
            } finally {
                if (em != null) {
                    em.close();
                }
            }
    }

    public List<User> findAll(int pageNumber,int pageSize){
        EntityManager em=emf.createEntityManager();
        try {
            return (List<User>) em.createNamedQuery("Users.findAll")
                    .setFirstResult(pageNumber*pageSize)
                    .setMaxResults(pageSize)
                    .getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public User findByUserId(int id){
        EntityManager em = emf.createEntityManager();
        try{
            return (User) em.createNamedQuery("Users.findByUserId")
                    .setParameter("userId", id)
                    .getSingleResult();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public void setPersisUser(boolean persist){
        this.persistUser = persist;
    }

    public boolean getPersistUser(){
        return this.persistUser;
    }

    public List<User> findByFirstName(String firstName){
        EntityManager em = emf.createEntityManager();
        try{
            return (List<User>) em.createNamedQuery("Users.findByFirstName")
                    .setParameter("firstName",firstName)
                    .getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public List<User> findByLastName(String lastName){
        EntityManager em = emf.createEntityManager();
        try{
            return (List<User>) em.createNamedQuery("Users.findByLastName")
                    .setParameter("lastName", lastName)
                    .getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public String count(){
        EntityManager em = emf.createEntityManager();
        try{
            return String.valueOf(em.createNamedQuery("Users.count").getSingleResult());
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

}
