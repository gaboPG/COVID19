/*ChartEnfermedades
 * Aquí es donde se genera un data set que contiene las columnas y sus casos.
 * Noviembre, 2020.*/
package Chart;

import org.jfree.chart.ChartFactory;
import Vista.VistaPersona1;
import org.jfree.chart.ChartPanel; 
import org.jfree.chart.JFreeChart; 
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset; 
import org.jfree.data.category.DefaultCategoryDataset; 
import org.jfree.ui.ApplicationFrame; 
import org.jfree.ui.RefineryUtilities; 

public class ChartEnfermedades extends ApplicationFrame {

public ChartEnfermedades( String applicationTitle , String chartTitle , int  Cuantos, String Enfermedad) {
      super( applicationTitle );        
      JFreeChart barChart = ChartFactory.createBarChart(
         chartTitle,           
         " ",            
         " ",            
         createDataset(Cuantos, Enfermedad),          
         PlotOrientation.VERTICAL,           
         true, true, false);
         
      ChartPanel chartPanel = new ChartPanel( barChart );        
      chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );    
      chartPanel.setBounds(500, 100, 600, 500); 
      //VistaPersona1.panelGraph.add(chartPanel);
      //setContentPane( chartPanel ); 
   }
   
   public static CategoryDataset createDataset(int Cuantos, String Enfermedad ) {
	   //nombre enfermedad          
      //final String enfer; enfer.equals(enfermedad);
      final String casos = "Casos";
      final DefaultCategoryDataset dataset = new DefaultCategoryDataset( );    
      
      dataset.addValue(Cuantos, Enfermedad, casos);
      dataset.addValue(0, " ", casos);
      dataset.addValue(0, "  ", casos);
              
                   

      return dataset; 
   }
   
   public static CategoryDataset createDataset2(int [] Cuantos, String Enfermedad ) {
	   //nombre enfermedad          
      //final String enfer; enfer.equals(enfermedad);
      final String r1 = "20 - 30";
      final String r2 = "30 - 40";
      final String r3 = "40 - 50";
      final String r4 = "50 - 60";
      final String r5 = "60 - 70";
      final String r6 = "70 - 100";
      final DefaultCategoryDataset dataset = new DefaultCategoryDataset( );    
      
      dataset.addValue(Cuantos[0], r1, r1);
      dataset.addValue(Cuantos[1], r2, r2);
      dataset.addValue(Cuantos[2], r3, r3);
      dataset.addValue(Cuantos[3], r4, r4);
      dataset.addValue(Cuantos[4], r5, r5);
      dataset.addValue(Cuantos[5], r6, r6);
              
                   

      return dataset; 
   }
}