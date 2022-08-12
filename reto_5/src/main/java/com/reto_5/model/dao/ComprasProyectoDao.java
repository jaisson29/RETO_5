package com.reto_5.model.dao;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.reto_5.model.vo.ComprasProyectoVo;
import com.reto_5.utils.JDBCUtilities;

public class ComprasProyectoDao {
    public List<ComprasProyectoVo> listar() throws SQLException {
        ArrayList<ComprasProyectoVo> respuesta = new ArrayList<>();
        Connection conn = JDBCUtilities.getConnection();
        Statement st = null;
        ResultSet rs = null;
        String consulta = "SELECT ID_Compra, p.Constructora, p.Banco_Vinculado  ";
        consulta += "FROM Compra c ";
        consulta += "JOIN Proyecto p  ";
        consulta += "ON c.ID_Proyecto = p.ID_Proyecto  ";
        consulta += "WHERE Proveedor ='Homecenter' AND p.Ciudad = 'Salento'; ";
        try {
            st = conn.createStatement();
            rs = st.executeQuery(consulta);
            while (rs.next()) {
                ComprasProyectoVo vo = new ComprasProyectoVo();
                vo.setId(rs.getInt("id_compra"));
                vo.setConstructora(rs.getString("constructora"));
                vo.setBanco(rs.getString("banco_vinculado"));

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
