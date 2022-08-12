package com.reto_5.model.vo;

public class ComprasProyectoVo {
    private Integer id;
    private String constructora;
    private String banco;
    
    //CONSULTORES
    //GETTERS
    public Integer getId() {
        return id;
    }
    public String getConstructora() {
        return constructora;
    }
    public String getBanco() {
        return banco;
    }
    
    
    //MODIFICADORES
    //SETTERS
    public void setId(Integer id) {
        this.id = id;
    }
    public void setConstructora(String constructora) {
        this.constructora = constructora;
    }
    public void setBanco(String banco) {
        this.banco = banco;
    }
    
}
