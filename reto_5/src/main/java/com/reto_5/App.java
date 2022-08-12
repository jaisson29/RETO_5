package com.reto_5;

import com.reto_5.view.ReportesView;
import java.awt.*;

import javax.swing.JFrame;
public class App 
{
    public static void main( String[] args )
    {
        //--PROYECTOS FINANCIADOS POR BANCO
        ReportesView reportesView = new ReportesView();
        
        //crear un layout para la ventana
        reportesView.setLayout(new FlowLayout());
        //dimensionar el layout
        reportesView.setSize(600, 400);
        //esto hace visible laventana
        reportesView.setVisible(true);
        //setResizable(false) para que no se pueda cambiar de tamaño
        reportesView.setResizable(false);
        //Titulo de la ventana
        reportesView.setTitle("Informes reto 5");
        reportesView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setLocationRelativeTo(null); esto ubica la ventana en el centro de la pantalla
        reportesView.setLocationRelativeTo(null);


    }
} 
