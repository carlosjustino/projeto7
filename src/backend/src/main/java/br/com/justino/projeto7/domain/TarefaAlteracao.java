package br.com.justino.projeto7.domain;

import br.com.justino.projeto7.validators.IntegerValues;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class TarefaAlteracao  extends PanacheEntity {

    public static final int TIPOMOVIMENTO_INCLUSAO = 1;
    public static final int TIPOMOVIMENTO_ALTERACAO = 2;
    public static final int TIPOMOVIMENTO_CONCLUSAO = 3;

    /* Refactory para usar o PanacheEntity
     @Id
     @GeneratedValue(strategy=GenerationType.IDENTITY)
     Long id;
 */
    @ManyToOne
    @JoinColumn(name="idTarefa", nullable=true)
    Tarefa tarefa;

    @NotBlank(message="O campo Descricao deve ser informado na Alteração")
    String descricao;

    @Temporal(TemporalType.TIMESTAMP)
    @NotNull(message="O campo datamovimento não pode ser vazio")
    Date datamovimento;

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

    public Date getDatamovimento() {
        return datamovimento;
    }

    public void setDatamovimento(Date datamovimento) {
        this.datamovimento = datamovimento;
    }

    public Integer getTipomovimento() {
        return tipomovimento;
    }

    public void setTipomovimento(Integer tipomovimento) {
        this.tipomovimento = tipomovimento;
    }
}
