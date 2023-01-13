
package com.portfolio.gn.Security.Service;

import com.portfolio.gn.Security.Entity.Rol;
import com.portfolio.gn.Security.Enums.RolNombre;
import com.portfolio.gn.Security.Repository.IRolRepository;
import javax.transaction.Transactional;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RolService {
    @Autowired IRolRepository irolRepository;
    
    public Optional<Rol> getByRolNombre(RolNombre rolNombre) {
        return irolRepository.findByRolNombre(rolNombre);
    }
    
    public void saveRol(Rol rol) {
        irolRepository.save(rol);
    }
    
    
}
