
package com.portfolio.gn.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DtoProyecto {
    @NotBlank
    private String nombreProy;
    @NotBlank
    private String descripcionProy;
    @NotBlank
    private String imgProy;

    public DtoProyecto() {
    }

    public DtoProyecto(String nombreProy, String descripcionProy, String imgProy) {
        this.nombreProy = nombreProy;
        this.descripcionProy = descripcionProy;
        this.imgProy = imgProy;
    }

    
    
    
}
