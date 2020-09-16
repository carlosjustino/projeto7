package br.com.justino.projeto7.services;

import br.com.justino.projeto7.domain.Tarefa;
import br.com.justino.projeto7.domain.TarefaAlteracao;
import br.com.justino.projeto7.domain.Usuario;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/tarefa")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TarefaResource {

    @GET
    public List<Tarefa> getAllTask(@PathParam("id") Long idUsuario){
        Usuario u = Usuario.findById(idUsuario);
        return Tarefa.find("Select t from Tarefa t where t.usuario = :u", u).list();
    }

    @POST
    @Transactional
    public Tarefa newTask(@Valid Tarefa tarefa){
        tarefa.getAlteracoes().add(new TarefaAlteracao(tarefa,"Inclusao", TarefaAlteracao.TIPOMOVIMENTO_INCLUSAO));
        tarefa.persistAndFlush();
        return tarefa;
    }

    @PUT
    @Transactional
    public Tarefa updateTask(@PathParam("id") Long idTarefa, @Valid Tarefa tarefanova){
        Tarefa tarefa = Tarefa.findById(idTarefa);
        tarefa.setDescricao(tarefanova.getDescricao());
        tarefa.setTitulo(tarefanova.getTitulo());
        tarefa.setConcluida(tarefanova.isConcluida());
        tarefa.getAlteracoes().add(new TarefaAlteracao(tarefa,"Alteracao da tarefa", tarefa.isConcluida() ? TarefaAlteracao.TIPOMOVIMENTO_CONCLUSAO : TarefaAlteracao.TIPOMOVIMENTO_ALTERACAO));
        return tarefa;
    }

    @GET
    public List<TarefaAlteracao> getAllChanges(@PathParam("id") Long idTarefa){
        Tarefa tarefa = Tarefa.findById(idTarefa);
        return tarefa.getAlteracoes();
    }


}
