
package com.portfolio.gn.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Hys {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String nombreHys;
    private int porcentajeHys;
    private String tipo;

    public Hys() {
    }

    public Hys(String nombreHys, int porcentajeHys, String tipo) {
        this.nombreHys = nombreHys;
        this.porcentajeHys = porcentajeHys;
        this.tipo = tipo;
    }
    
    
}
