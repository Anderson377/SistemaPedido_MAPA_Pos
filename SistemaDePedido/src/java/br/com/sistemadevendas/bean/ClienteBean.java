/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package br.com.sistemadevendas.bean;

import br.com.sistemadepedido.repositories.ClienteRepository;
import br.com.sistemdepedido.model.Cliente;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import br.com.sistemdepedido.util.JPAUtil;

/**
 *
 * @author Anderson Dolce
 */
@ManagedBean(name = "clienteBean")
@SessionScoped
public class ClienteBean {

    private final ClienteRepository clienteRepository;
    private Cliente cliente;
    
    public Cliente getCliente(){
        return cliente;
    }
    
    public List<Cliente> getAllCliente(){
        return clienteRepository.getAll();
    }
    
    public ClienteBean() {
        clienteRepository = new ClienteRepository(JPAUtil.getEntityManager());
    }
    
    public String register(){
        cliente = new Cliente();
        return "register";
    }
    public String list(){
        return "index";
    }
    public String confirm(){
        if(clienteRepository.create(cliente)){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cliente cadastrado com sucesso!"));
            return "index";
        }else{
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao cadastrar",
                    "Verifique os dados informados e tente novamente"));
            return "register";
        }
    }
    
}
