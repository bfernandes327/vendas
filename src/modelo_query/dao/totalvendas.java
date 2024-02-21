package modelo_query.dao;

import conexao.Banco;
// busca dados do mysql aqui 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
//import model.bean.venda_bean;

/**
 *
 * @author 
 * 
 * classe = totalvendas
 * metodo = checkData
 * valor = string 
 */
public class totalvendas {

    public int checkData(String data) {

        Connection con = Banco.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        int check = 0;

        try {
// SELECT sum(valor) as total FROM vendas where data = '2030-02-20';
            stmt = con.prepareStatement("SELECT sum(total_venda) as total FROM vendas WHERE data_venda = ?");
            stmt.setString(1, data);
            //stmt.setString(2, senha);
            rs = stmt.executeQuery();

            if (rs.next()) {                
                check = rs.getInt("total");
            }   
        } catch (SQLException ex) {
            Logger.getLogger(totalvendas.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Banco.closeConnection(con, stmt, rs);
        }

        return check;
    }
}
