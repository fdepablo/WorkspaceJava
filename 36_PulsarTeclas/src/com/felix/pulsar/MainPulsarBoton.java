package com.felix.pulsar;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainPulsarBoton {

	/**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void creaYMuestraGUI() {
        //Make sure we have nice window decorations.
        JFrame.setDefaultLookAndFeelDecorated(true);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1,5));
        
 
        //Create and set up the window.
        JFrame frame = new JFrame("Aplicacion de pulsado automatico de boton");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(new Point(500,400));
        frame.setPreferredSize(new Dimension(1000, 60));
        frame.getContentPane().add(panel);
 
        JLabel lMinutos = new JLabel("Introduce la cantidad: ");
        panel.add(lMinutos); 
        
        JTextField txtMinutos = new JTextField();
        txtMinutos.setMaximumSize(new Dimension(30, 5));
        txtMinutos.setText("300");//5 minutos por defecto
        panel.add(txtMinutos);
        JButton botonEmpezar = new JButton();
        botonEmpezar.setText("Empezar a pulsar F5");
        panel.add(botonEmpezar);
        JTextField txtResultado = new JTextField();
        txtResultado.setMaximumSize(new Dimension(100,5));
        panel.add(txtResultado);
        
        
        botonEmpezar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			    String sMinutos = txtMinutos.getText();
			    int iMinutos = Integer.parseInt(sMinutos);
			    int segundos = iMinutos;
			    int milisegundos = segundos * 1000;
			    
			    Timer t = new Timer();
			    List<Integer> listaTeclas = new ArrayList<>();
			    listaTeclas.add(KeyEvent.VK_F6);
			    listaTeclas.add(KeyEvent.VK_F5);
			    TareaPulsarBoton mTask = new TareaPulsarBoton(txtResultado, segundos, listaTeclas);
			    t.scheduleAtFixedRate(mTask, milisegundos, milisegundos);
			}
		});
        
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
 
    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                creaYMuestraGUI();
            }
        });
    }
	

}
