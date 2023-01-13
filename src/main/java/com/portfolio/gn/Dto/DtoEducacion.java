
package com.portfolio.gn.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DtoEducacion {
    
    @NotBlank
    private String nombreEduc;
    @NotBlank
    private String institucionEduc;
    @NotBlank
    private String descripcionEduc;
    @NotBlank
    private String fechaInicio;
    @NotBlank
    private String fechaFin;
    

    public DtoEducacion() {
    }

    public DtoEducacion(String nombreEduc, String institucionEduc, String descripcionEduc, String fechaInicio, String fechaFin) {
        this.nombreEduc = nombreEduc;
        this.institucionEduc = institucionEduc;
        this.descripcionEduc = descripcionEduc;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    

    
    
    
}
