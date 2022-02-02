
public class GestorPersona {

	/**
	 * El nombre es correcto cuando tiene al menos 3 caracteres
	 * @param persona la persona a validar
	 * @return true en caso de que p.nombre tenga 3 o mas caracteres
	 * false en caso contrario
	 */
	public boolean validarNombre(Persona persona) {
		if(persona.getNombre().length() >= 3) {
			return true;
		}else {
			return false;
		}
	}
}
