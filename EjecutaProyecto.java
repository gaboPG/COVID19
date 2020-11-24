/*EjecutaProyecto.
 * Ejectuta el proyecto general.
 * Noviembre, 2020.  */
package Controlador;

import Vista.VistaPersona1;
import Modelo.EstadosModConectar;

public class EjecutaProyecto {

	public static void main(String[] args) {
		VistaPersona1 vp = new VistaPersona1();
		EstadosModConectar pc = new EstadosModConectar();
		
		Controlador cp = new Controlador(vp, pc);
		vp.setVisible(true);

	}

}