
package com.portfolio.gn.Controller;

import com.portfolio.gn.Dto.DtoEducacion;
import com.portfolio.gn.Entity.Educacion;
import com.portfolio.gn.Security.Controller.Mensaje;
import com.portfolio.gn.Service.SEducacion;
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
@RequestMapping("/educacion")
@CrossOrigin(origins = "http://localhost:4200")
public class CEducacion {
    @Autowired
    SEducacion sEducacion;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Educacion>> list() {
        List<Educacion> list = sEducacion.list();
        
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id") int id)  {
        if(!sEducacion.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el registro"), HttpStatus.NOT_FOUND);
        }
        
        Educacion educacion = sEducacion.getOne(id).get();
        
        return new ResponseEntity(educacion, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        
        if(!sEducacion.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el registro"), HttpStatus.NOT_FOUND);
        }
        
        sEducacion.delete(id);
        return new ResponseEntity(new Mensaje("Eliminado correctamente"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoEducacion dtoEducacion) {
        if(StringUtils.isBlank(dtoEducacion.getNombreEduc())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoEducacion.getDescripcionEduc())) {
            return new ResponseEntity(new Mensaje("La descripción es obligaoria"), HttpStatus.BAD_REQUEST);
        }
        
        if(sEducacion.existsByNombreEduc(dtoEducacion.getNombreEduc())){
            return new ResponseEntity(new Mensaje("El registro ya existe"), HttpStatus.BAD_REQUEST);
        }
        
        Educacion educacion = new Educacion(dtoEducacion.getNombreEduc(),dtoEducacion.getInstitucionEduc(), dtoEducacion.getDescripcionEduc(), dtoEducacion.getFechaInicio(), dtoEducacion.getFechaFin());
        
        sEducacion.save(educacion);
        return new ResponseEntity(new Mensaje("Se creó correctamente"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoEducacion dtoEducacion) {
        if(!sEducacion.existsById(id)) {
            return new ResponseEntity(new Mensaje("El registro no existe"), HttpStatus.BAD_REQUEST);
        }
        if(sEducacion.existsByNombreEduc(dtoEducacion.getNombreEduc()) && sEducacion.getByNombreEduc(dtoEducacion.getNombreEduc()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Ya existe una educación con ese nombre"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(dtoEducacion.getNombreEduc())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        
        Educacion educacion = sEducacion.getOne(id).get();
        
        educacion.setNombreEduc(dtoEducacion.getNombreEduc());
        educacion.setInstitucionEduc(dtoEducacion.getInstitucionEduc());
        educacion.setDescripcionEduc(dtoEducacion.getDescripcionEduc());
        educacion.setFechaInicio(dtoEducacion.getFechaInicio());
        educacion.setFechaFin(dtoEducacion.getFechaFin());
        sEducacion.save(educacion);
        
        return new ResponseEntity(new Mensaje("Educación actualizada"), HttpStatus.OK);
    }
}
