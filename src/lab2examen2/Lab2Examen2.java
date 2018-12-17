/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2examen2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class Lab2Examen2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner run=new Scanner(System.in);
        Scanner leer=new Scanner(System.in);
        Equipos q=new Equipos();
        Jugadores w=new Jugadores();
        int op=0;
        do{
        System.out.println("\tMenu Principal"
                + "\n1. Crear Equipo"
                + "\n2. modificar Equipo"
                + "\n3. Agregar Jugador"
                + "\n4. Eliminar Equipo"              
                + "\n5. Listado atributos de equipos"
                + "\n6. Lista de todos los jugadores ordenados por edad"
                + "\n7. Listar equipos junto con jugadores"
                + "\n8. Listar jugadores por posicion"
                + "\n9. Equipos ordenados por capacidad de estadio");
        op=run.nextInt();
        switch(op){
            case 1:
                System.out.println("Crear Equipo"
                        + "\n Ingrese el nombre del Equipo:");
                String nombre=leer.next();
                System.out.println("Ingrese la ciudad del Equipo:");
                String city=leer.next();
                System.out.println("Ingrese la Capacidad del estadio: ");
                int capa=leer.nextInt();
                q.crearEquipo(nombre, city, capa);
                break;
            case 2:
                System.out.println("Modificar Equipo"
                        + "\nIngrese el Equipo a modificar: ");
                q.mostrarC();
                int m=leer.nextInt();
                System.out.println("Ingrese el nuevo nombre(o el mismo si no hay): ");
                String name=leer.next();
                System.out.println("Ingrese la ciudad (o la misma si no hay):");
                String ciu=leer.next();
                System.out.println("Ingrese la nueva capacidad: ");
                int cap=leer.nextInt();
                q.modificar(m, name, ciu, cap);
                
                break;
            case 3:
                System.out.println("Ingrese el equipo al que pertence: ");
                  q.mostrarC();
                  int n=leer.nextInt();
                  System.out.println("Ingrese el nombre del jugador: ");
                  String ju=leer.next();
                  System.out.println("Ingrese el numero dorsal: ");
                  int num=leer.nextInt();
                  System.out.println("Ingrese la posicion (atac,def,med,port): ");
                  String pos=leer.next();
                  System.out.println("Ingrese la edad: ");
                  int edad=leer.nextInt();
                  System.out.println("Ingrese nacionalidad: ");
                  String nac=leer.next();
                  w.crearJ(n, ju, num, pos,edad,nac);
                break;
            case 4:
                System.out.println("Eliminar Cuenta"
                        + "\n Ingrese la cuenta a eliminar:");
                int v=leer.nextInt();
                q.eliminarEquipo(v);
                break;
            case 5:
                System.out.println("Equipos ordenados de mayor a menor por cantidad de jugadores");
                int pe=q.retornaM();
                q.mostrarEquipo(pe);
                break;
            case 6:
                System.out.println("Jugadores Ordenados por Edad: ");
               int max= w.retornaAge();
               w.mostrarJ(max);
                break;
            case 7:
                break;
            case 8:
                break;
            case 9:
                break;
            
        }
        
        
        }while(op!=9); 
        // TODO code application logic here
    }
    
}
