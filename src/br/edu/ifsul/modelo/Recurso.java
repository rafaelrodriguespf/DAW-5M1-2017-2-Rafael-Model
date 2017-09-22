/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Rafael
 */
@Entity
@Table(name="recurso")
public class Recurso implements Serializable {
    @Id
    @SequenceGenerator(name = "seq_recurso", sequenceName = "seq_recurso_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_recurso", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotNull(message = "A Descrição não pode ser nulo")
    @Length(max = 40, message = "A Descrição não pode ter {max} caracteres")
    @NotBlank(message = "A descricao não pode ser embranco")
    @Column(name = "descricao", length = 40, nullable = false)   
    private String descricao;
    
     @ManyToMany
    @JoinTable(name = "condominio_recurso",
            joinColumns =
            @JoinColumn(name = "recurso",referencedColumnName ="id", nullable = false), 
            inverseJoinColumns = 
            @JoinColumn(name = "condominio", referencedColumnName = "id", nullable = false))
    private List<Condominio> recurso_condominio = new ArrayList<>();
     

    public Recurso() {
    }

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
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.getId());
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
        final Recurso other = (Recurso) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    /**
     * @return the recurso_condominio
     */
    public List<Condominio> getRecurso_condominio() {
        return recurso_condominio;
    }

    /**
     * @param recurso_condominio the recurso_condominio to set
     */
    public void setRecurso_condominio(List<Condominio> recurso_condominio) {
        this.recurso_condominio = recurso_condominio;
    }
    
}
