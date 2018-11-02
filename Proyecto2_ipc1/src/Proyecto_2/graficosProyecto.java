package Proyecto_2;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;
import java.io.*;
import java.util.Formatter;
import java.util.Properties;

import javax.imageio.ImageIO;
import javax.swing.*;

public class graficosProyecto  extends JFrame{
		
		public graficosProyecto() {
		
			
			setTitle("IPC1 - PROYECTO 1");
			setSize(1300,700);
			setResizable(false);
			setLocationRelativeTo(null);
			laminaPort milamina = new laminaPort();
			add(milamina);
		}
		
		
		private class laminaPort extends JPanel{
			
			
			
			private  Image usuariobiblio,Lusac,biblio;
			
			public void paintComponent(Graphics g) {
				
				
				super.paintComponent(g);
				
				try {
					
					usuariobiblio = ImageIO.read(new File("src/imag/iconobiblio.png"));
					
				}catch(IOException e) {
					
					JOptionPane.showMessageDialog(this, "La imagen no se encuentra");
				}
				
				try {
					
					Lusac = ImageIO.read(new File("src/imag/Lusac.png"));
					
				}catch(IOException e) {
					
					JOptionPane.showMessageDialog(this, "La imagen no se encuentra");
				}
				
				try {
					
					biblio = ImageIO.read(new File("src/imag/Biblioteca-Virtual.jpg"));
					
				}catch(IOException e) {
					
					JOptionPane.showMessageDialog(this, "La imagen no se encuentra");
				}
				
				g.drawImage(usuariobiblio, 70,25, null);
				
				g.drawImage(Lusac, 50,300, null);
				
				g.drawImage(biblio, 695, 305, null);
				
				g.drawRect(35, 15, 1200, 160);
				
				g.drawRect( 690, 300, 490, 260);
			}
			
			public laminaPort(){
				
				setLayout(null);
				
				JButton botonlogin = new JButton("Login");
				JButton botonabout = new JButton("About");
				
				botonlogin.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
//						marcologin login = new marcologin();
//						login.setVisible(true);
						
					}

				});
				
				botonabout.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
//						mrcabout lamina = new mrcabout();
//						lamina.setVisible(true);
					}
					
				});
				
				botonlogin.setBounds(460, 70, 95, 40);
				botonabout.setBounds(500, 550, 95, 40);
				
				
				
				add(botonlogin);
				add(botonabout);
				
		
				
			}

		}
	

}