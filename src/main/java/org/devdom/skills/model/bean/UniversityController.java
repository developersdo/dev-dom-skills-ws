package org.devdom.skills.model.bean;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.devdom.skills.model.dao.UniversityDao;
import org.devdom.skills.model.dto.University;

/**
 *
 * @author Carlos Vásquez Polanco
 */
@ManagedBean
@SessionScoped
public class UniversityController {

    private static final long serialVersionUID = 1L;
    private final UniversityDao dao = new UniversityDao();
    
    /**
     * Lista de universidades
     * @return 
     */
    public List<University> getUniversities(){
        return dao.findAllUniversities();
    }
}
