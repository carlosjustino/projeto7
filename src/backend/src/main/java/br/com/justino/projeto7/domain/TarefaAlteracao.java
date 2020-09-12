package br.com.justino.projeto7.domain;

import br.com.justino.projeto7.validators.IntegerValues;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class TarefaAlteracao {

    public static final Integer TIPOMOVIMENTO_INCLUSAO = 1;
    public static final Integer TIPOMOVIMENTO_ALTERACAO = 2;
    public static final Integer TIPOMOVIMENTO_CONCLUSAO = 3;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Long id;

    @ManyToOne
    @JoinColumn(name="idTarefa", nullable=true)
    Tarefa tarefa;

    @NotBlank(message="O campo Descricao deve ser informado na Alteração")
    String descricao;

    @Temporal(TemporalType.TIMESTAMP)
    @NotNull(message="O campo datamovimento não pode ser vazio")
    LocalDateTime datamovimento;

    @IntegerValues(values = {TIPOMOVIMENTO_INCLUSAO, TIPOMOVIMENTO_ALTERACAO, TIPOMOVIMENTO_CONCLUSAO}, message = "Tipo de movimento não permitido")
    Integer tipomovimento;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Tarefa getTarefa() {
        return tarefa;
    }

    public void setTarefa(Tarefa tarefa) {
        this.tarefa = tarefa;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getDatamovimento() {
        return datamovimento;
    }

    public void setDatamovimento(LocalDateTime datamovimento) {
        this.datamovimento = datamovimento;
    }

    public Integer getTipomovimento() {
        return tipomovimento;
    }

    public void setTipomovimento(Integer tipomovimento) {
        this.tipomovimento = tipomovimento;
    }
}
