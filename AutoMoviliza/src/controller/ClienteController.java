/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
/**
 *
 * @author Cetecom
 */
import Bd.Conexion;
import Controller.HelperController;
import com.mysql.cj.x.protobuf.MysqlxPrepare;
import java.util.ArrayList;
import java.util.List;
import models.Cliente;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class ClienteController {
    Conexion cx = new Conexion();
    HelperController helper = new HelperController();
    
    
    public List<Cliente> obtenerClientes(){
        List<Cliente> clientes = new ArrayList<>();
        String query = "SELECT * FROM CLIENTE;";
        try {
            ResultSet rs = cx.EjecutarQuery(query);
            while(rs.next()){
                clientes.add(new Cliente(
                rs.getInt("id_cliente"),
                rs.getString("rut"),
                rs.getString("nombre"),
                rs.getString("numero_contacto"),
                rs.getString("direccion"),
                rs.getString("tipo_cliente")
                ));
            }
        } catch (Exception e) {
            helper.showError("Cliente no encontrado." + e.getMessage());
        }return clientes;
    }
    
    public void agregarCliente(String parRut, String parNombre, String parNumeroContacto, String parDireccion, String parTipoCliente){
        cx.conectar();
        String query = "INSERT INTO cliente (rut, nombre, numero_contacto, direccion, tipo_cliente) VALUES (?,?,?,?,?);";
        try {
            PreparedStatement st = cx.getConnection().prepareStatement(query);
            st.setString(1, parRut);
            st.setString(2, parNombre);
            st.setString(3, parNumeroContacto);
            st.setString(4, parDireccion);
            st.setString(5, parTipoCliente);
            st.executeUpdate();
            helper.showInformation("Cliente agregado correctamente.");
        } catch (Exception e) {
            helper.showError("Error al agregar cliente: "+e.getMessage());
        }
        
    }
    
    public Cliente buscarCliente(int parIdCliente){
        Cliente clienteEncontrado = null;
        String query = "SELECT * FROM cliente WHERE id = "+parIdCliente+";";
        try {
            ResultSet rs = cx.EjecutarQuery(query);
            if(rs.next()){
                clienteEncontrado = new Cliente();
                clienteEncontrado.setRut(rs.getString("rut"));
                clienteEncontrado.setNombreCliente(rs.getString("nombre"));
                clienteEncontrado.setNumeroContacto(rs.getString("numero_contacto"));
                clienteEncontrado.setDireccion(rs.getString("direcion"));
                clienteEncontrado.setTipoCliente(rs.getString("tipo_cliente"));
            }
        } catch (Exception e) {
            helper.showError("Error al buscar el cliente: "+e.getMessage());
        }
        return clienteEncontrado;
    }
    
    public void editarCliente(int parIdCliente, String parRut, String parNombre, String parNumeroContacto, String parDireccion, String parTipoCliente){
        String query = "UPDATE cliente WHERE id_cliente = "+parIdCliente+" (rut, nombre, numero_contacto, direccion, tipo_cliente) "
                        + "VALUES (?,?,?,?,?)"+";";
        Cliente clienteEncontrado = null;
        buscarCliente(parIdCliente);
        try {
            ResultSet rs  = cx.EjecutarQuery(query);
            if(clienteEncontrado != null){
                PreparedStatement st = cx.getConnection().prepareStatement(query);
                st.setString(1, parRut);
                st.setString(2, parNombre);
                st.setString(3, parNumeroContacto);
                st.setString(4, parDireccion);
                st.setString(5, parTipoCliente);
            }
            helper.showInformation("Cliente actualizado.");
        } catch (Exception e) {
            helper.showError("Error al editar cliente: "+e.getMessage());
        }
    }
    
    public void eliminarCLiente(int parIdCliente){
        String query = "DELETE FROM cliente WHERE id_cliente = "+parIdCliente+";";
        
    }
}
