import controller.CoderController;
import controller.ContratacionController;
import controller.VacanteController;
import database.ConfigDB;
import model.CoderModel;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
int option = 0, optionCoder = 0, optionContratacion = 0, optionVacante = 0;
        do {
            option = Integer.parseInt(JOptionPane.showInputDialog("""
                    1. CRUD Coder.
                    2. CRUD Contratación.
                    3. CRUD Vacante.
                    
                    4. Salir
                    Ingrese la opción deseada:
                    """));
            switch (option){
                case 1:
                    do {
                        optionCoder = Integer.parseInt(JOptionPane.showInputDialog("""
                                1. Crear Coder
                                2. Listar Coders.
                                3. Actualizar Coder.
                                4. Eliminar Coder.
                                                            
                                5. Salir
                                Ingrese la opción deseada: 
                                """));
                        switch (optionCoder) {
                            case 1:
                                CoderController.crear();
                                break;
                            case 2:
                                CoderController.listar();
                                break;
                            case 3:
                                CoderController.actualizar();
                                break;
                            case 4:
                                CoderController.eliminar();
                                break;
                        }
                    }while (optionCoder != 5);
                    break;
                case 2:
                    do {
                        optionContratacion = Integer.parseInt(JOptionPane.showInputDialog("""
                                1. Crear Contratación.
                                2. Listar Contrataciones.
                                3. Actualizar Contratación.
                                4. Eliminar Contratación.
                                                            
                                5. Salir
                                Ingrese la opción deseada: 
                                """));
                        switch (optionContratacion) {
                            case 1:
                                ContratacionController.crear();
                                break;
                            case 2:
                                ContratacionController.listar();
                                break;
                            case 3:
                                ContratacionController.actualizar();
                                break;
                            case 4:
                                ContratacionController.eliminar();
                                break;
                        }
                    }while (optionContratacion != 5);
                    break;
                case 3:
                    do {
                        optionVacante = Integer.parseInt(JOptionPane.showInputDialog("""
                                1. Crear Vacante.
                                2. Listar Vacantes.
                                3. Actualizar Vacante.
                                4. Eliminar Vacante.
                                                            
                                5. Salir
                                Ingrese la opción deseada: 
                                """));
                        switch (optionVacante) {
                            case 1:
                                VacanteController.crear();
                                break;
                            case 2:
                                VacanteController.listar();
                                break;
                            case 3:
                                VacanteController.actualizar();
                                break;
                            case 4:
                                VacanteController.eliminar();
                                break;
                        }
                    }while (optionVacante != 5);
            }

        }while (option != 4);
    }
}