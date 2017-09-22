/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.ForeignKey;

/**
 *
 * @author Rafael
 */
@Entity
@Table(name = "aluguel")
public class Aluguel implements Serializable {
     @Id
    @SequenceGenerator(name = "seq_aluguel", sequenceName = "seq_aluguel_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_aluguel", strategy = GenerationType.SEQUENCE)
    private Integer id;
     
    @NotNull(message = "O Valor não pode ser nulo")
    @Column(name = "valor", nullable = false, columnDefinition = "decimal(10,2)")
    private Double valor;
    
    @NotNull(message = "O InícioContrato deve ser informado")
    @Column(name = "inicio_contrato" , nullable = false)
    private Calendar inicioContrato;
    
    @NotNull(message = "O FimContrato deve ser informado")
    @Column(name = "fim_contrato" , nullable = false)
    private Calendar fimContrato;
    
    @NotNull(message = "O Dia Vencimento não pode ser nulo")
    @Column(name = "dia_vencimento" , nullable = false)
    private Integer diaVencimento;
    
    @NotNull(message = "O Locatário não pode ser nulo") 
    @ManyToOne
    @JoinColumn(name = "locatario", referencedColumnName = "id")
    @ForeignKey(name = "fk_locatario_id")
    private Locatario locatario;
    
    @NotNull(message = "O Unidade condominial não pode ser nulo") 
    @ManyToOne
    @JoinColumn(name = "unidade_condominial", referencedColumnName = "id")
    @ForeignKey(name = "fk_unidade_condominial_id")
    private UnidadeCondominial unidadeCondominial;
    
    
    @OneToMany(mappedBy = "aluguel", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)// mapear coleção
    private List<Mensalidades> mensalidade = new ArrayList<>();
    
      public void adicionarMensalidades (Mensalidades obj){
        obj.setAluguel(this);
        this.getMensalidade().add(obj);
    }
    public void removerTelefone(int index){
        this.getMensalidade().remove(index);
    }

    public Aluguel() {
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
     * @return the valor
     */
    public Double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(Double valor) {
        this.valor = valor;
    }

    /**
     * @return the inicioContrato
     */
    public Calendar getInicioContrato() {
        return inicioContrato;
    }

    /**
     * @param inicioContrato the inicioContrato to set
     */
    public void setInicioContrato(Calendar inicioContrato) {
        this.inicioContrato = inicioContrato;
    }

    /**
     * @return the fimContrato
     */
    public Calendar getFimContrato() {
        return fimContrato;
    }

    /**
     * @param fimContrato the fimContrato to set
     */
    public void setFimContrato(Calendar fimContrato) {
        this.fimContrato = fimContrato;
    }

    /**
     * @return the diaVencimento
     */
    public Integer getDiaVencimento() {
        return diaVencimento;
    }

    /**
     * @param diaVencimento the diaVencimento to set
     */
    public void setDiaVencimento(Integer diaVencimento) {
        this.diaVencimento = diaVencimento;
    }

    /**
     * @return the locatario
     */
    public Locatario getLocatario() {
        return locatario;
    }

    /**
     * @param locatario the locatario to set
     */
    public void setLocatario(Locatario locatario) {
        this.locatario = locatario;
    }

    /**
     * @return the unidadeCondominial
     */
    public UnidadeCondominial getUnidadeCondominial() {
        return unidadeCondominial;
    }

    /**
     * @param unidadeCondominial the unidadeCondominial to set
     */
    public void setUnidadeCondominial(UnidadeCondominial unidadeCondominial) {
        this.unidadeCondominial = unidadeCondominial;
    }

    /**
     * @return the mensalidade
     */
    public List<Mensalidades> getMensalidade() {
        return mensalidade;
    }

    /**
     * @param mensalidade the mensalidade to set
     */
    public void setMensalidade(List<Mensalidades> mensalidade) {
        this.mensalidade = mensalidade;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.id);
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
        final Aluguel other = (Aluguel) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
}
