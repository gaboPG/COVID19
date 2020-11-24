/*Conectar Base D
 * Sirve para conectarse a la Base de datos.
 * Noviembre, 2020.*/
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConectarBaseD {
	private static Connection conn; //Objeto de tipo Connection 
	private static final String driver = "com.mysql.jdbc.Driver";
	private static final String user = "root";
	private static final String password = "";
	// En el panel de control de Xampp hay una columna de Ports,
	// Identificar el de MySQL
	                                                  // puerto nombre BD
	private static final String url = "jdbc:mysql://localhost:3306/covid19mx";
	
	public ConectarBaseD(){
		
		conn = null;
		try{
			Class.forName(driver);
			conn = DriverManager.getConnection(url,user,password);
			JOptionPane.showMessageDialog(null, "Se conecto","Hola POO 2020",JOptionPane.INFORMATION_MESSAGE);
			
			if (conn != null){
				System.out.println("Se conectó");
			}
			
		}catch (ClassNotFoundException | SQLException e){
			
			System.out.println("NO Se conectó");
		}
		
	}
	
	// Recupera el objeto de tipo Connection
	public Connection getConnection(){
		
		return conn;
	}

	// Método para cerrar la conexión. 
	public void DesConnecton(){

		conn = null;
		if(conn == null){
			System.out.println("Terminó conexión");
		}
   }
}
