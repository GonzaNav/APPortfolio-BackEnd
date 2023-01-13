
package com.portfolio.gn.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Experiencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreExp;
    private String puestoExp;
    private String descripcionExp;
    private String fechaInicio;
    private String fechaFin;
    
    //Constructores
    public Experiencia() {
    }

    public Experiencia(String nombreExp, String puestoExp, String descripcionExp, String fechaInicio, String fechaFin) {
        this.nombreExp = nombreExp;
        this.puestoExp = puestoExp;
        this.descripcionExp = descripcionExp;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    
    
    
}
