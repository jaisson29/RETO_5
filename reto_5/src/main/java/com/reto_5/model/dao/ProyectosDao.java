package com.reto_5.model.dao;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.reto_5.model.vo.ProyectosVo;
import com.reto_5.utils.JDBCUtilities;




public class ProyectosDao {
    public List<ProyectosVo> listar() throws SQLException {
        ArrayList<ProyectosVo> respuesta = new ArrayList<>();
        Connection conn = JDBCUtilities.getConnection();
        Statement st = null;
        ResultSet rs = null;
        String consulta = "SELECT ID_Proyecto AS id, Constructora ,Numero_Habitaciones AS habitaciones, Ciudad ";
        consulta += "FROM Proyecto p  ";
        consulta += "WHERE Clasificacion = 'Casa Campestre' AND Ciudad IN('Santa Marta', 'Cartagena', 'Barranquilla'); ";

        try {
            st = conn.createStatement();
            rs = st.executeQuery(consulta);
            while (rs.next()) {
                ProyectosVo vo = new ProyectosVo();
                vo.setId(rs.getInt("id"));
                vo.setConstructora(rs.getString("constructora"));
                vo.setHabitaciones(rs.getInt("habitaciones"));
                vo.setCiudad(rs.getString("ciudad"));


                respuesta.add(vo);
            }
        } finally {
            if (rs != null){
                rs.close();
            }
            if(st != null) {
                st.close();
            }
            if (conn != null){
                conn.close();
            }
        }

        return respuesta;
    }

}
