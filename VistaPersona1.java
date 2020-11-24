/*VistaPersona
 * Vista de nuestro proyecto.
 * Noviembre, 2020.*/
package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.ui.RefineryUtilities;
import java.awt.Font;

import Chart.ChartEnfermedades;


public class VistaPersona1 extends JFrame{
	//Declaramos 
	public JComboBox<String> combo;
	public  JButton MostrarNombres;
	public  JTextArea textMuestra;
	public JRadioButton hombre;
	public JRadioButton mujer;
	public JRadioButton EPOC;
	public JRadioButton Asma;
	public JRadioButton Hipertension;
	public JRadioButton Obesidad;
	public JRadioButton Edad;
	public JPanel panelGraph;
	public JLabel label;
	public JLabel label2;
	public JLabel label3;
	
	
    public VistaPersona1()
    {
		//Color
		//this.getContentPane().setBackground(Color.decode("#EE8DBF"));
		//size
		setSize(1200,650);
		//location
		setLocation(200,200);
		//Exit
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//resizable true false
		setResizable(true);
		//Color
		this.getContentPane().setBackground(Color.decode("#D3F5FA"));
		
		setLayout(null);
		//(x,y,width,height)
		
		//Acomodamos
		
		//combo box
		combo = new JComboBox<String>();
		combo.setBounds(0, 5, 380, 20);
		this.add(combo);
		combo.setVisible(false);
		
		//TextArea
		textMuestra = new JTextArea("");
		//tableContain.setBounds(0, 30, 400, 105);
		//this.add(tableContain);
		
		//Labels titulo
		label = new JLabel("");
		label.setBounds(500, -30, 400, 105);
		label.setFont(new Font("Verdana", Font.PLAIN, 25));
		this.add(label);
		label2 = new JLabel("");
		label2.setBounds(500, 0, 400, 105);
		label2.setFont(new Font("Verdana", Font.PLAIN, 25));
		this.add(label2);
		label3 = new JLabel("");
		label3.setBounds(500, 30, 600, 105);
		label3.setFont(new Font("Verdana", Font.PLAIN, 25));
		this.add(label3);
		
		//Boton
		MostrarNombres = new JButton("Iniciar");
		MostrarNombres.setBounds(350, 300, 500, 100);
		MostrarNombres.setBackground(Color.decode("#4B80CC"));
		this.add(MostrarNombres);
		
		//JRadioButtonHombre
		hombre = new JRadioButton("Hombre",true);
		hombre.setBounds(0,50, 250,50);
		hombre.setBackground(Color.decode("#D3F5FA"));
		this.add(hombre);
		hombre.setVisible(false);
		
		//JRadioButtonMujer
		mujer = new JRadioButton("Mujer",false);
		mujer.setBounds(250,50, 250,50);
		mujer.setBackground(Color.decode("#D3F5FA"));
		this.add(mujer);
		mujer.setVisible(false);
	   
		//JRadioButtonEPOC
		EPOC = new JRadioButton("EPOC", true);
		EPOC.setBounds(0,150, 250,50);
		EPOC.setBackground(Color.decode("#D3F5FA"));
		this.add(EPOC);
		EPOC.setVisible(false);
		
		//JRadioButtonAsma
		Asma = new JRadioButton("Asma", false);
		Asma.setBounds(250,150, 250,50);
		Asma.setBackground(Color.decode("#D3F5FA"));
		this.add(Asma);
		Asma.setVisible(false);
	     
		//JRadioButtonHipertension
		Hipertension = new JRadioButton("Hipertension",false);
		Hipertension.setBounds(0,250, 250,50);
		Hipertension.setBackground(Color.decode("#D3F5FA"));
		this.add(Hipertension);
		Hipertension.setVisible(false);
		
		//JRadioButtonObesidad
		Obesidad = new JRadioButton("Obesidad",false);
		Obesidad.setBounds(250,250, 250,50);
		Obesidad.setBackground(Color.decode("#D3F5FA"));
		this.add(Obesidad);	
		Obesidad.setVisible(false);
		
		//JRadioButtonEdad
		Edad = new JRadioButton("Edad", false);
		Edad.setBounds(0, 350, 250, 50);
		Edad.setBackground(Color.decode("#D3F5FA"));
		this.add(Edad);
		Edad.setVisible(false);
		
		
		//Panel para la grafica
		panelGraph = new JPanel();
		panelGraph.setLayout(new BorderLayout());
		panelGraph.setBounds(500, 100, 600, 500); 
		panelGraph.setBackground(Color.decode("#D3F5FA"));
		this.add(panelGraph);
		
	 }
}