package br.com.justino.projeto7.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.CascadeType.REFRESH;

@Entity
public class Tarefa {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Long id;

    @GeneratedValue(strategy=GenerationType.AUTO)
    Long numero;

    @Column()
    String titulo;

    @Column()
    String descricao;

    @NotNull(message="O campo Usuário deve ser informado em Tarefa")
    @OneToOne(cascade = REFRESH, orphanRemoval = false)
    @JoinColumn(name="idUsuario")
    Usuario usuario;

    @Temporal(TemporalType.TIMESTAMP)
    @NotNull(message="O campo datainclusao não pode ser vazio")
    LocalDateTime datainclusao;

    @OneToMany(fetch = FetchType.LAZY, cascade=ALL, orphanRemoval=true, mappedBy="tarefa")
    @JsonIgnoreProperties("tarefa")
    List<TarefaAlteracao> alteracoes;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDateTime getDatainclusao() {
        return datainclusao;
    }

    public void setDatainclusao(LocalDateTime datainclusao) {
        this.datainclusao = datainclusao;
    }

    public List<TarefaAlteracao> getAlteracoes() {
        return alteracoes;
    }

    public void setAlteracoes(List<TarefaAlteracao> alteracoes) {
        this.alteracoes = alteracoes;
    }
}
