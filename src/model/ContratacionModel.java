package model;

import database.CRUD;
import database.ConfigDB;
import entities.Contratacion;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class ContratacionModel implements CRUD {
    @Override
    public Object create(Object object) {
        Connection conexion = ConfigDB.openConnection();
        Contratacion contratacion = (Contratacion) object;
        String sql = "INSERT INTO contratacion (id, fecha_aplicacion, estado, salario, vacante_id, coder_id) VALUES (?,?,?,?,?,?);";
        try {
            PreparedStatement prepared = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            prepared.setInt(1, contratacion.getId());
            prepared.setString(2, contratacion.getFecha_aplicacion());
            prepared.setString(3,contratacion.getEstado());
            prepared.setDouble(4, contratacion.getSalario());
            prepared.setInt(5, contratacion.getVacante_id());
            prepared.setInt(6, contratacion.getCoder_id());

            prepared.execute();

            ResultSet result = prepared.getGeneratedKeys();
            if (result.next()){
                contratacion.setId(result.getInt(1));
            }
            JOptionPane.showMessageDialog(null, "Contratación asignada correctamente\n" + contratacion);
        }catch (SQLException error){
            JOptionPane.showMessageDialog(null, error.getMessage());
        }finally{
            ConfigDB.closeConecction();
        }
        return contratacion;
    }

    @Override
    public ArrayList<Object> list() {
        Connection conexion = ConfigDB.openConnection();
        ArrayList<Object> listaContrataciones = new ArrayList<>();
        String sql = "SELECT * FROM contratacion;";
        try {
            PreparedStatement prepared = conexion.prepareStatement(sql);
            ResultSet result = prepared.executeQuery();
            while (result.next()){
                Contratacion contratacion = new Contratacion();
                contratacion.setId(result.getInt("id"));
                contratacion.setFecha_aplicacion(result.getString("fecha_aplicacion"));
                contratacion.setEstado(result.getString("estado"));
                contratacion.setSalario(result.getDouble("salario"));
                contratacion.setVacante_id(result.getInt("vacante_id"));
                contratacion.setCoder_id(result.getInt("coder_id"));
                listaContrataciones.add(contratacion);
            }

        }catch (SQLException error){
            JOptionPane.showMessageDialog(null, error.getMessage());
        }finally{
            ConfigDB.closeConecction();
        }
        return listaContrataciones;
    }

    @Override
    public boolean update(Object object) {
        Connection conexion = ConfigDB.openConnection();
        boolean update = false;
        Contratacion contratacion = (Contratacion) object;
        String sql = "UPDATE contratacion SET fecha_aplicacion = ?, estado = ?, salario = ?, vacante_id = ?, coder_id = ? WHERE id = ?;";
        try {
            PreparedStatement prepared = conexion.prepareStatement(sql);
            prepared.setString(1, contratacion.getFecha_aplicacion());
            prepared.setString(2,contratacion.getEstado());
            prepared.setDouble(3, contratacion.getSalario());
            prepared.setInt(4, contratacion.getVacante_id());
            prepared.setInt(5, contratacion.getCoder_id());
            prepared.setInt(6, contratacion.getId());

            int filasAfectadas = prepared.executeUpdate();
            if (filasAfectadas > 0){
                update = true;
                JOptionPane.showMessageDialog(null, "Contratación actualizada correctamente" + contratacion);
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
        Contratacion contratacion = (Contratacion) object;
        String sql = "DELETE FROM contratacion WHERE id = ?";
        try {
            PreparedStatement prepared = conexion.prepareStatement(sql);
            prepared.setInt(1, contratacion.getId());

            int filasAfectadas = prepared.executeUpdate();
            if (filasAfectadas > 0){
                delete = true;
                JOptionPane.showMessageDialog(null, "Contratación eliminada correctamente\n" + contratacion);
            }

        }catch (SQLException error){
            JOptionPane.showMessageDialog(null, error.getMessage());
        }finally{
            ConfigDB.closeConecction();
        }
        return delete;
    }

    public Contratacion buscarId(int id){
        Connection conexion = ConfigDB.openConnection();
        Contratacion contratacion = null;
        String sql = "SELECT * FROM contratacion WHERE id = ?";
        try {
            PreparedStatement prepared = conexion.prepareStatement(sql);
            prepared.setInt(1, id);

            ResultSet result = prepared.executeQuery();
            if (result.next()){
                contratacion = new Contratacion();
                contratacion.setId(result.getInt("id"));
                contratacion.setFecha_aplicacion(result.getString("fecha_aplicacion"));
                contratacion.setEstado(result.getString("estado"));
                contratacion.setSalario(result.getDouble("salario"));
                contratacion.setVacante_id(result.getInt("vacante_id"));
                contratacion.setCoder_id(result.getInt("coder_id"));
            }
        }catch (SQLException error){
            JOptionPane.showMessageDialog(null, error.getMessage());
        }finally{
            ConfigDB.closeConecction();
        }
        return contratacion;
    }
}
