/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Rafael
 */
@Entity
@Table(name="locatario")
public class Locatario extends Pessoa implements Serializable {
    
    @NotNull(message = "A Renda não pode ser nulo")
    @Column(name = "renda", nullable = false, columnDefinition = "decimal(10,2)")
    private Double renda;
    
    @NotNull(message = "O LocalTrabalho não pode ser nulo")
    @Length(max = 40, message = "O LocalTrabalho não pode ter {max} caracteres")
    @NotBlank(message = "O LocalTrabalho não pode ser embranco")
    @Column(name = "local_trabalho", length = 40, nullable = false)
    private String localTrabalho;
    
    @NotNull(message = "O TelefoneTrabalho não pode ser nulo")
    @Length(max = 14, message = "O TelefoneTrabalho não pode ter {max} caracteres")
    @NotBlank(message = "O TelefoneTrabalho não pode ser embranco")
    @Column(name = "telefone_trabalho", length = 14, nullable = false)
    private String telefoneTrabalho;

    /**
     * @return the renda
     */
    public Double getRenda() {
        return renda;
    }

    /**
     * @param renda the renda to set
     */
    public void setRenda(Double renda) {
        this.renda = renda;
    }

    /**
     * @return the localTrabalho
     */
    public String getLocalTrabalho() {
        return localTrabalho;
    }

    /**
     * @param localTrabalho the localTrabalho to set
     */
    public void setLocalTrabalho(String localTrabalho) {
        this.localTrabalho = localTrabalho;
    }



    public Locatario() {
    }

    /**
     * @return the telefoneTrabalho
     */
    public String getTelefoneTrabalho() {
        return telefoneTrabalho;
    }

    /**
     * @param telefoneTrabalho the telefoneTrabalho to set
     */
    public void setTelefoneTrabalho(String telefoneTrabalho) {
        this.telefoneTrabalho = telefoneTrabalho;
    }
    
}
