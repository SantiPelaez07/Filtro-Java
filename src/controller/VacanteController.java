package controller;

import entities.Coder;
import entities.Contratacion;
import entities.Vacante;
import model.VacanteModel;

import javax.swing.*;

public class VacanteController {
    public static void crear(){
        VacanteModel objModel = new VacanteModel();
        String titulo = JOptionPane.showInputDialog("Ingrese el titulo de la vacante: ");
        String descripcion = JOptionPane.showInputDialog("Ingrese la descripción de la vacante: ");
        String duracion = JOptionPane.showInputDialog("Ingrese la duración de la vacante: ");
        String estado = JOptionPane.showInputDialog("Ingrese el estado de la vacante (Activo/inactivo): ");
        int empresa_id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id de la empresa a la cual corresponde la vacante: "));
        Vacante vacante = new Vacante();
        vacante.setTitulo(titulo);
        vacante.setDescripcion(descripcion);
        vacante.setDuracion(duracion);
        vacante.setEstado(estado);
        vacante.setEmpresa_id(empresa_id);
        objModel.create(vacante);
    }

    public static String listar(){
        VacanteModel objModel = new VacanteModel();
        String listaVacantes = "LISTA DE VACANTES\n";
        if (objModel.list().isEmpty()){
            JOptionPane.showMessageDialog(null, "Lista vacía");
        }else {
            for (Object iterador : objModel.list()) {
                Vacante vacante = (Vacante) iterador;
                listaVacantes += vacante;
            }
            JOptionPane.showMessageDialog(null, listaVacantes);
        }
        return listaVacantes;
    }

    public  static String listarString(){
        VacanteModel objModel = new VacanteModel();
        String listaVacantes = "LISTA DE VACANTES\n";
        if (objModel.list().isEmpty()){
            JOptionPane.showMessageDialog(null, "Lista vacía");
        }else {
            for (Object iterador : objModel.list()) {
                Vacante vacante = (Vacante) iterador;
                listaVacantes += vacante;
            }
        }
        return listaVacantes;
    }

    public static Vacante actualizar(){
        VacanteModel objModel = new VacanteModel();
        int idUpdate = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id de la vacante que desea actualizar: \n" + listarString()));
        Vacante vacante = objModel.buscarId(idUpdate);
        if (vacante == null){
            JOptionPane.showMessageDialog(null, "El id que proporcionaste no corresponde a ninguna vacante");
        }else {
            String titulo = JOptionPane.showInputDialog("Ingrese el titulo de la vacante: ", vacante.getTitulo());
            String descripcion = JOptionPane.showInputDialog("Ingrese la descripción de la vacante: ", vacante.getDescripcion());
            String duracion = JOptionPane.showInputDialog("Ingrese la duración de la vacante: ", vacante.getDuracion());
            String estado = JOptionPane.showInputDialog("Ingrese el estado de la vacante (Activo/inactivo): ", vacante.getEstado());
            int empresa_id = Integer.parseInt(JOptionPane.showInputDialog(VacanteController.listarString() + "\nIngrese el id de la empresa a la cual corresponde la vacante: ", vacante.getEmpresa_id()));
            vacante.setTitulo(titulo);
            vacante.setDescripcion(descripcion);
            vacante.setDuracion(duracion);
            vacante.setEstado(estado);
            vacante.setEmpresa_id(empresa_id);
            objModel.update(vacante);
        }
        return vacante;
    }

    public static Object eliminar(){
        VacanteModel objModel = new VacanteModel();
        int idRemove = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id de la vacante que desea eliminar: \n" + listarString()));
        Vacante vacante = objModel.buscarId(idRemove);
        if (vacante == null){
            JOptionPane.showMessageDialog(null, "El id que proporcionaste no corresponde a ninguna vacante");
        }else {
            int confirm = JOptionPane.showConfirmDialog(null, "¿Estás seguro de eliminar esta vacante?\n" + vacante);
            if (confirm == 0){
                objModel.delete(vacante);
            } else {
                JOptionPane.showMessageDialog(null, "La vacante no ha podido eliminarse correctamente");
            }
        }
        return vacante;
    }
}
