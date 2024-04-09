package controller;

import entities.Coder;
import entities.Vacante;
import model.CoderModel;
import model.VacanteModel;

import javax.swing.*;
import java.util.ArrayList;

public class CoderController {
    public static void crear(){
        CoderModel objModel = new CoderModel();
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del coder: ");
        String apellidos = JOptionPane.showInputDialog("Ingrese los apellidos del coder: ");
        String documento = JOptionPane.showInputDialog("Ingrese el documento del coder: ");
        int cohorte = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cohorte a la cual pertenece el coder: "));
        String cv = JOptionPane.showInputDialog("Ingrese la cv del coder: ");
        String clan = JOptionPane.showInputDialog("Ingrese el clan donde pertenece el Coder: ");
        Coder coder = new Coder();
        coder.setNombre(nombre);
        coder.setApellidos(apellidos);
        coder.setDocumento(documento);
        coder.setCohorte(cohorte);
        coder.setCv(cv);
        coder.setClan(clan);
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
            String clan = JOptionPane.showInputDialog("Ingrese el clan donde pertenece el Coder: ", coder.getClan());
            coder.setNombre(nombre);
            coder.setApellidos(apellidos);
            coder.setDocumento(documento);
            coder.setCohorte(cohorte);
            coder.setCv(cv);
            coder.setClan(clan);
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

    public static ArrayList<Coder> buscarCohorte(){
        CoderModel objModel = new CoderModel();
        int cohorte = Integer.parseInt(JOptionPane.showInputDialog("Ingresa la cohorte donde deseas visualizar todos los coders: "));
        ArrayList<Coder> listaCoders = objModel.buscarCohorte(cohorte);
        if (listaCoders.isEmpty()){
            JOptionPane.showMessageDialog(null, "No se registran Coders con esta cohorte");
        }else {
            JOptionPane.showMessageDialog(null, "Coders de corte " + cohorte + ": \n" +listaCoders);
            objModel.buscarCohorte(cohorte);
        }
        return listaCoders;
    }

    public static ArrayList<Coder> buscarClan(){
        CoderModel objModel = new CoderModel();
        String clan = JOptionPane.showInputDialog("Ingresa el clan donde deseas visualizar todos los coders: ");
        ArrayList<Coder> listaCoders = objModel.buscarClan(clan);
        if (listaCoders.isEmpty()){
            JOptionPane.showMessageDialog(null, "No se registran Coders con este clan");
        }else {
            JOptionPane.showMessageDialog(null, "Coders del clan " + clan + ": \n" +listaCoders);
            objModel.buscarClan(clan);
        }
        return listaCoders;
    }

    public static ArrayList<Coder> buscarCv(){
        CoderModel objModel = new CoderModel();
        String cv = JOptionPane.showInputDialog("Ingresa el cv con el cual deseas visualizar todos los coders: ");
        ArrayList<Coder> listaCoders = objModel.buscarCv(cv);
        if (listaCoders.isEmpty()){
            JOptionPane.showMessageDialog(null, "No se registran Coders con este CV");
        }else {
            JOptionPane.showMessageDialog(null, "Coders con tecnología " + cv + ": \n" +listaCoders);
            objModel.buscarCv(cv);
        }
        return listaCoders;
    }

}
