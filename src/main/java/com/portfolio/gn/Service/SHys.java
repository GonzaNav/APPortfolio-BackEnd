
package com.portfolio.gn.Service;

import com.portfolio.gn.Entity.Hys;
import com.portfolio.gn.Repository.RHys;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class SHys {
    @Autowired
    RHys rHys;
    
    public List<Hys> list() {
        return rHys.findAll();
    }
    
    public List<Hys> loadAndFilterByTipo(String tipo) {
        return rHys.findAllByTipo(tipo);
    }
    
    public Optional<Hys> getOne(int id) {
        return rHys.findById(id);
    }
    
    public Optional<Hys> getByNombreHys(String nombreHys) {
        return rHys.findByNombreHys(nombreHys);
    }
    
    public void save(Hys hys) {
        rHys.save(hys);
    }
    
    public void delete(int id) {
        rHys.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rHys.existsById(id);
    }
    
    public boolean existsByNombreHys(String nombreHys) {
        return rHys.existsByNombreHys(nombreHys);
    }
}
