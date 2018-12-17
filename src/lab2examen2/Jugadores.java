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
     
     public Jugadores() throws FileNotFoundException, IOException {
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
             buscarNum(Equipo);
             
             
         }
         
         
     }
     public int retornaCod(int cod) throws IOException{
        jugadores.seek(0);
        int l=0;
        
     while(team.getFilePointer()<team.length()){
         
         int m=jugadores.readInt();
             jugadores.readUTF();
             jugadores.readInt();
             jugadores.readUTF();
             jugadores.readInt();
             jugadores.readUTF();
        
         if(m==cod){
           return m;  
             
         }
         
     }
     return l;
    }
public int retornaAge() throws IOException{
        jugadores.seek(0);
        int l=0;
        
     while(jugadores.getFilePointer()<jugadores.length()){
         
         jugadores.readInt();
             jugadores.readUTF();
             jugadores.readInt();
             jugadores.readUTF();
             int m=jugadores.readInt();
             jugadores.readUTF();
        
         if(m>l){
           l=m;  
             
         }
         
     }
     return l;
    }


public void mostrarJ(int total) throws IOException{
    if(total>0){
    jugadores.seek(0);
     int p=total;

     
     while(jugadores.getFilePointer()<jugadores.length()){
         
         int equipo=jugadores.readInt();
            String name= jugadores.readUTF();
             int dorsal=jugadores.readInt();
             String po=jugadores.readUTF();
             int m=jugadores.readInt();
             String na=jugadores.readUTF();
        if(m==p ){
            
            
               p+=-1;
         System.out.println("\nEquipo: "+equipo+" nombre: "+name+" Dorsal: "+dorsal+" Posicion: "+po+" Edad: "+m+ " Nacionalidad: "+na) ;
         mostrarJ(p);
            
        }else{
           
        }
         
     }
     p+=-1;
        mostrarJ(p);     
        
         
         
     }
}
    
}

