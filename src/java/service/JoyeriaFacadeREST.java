/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Modelo.Joyeria;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Robin
 */
@Stateless
@Path("modelo.joyeria")
public class JoyeriaFacadeREST extends AbstractFacade<Joyeria> {

    @PersistenceContext(unitName = "TareaBimestralPU")
    private EntityManager em;

    public JoyeriaFacadeREST() {
        super(Joyeria.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Joyeria entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Joyeria entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Joyeria find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public List<Joyeria> findAll() {
        return super.findAll();
    }
    
    @POST
    @Path("crear")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public String crear (@FormParam("iDJoyeria")int iDJoyeria,@FormParam("nombre")String nombre,@FormParam("ubicacion")String ubicacion,@FormParam("direccion")String direccion,
            @FormParam("nombreEncargado")String nombreEncargado, @FormParam("dimension")int dimensionLocal,@FormParam("ciudad")String ciudad) {
        Joyeria ob =new Joyeria(iDJoyeria, nombre, ubicacion, direccion, nombreEncargado, dimensionLocal, ciudad);
        super.create(ob);
        return "el objeto se inserto con exito";  
    }
    
    @POST
    @Path("editar")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public String editar (@FormParam("iDJoyeria")int iDJoyeria,@FormParam("nombre")String nombre,@FormParam("ubicacion")String ubicacion,@FormParam("direccion")String direccion,
            @FormParam("nombreEncargado")String nombreEncargado, @FormParam("dimension")int dimensionLocal,@FormParam("ciudad")String ciudad) {
        Joyeria jc = super.find(iDJoyeria);
        jc.setIDJoyeria(iDJoyeria);
        jc.setNombre(nombre);
        jc.setUbicacion(ubicacion);
        jc.setDireccion(direccion);
        jc.setNombreEncargado(nombreEncargado);
        jc.setDimensionLocal(dimensionLocal);
        jc.setCiudad(ciudad);
        super.edit(jc);
           return ("se actualizo con exito");
    }
    
    @POST
    @Path("eliminar")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public String eliminar(@FormParam ("iDJoyeria")String iDJoyeria){
        Joyeria jc = super.find(iDJoyeria);
        super.remove(jc);
        return "se elimino con exito";
    }
    
    @POST
    @Path("consulJoyeriasCiu")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public List<Joyeria> leerJoyeria(@FormParam("ciudad")String ciudad){
           TypedQuery consulta = getEntityManager().createQuery("SELECT j FROM Joyeria j WHERE j.ciudad = :ciudad", Joyeria.class);
    consulta.setParameter("ciudad", ciudad);
    return consulta.getResultList();
    }
    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Joyeria> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
