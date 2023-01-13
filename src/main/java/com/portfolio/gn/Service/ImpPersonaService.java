
package com.portfolio.gn.Service;

import com.portfolio.gn.Entity.Persona;
import com.portfolio.gn.Repository.IPersonaRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class ImpPersonaService {

    @Autowired
    IPersonaRepository ipersonaRepository;
    
    public List<Persona> list() {
        return ipersonaRepository.findAll();
    }
    
    public Optional<Persona> getOne(int id) {
        return ipersonaRepository.findById(id);
    }
    
    public Optional<Persona> getByNombre(String nombreE){
        return ipersonaRepository.findByNombre(nombreE);
    }
    
    public void save(Persona exp) {
        ipersonaRepository.save(exp);
    }
    
    public void delete(int id) {
        ipersonaRepository.deleteById(id);
    }
    
    public boolean existsById(int id) {
        return ipersonaRepository.existsById(id);
    }
    
    public boolean existsByNombre(String nombre) {
        return ipersonaRepository.existsByNombre(nombre);
    }
    
}
