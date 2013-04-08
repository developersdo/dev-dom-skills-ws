package org.devdom.controller;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.devdom.model.beans.UserBeans;
import org.devdom.model.dao.UserDao;

/**
 * Clase User.
 * 
 * Es la clase que maneja todas las llamadas a datos de usuarios,
 * dentro de esta clase se exponen todos los métodos necesarios para manejar 
 * data de los developers.
 * 
 * Dentro de los métodos que se exponen están:
 * <ul>
 * <li>findAll <a href="user/findAll">findAll</a>
 * <li>A translation origin for rendering and clipping coordinates
 * <li>The current clip
 * </ul>
 * <p>
 * 
 * 
 * @author      Carlos Vásquez Polanco
 * @version     %I%, %G%
 * @since       0.1
 */
@Path("/user")
public class User {
    
    UserDao user = new UserDao();
    private final int PAGE_SIZE = 50;
    
    /**
    * Evento por defecto que retorna una lista de 50 developers de los pertenecientes al grupo 
    * developers dominicanos en facebook {@link http://www.facebook.com/groups/devdominicanos/}
    * <p>
    * Este método no tiene criterio de filtración pero fijo solo muestra la primera página.
    *
    * @return   returna una lista de tipo UserBeans que será formateado dependiendo del tipo de documento
    * @see      UserBeans
    */
    @GET
    @Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public Response index(){
        //return user.findAll(1,PAGE_SIZE);
        return Response.status(Response.Status.OK).entity(user.findAll(1,PAGE_SIZE).toArray()).build();
    }

    /**
    * Retorna una lista de todos los developers pertenecientes al grupo 
    * developers dominicanos en facebook {@link http://www.facebook.com/groups/devdominicanos/}
    * <p>
    * Este método no tiene criterio de filtración pero si debe ser páginado. Solo
    * permite mostrar 50 developers por página.
    *
    * @param    pageNumber especifica página a ser vista
    * @return   returna una lista de tipo UserBeans que será formateado dependiendo del tipo de documento
    * @see      UserBeans
    */
    @GET 
    @Path("/findAll/{pageNumber}")
    @Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public List<UserBeans> findAll(@PathParam("pageNumber") @DefaultValue("1") int pageNumber){
        return user.findAll(pageNumber,PAGE_SIZE);
    }
    
    /**
    * findByUserID. 
    * 
    * Este método se usa para traer información de un developer según su ID
    * <p>
    *
    * @param    userID se especifica el ID del developer que se desea consultar
    * @return   returna una entidad conteniendo la principal información de un developer 
    * La información será formateado dependiendo del tipo de documento
    */
    @GET 
    @Path("/findByUserID/{userID}")
    @Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public Response findByUserID(@PathParam("userID") int userID){
        return Response.status(Response.Status.OK).entity(user.findByUserId(userID)).build();
    }
    
    @GET
    @Path("/findByFirstName/{firstName}")
    @Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public Response findByFirstName(@PathParam("firstName") String firstName){
        return Response.status(Response.Status.OK).entity(user.findByFirstName(firstName)).build();
    }
    
    @GET
    @Path("/findByFirstName/{lastName}")
    @Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public Response findByLastName(@PathParam("lastName") String lastName){
        return Response.status(Response.Status.OK).entity(user.findByFirstName(lastName)).build();
    }
    
    @GET
    @Path("/findByFirstName/{lastName}")
    @Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public Response count(@PathParam("lastName") String lastName){
        return Response.status(Response.Status.OK).entity(user.count()).build();
    }
    
}
