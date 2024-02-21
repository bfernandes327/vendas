package modelo_query.dao;

import conexao.Banco;
// busca dados do mysql aqui 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Samuelson
 */
public class vendas {

    public boolean checkData(String data) {

        Connection con = Banco.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        boolean check = false;

        try {

            stmt = con.prepareStatement("select total_venda from vendas where data_venda = ?");
            stmt.setString(1, data);
          //  stmt.setString(2, senha);

            rs = stmt.executeQuery();

            if (rs.next()) {                
                check = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(vendas.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Banco.closeConnection(con, stmt, rs);
        }

        return check;

    }

}
