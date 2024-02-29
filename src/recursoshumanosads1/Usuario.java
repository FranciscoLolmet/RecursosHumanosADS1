/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursoshumanosads1;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;

/**
 *
 * @author Axel Aguilar
 */
public class Usuario {
private Connect cn=new Connect();
private Statement st;


private ResultSet rs;
private String sql;


public Usuario(){
}

public void AñadirUsuario(String nombre, String dpi, String edad, String telefono,String correo,String direccion, String permiso,String contraseña){
    try{ //"idUsuarios", "nombre", "dpi", "edad", "telefono", "correo", "direccion", "permiso", "contraseña"});
        sql="insert into usuarios(nombre, dpi, edad, telefono,correo,direccion,permiso,contraseña) values('"+nombre+"','"+dpi+"','"+edad+"','"+telefono+"','"+correo+"','"+direccion+"','"+permiso+"','"+contraseña+"')";
        cn.Conectar();
        PreparedStatement ps=cn.conexion.prepareStatement(sql);
        ps.execute();
        cn.Desconectar();
        System.out.println("Se añadio el Usuario Correctamente");
    }catch(Exception e){
        System.out.println("Error: "+e.getMessage());
    }
}
public void MostrarUsuario(){
    
    /* try{
        sql="select idMaestro,nombre,ranking from maestro";
        cn.Conectar();
        st=cn.conexion.createStatement();
        rs=st.executeQuery(sql);
        while(rs.next()){
            System.out.println(rs.getInt("idMaestro")+" "+rs.getString("nombre")+" "+rs.getInt("ranking"));
        }
        rs.close();
        cn.Desconectar();
    }catch(Exception e){
        System.out.println("Error: "+e.getMessage());
    }*/
}

public ResultSet getUsuario(){
    try{//"idUsuarios", "nombre", "dpi", "edad", "telefono", "correo", "direccion", "permiso", "contraseña"});
        sql="select idUsuarios,nombre,dpi,edad,telefono,correo,direccion,permiso,contraseña from usuarios";
        cn.Conectar();
        st=cn.conexion.createStatement();
        rs=st.executeQuery(sql);
        return rs;
        //rs.close();
        //cn.Desconectar();
    }catch(Exception e){
        System.out.println("Error: "+e.getMessage());
        return null;
    }    
}
public void ModificarUsuario(String nombre, String dpi, String edad, String telefono,String correo,String direccion, String permiso,String contraseña, int idUsuarios){
    try{ //"idUsuarios", "nombre", "dpi", "edad", "telefono", "correo", "direccion", "permiso", "contraseña"});
        sql="update usuarios set nombre='"+nombre+"', dpi='"+dpi+"',edad='"+edad+"',telefono='"+telefono+"',correo='"+correo+"',direccion='"+direccion+"',permiso='"+permiso+"',contraseña='"+contraseña+"' where idUsuarios="+idUsuarios;
        cn.Conectar();
        PreparedStatement ps=cn.conexion.prepareStatement(sql);
        ps.execute();
        cn.Desconectar();
        System.out.println("Se Modifico el Usuario Correctamente");
    }catch(Exception e){
        System.out.println("Error: "+e.getMessage());
    }
}
public void EliminarUsuario(int idUsuarios){
    try{
        sql="delete from usuarios where idUsuarios="+idUsuarios;
        cn.Conectar();
        PreparedStatement ps=cn.conexion.prepareStatement(sql);
        ps.execute();
        cn.Desconectar();
        System.out.println("Se Elimino el Usuario Correctamente");
    }catch(Exception e){
        System.out.println("Error: "+e.getMessage());
    }
}
}
