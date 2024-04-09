package model;

import database.CRUD;
import database.ConfigDB;
import entities.Coder;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class CoderModel implements CRUD {
    @Override
    public Object create(Object object) {
        Connection conexion = ConfigDB.openConnection();
        Coder coder = (Coder) object;
        String sql = "INSERT INTO coder (id, nombre, apellidos, documento, cohorte, cv) VALUES (?,?,?,?,?,?);";
        try {
            PreparedStatement prepared = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            prepared.setInt(1, coder.getId());
            prepared.setString(2, coder.getNombre());
            prepared.setString(3,coder.getApellidos());
            prepared.setString(4, coder.getDocumento());
            prepared.setInt(5, coder.getCohorte());
            prepared.setString(6, coder.getCv());

            prepared.execute();

            ResultSet result = prepared.getGeneratedKeys();
            if (result.next()){
                coder.setId(result.getInt(1));
            }
                JOptionPane.showMessageDialog(null, "Coder agregado correctamente\n" + coder);
        }catch (SQLException error){
            JOptionPane.showMessageDialog(null, error.getMessage());
        }finally{
            ConfigDB.closeConecction();
        }
        return coder;
    }

    @Override
    public ArrayList<Object> list() {
        Connection conexion = ConfigDB.openConnection();
        ArrayList<Object> listaCoders = new ArrayList<>();
        String sql = "SELECT * FROM coder;";
        try {
            PreparedStatement prepared = conexion.prepareStatement(sql);
            ResultSet result = prepared.executeQuery();
            while (result.next()){
                Coder coder = new Coder();
                coder.setId(result.getInt("id"));
                coder.setNombre(result.getString("nombre"));
                coder.setApellidos(result.getString("apellidos"));
                coder.setDocumento(result.getString("documento"));
                coder.setCohorte(result.getInt("cohorte"));
                coder.setCv(result.getString("cv"));
                listaCoders.add(coder);
            }

        }catch (SQLException error){
            JOptionPane.showMessageDialog(null, error.getMessage());
        }finally{
            ConfigDB.closeConecction();
        }
        return listaCoders;
    }

    @Override
    public boolean update(Object object) {
        Connection conexion = ConfigDB.openConnection();
        boolean update = false;
        Coder coder = (Coder) object;
        String sql = "UPDATE coder SET nombre = ?, apellidos = ?, documento = ?, cohorte = ?, cv = ? WHERE id = ?;";
        try {
            PreparedStatement prepared = conexion.prepareStatement(sql);
            prepared.setString(1, coder.getNombre());
            prepared.setString(2,coder.getApellidos());
            prepared.setString(3, coder.getDocumento());
            prepared.setInt(4, coder.getCohorte());
            prepared.setString(5, coder.getCv());
            prepared.setInt(6, coder.getId());

            int filasAfectadas = prepared.executeUpdate();
            if (filasAfectadas > 0){
                update = true;
                JOptionPane.showMessageDialog(null, "Coder actualizado correctamente" + coder);
            }
        }catch (SQLException error){
            JOptionPane.showMessageDialog(null, error.getMessage());
        }finally{
            ConfigDB.closeConecction();
        }
        return update;
    }

    @Override
    public boolean delete(Object object) {
        Connection conexion = ConfigDB.openConnection();
        boolean delete = false;
        Coder coder = (Coder) object;
        String sql = "DELETE FROM coder WHERE id = ?";
        try {
            PreparedStatement prepared = conexion.prepareStatement(sql);
            prepared.setInt(1, coder.getId());

            int filasAfectadas = prepared.executeUpdate();
            if (filasAfectadas > 0){
                delete = true;
                JOptionPane.showMessageDialog(null, "Coder eliminado correctamente\n" + coder);
            }

        }catch (SQLException error){
            JOptionPane.showMessageDialog(null, error.getMessage());
        }finally{
            ConfigDB.closeConecction();
        }
        return delete;
    }

    public Coder buscarId(int id){
        Connection conexion = ConfigDB.openConnection();
        Coder coder = null;
        String sql = "SELECT * FROM coder WHERE id = ?";
        try {
            PreparedStatement prepared = conexion.prepareStatement(sql);
            prepared.setInt(1, id);

            ResultSet result = prepared.executeQuery();
            if (result.next()){
                coder = new Coder();
                coder.setId(result.getInt("id"));
                coder.setNombre(result.getString("nombre"));
                coder.setApellidos(result.getString("apellidos"));
                coder.setDocumento(result.getString("documento"));
                coder.setCohorte(result.getInt("cohorte"));
                coder.setCv(result.getString("cv"));
            }
        }catch (SQLException error){
            JOptionPane.showMessageDialog(null, error.getMessage());
        }finally{
            ConfigDB.closeConecction();
        }
        return coder;
    }

}
