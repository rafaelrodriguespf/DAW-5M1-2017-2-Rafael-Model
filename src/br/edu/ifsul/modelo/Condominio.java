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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Rafael
 */
@Entity
@Table(name = "condominio")
public class Condominio implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_condominio", sequenceName = "seq_condominio_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_condominio", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @NotNull(message = "O Nome não pode ser nulo")
    @Length(max = 40, message = "o nome não pode ter {max} caracteres")
    @NotBlank(message = "O nome não pode ser embranco")
    @Column(name = "nome", length = 40, nullable = false)
    private String nome;

    @NotNull(message = "O endereço não pode ser nulo")
    @Length(max = 40, message = "o Endereço não pode ter {max} caracteres")
    @NotBlank(message = "O Endereço não pode ser embranco")
    @Column(name = "endereco", length = 40, nullable = false)
    private String endereco;

    @NotNull(message = "O Número não pode ser nulo")
    @Length(max = 10, message = "o Número não pode ter {max} caracteres")
    @NotBlank(message = "O Número não pode ser embranco")
    @Column(name = "numero", length = 10, nullable = false)
    private String numero;

    @NotNull(message = "O Cep não pode ser nulo")
    @Length(max = 9, message = "o Cep não pode ter {max} caracteres")
    @NotBlank(message = "O Cep não pode ser embranco")
    @Column(name = "cep", length = 9, nullable = false)
    private String cep;
    
     @ManyToMany
    @JoinTable(name = "condominio_recurso",
            joinColumns =
            @JoinColumn(name = "condominio",referencedColumnName ="id", nullable = false), 
            inverseJoinColumns = 
            @JoinColumn(name = "recurso", referencedColumnName = "id", nullable = false))
    private List<Recurso> condominio_recurso = new ArrayList<>();

    @OneToMany(mappedBy = "condominio", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)// mapear coleção
    private List<UnidadeCondominial> unidadeCondominial = new ArrayList<>();

    public void adicionarUnidadeCondominial(UnidadeCondominial obj) {
        obj.setCondominio(this);
        this.getUnidadeCondominial().add(obj);
    }

    public void removerUnidadeCondominial(int index) {
        this.getUnidadeCondominial().remove(index);
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
     * @return the endereco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * @return the cep
     */
    public String getCep() {
        return cep;
    }

    /**
     * @param cep the cep to set
     */
    public void setCep(String cep) {
        this.cep = cep;
    }

    public Condominio() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.getId());
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
        final Condominio other = (Condominio) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    /**
     * @return the unidadeCondominial
     */
    public List<UnidadeCondominial> getUnidadeCondominial() {
        return unidadeCondominial;
    }

    /**
     * @param unidadeCondominial the unidadeCondominial to set
     */
    public void setUnidadeCondominial(List<UnidadeCondominial> unidadeCondominial) {
        this.unidadeCondominial = unidadeCondominial;
    }

    /**
     * @return the condominio_recurso
     */
    public List<Recurso> getCondominio_recurso() {
        return condominio_recurso;
    }

    /**
     * @param condominio_recurso the condominio_recurso to set
     */
    public void setCondominio_recurso(List<Recurso> condominio_recurso) {
        this.condominio_recurso = condominio_recurso;
    }

}
