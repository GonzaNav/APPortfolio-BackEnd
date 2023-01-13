
package com.portfolio.gn.Controller;

import com.portfolio.gn.Dto.DtoProyecto;
import com.portfolio.gn.Entity.Proyecto;
import com.portfolio.gn.Security.Controller.Mensaje;
import com.portfolio.gn.Service.SProyecto;
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
@RequestMapping("/proyectos")
@CrossOrigin(origins = "http://localhost:4200")
public class CProyecto {
    @Autowired
    SProyecto sProyecto;
   
    @GetMapping("/lista")
    public ResponseEntity<List<Proyecto>> list() {
        List<Proyecto> list = sProyecto.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyecto> getById(@PathVariable("id") int id)  {
        if(!sProyecto.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el registro"), HttpStatus.NOT_FOUND);
        }
        
        Proyecto proyecto = sProyecto.getOne(id).get();
        
        return new ResponseEntity(proyecto, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoProyecto dtoProyecto) {
        if(StringUtils.isBlank(dtoProyecto.getNombreProy())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        
        if(sProyecto.existsByNombreProy(dtoProyecto.getNombreProy())) {
            return new ResponseEntity(new Mensaje("El proyecto no existe"), HttpStatus.BAD_REQUEST);
        }
        
        Proyecto proyecto = new Proyecto(dtoProyecto.getNombreProy(), dtoProyecto.getDescripcionProy(), dtoProyecto.getImgProy());
        sProyecto.save(proyecto);
        
        return new ResponseEntity(new Mensaje("Proyecto agregado"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoProyecto dtoProyecto) {
        if(!sProyecto.existsById(id)) {
            return new ResponseEntity(new Mensaje("El Proyecto no existe"), HttpStatus.BAD_REQUEST);
        }
        if(!sProyecto.existsByNombreProy(dtoProyecto.getNombreProy()) && sProyecto.getByNombreProy(dtoProyecto.getNombreProy()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Ya existe un proyecto con ese nombre"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(dtoProyecto.getNombreProy())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        
        Proyecto proyecto = sProyecto.getOne(id).get();
        
        proyecto.setNombreProy(dtoProyecto.getNombreProy());
        proyecto.setDescripcionProy(dtoProyecto.getDescripcionProy());
        sProyecto.save(proyecto);
        
        return new ResponseEntity(new Mensaje("Proyecto actualizado"), HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if(!sProyecto.existsById(id)) {
            return new ResponseEntity(new Mensaje("El proyecto no existe"), HttpStatus.BAD_REQUEST);
        }
        
        sProyecto.delete(id);
        return new ResponseEntity(new Mensaje("Proyecto eliminado"), HttpStatus.OK);
    }
}
