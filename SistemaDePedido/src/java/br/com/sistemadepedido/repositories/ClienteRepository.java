/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.sistemadepedido.repositories;

import br.com.sistemdepedido.model.Cliente;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Anderson Dolce
 */
public class ClienteRepository implements Serializable{
    
    private final EntityManager entityManager;
    
    public ClienteRepository(EntityManager em){
        this.entityManager = em;
    }
    
    public boolean create(Cliente cliente){
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(cliente);
            entityManager.getTransaction().commit();
            return true;
        }catch(Exception e){
            return false;
        }
    }
    
    public List<Cliente> getAll(){
        TypedQuery<Cliente> query = entityManager.createNamedQuery("Cliente.findAll", Cliente.class);
        return query.getResultList();
    }
    
}
