/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

/**
 *
 * @author Rafael
 */
@Entity
@Table(name="pessoa")
@Inheritance(strategy = InheritanceType.JOINED)// usar a anotação em classes  que irão fornecer herança
public class Pessoa implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_pessoa", sequenceName = "seq_pessoa_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_pessoa", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotNull(message = "O Nome não pode ser nulo")
    @Length(max = 40, message = "o nome não pode ter {max} caracteres")
    @NotBlank(message = "O nome não pode ser embranco")
    @Column(name = "nome", length = 40, nullable = false)   
    private String nome;
    
    @NotNull(message = "O Email não pode ser nulo")
    @Length(max = 40, message = "o Email não pode ter {max} caracteres")
    @NotBlank(message = "O Email não pode ser embranco")
    @Column(name = "email", length = 40, nullable = false)
    @Email(message = "o email deve ser valido")
     private String email;
 
    @CPF(message="O cpf deve ser valido")
    @NotNull(message = "O cpf não pode ser nulo")
    @Length(max = 14, message = "o cpf não pode ter {max} caracteres")
    @NotBlank(message = "O nome não pode ser embranco")
    @Column(name = "cpf", length = 14, nullable = false)
    private String cpf;
    
    @NotNull(message = "O Telefone não pode ser nulo")
    @Length(max = 14, message = "O Telefone não pode ter {max} caracteres")
    @NotBlank(message = "O nome não pode ser embranco")
    @Column(name = "telefone", length = 14, nullable = false)
    private String telefone;

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Pessoa() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pessoa other = (Pessoa) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
}
