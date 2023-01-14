
package com.portfolio.gn.Controller;

import com.portfolio.gn.Dto.DtoHys;
import com.portfolio.gn.Entity.Hys;
import com.portfolio.gn.Security.Controller.Mensaje;
import com.portfolio.gn.Service.SHys;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hys")
@CrossOrigin(origins = "http://localhost:4200")
public class CHys {
    @Autowired
    SHys sHys;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Hys>> list() {
        List<Hys> list = sHys.list();
        
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/lista/soft")
    public ResponseEntity<List<Hys>> listSoft() {
        List<Hys> list = sHys.loadAndFilterByTipo("soft");
        
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/lista/hard")
    public ResponseEntity<List<Hys>> listHard() {
        List<Hys> list = sHys.loadAndFilterByTipo("hard");
        
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Hys> getById(@PathVariable("id") int id)  {
        if(!sHys.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el registro"), HttpStatus.NOT_FOUND);
        }
        
        Hys hys = sHys.getOne(id).get();
        
        return new ResponseEntity(hys, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoHys dtoHys) {
        if(StringUtils.isBlank(dtoHys.getNombreHys())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        
        if(sHys.existsByNombreHys(dtoHys.getNombreHys())) {
            return new ResponseEntity(new Mensaje("Esa skill existe"), HttpStatus.BAD_REQUEST);
        }
        
        Hys hys = new Hys(dtoHys.getNombreHys(), dtoHys.getPorcentajeHys(), dtoHys.getTipo());
        sHys.save(hys);
        
        return new ResponseEntity(new Mensaje("Skill agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoHys dtoHys) {
        if(!sHys.existsById(id)) {
            return new ResponseEntity(new Mensaje("La skill no existe"), HttpStatus.BAD_REQUEST);
        }
        if(sHys.existsByNombreHys(dtoHys.getNombreHys()) && 
                sHys.getByNombreHys(dtoHys.getNombreHys()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Ya existe una skill con ese nombre"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(dtoHys.getNombreHys())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        
        Hys hys = sHys.getOne(id).get();
        
        hys.setNombreHys(dtoHys.getNombreHys());
        hys.setPorcentajeHys(dtoHys.getPorcentajeHys());
        sHys.save(hys);
        
        return new ResponseEntity(new Mensaje("Skill actualizada"), HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if(!sHys.existsById(id)) {
            return new ResponseEntity(new Mensaje("La skill no existe"), HttpStatus.BAD_REQUEST);
        }
        
        sHys.delete(id);
        return new ResponseEntity(new Mensaje("Skill eliminada"), HttpStatus.OK);
    }
}
