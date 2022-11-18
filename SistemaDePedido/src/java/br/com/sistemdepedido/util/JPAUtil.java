/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.sistemdepedido.util;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author Anderson Dolce
 */
public class JPAUtil {
    
    private static final String PERSISTENCE_UNIT = "SistemaDePedidoPU";
    
    private static EntityManager emf;
    
    public static EntityManager getEntityManager(){
        return Persistence.createEntityManagerFactory("SistemaDePedidoPU").createEntityManager();
    }
    
}
