/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tutoria.Interface;

import tutoria.Modelo.Cabin;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author cesartbossa
 */
public interface InterfaceCabin extends CrudRepository<Cabin,Integer>{
    
}