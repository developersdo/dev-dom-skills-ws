package org.devdom.skills.model.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.devdom.skills.model.dto.MasterUniversity;
import org.devdom.skills.model.dto.Pagination;
import org.devdom.skills.model.dto.University;

/**
 *
 * @author Carlos Vàsquez Polanco
 */
public class UniversityDao {
    
    private final MasterUniversity masterUniversity = new MasterUniversity();
    private final EntityManagerFactory emf;
    private final int ROWS_PER_PAGE = 10;
    private int from = 0;
    private int to = 0;
    private int rowCount = 0;
    private int currentPage = 1;
    
    public UniversityDao(){
        emf = Persistence.createEntityManagerFactory("jpa");
    }

    public EntityManager getEntityManager(){
        return emf.createEntityManager();
    }
    
    public List<University> getUniversityById(int universityId,String acceptHeader, String path){
        return findUniversityById(universityId);
    }

    public MasterUniversity getAllUniversities(String acceptHeader, String path){
        
        return getAllUniversities(acceptHeader, path, 1);
    }

    public MasterUniversity getAllUniversities(String acceptHeader, String path, int page){
        currentPage = page;
        from = (currentPage-1)*ROWS_PER_PAGE;
        to = (from+ROWS_PER_PAGE);

        List<University> universities = findAllUniversities();
        rowCount = universities.size();

        to = (to>rowCount)?rowCount:to;

        universities = universities.subList(from,to); 

        Pagination pagination = new Pagination();
        pagination.setPositionCurrentPage(currentPage);
        pagination.setRowsPerPages(ROWS_PER_PAGE);
        pagination.setTotalRow(rowCount);
        pagination.setDataType(acceptHeader);
        pagination.setAbsolutePath(path);
        pagination.generate();

        masterUniversity.setPagination(pagination);
        masterUniversity.setUniversity(universities);

        return masterUniversity;
    }
    
    public List<University> findAllUniversities(){

        EntityManager em = emf.createEntityManager();
        List<University> universities = null; 
        try{
            universities = em.createNamedQuery("University.findAllUniversities")
                 .getResultList();
         }catch(Exception ex){
            ex.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return universities;
    }
    
    public List<University> findUniversityById(int universityId){
        EntityManager em = emf.createEntityManager();
        List<University> university = null; 
        try{
            university = em.createNamedQuery("University.findUniversityById")
                    .setParameter("university_id",universityId)
                    .getResultList();
        }catch(Exception ex){
            ex.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return university;
    }
    
    public List<University> findUniversityByDeveloperId(int developerId){
        EntityManager em = emf.createEntityManager();
        List<University> university = null;
        try{
            university = em.createNamedQuery("University.findUniversityByDeveloperId")
                    .setParameter("developer_id",developerId)
                    .getResultList();
        }catch(Exception ex){
            ex.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return university;
    }
    
}
