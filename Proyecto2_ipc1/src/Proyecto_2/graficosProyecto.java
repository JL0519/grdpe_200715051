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

//LOGIN
	//-----------------------------------------------------------------------------------------------------------
	class marcologin extends JFrame{
		
		public marcologin(){
			
			setTitle("Login");
			setSize(550,350);
			setResizable(false);
			setLocationRelativeTo(null);
			setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			
			laminalogin lamina = new laminalogin();
			add(lamina);
			
			setVisible(true );
		}
		
		private class laminalogin extends JPanel{
			
			JTextField texto1;
			JPasswordField contra;
			
			String barra = File.separator;
			
			private String ubicacion = System.getProperty("user.dir")+barra+"Registros"+barra;
			
			public void paintComponent(Graphics g) {
					
					super.paintComponent(g);
					
					try {
						
						usuario = ImageIO.read(new File("src/imag/usuarioP.png"));
						}
					catch(IOException e){
						
						JOptionPane.showMessageDialog(marcologin.this, "La imagen no se encuentra");
						}
					g.drawImage(usuario,400,50,null);
				}
			
			
			public void ingreso() {
				
				String admin = "admin";
				String pass = "password";
				
				String password = new String(contra.getPassword());
				
				File url = new File(ubicacion+texto1.getText()+".registro");
				
				if(texto1.getText().equals(admin) && password.equals(pass)) {
				
				MarcoAdmin base= new MarcoAdmin();
				base.setVisible(true);
				this.setVisible(false);
				
				}
				
				else if(url.exists()) {
					
					
					
					try {
						
						FileInputStream fis1 = new FileInputStream(url);
						
						Properties mostrar = new Properties();
						
						mostrar.load(fis1);
						
						
						
						String texto1 = mostrar.getProperty("id");
						
						String cui = texto1;
						
						String pass2 = mostrar.getProperty("contraseña");
						
						//System.out.println(cui);					
						//System.out.println(pass2);
						
						if(texto1.equals(cui) && password.equals(pass2) ){
							
//							Usuario usu = new Usuario();
//							usu.setVisible(true);
//							marcologin.this.setVisible(false);
						}
						else {
							
							JOptionPane.showMessageDialog(rootPane, "Contraseña Incorrecta");
						}
						
						
						
					}catch(Exception e) {
						
						JOptionPane.showMessageDialog(rootPane, "No se encuentra el Usuario");
					}
				}
				
				else {
					
					JOptionPane.showMessageDialog(marcologin.this,"El usuario no existe. Por favor ponerse en contacto con "
											+"el administrador para solicitar un registro.","ERROR",0);
				}
			}
			
	//-----------------------------------------------------------------------------------------------------------------			
		public laminalogin() {
					
					setLayout(null);
					
					
			JLabel rotulo1 = new JLabel("Nombre:");
			JLabel rotulo2 = new JLabel("Contraseña:");
			
			texto1 = new JTextField();
			contra = new JPasswordField();
			
			rotulo1.setBounds(20, 20, 75, 20);
			rotulo2.setBounds(20, 80, 75, 20);
			
			texto1.setBounds(140, 50, 175, 20);
			contra.setBounds(140, 110, 175, 20);
			
			JButton ingresar = new JButton("Ingresar");
			JButton cancelar = new JButton("Cancelar");
			
			
			ingresar.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					ingreso();
				}
		
			});
					
					
			cancelar.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						
						if(e.getSource()==cancelar) {
							
							texto1.setText("");
							contra.setText("");
						}
						
					}
					
					
				});	
					
					ingresar.setBounds(80, 200, 105, 30);
					cancelar.setBounds(250, 200, 105, 30);
					
					add(rotulo1);
					add(rotulo2);
					add(texto1);
					add(contra);
					add(ingresar);
					add(cancelar);
				
				}
				
				private Image usuario;
			}

	}

	//ADMINISTRADOR
	//------------------------------------------------------------------------------------------------------

	class MarcoAdmin extends JFrame{
		
		public MarcoAdmin() {
			
			
			setTitle("Administrador");
			setSize(1200,650);
			setResizable(false);
			laminaBase milamina = new laminaBase();
			add(milamina);
			setLocationRelativeTo(null);
			setVisible(true);
			setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			
		}
		
		private class laminaBase extends JPanel{
			
			private Image Java,adminImagen;
			
			public void paintComponent(Graphics c) {
				
				super.paintComponent(c);
				
				Graphics2D d = (Graphics2D)c;
				
				Rectangle2D rect = new Rectangle2D.Double(700,280,450,300);
				
				Rectangle2D rect2 = new Rectangle2D.Double(50,280,450,300);
				
				try {
					
					Java = ImageIO.read(new File("src/Logo Java.png"));
					}
				catch(IOException e){
					
					JOptionPane.showMessageDialog(MarcoAdmin.this, "La imagen no se encuentra");
					}
				
				try {
					
					adminImagen= ImageIO.read(new File("src/imag/admin logo.png"));
					}
				catch(IOException e){
					
					JOptionPane.showMessageDialog(MarcoAdmin.this, "La imagen no se encuentra");
					}
				
				d.drawImage(adminImagen, 800, 90, null);
				
				d.drawImage(Java,100,130,null);
				
				d.draw(rect);
				
				d.draw(rect2);
			}
			
			
			
			public laminaBase() {
				
				setLayout(null);
				
				JLabel logo= new JLabel("Logo");
				JLabel adminUsu = new JLabel("Usuarios");
				JLabel adminBiblio= new JLabel("Bibliografias");
				
				
				
				JButton botonlog = new JButton("Logout");
				JButton usuCrear= new JButton("Crear");
				JButton biblioCrear= new JButton("Crear");
				JButton usuEliminar= new JButton("Eliminar");
				JButton biblioEliminar = new JButton("Eliminar");
				JButton usuModificar= new JButton("Modificar");
				JButton biblioModificar= new JButton("Modificar");
				JButton usuMostrar= new JButton("Mostrar");
				JButton biblioMostrar= new JButton("Mostrar");
				
				
				
				botonlog.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						
						
						MarcoAdmin.this.setVisible(false);
						
					}
					
					
					
				});
				
				usuCrear.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						registroUsu ver = new registroUsu();
						ver.setVisible(true);
					}

				});
				
				usuMostrar.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						JOptionPane.showMessageDialog(rootPane, "Ingrese el ID/CUI");
						
