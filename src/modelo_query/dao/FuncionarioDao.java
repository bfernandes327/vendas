/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo_query.dao;

import conexao.Banco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Produto;
import model.bean.Funcionario;

/**
 *
 * @author Samuelson
 */
public class FuncionarioDao {

    public void create(Funcionario v) {
        
        Connection con = Banco.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO funcionario (nome,email,celular,telefone,cep,endereco,numero,bairro,cidade,complemento,uf,rg,cpf,cargo,senha,acesso,login)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            stmt.setString(1, v.getnome());
            stmt.setString(2, v.getemail());
            stmt.setString(3, v.getcelular());
            stmt.setString(4, v.gettelefone());
            stmt.setString(5, v.getcep());
            stmt.setString(6, v.getendereco());
            stmt.setString(7, v.getnumero());
            stmt.setString(8, v.getbairro());
            stmt.setString(9, v.getcidade());
            stmt.setString(10, v.getcomplemento());
            stmt.setString(11, v.getuf());
            stmt.setString(12, v.getrg());
            stmt.setString(13, v.getcpf());
            stmt.setString(14, v.getcargo());
            stmt.setString(15, v.getsenha());
            stmt.setString(16, v.getacesso());
            stmt.setString(17, v.getlogin());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            Banco.closeConnection(con, stmt);
        }
    }
    
    public List<Funcionario> read() {

        Connection con = Banco.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Funcionario> funcionarios = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM funcionario");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Funcionario funcionario = new Funcionario();

                funcionario.setid(rs.getInt("id"));
                funcionario.setnome(rs.getString("nome"));
                funcionario.setemail(rs.getString("email"));
                funcionario.setlogin(rs.getString("login"));
                funcionario.setsenha(rs.getString("senha"));
                
                funcionarios.add(funcionario);
            }

        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Banco.closeConnection(con, stmt, rs);
        }

        return funcionarios;

    }
    
    public List<Produto> readForDesc(String desc) {

        Connection con = Banco.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Produto> produtos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM produto WHERE descricao LIKE ?");
            stmt.setString(1, "%"+desc+"%");
            
            rs = stmt.executeQuery();

            while (rs.next()) {

                Produto produto = new Produto();

                produto.setId(rs.getInt("id"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setQtd(rs.getInt("qtd"));
                produto.setPreco(rs.getDouble("preco"));
                produtos.add(produto);
            }

        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Banco.closeConnection(con, stmt, rs);
        }

        return produtos;

    }

    public void update(Funcionario p) {

        Connection con = Banco.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE funcionario SET nome = ? ,email = ?,login = ?,senha = ? WHERE id = ?");
            stmt.setString(1, p.getnome());
            stmt.setString(2, p.getemail());
            stmt.setString(3, p.getlogin());
            stmt.setString(4, p.getsenha());
            stmt.setInt(5, p.getid());
            

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            Banco.closeConnection(con, stmt);
        }

    }
    public void delete(Funcionario p) {

        Connection con = Banco.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM funcionario WHERE id = ?");
            stmt.setInt(1, p.getid());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            Banco.closeConnection(con, stmt);
        }

    } 
   
}
