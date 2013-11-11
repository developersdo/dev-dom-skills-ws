package org.devdom.skills.model.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.devdom.skills.model.dto.Resource;
import org.devdom.skills.util.IResource;

/**
 *
 * @author Carlos Vásquez Polanco
 */
@ManagedBean
@SessionScoped
public class ServiceResources implements Serializable{

    private static final long serialVersionUID = 1L;
    private final List<Resource> resource;

    public ServiceResources(){
        resource = new ArrayList<>();
        
        for(int id =0;id < IResource.URI.length;id++){
            resource.add(
                    new Resource(id,
                                IResource.finalURL(IResource.API_PATH+IResource.URI[id]),
                                IResource.URI[id],
                                IResource.getTag(IResource.URI[id]),
                                IResource.DESCRIPTION[id]));
        }
    }

    public List<Resource> getResources(){
        return resource;
    }

}