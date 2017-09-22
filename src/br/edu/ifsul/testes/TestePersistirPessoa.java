/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;


import br.edu.ifsul.modelo.Pessoa;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Rafael
 */
public class TestePersistirPessoa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DAW-5M1-2017-2-Rafael-ModelPU");
        //Gerenciador de intidades
        EntityManager em = emf.createEntityManager();
        Pessoa p = new Pessoa();

        p.setNome("Rafael");
        p.setCpf("831.736.090-34");
        p.setEmail("rafaelrodrihuespf@gmail.com");
        p.setTelefone("5433143794");
        em.getTransaction().begin(); //Iniciar comunicação
        em.persist(p);// salvar no banco
        em.getTransaction().commit();//Finalizar Comunicação
    }
    
}
