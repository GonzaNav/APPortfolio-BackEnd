package com.portfolio.gn.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotNull
    @Size(min = 1, max = 50, message = "No cumple con la longitud.")
    private String nombre;
    
    @NotNull
    @Size(min = 1, max = 50, message = "No cumple con la longitud.")
    private String apellido;
    
    @NotNull
    @Size(min = 1, max = 2000, message = "No cumple con la longitud.")
    private String descripcion;
    
    @NotNull
    @Size(min = 1, max = 50, message = "No cumple con la longitud.")
    private String titulo;
    
    //@NotNull
    private String img;

    public Persona() {
    }

    public Persona(String nombre, String apellido, String descripcion, String titulo, String img) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.descripcion = descripcion;
        this.titulo = titulo;
        this.img = img;
    }

    
    
    
    
    
}
