/*Controlador
 * Controlador de todos los botones y radio buttons de nuestra vista.*/
package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;

import Vista.VistaPersona1;
import Chart.ChartEnfermedades;
import Modelo.EstadosModConectar;
import Modelo.Recibir;

public class Controlador implements ActionListener{
	//Creando instancia vista
	VistaPersona1 vistPer = new VistaPersona1();
	//Conectamos
	EstadosModConectar personaConecta = new EstadosModConectar(); //Aqu� ya se realiz�
	//Variables
	public String genero = "Hombre";
	public String estado = "AGUASCALIENTES";
	public int num = 0;
	public String enfermedad = "EPOC";
	private int flag = 0;
	public String titulo ="";
	public String titulo2 = "";
	public String titulo3 = "";
	
	public Controlador(VistaPersona1 vistPer,EstadosModConectar personaConecta){
		//Agregando al action listener
		this.vistPer = vistPer;
		this.personaConecta = personaConecta;
		this.vistPer.MostrarNombres.addActionListener(this); //Bot�n de la vista
		this.vistPer.combo.addActionListener(this);
		this.vistPer.hombre.addActionListener(this); //Boton hombre
		this.vistPer.mujer.addActionListener(this); //Boton mujer
		this.vistPer.EPOC.addActionListener(this); //Boton EPOC
		this.vistPer.Asma.addActionListener(this); //Boton Asma
		this.vistPer.Hipertension.addActionListener(this); //Boton Hipertension
		this.vistPer.Obesidad.addActionListener(this); //Boton Obesidad
		this.vistPer.Edad.addActionListener(this); //Boton hombre
		// aqui escucha al evento
		System.out.println("Cons");
	}
   public void actionPerformed(ActionEvent e){
	   
	        //Si se pica el boton mostrar nombres
			if(e.getSource() == vistPer.MostrarNombres)
			{
				vistPer.combo.setVisible(true);
				vistPer.hombre.setVisible(true);
				vistPer.mujer.setVisible(true);
				vistPer.EPOC.setVisible(true);
				vistPer.Asma.setVisible(true);
				vistPer.Hipertension.setVisible(true);
				vistPer.Obesidad.setVisible(true);
				vistPer.Edad.setVisible(true);
				
				vistPer.MostrarNombres.setVisible(false);
				
				System.out.println("boton");
				vistPer.textMuestra.selectAll();
				vistPer.textMuestra.replaceSelection("");
				
				vistPer.combo.removeAllItems();
				//Cargando estados
				for(int i=0; i<personaConecta.listaEstados().size(); i++)
				{   
					vistPer.combo.addItem(personaConecta.listaEstados().get(i).getENTIDAD_FEDERATIVA());
				}
				
				vistPer.textMuestra.updateUI();
				vistPer.textMuestra.repaint();
			}
			
			//Si se pica el combo box
			if(e.getSource() == vistPer.combo)
			{
				System.out.println("combo");
				int num1 = 0, num2 = 0, num3 = 0, num4 = 0, num5 = 0, num6 = 0;
				
				
				if(vistPer.combo.getSelectedIndex() >= 0)
				{
					//Clear textMuestra
					vistPer.textMuestra.append(personaConecta.listaEstados().get(vistPer.combo.getSelectedIndex()).getABREVIATURA());
					vistPer.textMuestra.append(" ");
					vistPer.textMuestra.append(personaConecta.listaEstados().get(vistPer.combo.getSelectedIndex()).getENTIDAD_FEDERATIVA());
					vistPer.textMuestra.setText("");
					vistPer.textMuestra.append(Integer.toString(personaConecta.listaEstados().get(vistPer.combo.getSelectedIndex()).getCLAVE_ENTIDAD()));
					
					vistPer.textMuestra.updateUI();
					vistPer.textMuestra.repaint();
				}
				estado = personaConecta.listaEstados().get(vistPer.combo.getSelectedIndex()).getENTIDAD_FEDERATIVA();
				
				
				if(flag == 0)//Si es enfermedad
				{
					//Query
					estado = personaConecta.listaEstados().get(vistPer.combo.getSelectedIndex()).getENTIDAD_FEDERATIVA();
					String query = Recibir.getQuery(estado, genero, enfermedad);
					num = personaConecta.contarGente(query);
					System.out.println(num);
					//Update panel
					vistPer.panelGraph.updateUI();
					vistPer.panelGraph.repaint();
					vistPer.panelGraph.removeAll();
					JFreeChart barChart = ChartFactory.createBarChart(enfermedad, " ", " ", ChartEnfermedades.createDataset(num, enfermedad), PlotOrientation.VERTICAL, true, true, false);
					ChartPanel chartPanel = new ChartPanel( barChart );        
				    chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );    
				    chartPanel.setBounds(500, 100, 600, 500); 
				    vistPer.panelGraph.add(chartPanel);
				}
				if(flag == 1)//Si es por edad
				{
					//Query
					 num1 = personaConecta.contarGente("SELECT COUNT(ID_REGISTRO) FROM pacientes LEFT JOIN entidades ON pacientes.ENTIDAD_RES = entidades.CLAVE_ENTIDAD WHERE entidades.ENTIDAD_FEDERATIVA =" + "'" + estado + "' AND pacientes.SEXO = '1' AND pacientes.EDAD >= 20 AND pacientes.EDAD < 30;");
					 num2 = personaConecta.contarGente("SELECT COUNT(ID_REGISTRO) FROM pacientes LEFT JOIN entidades ON pacientes.ENTIDAD_RES = entidades.CLAVE_ENTIDAD WHERE entidades.ENTIDAD_FEDERATIVA =" + "'" + estado + "' AND pacientes.SEXO = '1' AND pacientes.EDAD >= 30 AND pacientes.EDAD < 40;");
					 num3 = personaConecta.contarGente("SELECT COUNT(ID_REGISTRO) FROM pacientes LEFT JOIN entidades ON pacientes.ENTIDAD_RES = entidades.CLAVE_ENTIDAD WHERE entidades.ENTIDAD_FEDERATIVA =" + "'" + estado + "' AND pacientes.SEXO = '1' AND pacientes.EDAD >= 40 AND pacientes.EDAD < 50;");
					 num4 = personaConecta.contarGente("SELECT COUNT(ID_REGISTRO) FROM pacientes LEFT JOIN entidades ON pacientes.ENTIDAD_RES = entidades.CLAVE_ENTIDAD WHERE entidades.ENTIDAD_FEDERATIVA =" + "'" + estado + "' AND pacientes.SEXO = '1' AND pacientes.EDAD >= 50 AND pacientes.EDAD < 60;");
					 num5 = personaConecta.contarGente("SELECT COUNT(ID_REGISTRO) FROM pacientes LEFT JOIN entidades ON pacientes.ENTIDAD_RES = entidades.CLAVE_ENTIDAD WHERE entidades.ENTIDAD_FEDERATIVA =" + "'" + estado + "' AND pacientes.SEXO = '1' AND pacientes.EDAD >= 60 AND pacientes.EDAD < 70;");
					 num6 = personaConecta.contarGente("SELECT COUNT(ID_REGISTRO) FROM pacientes LEFT JOIN entidades ON pacientes.ENTIDAD_RES = entidades.CLAVE_ENTIDAD WHERE entidades.ENTIDAD_FEDERATIVA =" + "'" + estado + "' AND pacientes.SEXO = '1' AND pacientes.EDAD >= 70 AND pacientes.EDAD < 100;");
					 int [] Cuantos = {num1, num2, num3, num4, num5, num6};
					//Update panel
					vistPer.panelGraph.updateUI();
					vistPer.panelGraph.repaint();
					vistPer.panelGraph.removeAll();
					JFreeChart barChart = ChartFactory.createBarChart(enfermedad, " ", " ", ChartEnfermedades.createDataset2(Cuantos, enfermedad), PlotOrientation.VERTICAL, true, true, false);
					ChartPanel chartPanel = new ChartPanel( barChart );        
				    chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );    
				    chartPanel.setBounds(500, 100, 600, 500); 
				    vistPer.panelGraph.add(chartPanel);
				}
				//Update titulo
				titulo = estado;
				titulo2 = "Población de " + genero;
				titulo3 = "Numero de casos con " + enfermedad;
				vistPer.label.setText(titulo);
				vistPer.label2.setText(titulo2);
				vistPer.label3.setText(titulo3);
				
				
			}
			
			//Si se pica boton hombre
			if(e.getSource() == vistPer.hombre) {
				vistPer.mujer.setSelected(false);
				genero = "Hombre";
				int num1 = 0, num2 = 0, num3 = 0, num4 = 0, num5 = 0, num6 = 0;
				if(flag == 0)//Si es enfermedad
				{
					//Query
					estado = personaConecta.listaEstados().get(vistPer.combo.getSelectedIndex()).getENTIDAD_FEDERATIVA();
					String query = Recibir.getQuery(estado, genero, enfermedad);
					num = personaConecta.contarGente(query);
					System.out.println(num);
					//Update panel
					vistPer.panelGraph.updateUI();
					vistPer.panelGraph.repaint();
					vistPer.panelGraph.removeAll();
					JFreeChart barChart = ChartFactory.createBarChart(enfermedad, " ", " ", ChartEnfermedades.createDataset(num, enfermedad), PlotOrientation.VERTICAL, true, true, false);
					ChartPanel chartPanel = new ChartPanel( barChart );        
				    chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );    
				    chartPanel.setBounds(500, 100, 600, 500); 
				    vistPer.panelGraph.add(chartPanel);
				}
				if(flag == 1)//Si es por edades
				{
					//Query
					 num1 = personaConecta.contarGente("SELECT COUNT(ID_REGISTRO) FROM pacientes LEFT JOIN entidades ON pacientes.ENTIDAD_RES = entidades.CLAVE_ENTIDAD WHERE entidades.ENTIDAD_FEDERATIVA =" + "'" + estado + "' AND pacientes.SEXO = '2' AND pacientes.EDAD >= 20 AND pacientes.EDAD < 30;");
					 num2 = personaConecta.contarGente("SELECT COUNT(ID_REGISTRO) FROM pacientes LEFT JOIN entidades ON pacientes.ENTIDAD_RES = entidades.CLAVE_ENTIDAD WHERE entidades.ENTIDAD_FEDERATIVA =" + "'" + estado + "' AND pacientes.SEXO = '2' AND pacientes.EDAD >= 30 AND pacientes.EDAD < 40;");
					 num3 = personaConecta.contarGente("SELECT COUNT(ID_REGISTRO) FROM pacientes LEFT JOIN entidades ON pacientes.ENTIDAD_RES = entidades.CLAVE_ENTIDAD WHERE entidades.ENTIDAD_FEDERATIVA =" + "'" + estado + "' AND pacientes.SEXO = '2' AND pacientes.EDAD >= 40 AND pacientes.EDAD < 50;");
					 num4 = personaConecta.contarGente("SELECT COUNT(ID_REGISTRO) FROM pacientes LEFT JOIN entidades ON pacientes.ENTIDAD_RES = entidades.CLAVE_ENTIDAD WHERE entidades.ENTIDAD_FEDERATIVA =" + "'" + estado + "' AND pacientes.SEXO = '2' AND pacientes.EDAD >= 50 AND pacientes.EDAD < 60;");
					 num5 = personaConecta.contarGente("SELECT COUNT(ID_REGISTRO) FROM pacientes LEFT JOIN entidades ON pacientes.ENTIDAD_RES = entidades.CLAVE_ENTIDAD WHERE entidades.ENTIDAD_FEDERATIVA =" + "'" + estado + "' AND pacientes.SEXO = '2' AND pacientes.EDAD >= 60 AND pacientes.EDAD < 70;");
					 num6 = personaConecta.contarGente("SELECT COUNT(ID_REGISTRO) FROM pacientes LEFT JOIN entidades ON pacientes.ENTIDAD_RES = entidades.CLAVE_ENTIDAD WHERE entidades.ENTIDAD_FEDERATIVA =" + "'" + estado + "' AND pacientes.SEXO = '2' AND pacientes.EDAD >= 70 AND pacientes.EDAD < 100;");
					 int [] Cuantos = {num1, num2, num3, num4, num5, num6};
					 //Update panel
					vistPer.panelGraph.updateUI();
					vistPer.panelGraph.repaint();
					vistPer.panelGraph.removeAll();
					JFreeChart barChart = ChartFactory.createBarChart(enfermedad, " ", " ", ChartEnfermedades.createDataset2(Cuantos, enfermedad), PlotOrientation.VERTICAL, true, true, false);
					ChartPanel chartPanel = new ChartPanel( barChart );        
				    chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );    
				    chartPanel.setBounds(500, 100, 600, 500); 
				    vistPer.panelGraph.add(chartPanel);
				}
				//Update titulo
				titulo = estado;
				titulo2 = "Población de " + genero;
				titulo3 = "Numero de casos con " + enfermedad;
				vistPer.label.setText(titulo);
				vistPer.label2.setText(titulo2);
				vistPer.label3.setText(titulo3);
				
			}
			//Si se pica mujer
			if(e.getSource() == vistPer.mujer) {
				vistPer.hombre.setSelected(false);
				genero = "Mujer";
				int num1 = 0, num2 = 0, num3 = 0, num4 = 0, num5 = 0, num6 = 0;
				if(flag == 0)//Si es enfermedad
				{
					//Query
					estado = personaConecta.listaEstados().get(vistPer.combo.getSelectedIndex()).getENTIDAD_FEDERATIVA();
					String query = Recibir.getQuery(estado, genero, enfermedad);
					num = personaConecta.contarGente(query);
					System.out.println(num);
					//Update panel
					vistPer.panelGraph.updateUI();
					vistPer.panelGraph.repaint();
					vistPer.panelGraph.removeAll();
					JFreeChart barChart = ChartFactory.createBarChart(enfermedad, " ", " ", ChartEnfermedades.createDataset(num, enfermedad), PlotOrientation.VERTICAL, true, true, false);
					ChartPanel chartPanel = new ChartPanel( barChart );        
				    chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );    
				    chartPanel.setBounds(500, 100, 600, 500); 
				    vistPer.panelGraph.add(chartPanel);
				}
				if(flag == 1)//Si es por edad
				{
					//Query
					 num1 = personaConecta.contarGente("SELECT COUNT(ID_REGISTRO) FROM pacientes LEFT JOIN entidades ON pacientes.ENTIDAD_RES = entidades.CLAVE_ENTIDAD WHERE entidades.ENTIDAD_FEDERATIVA =" + "'" + estado + "' AND pacientes.SEXO = '1' AND pacientes.EDAD >= 20 AND pacientes.EDAD < 30;");
					 num2 = personaConecta.contarGente("SELECT COUNT(ID_REGISTRO) FROM pacientes LEFT JOIN entidades ON pacientes.ENTIDAD_RES = entidades.CLAVE_ENTIDAD WHERE entidades.ENTIDAD_FEDERATIVA =" + "'" + estado + "' AND pacientes.SEXO = '1' AND pacientes.EDAD >= 30 AND pacientes.EDAD < 40;");
					 num3 = personaConecta.contarGente("SELECT COUNT(ID_REGISTRO) FROM pacientes LEFT JOIN entidades ON pacientes.ENTIDAD_RES = entidades.CLAVE_ENTIDAD WHERE entidades.ENTIDAD_FEDERATIVA =" + "'" + estado + "' AND pacientes.SEXO = '1' AND pacientes.EDAD >= 40 AND pacientes.EDAD < 50;");
					 num4 = personaConecta.contarGente("SELECT COUNT(ID_REGISTRO) FROM pacientes LEFT JOIN entidades ON pacientes.ENTIDAD_RES = entidades.CLAVE_ENTIDAD WHERE entidades.ENTIDAD_FEDERATIVA =" + "'" + estado + "' AND pacientes.SEXO = '1' AND pacientes.EDAD >= 50 AND pacientes.EDAD < 60;");
					 num5 = personaConecta.contarGente("SELECT COUNT(ID_REGISTRO) FROM pacientes LEFT JOIN entidades ON pacientes.ENTIDAD_RES = entidades.CLAVE_ENTIDAD WHERE entidades.ENTIDAD_FEDERATIVA =" + "'" + estado + "' AND pacientes.SEXO = '1' AND pacientes.EDAD >= 60 AND pacientes.EDAD < 70;");
					 num6 = personaConecta.contarGente("SELECT COUNT(ID_REGISTRO) FROM pacientes LEFT JOIN entidades ON pacientes.ENTIDAD_RES = entidades.CLAVE_ENTIDAD WHERE entidades.ENTIDAD_FEDERATIVA =" + "'" + estado + "' AND pacientes.SEXO = '1' AND pacientes.EDAD >= 70 AND pacientes.EDAD < 100;");
					 int [] Cuantos = {num1, num2, num3, num4, num5, num6};
					//Update panel
					vistPer.panelGraph.updateUI();
					vistPer.panelGraph.repaint();
					vistPer.panelGraph.removeAll();
					JFreeChart barChart = ChartFactory.createBarChart(enfermedad, " ", " ", ChartEnfermedades.createDataset2(Cuantos, enfermedad), PlotOrientation.VERTICAL, true, true, false);
					ChartPanel chartPanel = new ChartPanel( barChart );        
				    chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );    
				    chartPanel.setBounds(500, 100, 600, 500); 
				    vistPer.panelGraph.add(chartPanel);
				}
				//Update titulo
				titulo = estado;
				titulo2 = "Población de " + genero;
				titulo3 = "Numero de casos con " + enfermedad;
				vistPer.label.setText(titulo);
				vistPer.label2.setText(titulo2);
				vistPer.label3.setText(titulo3);
			}
			//Si se pica boton EPOC
			if(e.getSource() == vistPer.EPOC) {
				flag = 0;
				vistPer.Asma.setSelected(false);
				vistPer.Obesidad.setSelected(false);
				vistPer.Hipertension.setSelected(false);
				vistPer.Edad.setSelected(false);
				enfermedad = "EPOC";
				//Query
				estado = personaConecta.listaEstados().get(vistPer.combo.getSelectedIndex()).getENTIDAD_FEDERATIVA();
				String query = Recibir.getQuery(estado, genero, "EPOC");
				num = personaConecta.contarGente(query);
				System.out.println(num);
				
				//Update panel
				vistPer.panelGraph.updateUI();
				vistPer.panelGraph.repaint();
				vistPer.panelGraph.removeAll();
				JFreeChart barChart = ChartFactory.createBarChart(enfermedad, " ", " ", ChartEnfermedades.createDataset(num, enfermedad), PlotOrientation.VERTICAL, true, true, false);
				ChartPanel chartPanel = new ChartPanel( barChart );        
			    chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );    
			    chartPanel.setBounds(500, 100, 600, 500); 
			    vistPer.panelGraph.add(chartPanel);
			    //Update titulo
			    titulo = estado;
				titulo2 = "Población de " + genero;
				titulo3 = "Numero de casos con " + enfermedad;
				vistPer.label.setText(titulo);
				vistPer.label2.setText(titulo2);
				vistPer.label3.setText(titulo3);
			}
			//Si es asma
			if(e.getSource() == vistPer.Asma) {
				flag = 0;
				vistPer.EPOC.setSelected(false);
				vistPer.Obesidad.setSelected(false);
				vistPer.Hipertension.setSelected(false);
				vistPer.Edad.setSelected(false);
				enfermedad = "Asma";
				//Query
				estado = personaConecta.listaEstados().get(vistPer.combo.getSelectedIndex()).getENTIDAD_FEDERATIVA();
				String query = Recibir.getQuery(estado, genero, "Asma");
				num = personaConecta.contarGente(query);
				System.out.println(num);
				
				//Update panel
				vistPer.panelGraph.updateUI();
				vistPer.panelGraph.repaint();
				vistPer.panelGraph.removeAll();
				JFreeChart barChart = ChartFactory.createBarChart(enfermedad, " ", " ", ChartEnfermedades.createDataset(num, enfermedad), PlotOrientation.VERTICAL, true, true, false);
				ChartPanel chartPanel = new ChartPanel( barChart );        
			    chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );    
			    chartPanel.setBounds(500, 100, 600, 500); 
			    vistPer.panelGraph.add(chartPanel);
			    //Update titulo
			    titulo = estado;
				titulo2 = "Población de " + genero;
				titulo3 = "Numero de casos con " + enfermedad;
				vistPer.label.setText(titulo);
				vistPer.label2.setText(titulo2);
				vistPer.label3.setText(titulo3);
			}
			//Si es Obesidad
			if(e.getSource() == vistPer.Obesidad) {
				flag = 0;
				vistPer.Asma.setSelected(false);
				vistPer.EPOC.setSelected(false);
				vistPer.Hipertension.setSelected(false);
				vistPer.Edad.setSelected(false);
				enfermedad = "Obesidad";
				//Query
				estado = personaConecta.listaEstados().get(vistPer.combo.getSelectedIndex()).getENTIDAD_FEDERATIVA();
				String query = Recibir.getQuery(estado, genero, "Obesidad");
				num = personaConecta.contarGente(query);
				System.out.println(num);
				
				//Update panel
				vistPer.panelGraph.updateUI();
				vistPer.panelGraph.repaint();
				vistPer.panelGraph.removeAll();
				JFreeChart barChart = ChartFactory.createBarChart(enfermedad, " ", " ", ChartEnfermedades.createDataset(num, enfermedad), PlotOrientation.VERTICAL, true, true, false);
				ChartPanel chartPanel = new ChartPanel( barChart );        
			    chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );    
			    chartPanel.setBounds(500, 100, 600, 500); 
			    vistPer.panelGraph.add(chartPanel);
			    //Update titulo
			    titulo = estado;
				titulo2 = "Población de " + genero;
				titulo3 = "Numero de casos con " + enfermedad;
				vistPer.label.setText(titulo);
				vistPer.label2.setText(titulo2);
				vistPer.label3.setText(titulo3);
			}
			//Si es Hipertension
			if(e.getSource() == vistPer.Hipertension) {
				flag = 0;
				vistPer.Asma.setSelected(false);
				vistPer.Obesidad.setSelected(false);
				vistPer.EPOC.setSelected(false);
				vistPer.Edad.setSelected(false);
				enfermedad = "Hipertension";
				//Query
				estado = personaConecta.listaEstados().get(vistPer.combo.getSelectedIndex()).getENTIDAD_FEDERATIVA();
				String query = Recibir.getQuery(estado, genero, "Hipertension");
				num = personaConecta.contarGente(query);
				System.out.println(num);
				
				//Update panel
				vistPer.panelGraph.updateUI();
				vistPer.panelGraph.repaint();
				vistPer.panelGraph.removeAll();
				JFreeChart barChart = ChartFactory.createBarChart(enfermedad, " ", " ", ChartEnfermedades.createDataset(num, enfermedad), PlotOrientation.VERTICAL, true, true, false);
				ChartPanel chartPanel = new ChartPanel( barChart );        
			    chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );    
			    chartPanel.setBounds(500, 100, 600, 500); 
			    vistPer.panelGraph.add(chartPanel);
			    //Update titulo
			    titulo = estado;
				titulo2 = "Población de " + genero;
				titulo3 = "Numero de casos con " + enfermedad;
				vistPer.label.setText(titulo);
				vistPer.label2.setText(titulo2);
				vistPer.label3.setText(titulo3);
			}
			//Si se edades
			if(e.getSource() == vistPer.Edad) {
				flag = 1; //Entra a edad
				vistPer.Asma.setSelected(false);
				vistPer.Obesidad.setSelected(false);
				vistPer.Hipertension.setSelected(false);
				vistPer.EPOC.setSelected(false);
				enfermedad = "Edad";
				estado = personaConecta.listaEstados().get(vistPer.combo.getSelectedIndex()).getENTIDAD_FEDERATIVA();
				int num1 = 0, num2 = 0, num3 = 0, num4 = 0, num5 = 0, num6 = 0;
				
				//Queries
				if(genero.equals("Mujer"))
				{
					 num1 = personaConecta.contarGente("SELECT COUNT(ID_REGISTRO) FROM pacientes LEFT JOIN entidades ON pacientes.ENTIDAD_RES = entidades.CLAVE_ENTIDAD WHERE entidades.ENTIDAD_FEDERATIVA =" + "'" + estado + "' AND pacientes.SEXO = '1' AND pacientes.EDAD >= 20 AND pacientes.EDAD < 30;");
					 num2 = personaConecta.contarGente("SELECT COUNT(ID_REGISTRO) FROM pacientes LEFT JOIN entidades ON pacientes.ENTIDAD_RES = entidades.CLAVE_ENTIDAD WHERE entidades.ENTIDAD_FEDERATIVA =" + "'" + estado + "' AND pacientes.SEXO = '1' AND pacientes.EDAD >= 30 AND pacientes.EDAD < 40;");
					 num3 = personaConecta.contarGente("SELECT COUNT(ID_REGISTRO) FROM pacientes LEFT JOIN entidades ON pacientes.ENTIDAD_RES = entidades.CLAVE_ENTIDAD WHERE entidades.ENTIDAD_FEDERATIVA =" + "'" + estado + "' AND pacientes.SEXO = '1' AND pacientes.EDAD >= 40 AND pacientes.EDAD < 50;");
					 num4 = personaConecta.contarGente("SELECT COUNT(ID_REGISTRO) FROM pacientes LEFT JOIN entidades ON pacientes.ENTIDAD_RES = entidades.CLAVE_ENTIDAD WHERE entidades.ENTIDAD_FEDERATIVA =" + "'" + estado + "' AND pacientes.SEXO = '1' AND pacientes.EDAD >= 50 AND pacientes.EDAD < 60;");
					 num5 = personaConecta.contarGente("SELECT COUNT(ID_REGISTRO) FROM pacientes LEFT JOIN entidades ON pacientes.ENTIDAD_RES = entidades.CLAVE_ENTIDAD WHERE entidades.ENTIDAD_FEDERATIVA =" + "'" + estado + "' AND pacientes.SEXO = '1' AND pacientes.EDAD >= 60 AND pacientes.EDAD < 70;");
					 num6 = personaConecta.contarGente("SELECT COUNT(ID_REGISTRO) FROM pacientes LEFT JOIN entidades ON pacientes.ENTIDAD_RES = entidades.CLAVE_ENTIDAD WHERE entidades.ENTIDAD_FEDERATIVA =" + "'" + estado + "' AND pacientes.SEXO = '1' AND pacientes.EDAD >= 70 AND pacientes.EDAD < 100;");
					
				}
				if(genero.equals("Hombre"))
				{
					 num1 = personaConecta.contarGente("SELECT COUNT(ID_REGISTRO) FROM pacientes LEFT JOIN entidades ON pacientes.ENTIDAD_RES = entidades.CLAVE_ENTIDAD WHERE entidades.ENTIDAD_FEDERATIVA =" + "'" + estado + "' AND pacientes.SEXO = '2' AND pacientes.EDAD >= 20 AND pacientes.EDAD < 30;");
					 num2 = personaConecta.contarGente("SELECT COUNT(ID_REGISTRO) FROM pacientes LEFT JOIN entidades ON pacientes.ENTIDAD_RES = entidades.CLAVE_ENTIDAD WHERE entidades.ENTIDAD_FEDERATIVA =" + "'" + estado + "' AND pacientes.SEXO = '2' AND pacientes.EDAD >= 30 AND pacientes.EDAD < 40;");
					 num3 = personaConecta.contarGente("SELECT COUNT(ID_REGISTRO) FROM pacientes LEFT JOIN entidades ON pacientes.ENTIDAD_RES = entidades.CLAVE_ENTIDAD WHERE entidades.ENTIDAD_FEDERATIVA =" + "'" + estado + "' AND pacientes.SEXO = '2' AND pacientes.EDAD >= 40 AND pacientes.EDAD < 50;");
					 num4 = personaConecta.contarGente("SELECT COUNT(ID_REGISTRO) FROM pacientes LEFT JOIN entidades ON pacientes.ENTIDAD_RES = entidades.CLAVE_ENTIDAD WHERE entidades.ENTIDAD_FEDERATIVA =" + "'" + estado + "' AND pacientes.SEXO = '2' AND pacientes.EDAD >= 50 AND pacientes.EDAD < 60;");
					 num5 = personaConecta.contarGente("SELECT COUNT(ID_REGISTRO) FROM pacientes LEFT JOIN entidades ON pacientes.ENTIDAD_RES = entidades.CLAVE_ENTIDAD WHERE entidades.ENTIDAD_FEDERATIVA =" + "'" + estado + "' AND pacientes.SEXO = '2' AND pacientes.EDAD >= 60 AND pacientes.EDAD < 70;");
					 num6 = personaConecta.contarGente("SELECT COUNT(ID_REGISTRO) FROM pacientes LEFT JOIN entidades ON pacientes.ENTIDAD_RES = entidades.CLAVE_ENTIDAD WHERE entidades.ENTIDAD_FEDERATIVA =" + "'" + estado + "' AND pacientes.SEXO = '2' AND pacientes.EDAD >= 70 AND pacientes.EDAD < 100;");
				}
				int [] Cuantos = {num1, num2, num3, num4, num5, num6};
				//Update panel
				vistPer.panelGraph.updateUI();
				vistPer.panelGraph.repaint();
				vistPer.panelGraph.removeAll();
				JFreeChart barChart = ChartFactory.createBarChart(enfermedad, " ", " ", ChartEnfermedades.createDataset2(Cuantos, enfermedad), PlotOrientation.VERTICAL, true, true, false);
				ChartPanel chartPanel = new ChartPanel( barChart );        
			    chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );    
			    chartPanel.setBounds(500, 100, 600, 500); 
			    vistPer.panelGraph.add(chartPanel);
			    //Update titulo
			    titulo = estado;
				titulo2 = "Población de " + genero;
				titulo3 = "Numero de casos con " + enfermedad;
				vistPer.label.setText(titulo);
				vistPer.label2.setText(titulo2);
				vistPer.label3.setText(titulo3);
			}
		
	}
}