//						mostrarUsu mostrar = new mostrarUsu();
//						
//						mostrar.setVisible(true);
					}

				});
				
				usuModificar.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						
//						JOptionPane.showMessageDialog(rootPane, "Ingrese el ID/CUI para modificar");
//						modificarUsu modificar = new modificarUsu();
//						modificar.setVisible(true);
					}
					
				});
				
				usuEliminar.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
//						eliminarUsu eliminar = new eliminarUsu();
//						eliminar.setVisible(true);
					}
				});
				
				biblioCrear.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
//						cargaIndividual carga = new cargaIndividual();
//						carga.setVisible(true);
					}
					
				});
				
				biblioMostrar.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						JOptionPane.showMessageDialog(rootPane, "Ingrese el nombre del TITULO para mostrar el archivo guardado");

						
//						bibliomostrar mostrar = new bibliomostrar();
//						mostrar.setVisible(true);
					}
					
				});
				
				biblioEliminar.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
//						borrarbiblio borrar = new borrarbiblio();
//						borrar.setVisible(true);
					}
					
				});
				
				biblioModificar.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						JOptionPane.showMessageDialog(rootPane, "Ingrese primero el titulo deseado para modificar");
//						modificarbiblio modi = new modificarbiblio();
//						modi.setVisible(true);
					}
					
				});
				
				logo.setBounds(150, 100, 50, 20);
				botonlog.setBounds(1000, 100, 95, 30);
				adminUsu.setBounds(70, 300, 75, 25);
				adminBiblio.setBounds(720, 300, 75, 25);
				usuCrear.setBounds(80, 350, 120, 40);
				usuEliminar.setBounds(80,500,120,40);
				usuModificar.setBounds(300,350,120,40);
				usuMostrar.setBounds(300,500,120,40);
				biblioCrear.setBounds(730, 350, 120, 40);
				biblioEliminar.setBounds(730,500,120,40);
				biblioModificar.setBounds(1000,350,120,40);
				biblioMostrar.setBounds(1000,500,120,40);
				
				add(logo);
				add(botonlog);
				add(adminUsu);
				add(adminBiblio);
				add(usuCrear);
				add(usuEliminar);
				add(usuModificar);
				add(usuMostrar);
				add(biblioCrear);
				add(biblioEliminar);
				add(biblioModificar);
				add(biblioMostrar);
			}
		}

	}


	//REGISTRO
	//----------------------------------------------------------------------------------------------------------


	class registroUsu extends JFrame{
		
		
		public registroUsu(){
			
			
			setTitle("Registro de Usuarios");
			setBounds(300,80,350,355);
			setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			setResizable(false);
			
			laminaregistro milamina = new laminaregistro();
			add(milamina);
			
			setVisible(true);
		}

	private class laminaregistro extends JPanel{
		

		String barra = File.separator;
		
		private String ubicacion = System.getProperty("user.dir")+barra+"Registros"+barra;
		
		private JTextField txtid,txtnombre,txtapellido,txtuser,txtrol,txtcontraseña;
		
		private void crear() {
			
			
			
			String archivo = txtid.getText()+".registro";
			
			File crearubicacion = new File(ubicacion);
			File creararchivo= new File(ubicacion+archivo);
			
			if(txtid.getText().equals("")) {
				
				JOptionPane.showMessageDialog(rootPane, "No hay ID/CUI");
			}else {
				
				try {
					
					if(creararchivo.exists()) {
						
						JOptionPane.showMessageDialog(rootPane, "El registro ya Existe");
						
					}
					
					else {
						
						
						crearubicacion.mkdirs();
						
						
						Formatter crea = new Formatter(ubicacion+archivo);
						
						crea.format("%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s",
								"id= "+txtid.getText(),"nombre= "+txtnombre.getText(),"apellido= "+txtapellido.getText()
								,"user= "+txtuser.getText(),"rol= "+txtrol.getText(),"contraseña= "+txtcontraseña.getText());
						
						 
						crea.close();
						JOptionPane.showMessageDialog(rootPane, "Archivo Creado");
						
					}
				
				}catch(Exception e) {
					
					JOptionPane.showMessageDialog(rootPane, "No se pudo crear archivo");

				}
				
			}
			
		}


		
		public laminaregistro(){
			
			setLayout(new colocar());
			
			
			JLabel id = new JLabel("ID/CUI");
			JLabel nombre = new JLabel("Nombre");
			JLabel apellido = new JLabel("Apellido");
			JLabel user = new JLabel("User");
			JLabel rol= new JLabel("Rol");
			JLabel contraseña = new JLabel("Contraseña");
			
			txtid = new JTextField(10);
			txtnombre = new JTextField(10);
			txtapellido = new JTextField(10);
			txtuser = new JTextField(10);
			txtrol = new JTextField(10);
			txtcontraseña = new JTextField(10);
			
			JButton registrar = new JButton("Registrar");
			
			JButton cancelar = new JButton("Limpiar");
			
			registrar.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					
					crear();// LLAMAMOS METODO
				
				
				}
				
				
			});
			
			cancelar.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
						
					if(e.getSource()==cancelar) {
						
						txtid.setText("");
						txtnombre.setText("");
						txtapellido.setText("");
						txtuser.setText("");
						txtrol.setText("");
						txtcontraseña.setText("");
					}
				}
				
				
			});
			
			
			
			add(id);
			add(txtid);
			add(nombre);
			add(txtnombre);
			add(apellido);
			add(txtapellido);
			add(user);
			add(txtuser);
			add(rol);
			add(txtrol);
			add(contraseña);
			add(txtcontraseña);
			
			add(registrar);
			add(cancelar);
		}

	}
	private class colocar implements LayoutManager{
		
		private int x; 
		private int y = 40;

		@Override
		public void addLayoutComponent(String arg0, Component arg1) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void layoutContainer(Container contenedor) {
			// TODO Auto-generated method stub
			
			int d = contenedor.getWidth();
			x= d/2;
			
			int contador = 0;
			int n= contenedor.getComponentCount();
			
			for(int i = 0; i < n ; i++) {
				
				
				contador++;
				
				Component c = contenedor.getComponent(i);
				
				c.setBounds(x-100, y, 100, 20);
				x+= 100;
				
				if(contador%2==0) {
					
					x=d/2;
					y+=40;
				}
				
			}
			
		}

		@Override
		public Dimension minimumLayoutSize(Container arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Dimension preferredLayoutSize(Container arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void removeLayoutComponent(Component arg0) {
			// TODO Auto-generated method stub
			
		}
		
		
	    }
	}


