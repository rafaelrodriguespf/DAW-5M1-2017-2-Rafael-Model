/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.util.relatorios;


import br.edu.ifsul.modelo.Condominio;
import br.edu.ifsul.modelo.Pessoa;
import br.edu.ifsul.modelo.Recurso;
import br.edu.ifsul.modelo.UnidadeCondominial;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rafael
 */
public class FabricaObjetos {
  
    public static List<Condominio> carregarCondominios(){
        List<Condominio> lista = new ArrayList<>();
        List<Recurso> recurso = new ArrayList<>();
        List<UnidadeCondominial> unidadeCondominial = new ArrayList<>();
        Recurso r = new Recurso();
        r.setDescricao("Piscina");
        recurso.add(r);
        
        Pessoa p = new Pessoa();
        p.setCpf("831.736.090.34");
        p.setEmail("rafaelrodriguespf@gmail.com");
        p.setNome("rafael");
        p.setTelefone("991666134");
        
        
        UnidadeCondominial u = new UnidadeCondominial();
        u.setArea(200.0);
        u.setDescricao("xxxxxx");
        u.setNumero("101");
        u.setNumeroQuarto(1);
        u.setPessoa(p);        
        unidadeCondominial.add(u);
        
        Condominio c = new Condominio();
        c.setCep("99030010");
        c.setEndereco("Av Brasil");
        c.setNome("Teste");
        c.setNumero("200");
        c.setUnidadeCondominial(unidadeCondominial);
        c.setCondominio_recurso(recurso);
        lista.add(c);
            
        return lista;
    }
    

  
 
    
 
}
