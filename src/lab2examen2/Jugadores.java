/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2examen2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author DELL
 */
public class Jugadores extends Equipos {
    File f;
     RandomAccessFile jugadores;
     
     public Jugadores() throws FileNotFoundException {
         super();
        f=new File("jugadores.team");
       
        jugadores=new RandomAccessFile(f,"rw");
        
    }
     public void crearJ(int Equipo, String nombre,int dorsal,String posicion,int edad,String nacion) throws IOException{
         if(buscarC(Equipo)!=0){
             jugadores.seek(jugadores.length());
             jugadores.writeInt(Equipo);
             jugadores.writeUTF(nombre);
             jugadores.writeInt(dorsal);
             jugadores.writeUTF(posicion);
             jugadores.writeInt(edad);
             jugadores.writeUTF(nacion);
             
             
         }
         
         
     }
    
}
