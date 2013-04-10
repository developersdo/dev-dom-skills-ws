package org.devdom.service;

import java.util.List;
import javax.persistence.NoResultException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.devdom.model.dto.User;
import org.devdom.model.dao.UserDao;


/**
 * Clase UserResource.
 * 
 * Es la clase que maneja todas las llamadas a datos de usuarios,
 * dentro de esta clase se exponen todos los m�todos necesarios para manejar 
 * data de los developers.
 * 
 * Dentro de los m�todos que se exponen est�n:
 * <ul>
 * <li>findAll <a href="user/findAll">findAll</a>
 * <li>A translation origin for rendering and clipping coordinates
 * <li>The current clip
 * </ul>
 * <p>
 * 
 * 
 * @author      Carlos V�squez Polanco
 * @version     %I%, %G%
 * @since       0.4
 */
@Path("/user")
public class UserResource {
    
    UserDao user = new UserDao();
    private final int PAGE_SIZE = 50;
    
    /**
    * Evento por defecto que retorna una lista de 50 developers de los pertenecientes al grupo 
    * developers dominicanos en facebook {@link http://www.facebook.com/groups/devdominicanos/}
    * <p>
    * Este m�todo no tiene criterio de filtraci�n pero fijo solo muestra la primera p�gina.
    *
    * @return   returna una lista de tipo User que ser� formateado dependiendo del tipo de documento
    * @see      User
    */
    @GET
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public List<User> index(){
        return user.findAll(1,PAGE_SIZE);
    }

    /**
    * Retorna una lista de todos los developers pertenecientes al grupo 
    * developers dominicanos en facebook {@link http://www.facebook.com/groups/devdominicanos/}
    * <p>
    * Este m�todo no tiene criterio de filtraci�n pero si debe ser p�ginado. Solo
    * permite mostrar 50 developers por p�gina.
    *
    * @param    pageNumber especifica p�gina a ser vista
    * @return   returna una lista de tipo User que ser� formateado dependiendo del tipo de documento
    * @see      User
    */
    @GET 
    @Path("/findAll/{pageNumber}")
    @Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public List<User> findAll(@PathParam("pageNumber") @DefaultValue("1") int pageNumber) {
            return user.findAll(pageNumber,PAGE_SIZE);
    }    
    
    /**
    * findByUserID. 
    * 
    * Este m�todo se usa para traer informaci�n de un developer seg�n su ID
    * <p>
    *
    * @param    userID se especifica el ID del developer que se desea consultar
    * @return   returna una entidad conteniendo la principal informaci�n de un developer 
    * La informaci�n ser� formateado dependiendo del tipo de documento
    */
    @GET 
    @Path("/findByUserID/{userID}")
    @Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public Response findByUserID (@PathParam("userID") int userID)
    {
        try{
            return Response.status(Response.Status.OK).entity(user.findByUserId(userID)).build();
        }catch(NoResultException ex){            
            return Response.status(Response.Status.NOT_FOUND)
                        .entity(ex.getMessage())
                        .type(MediaType.TEXT_PLAIN)
                        .build();
        }
    }
    
    @GET
    @Path("/findByFirstName/{firstName}")
    @Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public List<User> findByFirstName(@PathParam("firstName") String firstName){
        return user.findByFirstName(firstName);
    }
    
    @GET
    @Path("/findByLastName/{lastName}")
    @Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public List<User> findByLastName(@PathParam("lastName") String lastName){
        return user.findByLastName(lastName);
    }
    
    @GET
    @Path("/count")
    @Produces(MediaType.TEXT_PLAIN)
    public Response count(){
        return Response.status(Response.Status.OK).entity(String.valueOf(user.count())).build();
    }
            
    @POST
    @Path("/add")
    @Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public String add(
            @QueryParam("firstName") String firstName,
            @QueryParam("lastName") String lastName,
            @QueryParam("picSmall") String picSmall,
            @QueryParam("picBig") String picBig,
            @QueryParam("pic") String pic,
            @QueryParam("sex") String sex,
            @QueryParam("username") String username,
            @QueryParam("picCover") String picCover,
            @QueryParam("offsetY") String offsetY,
            @QueryParam("uid") Long uid
            ){

        UserDao addUser = new UserDao(firstName,lastName,picSmall,picBig,pic,sex,username,picCover,offsetY,uid);

        return String.valueOf(addUser.getPersistUser());

    }

}
