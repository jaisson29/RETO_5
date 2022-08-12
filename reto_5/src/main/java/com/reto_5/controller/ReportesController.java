package com.reto_5.controller;

import java.sql.SQLException;
import java.util.List;

import com.reto_5.model.dao.ListaLideresDao;
import com.reto_5.model.dao.ComprasProyectoDao;
import com.reto_5.model.dao.ProyectosDao;
import com.reto_5.model.vo.ListaLideresVo;
import com.reto_5.model.vo.ComprasProyectoVo;
import com.reto_5.model.vo.ProyectosVo;

public class ReportesController {
    private ProyectosDao proyectosDao;
    private ListaLideresDao listaLideresDao;
    private ComprasProyectoDao comprasProyectoDao;

    public ReportesController(){
        proyectosDao = new ProyectosDao();
        listaLideresDao = new ListaLideresDao();
        comprasProyectoDao = new ComprasProyectoDao();
    }

    public List<ProyectosVo> listarProyectos() throws SQLException{
        return proyectosDao.listar();
    }

    public List<ComprasProyectoVo> listarTotalAdeudadoProyecto() throws SQLException{
        return comprasProyectoDao.listar();
    }

    public List<ListaLideresVo> listarLideres() throws SQLException{
        return listaLideresDao.listar();
    }

}
