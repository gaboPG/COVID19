/*Estados Mod Conectar
 * Sirve para generar el query de cargar estados.
 * Noviembre, 2020.*/
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class EstadosModConectar {
	//Nos conectanos
	ConectarBaseD conectarBaseD;
	
	public EstadosModConectar(){
		
		conectarBaseD = new ConectarBaseD();
	}

	
	public ArrayList<EstadosModelo> listaEstados(){
		//Arreglo que contendra los estados
		ArrayList<EstadosModelo> listaEstados = new ArrayList<EstadosModelo>();
		EstadosModelo estado;
		
		try{
			// recupera la conexion
			Connection conn = conectarBaseD.getConnection();
			// depende del nombre de su tabla. 
			PreparedStatement prest = conn.prepareStatement("select * from entidades");
            ResultSet rs = prest.executeQuery();
            
            
            while(rs.next()){
            	// Lee cada uno de las columnas de la tabla
            	estado = new EstadosModelo();
            	estado.setCLAVE_ENTIDAD(rs.getInt(1));
            	estado.setENTIDAD_FEDERATIVA(rs.getString(2));
            	estado.setABREVIATURA(rs.getString(3));
            	listaEstados.add(estado);
            		
            }
            
		
		}catch(Exception ex){
			
			ex.printStackTrace () ;	  
			System.out.println(" SQLException : " + ex.getMessage() );	
			
		}
		return listaEstados;
	}
	
	public int contarGente(String query){
		//Método que cuenta el numero de casos dependiendo del query
		int num = 0;
		try{
			// recupera la conexion
			Connection conn = conectarBaseD.getConnection();
			// depende del nombre de su tabla. 
			PreparedStatement prest = conn.prepareStatement(query);
            ResultSet rs = prest.executeQuery();
            
            while(rs.next()){
            	num  = rs.getInt(1);
            	}
            
		}catch(Exception ex){
			ex.printStackTrace () ;	  
			System.out.println(" SQLException : " + ex.getMessage() );	
		}
		return num;
	}
	
}


