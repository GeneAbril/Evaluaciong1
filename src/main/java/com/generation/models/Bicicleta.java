package com.generation.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bicicletas")
public class Bicicleta {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)


    private String marca;
    private String color;
    private String tipo;
    private int rodado;
    

    //CONSTRUCTOR VACIO
    public Bicicleta() {
    }
//CONSTRUCTOR CON PARAMETROS
    public Bicicleta(String marca, String color, String tipo, int rodado) {
        this.marca = marca;
        this.color = color;
        this.tipo = tipo;
        this.rodado = rodado;
    }

    //GETTERS AND SETTERS
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public int getRodado() {
        return rodado;
    }
    public void setRodado(int rodado) {
        this.rodado = rodado;
    }
    public String getId() {
        return null;
    }
    public void setId(Long id) {
    }
}
