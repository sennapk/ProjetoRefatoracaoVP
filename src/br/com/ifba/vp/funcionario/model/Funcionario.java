package br.com.ifba.vp.funcionario.model;

import br.com.ifba.vp.infrastructure.model.Pessoa;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Senna
 */
@Entity
@Table(name = "Funcionario")
public class Funcionario extends Pessoa implements Serializable {
    
    private String senha;
    private String email;
    private String especializacao;
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEspecializacao() {
        return especializacao;
    }

    public void setEspecializacao(String especializacao) {
        this.especializacao = especializacao;
    }
}