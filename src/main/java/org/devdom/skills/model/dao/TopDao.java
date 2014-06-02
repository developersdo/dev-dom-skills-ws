package org.devdom.skills.model.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.devdom.skills.model.dto.Top;

/**
 *
 * @author Carlos Vásquez Polanco
 */
public class TopDao {
    
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
    
    public TopDao(){ }

    /**
     * Top 20 de los developers más influyentes a nivel general
     * 
     * @param groupId
     * @return
     * @throws Exception 
     */
    public List<Top> findTop20Devs(String groupId) throws Exception{
        EntityManager em = emf.createEntityManager();
        try{
            return (List<Top>) em.createNamedQuery("Top.findTop20DevsInfluents")
                    .setParameter("group_id", groupId)
                    .getResultList();
        }finally{
            if(em!=null|em.isOpen())
                em.close();
            
            if(emf.isOpen())
                emf.close();
        }
    }
}
