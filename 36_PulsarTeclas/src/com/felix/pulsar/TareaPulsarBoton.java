package com.felix.pulsar;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.IOException;
import java.util.List;
import java.util.TimerTask;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JTextField;


class TareaPulsarBoton extends TimerTask {

	private JTextField txt;
	private int segundos;
	private Robot robot;
	private List<Integer> teclasPresionar;
	private Clip sonido;
	
	public TareaPulsarBoton(JTextField txtResultado, int segundos, List<Integer> teclasPresionar) {
		this.txt = txtResultado;
		this.segundos = segundos;
		this.teclasPresionar = teclasPresionar;
		
		txt.setText("Configurado para " + segundos + " para teclas");
		try {
			//cargamos el roboto que pulsará el boton
			robot = new Robot();
			// Se obtiene un Clip de sonido
	        sonido = AudioSystem.getClip();
	        
	        // Se carga con un fichero wav
	        //sonido.open(AudioSystem.getAudioInputStream(new File("bloop.wav")));
	        sonido.open(AudioSystem.getAudioInputStream(TareaPulsarBoton.class.getResourceAsStream("/com/felix/pulsar/sonidos/bloop.wav")));
		} catch (AWTException e) {
			System.out.println("No se ha podido crear el robot");
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}       
        
	}

	@Override
	public void run() {
		//txt.setText(segundos+":"+new Random().nextInt(20));
		for(Integer tecla : teclasPresionar) {
			txt.setText("Se ha presionado la tecla con codigo " + tecla);
			robot.keyPress(tecla);
			robot.keyRelease(tecla);
		}
		
		// Comienza la reproducción
        sonido.start();
	}

}