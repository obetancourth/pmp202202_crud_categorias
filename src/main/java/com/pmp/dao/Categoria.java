/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pmp.dao;

/**
 *
 * @author obetancourth
 */
public class Categoria {
    
    public Categoria(){
        
    }
    
    public Categoria(int codigo, String nombre, String estado){
        this.codigo = codigo;
        this.nombre = nombre;
        this.estado= estado;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public String printString(){
        return String.valueOf(codigo) + '\t' + nombre + '\t' + estado;
    }
    
    private int codigo;
    private String nombre;
    private String estado;
    
}
