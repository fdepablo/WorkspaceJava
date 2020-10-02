package modelo.negocio;

import java.util.ArrayList;

import modelo.entidades.Empleado;
import persistencia.DaoEmpleados;

public class GestorEmpleados {
		
	public boolean alta(Empleado e){
		//regla de negocio o requisito funcional
		if("".equals(e.getNombre())){
			return false;
		}
		return new DaoEmpleados().altaEmpleado(e);
	}
	
	public boolean baja(String nombre){
		DaoEmpleados daoEmpleados = new DaoEmpleados();
		return daoEmpleados.eliminarEmpleado(nombre);	
	}

	public ArrayList<Empleado> getListaEmpleados() {
		return new DaoEmpleados().getListaEmpleados();
	}

}
