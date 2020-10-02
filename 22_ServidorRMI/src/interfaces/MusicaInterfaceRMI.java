package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

import beans.Cancion;

//El objeto stub que se generará en el cliente tiene que extender de Remote
//para que pueda ser casteado ya que la busqueda
//de objetos en el registro devuelve un objeto de tipo Remote
//(ver la parte de cliente)
public interface MusicaInterfaceRMI extends Remote{
	public String buscarTitulo(String titulo) throws RemoteException;
	public String buscarBanda(String banda) throws RemoteException;
	public String buscarAlbum(String album) throws RemoteException;
	public String buscarProducido(int a) throws RemoteException;
	public Cancion buscarCancion(int id) throws RemoteException;
}
