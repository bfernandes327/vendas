/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

/**
 *
 * @author Samuelson
 */
public class venda_bean {
    
       
    private String data_venda;
    private int total_venda;
    private String obs;
    
    public String getdata_venda() {
        return data_venda;
    }

    public void setdata_venda(String data) {
        this.data_venda = data;
    }
    
    public int gettotal_venda() {
        return total_venda;
    }

    public void settotal_venda(int valor) {
        this.total_venda = valor;
    }
    
    public String getobs() {
        return obs;
    }

    public void setobs(String obs) {
        this.obs = obs;
    }   
}
