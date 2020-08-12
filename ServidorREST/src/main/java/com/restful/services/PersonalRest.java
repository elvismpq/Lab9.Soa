/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restful.services;

import com.restful.entidades.Personal;
import com.restful.session.PersonalFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("Personal")
public class PersonalRest {
    
    @EJB
    private PersonalFacade personalFacade;
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Personal>findAll(){
    return personalFacade.findAll();
    }
    //TRAER UN ID ESPECIFICO DE LA BASE DE DATOS
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("{id}")
    public Personal findById(@PathParam("id") Integer id) {
        return personalFacade.find(id);
    }

    //BORRAR UN ID ESPECIFICO DE LA BASE DE DATOS
    @DELETE
    @Consumes({MediaType.APPLICATION_JSON})
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        personalFacade.remove(personalFacade.find(id));
        
    }

    //INSERTAR UN ELEMENTO EN LA BASE DE DATOS
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public Response create(Personal personal) {
        personalFacade.create(personal);    
        return Response.ok("Dato ingresado",MediaType.APPLICATION_JSON).build();   
  
        
        
    }

    //ACTUALIZAR UN ID ESPECIFICO DE LA BASE DE DATOS
    // DEBER
    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Path("{id}")
    public void edit(@PathParam("id") Integer id, Personal personal) {
        personal.setId(id);
        personalFacade.edit(personal);
    }
}
