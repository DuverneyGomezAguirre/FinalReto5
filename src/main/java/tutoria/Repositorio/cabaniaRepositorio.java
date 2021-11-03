/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tutoria.Repositorio;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tutoria.Modelo.Cabin;
import tutoria.Interface.InterfaceCabin;

/**
 *
 * @author cesartbossa
 */
@Repository
public class cabaniaRepositorio {
    @Autowired
    private InterfaceCabin crud;
    

    public List<Cabin> getAll(){
        return (List<Cabin>) crud.findAll();       
    }
    
    public Optional <Cabin> getCabania(int id){
        return crud.findById(id);
    }
    
    public Cabin save(Cabin cabania){
        return crud.save(cabania);
    }
     public void delete(Cabin cabania){
        crud.delete(cabania);
    }
    
}