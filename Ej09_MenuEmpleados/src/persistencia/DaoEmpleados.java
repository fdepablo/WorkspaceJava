package persistencia;

import java.util.ArrayList;

import modelo.entidades.Empleado;

//Encargar de la comunicación con la base de datos (si hubiera)
//o cualquier tipo de persistencia
public class DaoEmpleados {
	private static ArrayList<Empleado> listaEmpleados = new ArrayList<>();
	
	/**
	 * Add un empleado al array list 
	 * @param e el empleado a dar de alta
	 * @return true en caso de que se haya podido insertar
	 */
	public boolean altaEmpleado(Empleado e) {
		listaEmpleados.add(e);
		return true;
	}
	
	/**
	 * Metodo que elimina un empleado de la lista a partir del nombre
	 * @param nombre el nombre del empleado a borrar
	 * @return true en caso de que se haya podido borrar el empleado,
	 * es decir, el usuario existe, y false en caso de que no exista
	 */
	public boolean eliminarEmpleado(String nombre){
		Empleado empleadoEncontrado = null;
		for(Empleado empleado : listaEmpleados){
			if(empleado.getNombre().equalsIgnoreCase(nombre)){
				empleadoEncontrado = empleado;
				break;
			}
		}
		if(empleadoEncontrado != null){
			return listaEmpleados.remove(empleadoEncontrado);
		}else {
			return false;
		}
		
	}
	
	/**
	 * Devuelve la lista de empleados actuales
	 * @return la lista de empleados
	 */
	public ArrayList<Empleado> getListaEmpleados(){
		return listaEmpleados;
	}
}
