/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.pmp.holamund202202;
import java.util.Scanner;
import java.util.ArrayList;
import com.pmp.dao.Categoria;
import com.pmp.dao.CategoriaDao;
/**
 *
 * @author obetancourth
 */
public class Holamund202202 {

    private static Scanner keyInput;
    private static String  selectedOption = "M";
    private static ArrayList<Categoria> categorias;
    private static int categoriaCode = 0;
    
    public static void main(String[] args) {
        init();
        PrintUtilities.printH1("Hola Mundo \n 202202");
        while(!selectedOption.equalsIgnoreCase("S")) {
            PrintUtilities.printMenu();
            selectedOption = PrintUtilities.readInput(
                    keyInput,
                    "Escriba la opcion a ejecutar",
                    "M"
            );
            switch (selectedOption.toUpperCase()) {
                case "C":
                    createNewCategoria();
                    break;
                case "E":
                    mostrarCategorias();
                    updateCategoria();
                    break;
                case "D":
                    mostrarCategorias();
                    eliminarCategoria();
                case "M":
                    mostrarCategorias();
                    break;
                case "P":
                    getDatosPersonales();
                    break;
                case "S":
                    PrintUtilities.printH1("Adios");
                    break;
            }
        }
        
    }

    
    private static void getDatosPersonales() throws NumberFormatException {
        String nombre = PrintUtilities.readInput(
                keyInput,
                "Nombre Completo",
                "Nombre"
        );
        
        int edad = Integer.parseInt(PrintUtilities.readInput(
                keyInput, 
                "Edad (número)",
                "18"
        ));
        
        PrintUtilities.printH1(nombre);
        PrintUtilities.printH1(String.valueOf(edad));
    }
    
    private static void mostrarCategorias(){
        categorias = CategoriaDao.obtenerTodos();
        for( int i = 0; i< categorias.size(); i++) {
            Categoria currentCategoria = categorias.get(i);
            System.out.println( currentCategoria.printString());
        }
    }
    
    private static void createNewCategoria() {
        PrintUtilities.printH1("Crear Nueva Categoría");
        String nombre = PrintUtilities.readInput(keyInput, "Nombre", "Nueva Categoría");
        String estado = PrintUtilities.readInput(keyInput, "Estado (ACT, INA)", "ACT");
        Categoria newCategory = new Categoria();
        newCategory.setEstado(estado);
        newCategory.setNombre(nombre);
        //categoriaCode ++;
        //int codigo = categoriaCode;
        //newCategory.setCodigo(codigo);
        CategoriaDao.agregarNuevo(newCategory);
        categorias = CategoriaDao.obtenerTodos();
    }
    
    private static void updateCategoria() {
        int selectedCodigo = Integer.parseInt(
                PrintUtilities.readInput(keyInput, "Código de la Categoría", "")
            );
        if (selectedCodigo == 0) {
            PrintUtilities.printH1("El Código ingresado no es correcto o no se encuentra.");
        } else {
            Categoria categoryToUpdate = null;
            for (int i = 0; i < categorias.size(); i++) {
                if (categorias.get(i).getCodigo()== selectedCodigo) {
                    categoryToUpdate = categorias.get(i);
                    break;
                }
            }
            if (categoryToUpdate == null) {
                PrintUtilities.printH1("El Código ingresado no es correcto o no se encuentra.");
            } else {
                PrintUtilities.print("Categoría a Modificar");
                PrintUtilities.print(categoryToUpdate.printString());
                PrintUtilities.print("-----------------------");
                categoryToUpdate.setNombre(
                        PrintUtilities.readInput(keyInput, "Categoría", categoryToUpdate.getNombre())
                );
                categoryToUpdate.setEstado(
                        PrintUtilities.readInput(keyInput, "Estado", categoryToUpdate.getEstado())
                );
                PrintUtilities.print("---------------------");
                // DAO
                CategoriaDao.actualizar(categoryToUpdate);
                categorias = CategoriaDao.obtenerTodos();
            }
        }
    }
    
    private static void eliminarCategoria() {
        int selectedCodigo = Integer.parseInt(
                PrintUtilities.readInput(keyInput, "Código de la Categoría", "")
            );
        if (selectedCodigo == 0) {
            PrintUtilities.printH1("El Código ingresado no es correcto o no se encuentra.");
        } else {
            Categoria categoryToDelete = null;
            int indexToRemove = -1;
            for (int i = 0; i < categorias.size(); i++) {
                if (categorias.get(i).getCodigo()== selectedCodigo) {
                    categoryToDelete = categorias.get(i);
                    indexToRemove = i;
                    break;
                }
            }
            if (categoryToDelete == null) {
                PrintUtilities.printH1("El Código ingresado no es correcto o no se encuentra.");
            } else {
                PrintUtilities.print("Categoría a Eliminar");
                PrintUtilities.print(categoryToDelete.printString());
                PrintUtilities.print("-----------------------");
                String eliminar = PrintUtilities.readInput(keyInput, "Desea eliminar esta categoría? (S, N): ", "N");
                if ( eliminar.equalsIgnoreCase("S") ) {
                    //categorias.remove(indexToRemove);
                    CategoriaDao.eliminarCategoria(categoryToDelete.getCodigo());
                    categorias = CategoriaDao.obtenerTodos();
                    PrintUtilities.print("Categoría Eliminada");
                } else {
                    PrintUtilities.print("Eliminación fue Cancelada");
                }
                
                PrintUtilities.print("---------------------");
            }
        }
    }
    
    private static void init(){
        keyInput = new Scanner(System.in);
        CategoriaDao.setup();
        categorias = new ArrayList<Categoria>();
    }
}
