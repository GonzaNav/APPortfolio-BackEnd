
package com.portfolio.gn.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Educacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreEduc;
    private String institucionEduc;
    private String descripcionEduc;
    private String fechaInicio;
    private String fechaFin;

    public Educacion() {
    }

    public Educacion(String nombreEduc, String institucionEduc, String descripcionEduc, String fechaInicio, String fechaFin) {
        this.nombreEduc = nombreEduc;
        this.institucionEduc = institucionEduc;
        this.descripcionEduc = descripcionEduc;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }    
}
