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
import org.devdom.skills.model.dao.TopDao;
import org.devdom.skills.model.dto.Top;

/**
 *
 * @author Carlos Vásquez Polanco
 */
@Path("/influencer")
public class InfluencerResource {
    
    private final TopDao dao = new TopDao();
    
    @GET
    @Path("top/general")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Top> findTop20General(@HeaderParam("Accept") String acceptHeader,
                                              @Context UriInfo uri) throws Exception{
        return dao.findTop20Devs("1");
    }
    
    @GET
    @Path("top/by/group/id/{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Top> findTop20ByGroupId(@HeaderParam("Accept") String acceptHeader,
                                @PathParam("id") String id,
                                @Context UriInfo uri) throws Exception{
        return dao.findTop20Devs(id);
    }
    
    
    
}
