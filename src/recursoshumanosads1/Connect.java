/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursoshumanosads1;

import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author Francisco Lolmet
 */
public class Connect {
private String url="jdbc:mysql://localhost:3306/RRHHADS1";
private String user="root";
private String pass="Guate2023.";
public Connection conexion;

public Connect(){}

public void Conectar(){
    try{
        conexion=DriverManager.getConnection(url,user,pass);
        if(conexion!=null)
            System.out.println("Conexion exitosa");
    }catch(Exception e){
        System.out.println("Error: "+e.getMessage());
    }
}
public void Desconectar(){
    try{
        conexion.close();
    }catch(Exception e){
        System.out.println("Error: "+e.getMessage());
    }
    
}
}
