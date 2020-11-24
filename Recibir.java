/*Recibir
 * Sirve para fenerar un query dependiendo del genero, estado y enfermedad.
 * Noviembre, 2020.*/
package Modelo;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;

import Vista.VistaPersona1;
import Chart.ChartEnfermedades;

public class Recibir {

	public static String query;
	
	public static String getQuery(String estado, String genero, String enfe)
	{	
			if(genero.equals("Mujer"))//Si genero es mujer
			{
				query = "SELECT COUNT(ID_REGISTRO) FROM pacientes LEFT JOIN entidades ON pacientes.ENTIDAD_RES = entidades.CLAVE_ENTIDAD WHERE " + enfe + " = '1' "+ 
						"AND entidades.ENTIDAD_FEDERATIVA =" + "'" + estado + "' AND pacientes.SEXO = '1';";
				System.out.println("hola M " + query);
			}
			if(genero.equals("Hombre"))//Si genero es hombre
			{
				query = "SELECT COUNT(ID_REGISTRO) FROM pacientes LEFT JOIN entidades ON pacientes.ENTIDAD_RES = entidades.CLAVE_ENTIDAD WHERE " + enfe + " = '1' "+ 
						"AND entidades.ENTIDAD_FEDERATIVA =" + "'" + estado + "' AND pacientes.SEXO = '2';";
				System.out.println("hola H " +query);
			}
			
			//SELECT COUNT(ID_REGISTRO) FROM pacientes LEFT JOIN entidades ON pacientes.ENTIDAD_RES = entidades.CLAVE_ENTIDAD WHERE pacientes.EPOC = '1' AND entidades.ENTIDAD_FEDERATIVA ="Ciudad de Mexico" AND pacientes.SEXO = "1"
			System.out.println(query);
			return query;
		}
}
