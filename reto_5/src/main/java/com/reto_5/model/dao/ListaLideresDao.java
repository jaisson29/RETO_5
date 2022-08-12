package com.reto_5.model.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.reto_5.model.vo.ListaLideresVo;
import com.reto_5.utils.JDBCUtilities;

public class ListaLideresDao {
    public List<ListaLideresVo> listar() throws SQLException {
        ArrayList<ListaLideresVo> respuesta = new ArrayList<>();
        Connection conn = JDBCUtilities.getConnection();
        Statement st = null;
        ResultSet rs = null;
        String consulta = "SELECT ID_Lider AS id, ";
                consulta += "Nombre, ";
                consulta += "Primer_Apellido AS apellido,";
                consulta += "Ciudad_Residencia AS ciudad ";
                consulta += "FROM Lider l  ";
                consulta += "ORDER BY Ciudad_Residencia; ";

        try {
            st = conn.createStatement();
            rs = st.executeQuery(consulta);
            while (rs.next()) {
                ListaLideresVo vo = new ListaLideresVo();
                vo.setId(rs.getInt("id"));
                vo.setNombre(rs.getString("nombre"));
                vo.setApellido(rs.getString("apellido"));
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
