package com.reto_5.model.vo;

public class ProyectosVo {
    private Integer id;
    private String constructora;
    private Integer habitaciones;
    private String ciudad;

    
    //CONSULTORES
    //GETTERS
    public Integer getId() {
        return id;
    }
    public String getConstructora() {
        return constructora;
    }
    public Integer getHabitaciones() {
        return habitaciones;
    }
    public String getCiudad() {
        return ciudad;
    }
    
    //MODIFICADORES
    //SETTERS
    public void setId(Integer id) {
        this.id = id;
    }
    public void setConstructora(String constructora) {
        this.constructora = constructora;
    }
    public void setHabitaciones(Integer habitaciones) {
        this.habitaciones = habitaciones;
    }
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
}
