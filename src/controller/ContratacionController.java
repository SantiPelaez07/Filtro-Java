package controller;


import entities.Contratacion;
import model.ContratacionModel;

import javax.swing.*;

public class ContratacionController {
    public static void crear(){
        ContratacionModel objModel = new ContratacionModel();
        String estado = JOptionPane.showInputDialog("Ingrese el estado de la Contratación (Activa/inactiva/pendiente): ");
        double salario = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el salario de la contratación: "));
        int vacante_id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id de la vacante a la cual se le realizó una contratación: "));
        int coder_id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del coder que se contrató: \n" + CoderController.listarString()));
        Contratacion contratacion = new Contratacion();
        contratacion.setEstado(estado);
        contratacion.setSalario(salario);
        contratacion.setVacante_id(vacante_id);
        contratacion.setCoder_id(coder_id);
        objModel.create(contratacion);
    }

    public static String listar(){
        ContratacionModel objModel = new ContratacionModel();
        String listaContrataciones = "LISTA DE CONTRATACIONES\n";
        if (objModel.list().isEmpty()){
            JOptionPane.showMessageDialog(null, "Lista vacía");
        }else {
            for (Object iterador : objModel.list()) {
                Contratacion contratacion = (Contratacion) iterador;
                listaContrataciones += contratacion;
            }
            JOptionPane.showMessageDialog(null, listaContrataciones);
        }
        return listaContrataciones;
    }

    public  static String listarString(){
        ContratacionModel objModel = new ContratacionModel();
        String listaContrataciones = "LISTA DE CONTRATACIONES\n";
        if (objModel.list().isEmpty()){
            listaContrataciones = "Lista vacía";
        }else {
            for (Object iterador : objModel.list()) {
                Contratacion contratacion = (Contratacion) iterador;
                listaContrataciones += contratacion;
            }
        }
        return listaContrataciones;
    }

    public static Contratacion actualizar(){
        ContratacionModel objModel = new ContratacionModel();
        int idUpdate = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id de la contratación que desea actualizar: \n" + listarString()));
        Contratacion contratacion = objModel.buscarId(idUpdate);
        if (contratacion == null){
            JOptionPane.showMessageDialog(null, "El id que proporcionaste no corresponde a ninguna Contratación");
        }else {
            String estado = JOptionPane.showInputDialog("Ingrese el estado de la Contratación (Activa/inactiva/pendiente): ", contratacion.getEstado());
            double salario = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el salario de la contratación: ", contratacion.getSalario()));
            int vacante_id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id de la vacante a la cual se le realizó una contratación: ", contratacion.getVacante_id()));
            int coder_id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del coder que se contrató: \n" + CoderController.listarString(), contratacion.getCoder_id()));
            contratacion.setEstado(estado);
            contratacion.setSalario(salario);
            contratacion.setVacante_id(vacante_id);
            contratacion.setCoder_id(coder_id);
            objModel.update(contratacion);
        }
        return contratacion;
    }

    public static Object eliminar(){
        ContratacionModel objModel = new ContratacionModel();
        int idRemove = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id de la contratación que desea eliminar: \n" + listarString()));
        Contratacion contratacion = objModel.buscarId(idRemove);
        if (contratacion == null){
            JOptionPane.showMessageDialog(null, "El id que proporcionaste no corresponde a ninguna contratación");
        }else {
            int confirm = JOptionPane.showConfirmDialog(null, "¿Estás seguro de eliminar a esta contratación?\n" + contratacion);
            if (confirm == 0){
                objModel.delete(contratacion);
            } else {
                JOptionPane.showMessageDialog(null, "La contratación no ha podido eliminarse correctamente");
            }
        }
        return contratacion;
    }
}
