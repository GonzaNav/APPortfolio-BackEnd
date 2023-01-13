
package com.portfolio.gn.Service;

import com.portfolio.gn.Entity.Proyecto;
import com.portfolio.gn.Repository.RProyecto;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SProyecto {
    @Autowired
    RProyecto rProyecto;
    
    public List<Proyecto> list() {
        return rProyecto.findAll();
    }
    
    public Optional<Proyecto> getOne(int id) {
        return rProyecto.findById(id);
    }
    
    public Optional<Proyecto> getByNombreProy(String nombreProy){
        return rProyecto.findByNombreProy(nombreProy);
    }
    
    public void save(Proyecto proy) {
        rProyecto.save(proy);
    }
    
    public void delete(int id) {
        rProyecto.deleteById(id);
    }
    
    public boolean existsById(int id) {
        return rProyecto.existsById(id);
    }
    
    public boolean existsByNombreProy(String nombreProy) {
        return rProyecto.existsByNombreProy(nombreProy);
    }
}
