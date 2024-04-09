package controller;

import entities.Coder;
import model.CoderModel;

import javax.swing.*;

public class CoderController {
    public static void crear(){
        CoderModel objModel = new CoderModel();
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del coder: ");
        String apellidos = JOptionPane.showInputDialog("Ingrese los apellidos del coder: ");
        String documento = JOptionPane.showInputDialog("Ingrese el documento del coder: ");
        int cohorte = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cohorte a la cual pertenece el coder: "));
        String cv = JOptionPane.showInputDialog("Ingrese la cv del coder: ");
        Coder coder = new Coder();
        coder.setNombre(nombre);
        coder.setApellidos(apellidos);
        coder.setDocumento(documento);
        coder.setCohorte(cohorte);
        coder.setCv(cv);
        objModel.create(coder);
    }

    public static String listar(){
        CoderModel objModel = new CoderModel();
        String listaCoders = "LISTA DE CODERS\n";
        for (Object iterador : objModel.list()){
            Coder coder = (Coder) iterador;
            listaCoders += coder;
        }
        JOptionPane.showMessageDialog(null, listaCoders);
        return listaCoders;
    }

    public  static String listarString(){
        CoderModel objModel = new CoderModel();
        String listaCoders = "LISTA DE CODERS";
        for (Object iterador : objModel.list()){
            Coder coder = (Coder) iterador;
            listaCoders += coder;
        }
        return listaCoders;
    }

    public static Coder actualizar(){
        CoderModel objModel = new CoderModel();
        int idUpdate = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del Coder que desea actualizar: \n" + listarString()));
        Coder coder = objModel.buscarId(idUpdate);
        if (coder == null){
            JOptionPane.showMessageDialog(null, "El id que proporcionaste no corresponde a ningún Coder");
        }else {
            String nombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre del coder: ", coder.getNombre());
            String apellidos = JOptionPane.showInputDialog("Ingrese los nuevos apellidos del coder: ", coder.getApellidos());
            String documento = JOptionPane.showInputDialog("Ingrese el nuevo documento del coder: ", coder.getDocumento());
            int cohorte = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nueva cohorte a la cual pertenece el coder: ", coder.getCohorte()));
            String cv = JOptionPane.showInputDialog("Ingrese la nueva cv del coder: ", coder.getCv());
            coder.setNombre(nombre);
            coder.setApellidos(apellidos);
            coder.setDocumento(documento);
            coder.setCohorte(cohorte);
            coder.setCv(cv);
            objModel.update(coder);
        }
        return coder;
    }

    public static Object eliminar(){
        CoderModel objModel = new CoderModel();
        int idRemove = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del Coder que desea eliminar: \n" + listarString()));
        Coder coder = objModel.buscarId(idRemove);
        if (coder == null){
            JOptionPane.showMessageDialog(null, "El id que proporcionaste no corresponde a ningún Coder");
        }else {
            int confirm = JOptionPane.showConfirmDialog(null, "¿Estás seguro de eliminar a este Coder?\n" + coder);
            if (confirm == 0){
                objModel.delete(coder);
            } else {
                JOptionPane.showMessageDialog(null, "El Coder no ha podido eliminarse correctamente");
            }
        }
        return coder;
    }

}
