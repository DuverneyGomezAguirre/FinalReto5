/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tutoria.Servicios;

import tutoria.Modelo.Cabin;
import tutoria.Repositorio.cabaniaRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author cesartbossa
 */
@Service
public class ServiciosCabin {
    @Autowired
    private cabaniaRepositorio metodosCrud;
    
    public List<Cabin> getAll(){
        return metodosCrud.getAll();
    }
    
    public Optional<Cabin> getCabania(int idCabania){
        return metodosCrud.getCabania(idCabania);
    }
    
    public Cabin save(Cabin cabania){
        if(cabania.getId()==null){
            return metodosCrud.save(cabania);
        }else{
            Optional<Cabin> evt=metodosCrud.getCabania(cabania.getId());
            if(evt.isEmpty()){
                return metodosCrud.save(cabania);
            }else{
                return cabania;
            }
        }
    }
    public Cabin update(Cabin cabania){
        if(cabania.getId()!=null){
            Optional<Cabin> e=metodosCrud.getCabania(cabania.getId());
            if(!e.isEmpty()){
                if(cabania.getName()!=null){
                    e.get().setName(cabania.getName());
                }
                if(cabania.getBrand()!=null){
                    e.get().setBrand(cabania.getBrand());
                }
                if(cabania.getRooms()!=null){
                    e.get().setRooms(cabania.getRooms());
                }
                if(cabania.getDescription()!=null){
                    e.get().setDescription(cabania.getDescription());
                }
                if(cabania.getCategory()!=null){
                    e.get().setCategory(cabania.getCategory());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return cabania;
            }
        }else{
            return cabania;
        }
    }


    public boolean deleteCabania(int cabaniaId) {
        Boolean aBoolean = getCabania(cabaniaId).map(cabania -> {
            metodosCrud.delete(cabania);
            return true;
        }).orElse(false);
        return aBoolean;
    }
     
}