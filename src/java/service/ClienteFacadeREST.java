/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Modelo.Cliente;
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
@Path("modelo.cliente")
public class ClienteFacadeREST extends AbstractFacade<Cliente> {

    @PersistenceContext(unitName = "TareaBimestralPU")
    private EntityManager em;

    public ClienteFacadeREST() {
        super(Cliente.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Cliente entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") String id, Cliente entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") String id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Cliente find(@PathParam("id") String id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public List<Cliente> findAll() {
        return super.findAll();
    }
    
    
    
    @POST
    @Path("crear")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public String crear (@FormParam("cedula")String cedula,@FormParam("nombre")String nombre,@FormParam("direccion")String direccion,@FormParam("correo")String correo,
            @FormParam("telefono")String telefono, @FormParam("ciudad")String ciudad,@FormParam("edad")int edad,@FormParam("joyeriaPref")int joyeriaPref) {
        Cliente ob =new Cliente(cedula, nombre, direccion, correo, telefono, ciudad, edad, joyeriaPref);
        super.create(ob);
        return "el objeto se inserto con exito";  
    }
    
    @POST
    @Path("editar")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public String editar (@FormParam("cedula")String cedula,@FormParam("nombre")String nombre,@FormParam("direccion")String direccion,@FormParam("correo")String correo,
            @FormParam("telefono")String telefono, @FormParam("ciudad")String ciudad,@FormParam("edad")int edad,@FormParam("joyeriaPref")int joyeriaPref) {
        Cliente jc = super.find(cedula);
        jc.setCedula(cedula);
        jc.setNombre(nombre);
        jc.setDireccion(direccion);
        jc.setCorreo(correo);
        jc.setTelefono(telefono);
        jc.setCiudad(ciudad);
        jc.setEdad(edad);
        jc.setJoyeriaPref(joyeriaPref);
        super.edit(jc);
           return ("se actualizo con exito");
    }
    
    @POST
    @Path("eliminar")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public String eliminar(@FormParam ("cedula")String cedula){
        Cliente jc = super.find(cedula);
        super.remove(jc);
        return "se elimino con exito";
    }
    
    @POST
    @Path("consultarJoyeria")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public List<Cliente> leerJoyeria(@FormParam("joyeriaPref")int joyeriaPref){
           TypedQuery consulta = getEntityManager().createQuery("SELECT c FROM Cliente c WHERE c.joyeriaPref = :joyeriaPref", Cliente.class);
    consulta.setParameter("joyeriaPref", joyeriaPref);
    return consulta.getResultList();
    }
    
    @POST
    @Path("consultarEdad")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public List<Cliente> leerEdad(@FormParam("edad")int edad){
           TypedQuery consulta = getEntityManager().createQuery("SELECT c FROM Cliente c WHERE c.edad = :edad", Cliente.class);
    consulta.setParameter("edad", edad);
    return consulta.getResultList();
    }
    
    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Cliente> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
