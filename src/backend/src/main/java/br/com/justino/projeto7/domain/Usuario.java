package br.com.justino.projeto7.domain;

import br.com.justino.projeto7.adapters.SenhaHashAdapter;
import br.com.justino.projeto7.common.SenhaHash;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@Entity
public class Usuario {

    public static final String REGEX_FIELD_NOME = "^\\b.{2,100}$";
    public static final String REGEX_FIELD_LOGIN = "^\\b{2,25}$";
    public static final String REGEX_FIELD_EMAIL = "^[a-z0-9.]+@[a-z0-9]+\\.[a-z]+\\.([a-z]+)?$";

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    Long id;

    @NotBlank(message="O campo Nome deve ser informado em Usuário")
    @Size(max=100, message="O campo Nome em Usuário deve ter o tamanho entre 2 e 100")
    @Pattern(regexp = REGEX_FIELD_NOME)
    @Column(length=100)
    String nome;

    @NotBlank(message="O campo Login deve ser informado em Usuário")
    @Size(max=25, message="O campo Nome em Usuário deve ter o tamanho entre 2 e 25")
    @Pattern(regexp = REGEX_FIELD_LOGIN)
    @Column(length=25)
    String login;

    @NotBlank(message="O campo Email deve ser informado em Usuário")
    @Pattern(regexp = REGEX_FIELD_EMAIL)
    @Column(length=200)
    String email;

    @NotNull(message="O campo Senha deve ser informado em Usuário")
    @Embedded
    @AttributeOverride(name = "senha", column = @Column (name="senha", nullable = false, length = 500) )
    @XmlJavaTypeAdapter(SenhaHashAdapter.class)
    private SenhaHash senha;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }


    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }


    public SenhaHash getSenha() {
        return this.senha;
    }
    public void setSenha(SenhaHash pSenha) {
        this.senha = pSenha;
    }



}
