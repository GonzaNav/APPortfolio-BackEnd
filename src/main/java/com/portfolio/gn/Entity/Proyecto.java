
package com.portfolio.gn.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreProy;
    private String descripcionProy;
    private String imgProy;

    public Proyecto() {
    }

    public Proyecto(String nombreProy, String descripcionProy, String imgProy) {
        this.nombreProy = nombreProy;
        this.descripcionProy = descripcionProy;
        this.imgProy = imgProy;
    }
    
    
}
