
package com.portfolio.gn.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DtoHys {
    @NotBlank
    private String nombreHys;
    @NotBlank
    private int porcentajeHys;
    @NotBlank
    private String tipo;

    public DtoHys() {
    }

    public DtoHys(String nombreHys, int porcentajeHys, String tipo) {
        this.nombreHys = nombreHys;
        this.porcentajeHys = porcentajeHys;
        this.tipo = tipo;
    }
}
