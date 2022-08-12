package com.reto_5.view;

import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.awt.*;

import com.reto_5.controller.ReportesController;
import com.reto_5.model.vo.ListaLideresVo;
import com.reto_5.model.vo.ComprasProyectoVo;
import com.reto_5.model.vo.ProyectosVo;

public class ReportesView extends JFrame implements ActionListener{
    private static ReportesController controller;
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem primerInf, segundoInf, tercerInf;
    private JTable tabla;
    private DefaultTableModel modelo;
    private JLabel lblTitulo, lblConsulta;

    public ReportesView() {
        controller = new ReportesController();
        menu();
        etiqueta1();
        etiqueta2();
        tabla();
    }

    public void tabla() {
        tabla = new JTable(modelo);
        tabla.setPreferredScrollableViewportSize(new Dimension(500, 200));
        add(tabla); 
        JScrollPane pane = new JScrollPane(tabla);
        add(pane);
    }

    public void etiqueta1() {
        lblTitulo = new JLabel("Informe reto 5");
        lblTitulo.setPreferredSize(new Dimension(500, 30));
        lblTitulo.setSize(500, 30);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 20));
        add(lblTitulo);
    }

    public void etiqueta2() {
        lblConsulta = new JLabel();
        lblConsulta.setPreferredSize(new Dimension(500, 30));
        lblConsulta.setSize(500, 30);
        lblConsulta.setFont(new Font("Arial", Font.BOLD, 14));
        add(lblConsulta);

    }

    

    public void menu(){
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menu = new JMenu("Informes");
        menuBar.add(menu);
        primerInf = new JMenuItem("Primer informe");
        segundoInf = new JMenuItem("Segundo informe");
        tercerInf = new JMenuItem("Tercer informe");
        menu.add(primerInf);
        menu.add(segundoInf);
        menu.add(tercerInf);
        primerInf.addActionListener(this);
        segundoInf.addActionListener(this);
        tercerInf.addActionListener(this);
    }

    public void segundoInforme() {
        // Imprimir en pantalla la información del proyecto
        try {
            List<ProyectosVo> proyectos = controller.listarProyectos();
            //Creacion del modelo
            modelo = new DefaultTableModel();
            modelo.addColumn("Id Proyecto");
            modelo.addColumn("Constructora");
            modelo.addColumn("Habitaciones");
            modelo.addColumn("Ciudad");
            for (ProyectosVo proyecto : proyectos) {
                Object[] fila = new Object[4];
                fila[0] = proyecto.getId();
                fila[1] = proyecto.getConstructora();
                fila[2] = proyecto.getHabitaciones();
                fila[3] = proyecto.getCiudad();
                modelo.addRow(fila);
            }
            //ACtualizo el modelo de la tabla
            tabla.setModel(modelo);
            modelo.fireTableDataChanged();
        } catch (Exception ex) {
            System.err.println("Error: " + ex);
            ex.printStackTrace();
        }
        
    }
    public void tercerInforme() {
        //  Imprimir en pantalla la información del total adeudado
        try {
            List<ComprasProyectoVo> Cproyecto = controller.listarTotalAdeudadoProyecto();
            //Creacion del modelo
            modelo = new DefaultTableModel();
            modelo.addColumn("Id compra");
            modelo.addColumn("Constructora");
            modelo.addColumn("Banco vinculado");
            for (ComprasProyectoVo Cproyectos : Cproyecto) {
                Object[] fila = new Object[4];
                fila[0] = Cproyectos.getId();
                fila[1] = Cproyectos.getConstructora();
                fila[2] = Cproyectos.getBanco();
                modelo.addRow(fila);
            }
            //ACtualizo el modelo de la tabla
            tabla.setModel(modelo);
            modelo.fireTableDataChanged();
        } catch (Exception e) {
            System.out.println("Error: "+ e);
            e.printStackTrace();
        }
        
    }

    public void primerInforme() {
        // Imprimir en pantalla la información de los líderes
        try {
            List<ListaLideresVo> lideres = controller.listarLideres();
            //Creacion del modelo
            modelo = new DefaultTableModel();
            modelo.addColumn("Id Lider");
            modelo.addColumn("Nombre");
            modelo.addColumn("Apellido");
            modelo.addColumn("Ciudad");
            for (ListaLideresVo lider : lideres) {
                Object[] fila = new Object[4];
                fila[0] = lider.getId();
                fila[1] = lider.getNombre();
                fila[2] = lider.getApellido();
                fila[3] = lider.getCiudad();
                modelo.addRow(fila);
            }
            //ACtualizo el modelo de la tabla
            tabla.setModel(modelo);
            modelo.fireTableDataChanged();

        } catch (Exception e) {
            System.out.println("Error: "+ e);
            e.printStackTrace();
        }
    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == primerInf){
            primerInforme();
            lblConsulta.setText("Informe de lideres");
        }else if(e.getSource() == segundoInf) {
            segundoInforme();
            lblConsulta.setText("Informe de Proyectos");
        }else if(e.getSource() == tercerInf) {
            tercerInforme();
            lblConsulta.setText("Informe de Compras por poryecto");
        }
        
    }
}
