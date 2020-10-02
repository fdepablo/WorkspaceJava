package main;

import java.util.ArrayList;

import entidades.*;

public class Main {
	public static void main(String[] args) {
		ArrayList<Empleado> empleadosEmpresa;
		empleadosEmpresa = new ArrayList<>();
		
		Trabajador t1 = new Trabajador();
		t1.setNombre("Pepe");
		t1.setNomina(1100);
		
		Trabajador t2 = new Trabajador();
		t2.setNombre("Maria");
		t2.setNomina(1200);
		
		Jefe j1 = new Jefe();
		j1.setNombre("Eduardo");
		j1.setNomina(1300);
		j1.setIncentivo(100);
		
		Directivo d1 = new Directivo();
		d1.setNombre("Ana");
		d1.setNomina(1800);
		ArrayList<Empleado> empleadosACargo = new ArrayList<>();
		empleadosACargo.add(t1);
		empleadosACargo.add(j1);
		d1.setListaEmpleadosACargo(empleadosACargo);
		
		empleadosEmpresa.add(t1);
		empleadosEmpresa.add(t2);
		empleadosEmpresa.add(j1);
		empleadosEmpresa.add(d1);
		
		for(Empleado e : empleadosEmpresa){
			System.out.println(e.getNombre() + " gana la cantidad de"
					+ " " + e.calcularSueldo());
		}
		
	}
}
