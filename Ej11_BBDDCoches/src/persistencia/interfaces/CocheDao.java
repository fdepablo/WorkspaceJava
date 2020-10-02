package persistencia.interfaces;

import java.util.List;

import entidades.Coche;

public interface CocheDao {
	boolean alta(Coche p);
	boolean baja(int id);
	boolean modificar(Coche p);
	Coche obtener(int id);
	List<Coche> listar();
}
