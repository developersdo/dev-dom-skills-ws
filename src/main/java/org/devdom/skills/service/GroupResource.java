package org.devdom.skills.service;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import org.devdom.skills.model.dao.GroupDao;
import org.devdom.skills.model.dto.Group;

/**
 *
 * @author Carlos Vásquez Polanco
 */
@Path("/group")
public class GroupResource {
    
    private final GroupDao dao = new GroupDao();
    
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Group> index(@HeaderParam("Accept") String acceptHeader,
                                              @Context UriInfo uri) throws Exception{
        return dao.findAllGroups();
    }
    
    @GET
    @Path("/by/id/{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Group findGroupById(@HeaderParam("Accept") String acceptHeader,
                                    @PathParam("id") String id,
                                    @Context UriInfo uri) throws Exception{
        
        return dao.findGroupById(id);
    }
    
}
