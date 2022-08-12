package com.reto_5.model.vo;

public class ListaLideresVo {
    private Integer id;
    private String nombre;
    private String apellido;
    private String ciudad;
    
    
    //GETTERS
    public Integer getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public String getCiudad() {
        return ciudad;
    }
    
    
    //SETTERS
    public void setId(Integer id) {
        this.id = id;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    
}
