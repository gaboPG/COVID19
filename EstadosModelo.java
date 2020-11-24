/*Estados Modelo
 * Sirve para generar objetos tipo estado que tienen id, nombre y abreviatura.
 * Noviembre, 2020.*/
package Modelo;

public class EstadosModelo {
	// de  acuerdo a los campos de la BD
		int CLAVE_ENTIDAD;
		String ENTIDAD_FEDERATIVA;
		String ABREVIATURA;
		
		public EstadosModelo(int cLAVE_ENTIDAD, String eNTIDAD_FEDERATIVA,
				String aBREVIATURA) {
			super();
			CLAVE_ENTIDAD = cLAVE_ENTIDAD;
			ENTIDAD_FEDERATIVA = eNTIDAD_FEDERATIVA;
			ABREVIATURA = aBREVIATURA;
		}
		
		public EstadosModelo(){
			CLAVE_ENTIDAD=0;
			ENTIDAD_FEDERATIVA="";
			ABREVIATURA="";
		}
		
		public int getCLAVE_ENTIDAD() {
			return CLAVE_ENTIDAD;
		}
		
		public void setCLAVE_ENTIDAD(int cLAVE_ENTIDAD) {
			CLAVE_ENTIDAD = cLAVE_ENTIDAD;
		}
		
		public String getENTIDAD_FEDERATIVA() {
			return ENTIDAD_FEDERATIVA;
		}
		
		public void setENTIDAD_FEDERATIVA(String eNTIDAD_FEDERATIVA) {
			ENTIDAD_FEDERATIVA = eNTIDAD_FEDERATIVA;
		}
		
		public String getABREVIATURA() {
			return ABREVIATURA;
		}
		
		public void setABREVIATURA(String aBREVIATURA) {
			ABREVIATURA = aBREVIATURA;
		}
		
}
