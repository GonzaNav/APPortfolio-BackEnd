
package com.portfolio.gn.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DtoExperiencia {
    @NotBlank
    private String nombreExp;
    @NotBlank
    private String puestoExp;
    @NotBlank
    private String descripcionExp;
    @NotBlank
    private String fechaInicio;
    @NotBlank
    private String fechaFin;
    
    //constructores

    public DtoExperiencia() {
    }

    public DtoExperiencia(String nombreExp, String puestoExp, String descripcionExp, String fechaInicio, String fechaFin) {
        this.nombreExp = nombreExp;
        this.puestoExp = puestoExp;
        this.descripcionExp = descripcionExp;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    
    
    
}
