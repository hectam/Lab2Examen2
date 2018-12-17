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
public class Equipos {
    File f;
    RandomAccessFile cod,team;

    public Equipos() throws FileNotFoundException, IOException {
        f=new File("Equipos.team");
        cod=new RandomAccessFile("codigos.asd","rw");
        team=new RandomAccessFile(f,"rw");
        if (cod.length()==0) {
            cod.writeInt(1);
        }
    }
    private void initCodes() throws IOException{
        if (cod.length()==0) {
            cod.writeInt(1);
        }
    }
    private int getCode()throws IOException{
cod.seek(0);
int code=cod.readInt();
cod.seek(0);
cod.writeInt(code+1);
return code;
}
    
 public void crearEquipo(String nombre,String city,int cap) throws IOException{
     team.seek(team.length());
     
     team.writeInt(getCode());
     team.writeUTF(nombre);
     team.writeUTF(city);
     team.writeInt(cap);
     team.writeInt(0);
     team.writeBoolean(true);
     System.out.println("Equipo Creado!!!!");
  
 }
 public long buscar(int b) throws IOException{
     team.seek(0);
     while(team.getFilePointer()<team.length()){
         
         int m=team.readInt();//codigo
         long c=team.getFilePointer();
         team.readUTF();//nombre
         team.readUTF();//ciudad
         team.readInt();//capacidad
         team.readInt();
         team.readBoolean();
         if(m==b){
            return c; 
             
         }
         
     }
     return 0;
     
 }
 
 public void modificar(int c,String nombre,String ciudad,int cap) throws IOException{
     if(buscar(c) !=0){
         team.seek(buscar(c));
         team.writeUTF(nombre);
         team.writeUTF(ciudad);
         team.writeInt(cap);
         System.out.println("Se modifico con exito!!!!");
     }else{
         System.out.println("No se pudo modificar; ingrese otro codigo de equipo!!!");
     }
 
 }
 public void mostrarC() throws IOException{
     team.seek(0);
     int p=0;
     String all="";
     while(team.getFilePointer()<team.length()){
         p++;
         int m=team.readInt();//codigo
         String name=team.readUTF();//nombre
         team.readUTF();//ciudad
         team.readInt();//capacidad
         int w=team.readInt();
        boolean q= team.readBoolean();
        
            if(q==true){
             
         System.out.println("\n"+p+"."+name+" codigo: "+m);
            }
         
     }
     
     
 }
 public int buscarC(int b) throws IOException{
     team.seek(0);
     while(team.getFilePointer()<team.length()){
         
         int m=team.readInt();//codigo
         team.readUTF();//nombre
         team.readUTF();//ciudad
         team.readInt();//capacidad
         team.readInt();
         boolean q= team.readBoolean();
         if(m==b && q==true){
            return m; 
             
         }
         
     }
     return 0;
     
 }
 public void eliminarEquipo(int c) throws IOException{
     if(buscar(c) !=0){
        
         team.readUTF();
         team.readUTF();
         team.readInt();
         team.readInt();
         team.writeBoolean(true);
         System.out.println("Eliminada");
         
     }
     
 }
 public void buscarNum(int cod) throws IOException{
     if(buscar(cod) !=0){
       team.seek(buscar(cod));
         team.readUTF();
         team.readUTF();
         team.readInt();
         long ret=team.getFilePointer();
         int ju=team.readInt();
         team.readBoolean();
         team.seek(ret);
           ju++;
            team.writeInt(ju);  
             
         
         
         System.out.println("prron");
         
     }
     
 }
 
 
 public void mostrarEquipo(int total) throws IOException{
     if(total>0){
     team.seek(0);
     int p=total;
     
     while(team.getFilePointer()<team.length()){
         
         int m=team.readInt();//codigo
         String name=team.readUTF();//nombre
         String ciudad=team.readUTF();//ciudad
         int capa=team.readInt();//capacidad
        int ju= team.readInt();
        boolean q= team.readBoolean();
        if(ju==p && q==true){
            
            
             p--;
         System.out.println("\nEquipo: "+name+" codigo: "+m+" Ciudad: "+ciudad+" Capacidad Estadio: "+capa) ;
         mostrarEquipo(p);
            
        }else{
            
        }
         
     }
     p--;
            mostrarEquipo(p);
        
         
         
     }
 
 }
 
    public int retornaM() throws IOException{
        team.seek(0);
        int l=0;
        
     while(team.getFilePointer()<team.length()){
         
         team.readInt();//codigo
         team.readUTF();//nombre
         team.readUTF();//ciudad
         team.readInt();//capacidad
         int m=team.readInt();
         boolean q= team.readBoolean();
         if(m>l){
            l=m; 
             
         }
         
     }
     return l;
    }
    public int retornaEdad() throws IOException{
        team.seek(0);
        int l=0;
        
     while(team.getFilePointer()<team.length()){
         
         team.readInt();//codigo
         team.readUTF();//nombre
         team.readUTF();//ciudad
         team.readInt();//capacidad
         int m=team.readInt();
         boolean q= team.readBoolean();
         if(m>l){
            l=m; 
             
         }
         
     }
     return l;
    }
    
    
    
    
}
