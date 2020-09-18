package br.com.justino.projeto7.services;

import br.com.justino.projeto7.domain.Usuario;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/usuario")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioResource {
    @Inject
    EntityManager em;

    @GET
    @Path("/all")
    public List<Usuario> getAllUsers(){
        return Usuario.listAll();
    }

    @POST
    @Transactional
    public Usuario create(@Valid Usuario usuario){
        usuario.getSenha().verificaAtualizacaoDeSenha(true,2,100);
        usuario.persistAndFlush();
        return usuario;
    }

    @GET
    public Usuario getUser(@PathParam("id") Long id){
        return Usuario.findById(id);
    }

}
