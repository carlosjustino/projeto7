package br.com.justino.projeto7.services;

import br.com.justino.projeto7.domain.Usuario;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/usuario")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioResource {

    @GET
    public List<Usuario> getAllUsers(){
        return Usuario.listAll();
    }

    @POST
    @Transactional
    public Usuario create(@Valid Usuario usuario){
        usuario.persistAndFlush();
        return usuario;
    }

}
