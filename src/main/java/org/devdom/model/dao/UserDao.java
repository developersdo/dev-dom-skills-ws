package org.devdom.model.dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.devdom.model.beans.UserBeans;

/**
 * @author Carlos Vásquez Polanco
 */
public class UserDao implements Serializable{

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
    public UserDao(){

    }
    
    public List<UserBeans> findAll(int pageNumber,int pageSize){
        EntityManager em=emf.createEntityManager();
        try {
            return (List<UserBeans>) em.createNamedQuery("Users.findAll")
                    .setFirstResult(pageNumber*pageSize)
                    .setMaxResults(pageSize)
                    .getResultList();
        } finally {
            em.close();
        }
    }
    
    public UserBeans findByUserId(int id){
        EntityManager em = emf.createEntityManager();
        try{
            return (UserBeans) em.createNamedQuery("Users.findByUserId")
                    .setParameter("userId", id)
                    .getSingleResult();
        }finally{
            em.close();
        }
    }
    
    public List<UserBeans> findByFirstName(String firstName){
        EntityManager em = emf.createEntityManager();
        try{
            return (List<UserBeans>) em.createNamedQuery("Users.findByFirstName")
                    .setParameter("firstName",firstName)
                    .getResultList();
        }finally{
            em.close();
        }
    }
    
    public List<UserBeans> findByLastName(String lastName){
        EntityManager em = emf.createEntityManager();
        try{
            return (List<UserBeans>) em.createNamedQuery("Users.findByLastName")
                    .setParameter("lastName", lastName)
                    .getResultList();
        }finally{
            em.close();
        }
    }
    
    public String count(){
        EntityManager em = emf.createEntityManager();
        try{
            return String.valueOf(em.createNamedQuery("Users.count").getSingleResult());
        }finally{
        
        }
    }

}
