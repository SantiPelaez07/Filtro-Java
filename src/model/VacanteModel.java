package model;

import database.CRUD;
import database.ConfigDB;
import entities.Vacante;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class VacanteModel implements CRUD {
    @Override
    public Object create(Object object) {
        Connection conexion = ConfigDB.openConnection();
        Vacante vacante = (Vacante) object;
        String sql = "INSERT INTO vacante (id, titulo, descripcion, duracion, estado, empresa_id) VALUES (?,?,?,?,?,?);";
        try {
            PreparedStatement prepared = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            prepared.setInt(1, vacante.getId());
            prepared.setString(2, vacante.getTitulo());
            prepared.setString(3,vacante.getDescripcion());
            prepared.setString(4, vacante.getDuracion());
            prepared.setString(5, vacante.getEstado());
            prepared.setInt(6, vacante.getEmpresa_id());

            prepared.execute();

            ResultSet result = prepared.getGeneratedKeys();
            if (result.next()){
                vacante.setId(result.getInt(1));
            }
            JOptionPane.showMessageDialog(null, "Vacante agregada correctamente\n" + vacante);
        }catch (SQLException error){
            JOptionPane.showMessageDialog(null, error.getMessage());
        }finally{
            ConfigDB.closeConecction();
        }
        return vacante;
    }

    @Override
    public ArrayList<Object> list() {
        Connection conexion = ConfigDB.openConnection();
        ArrayList<Object> listaVacantes = new ArrayList<>();
        String sql = "SELECT * FROM vacante;";
        try {
            PreparedStatement prepared = conexion.prepareStatement(sql);
            ResultSet result = prepared.executeQuery();
            while (result.next()){
                Vacante vacante = new Vacante();
                vacante.setId(result.getInt("id"));
                vacante.setTitulo(result.getString("titulo"));
                vacante.setDescripcion(result.getString("descripcion"));
                vacante.setDuracion(result.getString("duracion"));
                vacante.setEstado(result.getString("estado"));
                vacante.setEmpresa_id(result.getInt("empresa_id"));
                listaVacantes.add(vacante);
            }

        }catch (SQLException error){
            JOptionPane.showMessageDialog(null, error.getMessage());
        }finally{
            ConfigDB.closeConecction();
        }
        return listaVacantes;
    }

    @Override
    public boolean update(Object object) {
        Connection conexion = ConfigDB.openConnection();
        boolean update = false;
        Vacante vacante = (Vacante) object;
        String sql = "UPDATE vacante SET titulo = ?, descripcion = ?, duracion = ?, estado = ?, empresa_id = ? WHERE id = ?;";
        try {
            PreparedStatement prepared = conexion.prepareStatement(sql);
            prepared.setString(1, vacante.getTitulo());
            prepared.setString(2,vacante.getDescripcion());
            prepared.setString(3, vacante.getDuracion());
            prepared.setString(4, vacante.getEstado());
            prepared.setInt(5, vacante.getEmpresa_id());
            prepared.setInt(6, vacante.getId());

            int filasAfectadas = prepared.executeUpdate();
            if (filasAfectadas > 0){
                update = true;
                JOptionPane.showMessageDialog(null, "Vacante actualizada correctamente" + vacante);
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
        Vacante vacante = (Vacante) object;
        String sql = "DELETE FROM vacante WHERE id = ?";
        try {
            PreparedStatement prepared = conexion.prepareStatement(sql);
            prepared.setInt(1, vacante.getId());

            int filasAfectadas = prepared.executeUpdate();
            if (filasAfectadas > 0){
                delete = true;
                JOptionPane.showMessageDialog(null, "Vacante eliminada correctamente\n" + vacante);
            }

        }catch (SQLException error){
            JOptionPane.showMessageDialog(null, error.getMessage());
        }finally{
            ConfigDB.closeConecction();
        }
        return delete;
    }

    public Vacante buscarId(int id){
        Connection conexion = ConfigDB.openConnection();
        Vacante vacante = null;
        String sql = "SELECT * FROM vacante WHERE id = ?";
        try {
            PreparedStatement prepared = conexion.prepareStatement(sql);
            prepared.setInt(1, id);

            ResultSet result = prepared.executeQuery();
            if (result.next()){
                vacante = new Vacante();
                vacante.setId(result.getInt("id"));
                vacante.setTitulo(result.getString("titulo"));
                vacante.setDescripcion(result.getString("descripcion"));
                vacante.setDuracion(result.getString("duracion"));
                vacante.setEstado(result.getString("estado"));
                vacante.setEmpresa_id(result.getInt("empresa_id"));
            }
        }catch (SQLException error){
            JOptionPane.showMessageDialog(null, error.getMessage());
        }finally{
            ConfigDB.closeConecction();
        }
        return vacante;
    }


}
