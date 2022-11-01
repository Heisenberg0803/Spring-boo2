package com.example.demo.controller.entitiy;

import com.example.demo.entitiy.Cliente;
import com.example.demo.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value="/cliente/v1/")

public class Controller {
    @Autowired
    Repository repository;

    @PostMapping
    public Cliente create(@RequestBody Cliente cliente){
        Cliente clienteSaved = repository.save(cliente);
        return clienteSaved;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Optional<Cliente> getClienteById(@PathVariable Long id){
        Optional<Cliente> clienteReturned = repository.findById(id);
        return clienteReturned;
    }
    @DeleteMapping("/{id}")
    public String deleteCliente(@PathVariable Long id){
        try{
           Optional<Cliente> cliente = Optional.of(repository.getById(id));
            if( cliente!=null){
                repository.deleteById(id);
                return "Cliente de "+id+" deletado com sucesso";

            }else{
                throw new Exception("Cliente inexsitente");
            }
        }catch(Exception e){
            e.printStackTrace();
            return"O cliente de "+id+" não existe para ser deletado!";
        }
    }



}
