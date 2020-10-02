package negocio;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import beans.Cancion;
import interfaces.MusicaInterfaceRMI;

/*
 * UnicastRemoteObject, lo que permitirá a los clientes obtener 
 * el stub del objeto para establecer la comunicación y 
 * poder invocar a los métodos remotos.
 */
public class MusicaRMI extends UnicastRemoteObject implements MusicaInterfaceRMI,Serializable {
		//La interface Serializable es lo que va a permitir salir el objeto de la 
		//MV donde se encuentre
		private static final long serialVersionUID = -4817856459999901795L;
		
		private ArrayList<Cancion> canciones;
		
		public MusicaRMI() throws RemoteException {
			canciones = new ArrayList<Cancion>();
		
			canciones.add(new Cancion(1,"Bohemian Rhapsody", "Queen", "A Night at the Opera", 1975));
			canciones.add(new Cancion(2,"You're My Best Friend", "Queen", "A Night at the Opera", 1975));
			canciones.add(new Cancion(3,"Sweet Lady", "Queen", "A Night at the Opera", 1975));
			
			canciones.add(new Cancion(4,"Karma Police", "Radiohead", "OK Computer", 1997));
			canciones.add(new Cancion(5,"Meeting In The Aisle", "Radiohead", "OK Computer", 1997));
			
			canciones.add(new Cancion(6,"Bloom", "Radiohead", "The King of Limbs", 2011));
			canciones.add(new Cancion(7,"Little by Little", "Radiohead", "The King of Limbs", 2011));
			canciones.add(new Cancion(8,"Give Up the Ghost", "Radiohead", "The King of Limbs", 2011));
			
			canciones.add(new Cancion(9,"Every Breaking Wave", "U2", "Songs of Innocence", 2014));
			canciones.add(new Cancion(10,"Raised by Wolves", "U2", "Songs of Innocence", 2014));
			canciones.add(new Cancion(11,"The Troubles", "U2", "Songs of Innocence", 2014));
			
			canciones.add(new Cancion(12,"The Refugee", "U2", "War", 1983));
			canciones.add(new Cancion(13,"Red Light", "U2", "War", 1983));
			canciones.add(new Cancion(14,"Sunday Bloody Sunday", "U2", "War", 1983));
		}

		@Override
		public String buscarTitulo(String titulo) throws RemoteException {
			String resultado = "";
			for (Cancion c : canciones) {
				if (c.getTitulo().contains(titulo)) {
					resultado = resultado + c + "\n";
				}
			}
			return resultado;
		}

		@Override
		public String buscarBanda(String banda) throws RemoteException {
			String resultado = "";
			for (Cancion c : canciones) {
				if (c.getBanda().contains(banda)) {
					resultado = resultado + c + "\n";
				}
			}
			return resultado;
		}

		@Override
		public String buscarAlbum(String album) throws RemoteException {
			String resultado = "";
			for (Cancion c : canciones) {
				if (c.getAlbum().contains(album)) {
					resultado = resultado + c + "\n";
				}
			}
			return resultado;
		}

		@Override
		public String buscarProducido(int a) throws RemoteException {
			String resultado = "";
			for (Cancion c : canciones) {
				if (c.getProducido() == a) {
					resultado = resultado + c + "\n";
				}
			}
			return resultado;
		}

		@Override
		public Cancion buscarCancion(int id) throws RemoteException {
			for (Cancion c : canciones) {
				if (c.getId() == id) {
					return c;
				}
			}
			return null;
		}
	}

