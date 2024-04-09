package controller;

import entities.Vacante;
import model.ContratacionModel;
import model.VacanteModel;

import javax.swing.*;
import java.util.ArrayList;

public class VacanteController {
    public static void crear(){
        String titulo = JOptionPane.showInputDialog("Ingrese el titulo de la vacante: ");
        String descripcion = JOptionPane.showInputDialog("Ingrese la descripción de la vacante: ");
        String duracion = JOptionPane.showInputDialog("Ingrese la duración de la vacante: ");
            int empresa_id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id de la empresa a la cual corresponde la vacante: "));
            String tecnologia = JOptionPane.showInputDialog("Ingrese la tecnología del empleo: ");
            Vacante vacante = new Vacante();
            vacante.setTitulo(titulo);
            vacante.setDescripcion(descripcion);
            vacante.setEstado("Activa");
            vacante.setDuracion(duracion);
            vacante.setEmpresa_id(empresa_id);
            vacante.setTecnologia(tecnologia);
        VacanteModel objModel = new VacanteModel();
            objModel.create(vacante);
    }



    public static String listar(){
        VacanteModel objModel = new VacanteModel();
        String listaVacantes = "LISTA DE VACANTES\n";
        if (objModel.list().isEmpty()){
            JOptionPane.showMessageDialog(null, "No se registran vacantes activas");
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
                int empresa_id = Integer.parseInt(JOptionPane.showInputDialog(VacanteController.listarString() + "\nIngrese el id de la empresa a la cual corresponde la vacante: ", vacante.getEmpresa_id()));
                String tecnologia = JOptionPane.showInputDialog("Ingrese la tecnología del empleo: ");
                vacante.setTitulo(titulo);
                vacante.setDescripcion(descripcion);
                vacante.setDuracion(duracion);
                vacante.setEmpresa_id(empresa_id);
                vacante.setTecnologia(tecnologia);
                objModel.update(vacante);
        }
        return vacante;
    }

    public static Object eliminar(){
        VacanteModel objModel = new VacanteModel();
        Vacante vacante = null;
        ArrayList<Object> verificacion = objModel.list();
        if (verificacion.isEmpty()){
            JOptionPane.showMessageDialog(null, "No hay vacantes disponibles por eliminar");
        }else{
        int idRemove = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id de la vacante que desea eliminar: \n" + listarString()));
        vacante = objModel.buscarId(idRemove);
        if (vacante == null){
            JOptionPane.showMessageDialog(null, "El id que proporcionaste no corresponde a ninguna vacante");
        }else {
            int confirm = JOptionPane.showConfirmDialog(null, "¿Estás seguro de eliminar esta vacante?\n" + vacante);
            if (confirm == 0) {
                objModel.delete(vacante);
            } else {
                JOptionPane.showMessageDialog(null, "La vacante no ha podido eliminarse correctamente");
            }
        }
        }
        return vacante;
    }

    public static ArrayList<Vacante> buscarTitulo(){
        VacanteModel objModel = new VacanteModel();
        String nombre = JOptionPane.showInputDialog("Ingresa el nombre de la(s) vacante(s) que deseas visualizar: ");
        ArrayList<Vacante> listaVacantes = objModel.vacanteTitulo(nombre);
        if (listaVacantes.isEmpty()){
            JOptionPane.showMessageDialog(null, "No se registran vacantes con ese nombre");
        }else {
            JOptionPane.showMessageDialog(null, "Vacantes de " + nombre + ": \n" +listaVacantes);
            objModel.vacanteTitulo(nombre);
        }
        return listaVacantes;
    }

    public static ArrayList<Vacante> buscarTecnologia(){
        VacanteModel objModel = new VacanteModel();
        String tecnologia = JOptionPane.showInputDialog("Ingresa la tecnología de la(s) vacante(s) que deseas visualizar: ");
        ArrayList<Vacante> listaVacantes = objModel.vacanteTitulo(tecnologia);
        if (listaVacantes.isEmpty()){
            JOptionPane.showMessageDialog(null, "No se registran vacantes con ese nombre");
        }else {
            JOptionPane.showMessageDialog(null, "Vacantes de " + tecnologia + ": \n" +listaVacantes);
            objModel.vacanteTitulo(tecnologia);
        }
        return listaVacantes;
    }
}
