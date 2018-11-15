package Proyecto_2;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;
import java.io.*;
import java.util.Formatter;
import java.util.Properties;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class graficosProyecto  extends JFrame{
		
	public graficosProyecto() {

		
		setTitle("IPC1 - PROYECTO 2");
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
					marcologin login = new marcologin();
					login.setVisible(true);
					
				}

			});
			
			botonabout.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
//					mrcabout lamina = new mrcabout();
//					lamina.setVisible(true);
				}
				
			});
			
			botonlogin.setBounds(1000, 47, 80, 40);
			botonabout.setBounds(500, 550, 95, 40);
			
			
			
			add(botonlogin);
			add(botonabout);
			
		}

	}
}

//LOGIN
//-----------------------------------------------------------------------------------------------------------
class marcologin extends JFrame{
	
	JTextField texto1;
	JPasswordField contra;
	
	registroAlumno registro= new registroAlumno();
	cargaMasiva carga = new cargaMasiva();

	nodoUsuario temporal, temporal2;
	
	nodoCatedra temporalCat1;
	
	ventanaCatedra catedra = new ventanaCatedra();
	
	Usuario usu1 = new Usuario();
	
	static loginDato log;
	static loginCatedra logCat;
	
	public marcologin(){
		
		setTitle("Login");
		setSize(550,350);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		laminalogin lamina = new laminalogin();
		add(lamina);
	}
	
	public void salir() {
		
		this.setVisible(false);
	}
	
	
//-----------------------------------------------------------------------------------------------------------------				
	private class laminalogin extends JPanel{

		
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
		JButton limpiar = new JButton("Limpiar");
		
		
		ingresar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ingreso();
			}
	
		});
				
				
		limpiar.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
						
						texto1.setText("");
						contra.setText("");
					
				}
				
				
			});	
		
		cancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				salir();
			}
		});
				
				ingresar.setBounds(80, 200, 105, 30);
				limpiar.setBounds(200, 200, 105, 30);
				cancelar.setBounds(320, 200, 105, 30);
				
				add(rotulo1);
				add(rotulo2);
				add(texto1);
				add(contra);
				add(ingresar);
				add(cancelar);
				add(limpiar);
			
			}
			
			private Image usuario;
		}


	public void ingreso() {
		
		String admin = "admin";
		String pass = "123";

		
		String password = new String(contra.getPassword());//SE DEFINE EL STRING COMO NEW PARA LAS CONTRASEÑAS
			
		if(texto1.getText().equals(admin) && password.equals(pass)) 
		{
		
			MarcoAdmin base= new MarcoAdmin();
			
			base.setVisible(true);
			
			marcologin.this.setVisible(false);
			
		}
		
		else if(!texto1.getText().equals(admin) && !texto1.getText().equals("")){
				
			temporal2 = carga.lista.inicio;
			//temporalCat1 = catedra.listaCat.inicio;
			
			
			for(int j =0; j < carga.lista.getTamaño(); j++) {//BUCLE DE CARGA MASIVA
				
				if(texto1.getText().equals(temporal2.getCarnet())) {
					
					if(password.equals(temporal2.getContraseña())) {
						
						log = new loginDato(temporal2.getCarnet());
						
						usu1.setVisible(true);
						
						marcologin.this.setVisible(false);
						
						break;
						
					}else {
										
						JOptionPane.showMessageDialog(rootPane,"El usuario no existe. Por favor ponerse en contacto con "
								+"el administrador para solicitar un registro.","ERROR",0);

						break;
					}
				}
				
				temporal2 = temporal2.getSiguiente();
			}	
			
			for(int k =0; k < catedra.listaCat.getTamaño(); k++) {//BUCLE DE CARGA MASIVA
				
				if(texto1.getText().equals(temporalCat1.getNombre())) {
					
					if(password.equals(temporalCat1.getContraseña())) {
						
						logCat = new loginCatedra(temporalCat1.getNombre());
						
						System.out.println(logCat.getDato());
						
						catedratico vent = new catedratico();
						vent.setVisible(true);
						
						marcologin.this.setVisible(false);
						break;
						
					}else {
										
						JOptionPane.showMessageDialog(rootPane,"El usuario no existe. Por favor ponerse en contacto con "
								+"el administrador para solicitar un registro.","ERROR",0);

						break;
					}
				}
				
				temporalCat1 = temporalCat1.getSiguiente();
			}	
		}
			
		
			
		else if(texto1.getText().equals("")) 
		{
				
				JOptionPane.showMessageDialog(rootPane, "Ingrese un usuario por favor.", "ERROR", 1);
		}
			
		else
		{
			
			JOptionPane.showMessageDialog(rootPane,"El usuario no existe. Por favor ponerse en contacto con "
									+"el administrador para solicitar un registro.","ERROR",0);	
		}
	}
}

//ADMINISTRADOR
//------------------------------------------------------------------------------------------------------

class MarcoAdmin extends JFrame{
	
	public MarcoAdmin() {
		
		
		setTitle("Administrador");
		setSize(1000,500);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		laminaBase milamina = new laminaBase();
		add(milamina);
		
		
	}
	
	private class laminaBase extends JPanel{
		
		private Image Java,adminImagen;
		
		public void paintComponent(Graphics c) {
			
			super.paintComponent(c);
			
			Graphics2D d = (Graphics2D)c;
			
			Rectangle2D rect = new Rectangle2D.Double(650,280,250,150);
			
			Rectangle2D rect2 = new Rectangle2D.Double(350,280,250,150);
			
			Rectangle2D rect3 = new Rectangle2D.Double(50,280,250,150);
			
			try {
				
				Java = ImageIO.read(new File("src/imag/Logo Java.png"));
				
				adminImagen= ImageIO.read(new File("src/imag/admin logo.png"));
				
				}
			catch(IOException e){
				
				JOptionPane.showMessageDialog(MarcoAdmin.this, "La imagen no se encuentra");
				}
			
			d.drawImage(adminImagen, 600, 90, null);
			
			d.drawImage(Java,100,130,null);
			
			d.draw(rect);
			
			d.draw(rect2);
			
			d.draw(rect3);
		}
		
		
		
		public laminaBase() {
			
			setLayout(null);
			
			JLabel logo= new JLabel("Logo");
			JLabel adminUsu = new JLabel("Alumnos:");
			JLabel adminBiblio= new JLabel("Cursos:");
			JLabel adminCatedratico = new JLabel("Catedratico:");
			
			JButton botonlog = new JButton("Logout");
			JButton botonAlumno = new JButton("Alumnos");
			JButton botonCurso = new JButton("Cursos");
			JButton botonCatedra = new JButton("Catedraticos");
			
			
			botonlog.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
						
					MarcoAdmin.this.setVisible(false);
					
				}
						
			});
			
			botonAlumno.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					ventanaUsuario ventana = new ventanaUsuario();
					ventana.setVisible(true);
					
					
				}
			});
			
			botonCatedra.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					ventanaCatedra cat = new ventanaCatedra();
					cat.setVisible(true);
				}
			});
			
			botonCurso.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					

					ventanaCurso curso = new ventanaCurso();
					
					curso.setVisible(true);
				}
			});
			
			
			logo.setBounds(150, 100, 50, 20);
			botonlog.setBounds(830, 100, 95, 30);
			botonAlumno.setBounds(100, 350, 150, 30);
			botonCatedra.setBounds(700, 350, 150, 30);
			botonCurso.setBounds(400, 350, 150, 30);
			adminUsu.setBounds(70, 300, 75, 25);
			adminCatedratico.setBounds(690, 300, 75, 25);
			adminBiblio.setBounds(370, 300, 75, 25);
			
			
			add(logo);
			add(botonlog);
			add(adminUsu);
			add(adminBiblio);
			add(adminCatedratico);
			add(botonAlumno);
			add(botonCurso);
			add(botonCatedra);
			
		}
	}

}

class ventanaUsuario extends JFrame{
	
	private JButton agregar, mostrar, eliminar, modificar;
	registroAlumno alumno1 = new registroAlumno();
	
	
	public ventanaUsuario() {
		// TODO Auto-generated constructor stub
		
		setTitle("Ventana de Alumno");
		setSize(300,270);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		laminaventana lamin =new laminaventana();
		add(lamin);
		
	}
	
	private class laminaventana extends JPanel{
		
		
		public laminaventana() {
			// TODO Auto-generated constructor stub
		
			setLayout(null);
			
			agregar = new JButton("Agregar");
			mostrar = new JButton("Visualizar");
			modificar = new JButton("Modificar");
			eliminar = new JButton("Eliminar");
			
			agregar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					
					alumno1.setVisible(true);
					
					ventanaUsuario.this.setVisible(false);
				}
			});
			
			mostrar.addActionListener( new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					visualizarUsuario visual = new visualizarUsuario();
					
					visual.setVisible(true);
					ventanaUsuario.this.setVisible(false);
				}
			});
			
			modificar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					modificarAlumno modi = new modificarAlumno();
					
					modi.setVisible(true);
					
					ventanaUsuario.this.setVisible(false);
				}
			});
			
			eliminar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					
					eliminarAlumno eli = new eliminarAlumno();
					eli.setVisible(true);
					
					ventanaUsuario.this.setVisible(false);
				}
			});
			
			agregar.setBounds(100, 30, 100, 30);
			mostrar.setBounds(100, 70, 100, 30);
			modificar.setBounds(100, 110, 100, 30);
			eliminar.setBounds(100, 150, 100, 30);
			
			add(agregar);
			add(mostrar);
			add(modificar);
			add(eliminar);
			
		}
	}
}


//REGISTRO ALUMNO
//----------------------------------------------------------------------------------------------------------

class registroAlumno extends JFrame{
	
	private JTextField txtid,txtnombre,txtcorreo,txtdireccion,txtrcreditos, txtcarnet;
	private JLabel contraRandom, carnet, id, nombre, correo,direccion, creditos, contraseña;

	int valorAuto;
	private String ultimos,id2,carnet2,nombre2,direccion2,correo2,creditos2,contraseña2;
	
	static String contenido;
	cargaMasiva carga;
	
	public registroAlumno(){
		
		
		setTitle("Registro de Alumnos");
		setSize(430,350);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setResizable(false);
		
		laminaregistro milamina = new laminaregistro();
		add(milamina);
		
		botonUsuario miboton = new botonUsuario();
		
		add(miboton, BorderLayout.SOUTH);
	}

	private class laminaregistro extends JPanel{
			
		
		public laminaregistro(){
			
			setLayout(null);
			
			carnet = new JLabel("Carné:");
			id = new JLabel("ID/CUI:");
			nombre = new JLabel("Nombre:");
			correo = new JLabel("Correo:");
			direccion = new JLabel("Direccion:");
			creditos = new JLabel("Creditos:");
			contraseña = new JLabel("Contraseña:");
			contraRandom = new JLabel();
			
			txtcarnet = new JTextField();
			txtid = new JTextField();
			txtnombre = new JTextField();
			txtcorreo = new JTextField();
			txtdireccion = new JTextField();
			txtrcreditos = new JTextField();
			
			carnet.setBounds(30,30,100,20);
			txtcarnet.setBounds(180,30,150,20);
			id.setBounds(30,60,100,20);
			txtid.setBounds(180,60,150,20);
			nombre.setBounds(30,90,100,20);
			txtnombre.setBounds(180,90,150,20);
			direccion.setBounds(30,120,100,20);
			txtdireccion.setBounds(180,120,150,20);
			correo.setBounds(30,150,100,20);
			txtcorreo.setBounds(180,150,150,20);
			creditos.setBounds(30,180,100,20);
			txtrcreditos.setBounds(180,180,150,20);
			contraseña.setBounds(30, 210, 100, 20);
			contraRandom.setBounds(180, 210, 150, 20);
			
			add(id);
			add(txtid);
			add(carnet);
			add(txtcarnet);
			add(nombre);
			add(txtnombre);
			add(direccion);
			add(txtdireccion);
			add(correo);
			add(txtcorreo);
			add(creditos);
			add(txtrcreditos);
			add(contraseña);
			add(contraRandom);
			
			
		}
	
	}

	private class botonUsuario extends JPanel{
	
	public botonUsuario() {
		// TODO Auto-generated constructor stub
		
		setBackground(Color.orange);
	
		JButton registrar = new JButton("Registrar");
		JButton crearContra = new JButton("Contraseña");
		JButton cancelar = new JButton("Limpiar");
		JButton masiva = new JButton("Carga Masiva");
		
		registrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				agregar();// LLAMAMOS METODO
			
			}
			
			
		});
		
		masiva.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				cargaMasiva();
				
				cargaMasiva carga = new cargaMasiva();
				
				carga.cargaCadena(contenido);
				
				JOptionPane.showMessageDialog(rootPane, "Alumnos registrados de forma exitosa.", "Registro exitoso!!", 1);
		
				registroAlumno.this.setVisible(false);
			}
		});
		
		cancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
					
					txtid.setText("");
					txtnombre.setText("");
					txtcarnet.setText("");
					txtcorreo.setText("");
					txtdireccion.setText("");
					txtrcreditos.setText("");
					contraRandom.setText("");
			}
			
			
		});
		
		crearContra.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				contraseñaRandom();
				
			}
		});
		
		add(crearContra);
		add(registrar);
		add(masiva);
		add(cancelar);
	}
}


	public void agregar() {
	
		id2 = txtid.getText();
		nombre2 = txtnombre.getText();
		correo2 = txtcorreo.getText();
		direccion2 = txtdireccion.getText();
		creditos2 = txtrcreditos.getText();
		carnet2 = txtcarnet.getText();
		contraseña2 = contraRandom.getText();
		
		carga.lista.agregarFinal(carnet2, id2, nombre2, correo2, direccion2, creditos2, contraseña2);
		
		JOptionPane.showMessageDialog(rootPane, "Alumno registrado de manera exitosa!!!");
	}
	

	public void cargaMasiva() {
		
		String separador = File.separator;
		String url = "src"+separador+"archivo.ipc1_e";
		
		int c = 0;
		int d =0;
		int contador =0;
		char letra2;
		
		try {
			FileReader entrada = new FileReader(url);
			FileReader entrada2 = new FileReader(url);
			
			while(c!=-1) {
				
				c = entrada.read();
				
				if(c ==-1) {
				
					break;
				}	
					
				contador++;
			}
			
			char [] texto = new char[contador];
			
			for(int i =0; i< contador;i++ ) {
				
				d = entrada2.read();
				
				letra2 = (char)d;
				
				texto[i]= letra2;
			}
			
			contenido = new String(texto);
			
			contenido = contenido.replaceAll("[\n\r]", "");
			//CON ".replaceAll(LO QUE QUEREMOS REMPLAZAR, REMPLAZO );" QUITAMOS LOS SALTOS DE LINEA, PARA QUE
			//NO SE ALMACENEN EN EL STRING QUE QUERRAMOS
			
			entrada.close();
			
			
		} catch (IOException e) {
			
			JOptionPane.showMessageDialog(rootPane, "No existe el archivo!!!!");
		}
		
	}
	
	public void contraseñaRandom() {
	
		do{
		
			valorAuto = (int)(Math.random()*150);
		
		}while(valorAuto<50); 
	
		ultimos = Integer.toString(valorAuto);
		
		contraRandom.setText(txtcarnet.getText() + ultimos);
	}
	
	
}

//VISUALIZAR USUARIO
//-------------------------------------------------------------------------------------------------------------------------
class visualizarUsuario extends JFrame {
	
	JButton visualUsu, visualCarga;
	JTable tablaUsu, tablaCarga;
	
	String [] cabecera = {"Carnet","DPI/CUI", "Nombre", "Correo","Direccion", "Creditos", "Contraseña"};
	
	DefaultTableModel tabla1 = new DefaultTableModel(null, cabecera);
	DefaultTableModel tabla2 = new DefaultTableModel(null, cabecera);
	
	registroAlumno alumno = new registroAlumno();
	
	cargaMasiva carga = new cargaMasiva();

	nodoUsuario temporal;
	
	
	public visualizarUsuario() {
		// TODO Auto-generated constructor stub
	
		setTitle("Visualzar Alumno");
		setSize(800, 350);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		laminaVisualizar lamina1 = new laminaVisualizar();
		add(lamina1);
		add(new JScrollPane(tablaUsu));
		
		laminaBotones lamina2 = new laminaBotones();
		add(lamina2, BorderLayout.SOUTH);
		
		
	}
	
	 class laminaVisualizar extends JPanel{
		
		public laminaVisualizar() {
			// TODO Auto-generated constructor stub
		
			
			tablaUsu = new JTable();
			
			tablaUsu.setModel(tabla1);
			
			add(tablaUsu);
			
		}
	}
	
	class laminaBotones extends JPanel{
		
		public laminaBotones() {

			visualCarga = new JButton("Ver Tabla");
			
			
			visualCarga.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					tablaMasiva();
				}
			});
		
			add(visualCarga);
		}
	}
	
	
	public void tablaMasiva() {
		
		
		
		temporal = carga.lista.inicio;
		
		
		for(int i =0; i < carga.lista.getTamaño(); i++) {
			
			String [] filas = {temporal.getCarnet(),temporal.getID(), temporal.getNombre(),temporal.getCorreo()
					, temporal.getDireccion(), temporal.getCreditos(), temporal.getContraseña()};
			
			tabla2.addRow(filas);
			
			temporal = temporal.getSiguiente();
		}
	
		tablaUsu.setModel(tabla2);

		visualCarga.setEnabled(false);
	}
}

class modificarAlumno extends JFrame{
	
	registroAlumno regis = new registroAlumno();
	cargaMasiva carga = new cargaMasiva();
	
	nodoUsuario temporal, temporal2;
	
	JLabel carnet, dpi, nombre, direccion, creditos, contraseña, correo, rotulo, separacion;
	
	JTextField carnet2, dpi2, nombre2, direccion2, creditos2, contraseña2, correo2;
	
	JButton mostrar, modificar, cancelar;
	
	public modificarAlumno() {
		
		setTitle("Modificar Usuario");
		setSize(350, 450);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		laminaModifocar lamina = new laminaModifocar();
		botonesModificar boton = new botonesModificar();
		
		add(lamina);
		add(boton, BorderLayout.SOUTH);
	}
	
	private class laminaModifocar extends JPanel{
		
		public laminaModifocar() {
			
			setLayout(null);
			
			carnet = new JLabel("Carné:");
			dpi = new JLabel("DPI/CUI:");
			nombre = new JLabel("Nombre:");
			direccion = new JLabel("Direccion:");
			correo = new JLabel("Correo:");
			creditos = new JLabel("Creditos:");
			contraseña = new JLabel("Contraseña:");
			rotulo = new JLabel("Ingresa el numero de Carné y presiona Mostrar");
			separacion = new JLabel("------------------------------------------------------------");
			
			carnet2 = new JTextField();
			dpi2 = new JTextField();
			nombre2 = new JTextField();
			direccion2 = new JTextField();
			correo2 = new JTextField();
			creditos2 = new JTextField();
			contraseña2 = new JTextField();
			
			rotulo.setBounds(40, 20, 300, 20);
			carnet.setBounds(40, 60, 100, 20);
			separacion.setBounds(60, 90, 400, 20);
			dpi.setBounds(40, 120, 100, 20);
			nombre.setBounds(40, 160, 100, 20);
			direccion.setBounds(40, 200, 100, 20);
			correo.setBounds(40, 240, 100, 20);
			creditos.setBounds(40, 280, 100, 20);
			contraseña.setBounds(40, 320, 100, 20);
			
			carnet2.setBounds(180, 60, 150, 20);
			dpi2.setBounds(180, 120, 150, 20);
			nombre2.setBounds(180, 160, 150, 20);
			direccion2.setBounds(180, 200, 150, 20);
			correo2.setBounds(180, 240, 150, 20);
			creditos2.setBounds(180, 280, 150, 20);
			contraseña2.setBounds(180, 320, 150, 20);
			
			add(rotulo);
			add(carnet);
			add(separacion);
			add(dpi);
			add(nombre);
			add(direccion);
			add(correo);
			add(creditos);
			add(contraseña);
			
			add(carnet2);
			add(dpi2);
			add(nombre2);
			add(direccion2);
			add(correo2);
			add(creditos2);
			add(contraseña2);
			
		}
		
	}
	
	private class botonesModificar extends JPanel{
		
		public botonesModificar() {
		
			setBackground(Color.BLUE);
			
			mostrar = new JButton("Mostrar");
			modificar = new JButton("Modificar");
			cancelar = new JButton("Salir");
			
			mostrar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					mostrarDatos();
				}
			});
			
			modificar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					modificar();
					JOptionPane.showMessageDialog(rootPane, "Alumno modificado de forma exitosa:", "Registro Existoso", 2);
				}
			});
			
			cancelar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					modificarAlumno.this.setVisible(false);
				}
			});
			
			add(mostrar);
			add(modificar);
			add(cancelar);
		}
		
	}
	
	public void mostrarDatos() {
		
	
		if(!carnet2.getText().equals("")) {
			
			temporal2 = carga.lista.inicio;
			
			
			for(int i =0; i<carga.lista.getTamaño(); i++) {
				
				if(temporal2.getCarnet().equals(carnet2.getText())) {
					
					dpi2 .setText(temporal2.getID());
					nombre2.setText(temporal2.getNombre());
					direccion2.setText(temporal2.getDireccion());
					correo2.setText(temporal2.getCorreo());
					creditos2.setText(temporal2.getCreditos());
					contraseña2.setText(temporal2.getContraseña());
					
					break;
				}else {
					
					temporal2 = temporal2.getSiguiente();
				}
				
			}
			
		}else {
			
			JOptionPane.showMessageDialog(rootPane, "Agrege un numero de carné!!!");
		}
		
	}
	
	public void modificar() {
		
		if(!carnet2.getText().equals("")) {
			
			temporal2 = carga.lista.inicio;
			
			
			for(int i =0; i<carga.lista.getTamaño()-1; i++) {
				
				if(temporal2.getCarnet().equals(carnet2.getText())) {
					
					temporal2.setDPI(dpi2.getText());
					temporal2.setNombre(nombre2.getText()); 
					temporal2.setDireccion(direccion2.getText());
					temporal2.setCorreo(correo2.getText());
					temporal2.setCreditos(creditos2.getText());
					temporal2.setContraseña(contraseña2.getText());
					
					break;
				}else {
					
					temporal2 = temporal2.getSiguiente();
				}
				
			}
		}
	}
}
//ELIMINAR ALUMNO
//-----------------------------------------------------------------------------------------------------------------
class eliminarAlumno extends JFrame{
	
	JLabel eliminar;
	JButton btnEliminar;
	JTextField tEliminar;
	
	registroAlumno regis;
	cargaMasiva carga;
	
	nodoUsuario temporal, temporal2, temporal3;
	
	//SE CREARAN BOTONES PARA EL JOPTIOPANE POR MEDIO DE UN STRING[]
	String botones[] = {"Eliminar", "Cancelar"};
	
	public eliminarAlumno() {
	
		setTitle("Eliminar Alumno");
		setSize(400, 225);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		laminaEliminar eli2 = new laminaEliminar();
		add(eli2);
		
	}
	
	private class laminaEliminar extends JPanel{
		
		public laminaEliminar() {
			
			setLayout(null);
		
			eliminar = new JLabel("Eliminar Alumno:");
			btnEliminar = new JButton("Eliminar");
			tEliminar = new JTextField();
			
			eliminar.setBounds(40,40,150,20);
			tEliminar.setBounds(200, 40, 150, 20);
			btnEliminar.setBounds(150, 100, 100, 30);
			
			btnEliminar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
	int seguro = JOptionPane.showOptionDialog(rootPane, "¿Estas seguro de eliminar el Alumno? "+tEliminar.getText()
					, "Eliminacion", 0, 0, null, botones, null );

		// YES_OPTION ES EL PRIMER VALOR  DEL STRING[]	
		if(seguro==JOptionPane.YES_OPTION) {
		
			eliminar();
			
			JOptionPane.showMessageDialog(rootPane, "Usuario Eliminado");
			
			eliminarAlumno.this.setVisible(false);
		}
		
		// NO_OPTION ES EL SEGUNDO VALOR DEL STRING[]
		else if(seguro==JOptionPane.NO_OPTION) {
		
		
		
		}
				}
			});
			
			add(eliminar);
			add(btnEliminar);
			add(tEliminar);
		}
	}
	
	public void eliminar() {
		
		temporal2 = carga.lista.inicio;
		
		for(int i = 0; i<carga.lista.getTamaño(); i++) {
			
			if(temporal2.getCarnet().equals(tEliminar.getText())) {
				
				if(i==0) {
					
					carga.lista.inicio = carga.lista.inicio.getSiguiente();
					
				}else {
				
				temporal2 = temporal2.getAnterior();
				temporal3 = temporal2.getSiguiente().getSiguiente();
					
				temporal2.enlazarSiguiente(temporal3);
				temporal3.enlazarAnterior(temporal2);
				
				carga.lista.size--;
				
				}
			}else {
				
				temporal2 = temporal2.getSiguiente();
			}
		}
	}
}

//VENTANA CURSO
//------------------------------------------------------------------------------------------------------------------
class ventanaCurso extends JFrame{
	
	JButton agregar, mostrar, modificar, eliminar;
	
	public ventanaCurso() {
	
		setTitle("Ventana de Curso");
		setSize(300,270);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		laminaventana2 lam = new laminaventana2();
		add(lam);
	}
	
		private class laminaventana2 extends JPanel{
			
			
			public laminaventana2() {
				// TODO Auto-generated constructor stub
			
				setLayout(null);
				
				agregar = new JButton("Agregar");
				mostrar = new JButton("Visualizar");
				modificar = new JButton("Modificar");
				eliminar = new JButton("Eliminar");
				
				agregar.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						
						cursoIndividual cur = new cursoIndividual();
						
						cur.setVisible(true);
						
						ventanaCurso.this.setVisible(false);
					}
				});
				
				
				mostrar.addActionListener( new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						
						agregarCursos agrega = new agregarCursos();
						
						agrega.setVisible(true);
						
						ventanaCurso.this.setVisible(false);
					}
				});
				
				modificar.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						
						
						ventanaCurso.this.setVisible(false);
					}
				});
				
				agregar.setBounds(70, 30, 150, 30);
				mostrar.setBounds(70, 70, 150, 30);
				modificar.setBounds(70, 110, 150, 30);
				eliminar.setBounds(70, 150, 150, 30);
				
				add(agregar);
				add(mostrar);
				add(modificar);
				add(eliminar);
			
		}
	}
}


class cursoIndividual extends JFrame{
	

	private JTextField tcodigo, tcurso, tcatedratico, tcreditos, tseccion, tlaboratorio, tpre, tpost;
	private JLabel  lcodigo, lcurso, lcatedratico, lcreditos, lseccion, llaboratorio, lpre, lpost, contraRandom, lcontra;
	
	static String contenido;
	
	cargaCurso curso;

	public cursoIndividual() {
		
		setTitle("Agregar Curso");
		setSize(400, 400);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		laminaCurso lam = new laminaCurso();
		add(lam);
		
		botonCurso btn = new botonCurso();
		add(btn, BorderLayout.SOUTH);
			
	}
	
	private class laminaCurso extends JPanel{
		
		public laminaCurso() {
			
			setLayout(null);
			
			tcodigo = new JTextField();
			tcurso = new JTextField();
			tcatedratico = new JTextField();
			tcreditos = new JTextField();
			tseccion = new JTextField();
			tlaboratorio = new JTextField();
			tpre = new JTextField();
			tpost = new JTextField();
			
			lcodigo = new JLabel("Codigo:");
			lcurso = new JLabel("Curso:");
			lcatedratico = new JLabel("Catedratico:");
			lcreditos = new JLabel("Creditos:");
			lseccion = new JLabel("Seccion:");
			llaboratorio = new JLabel("Laboratorio:");
			lpre = new JLabel("Pre-Requisito:");
			lpost = new JLabel("Post-Requisito:");
			lcontra = new JLabel("Contraseña:");
			contraRandom = new JLabel();
			
			lcodigo.setBounds(30,30,100,20);
			tcodigo.setBounds(180,30,150,20);
			lcurso.setBounds(30,60,100,20);
			tcurso.setBounds(180,60,150,20);
			lcatedratico.setBounds(30,90,100,20);
			tcatedratico.setBounds(180,90,150,20);
			lcreditos.setBounds(30,120,100,20);
			tcreditos.setBounds(180,120,150,20);
			lseccion.setBounds(30,150,100,20);
			tseccion.setBounds(180,150,150,20);
			llaboratorio.setBounds(30,180,100,20);
			tlaboratorio.setBounds(180,180,150,20);
			lpre.setBounds(30, 210, 100, 20);
			tpre.setBounds(180, 210, 150, 20);
			lpost.setBounds(30,240,100,20);
			tpost.setBounds(180,240,150,20);
		
			add(lcodigo);
			add(tcodigo);
			add(lcurso);
			add(tcurso);
			add(lcatedratico);
			add(tcatedratico);
			add(lcreditos);
			add(tcreditos);
			add(lseccion);
			add(tseccion);
			add(llaboratorio);
			add(tlaboratorio);
			add(lpre);
			add(tpre);
			add(lpost);
			add(tpost);
			
		}
	}
	
	private class botonCurso extends JPanel{
		
		public botonCurso() {
		
			JButton agregar = new JButton("Agregar");
			JButton Carga = new JButton("Carga Masiva");
			JButton limpiar = new JButton("Limpiar");
			JButton salir = new JButton("Salir");
			
			agregar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					agregar();
					JOptionPane.showMessageDialog(rootPane, "Registro exitoso.", "Registro", 1);
				}
			});
			
			Carga.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					agregarCarga();
					
					cargaCurso agregar = new cargaCurso();
					
					agregar.cargaCadena(contenido);
				}
			});
			
			limpiar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
				}
			});
			
			salir.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
				
					cursoIndividual.this.setVisible(false);
				}
			});
			
			add(agregar);
			add(Carga);
			add(limpiar);
			add(salir);
		}
	}
	
	public void agregar() {
		
		String tcodigo2, tcurso2, tcatedratico2, tcreditos2, tseccion2, tlaboratorio2, tpre2, tpost2,esta2;
		
		tcodigo2 = tcodigo.getText();
		tcatedratico2 = tcatedratico.getText();
		tcurso2= tcurso.getText();
		tcreditos2 = tcreditos.getText();
		tseccion2 = tseccion.getText();
		tlaboratorio2 = tlaboratorio.getText();
		tpre2 = tpre.getText();
		tpost2 = tpost.getText();
		esta2 ="Reprobado";
		
		curso.lista.agregarFinal(tcodigo2, tcurso2, tcatedratico2, tcreditos2, tlaboratorio2, tseccion2, tpre2, tpost2, esta2);
	}
	
	public void agregarCarga() {
		
		String separador = File.separator;
		String url = "src"+separador+"cursos.ipc1_e";
		
		int c = 0;
		int d =0;
		int contador =0;
		char letra2;
		
		try {
			FileReader entrada = new FileReader(url);
			FileReader entrada2 = new FileReader(url);
			
			while(c!=-1) {
				
				c = entrada.read();
				
				if(c ==-1) {
				
					break;
				}	
					
				contador++;
			}
			
			char [] texto = new char[contador];
			
			for(int i =0; i< contador;i++ ) {
				
				d = entrada2.read();
				
				letra2 = (char)d;
				
				texto[i]= letra2;
			}
			
			contenido = new String(texto);
			
			contenido = contenido.replaceAll("[\n\r]", "");
			//CON ".replaceAll(LO QUE QUEREMOS REMPLAZAR, REMPLAZO );" QUITAMOS LOS SALTOS DE LINEA, PARA QUE
			//NO SE ALMACENEN EN EL STRING QUE QUERRAMOS
			
			entrada.close();
			
			
			JOptionPane.showMessageDialog(rootPane, "Cursos agregados de forma exitosa.", "Registro Exitoso", 1);
			
		} catch (IOException e) {
			
			JOptionPane.showMessageDialog(rootPane, "No existe el archivo!!!!");
		}
	}
	
}

//AGREGAR Y VER CURSOS
//--------------------------------------------------------------------------------------------------------------
class agregarCursos extends JFrame{
	
	JButton  verCurso, salir;
	JTable tabla;
	String [] cabecera = {"codigo", "curso", "catedratico",  "creditos", "laboratorio", "seccion",
			"preRequisito", "postRequisito", "estado"};
	
	DefaultTableModel modeloTabla = new DefaultTableModel(null, cabecera);
	
	nodoCurso1 temporal;
	cargaCurso carga;
	
	static String contenido;
	
	public agregarCursos() {
		
		setTitle("Administrador de Cursos");
		setSize(800, 350);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		tablaCurso tbl = new tablaCurso();
		add(tbl);
		add(new JScrollPane(tabla));
		
		botonCurso btn = new botonCurso();
		add(btn, BorderLayout.SOUTH);
	}
	
	private class tablaCurso extends JPanel{
		
		public tablaCurso() {
		
			tabla = new JTable();
			tabla.setModel(modeloTabla);
			
			add(tabla);
			
		}
	}
	
	private class botonCurso extends JPanel{
		
		public botonCurso() {
		
			verCurso = new JButton("Ver");
			salir = new JButton("Salir");
			
			verCurso.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					verTabla();
				}
			});
			
			salir.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					agregarCursos.this.setVisible(false);
				}
			});
		
			add(verCurso);
			add(salir);
		}
	}
	
	public void verTabla() {
		
		temporal = carga.lista.inicio;
		
		for(int i =0; i < carga.lista.getTamaño(); i++) {
			
				String [] filas = {temporal.getCodigo(), temporal.getCurso(), temporal.getCatedratico(), temporal.getCreditos(),
						temporal.getLaboratorio(), temporal.getSeccion(), temporal.getPreRequisitos(), temporal.getPostRequisitos()
						, temporal.getEstado()};
				
				modeloTabla.addRow(filas);
				
				temporal = temporal.getSiguiente();
		}
		
		tabla.setModel(modeloTabla);
		
		verCurso.setEnabled(false);
	}
}
//VENTANA CATEDRATICO
//--------------------------------------------------------------------------------------------------------------
class ventanaCatedra extends JFrame{
	
	JTable tabla;
	String [] cabecera = {"Numero", "Catedratico", "contraseña"};
	DefaultTableModel modelo = new DefaultTableModel(null, cabecera);
	
	nodoCatedra temp;
	static listaCatedra listaCat = new listaCatedra();
	
	cargaCurso curso;
	nodoCurso1 temporal;
	
	public ventanaCatedra() {
	
		setTitle("Ventana Catedratico");
		setSize(800, 300);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		laminaVentana ven = new laminaVentana();
		add(ven);
		add(new JScrollPane(tabla));
		
		btnVentana btn = new btnVentana();
		add(btn, BorderLayout.SOUTH);
	}
	
	private class laminaVentana extends JPanel{
		
		public laminaVentana() {
		
			tabla = new JTable();
			tabla.setModel(modelo);
			
			add(tabla);
			
		}
	}
	
	private class btnVentana extends JPanel{
		
		public btnVentana() {
			
		JButton agregar = new JButton("Agregar");
		JButton verLista = new JButton("Mostrar");
		JButton salir = new JButton("Salir");
		
		agregar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				agregarCatedra();
				JOptionPane.showMessageDialog(rootPane, "Registro de Catedraticos exitoso.", "Registro Exitoso.", 1);

			}
		});
		
		verLista.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				mostrarTabla();
				setEnabled(false);
			}
		});
		
		salir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				ventanaCatedra.this.setVisible(false);
			}
		});
		
		add(agregar);
		add(verLista);
		add(salir);
		}
	}
	
	public void agregarCatedra() {
		
		String  nombre = "";
		int pass =0;
		String contraseña ="";
				
		temporal = curso.lista.inicio ;
		
		for(int i=0; i<curso.lista.getTamaño(); i++ ) {
			
			nombre = temporal.getCatedratico();
			
			
			do {
				
				pass = (int)(Math.random()*150);
				
			}while(pass<=49);
				
			contraseña = nombre +Integer.toString(pass);
		
			
			listaCat.agregarCatedra(nombre, contraseña);
			
			temporal = temporal.getSiguiente();
		}
	}
	
	public void mostrarTabla() {
		
		//temp = listaCat.inicio;
		
		int contador =1;
		
		for(int i =0; i < listaCat.getTamaño(); i++) {
			
				String [] filas = {Integer.toString(contador), temp.getNombre(), temp.getContraseña()};
				
				modelo.addRow(filas);
				
				temp = temp.getSiguiente();
				
				contador++;
		}
		
		tabla.setModel(modelo);
	}
}


//CREAMOS UNA CLASE PARA QUE ALMACENE EL VALOR QUE DESEAMOS QUE SE USE EN VARIAS CLASES
class loginDato {
	
	String dato;
	
	public loginDato(String dato) {//RECIBE UN DATO CON EL CONSTRUCTOR
		
		this.dato = dato;//LA VARIABLE DE CLASE CAMBIA CON EL VALOR QUE RECIBE EL CONSTRUCTOR
	}
	
	public String getDato() {
		
		return dato;//DEVUELVE EL VALOR QUE ESTA ALMACENADA EN LA CLASE
	}
}

class loginCatedra {
	
	String dato;
	
	public loginCatedra(String dato) {
		
		this.dato = dato;
	}
	
	public String getDato() {
		
		return dato;
	}
}


//USUARIO
//--------------------------------------------------------------------------------------------------------------
class Usuario extends JFrame{
	
	String columna [] = {"Numero","Codigo", "Curso", "Catedratico", "Creditos", "Laboratorio", 
			"Pre-requisito","Post-requisito", "Eliminar"};
	DefaultTableModel tablamodel= new DefaultTableModel(null, columna)
	{
		
		public boolean isCellEditable(int column, int row) {//LE INDICAMOS AL MODELO QUE NO SEA EDITABLE
			
			return false;
		}
	};
	
	private Image javaU, usuImagen;
	JTable tablaAlumno;
	JComboBox comboSemestre, comboCurso;
	
	cargaCurso carga1 = new cargaCurso();
	
	nodoCurso1 temporal;
	
	int contador=1;
	
	String [] matriz = new String[carga1.lista.getTamaño()]; 
	
	marcologin marco;
	
	static listaFinal listaNotas = new listaFinal();

	public Usuario() {
		
		setLayout(new GridLayout(3,1));
		setTitle("usuario");
		setSize(1100,600);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		laminausuario lamina = new laminausuario();
		add(lamina, BorderLayout.NORTH);
		
		laminaCentro lam = new laminaCentro();
		add(lam, BorderLayout.CENTER);
		
		tablaLamina lamina1 = new tablaLamina();
		add(lamina1, BorderLayout.SOUTH);	
	}
	
	private class laminausuario extends JPanel{
		
	
		public void paintComponent(Graphics g){
			
			super.paintComponent(g);
			
			Graphics2D d = (Graphics2D)g;
			
			try {
				
				usuImagen = ImageIO.read(new File("src/imag/usuicon.jpg"));
				}
			catch(IOException e){
				
				JOptionPane.showMessageDialog(Usuario.this, "La imagen no se encuentra");
				}
			
			try {
				
				javaU= ImageIO.read(new File("src/imag/javausu.png"));
				
			}catch(IOException e) {
				
				JOptionPane.showMessageDialog(Usuario.this, "La imagen no se encuentra");
			}
			
			d.drawImage(usuImagen, 485, 15, null);
			
			d.drawImage(javaU,35,60,null);
			
		}
		
		public laminausuario(){
			
			setLayout(null);
			
			JLabel logo = new JLabel("bienvenido");
			JButton logout = new JButton("Logout");

			logo.setBounds(80,10,200,30);
			logout.setBounds(900, 55, 95, 30);
			

			logout.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					
				Usuario.this.setVisible(false);
					
			}

			});

			
			add(logout);
			add(logo);
		}
	}	
	
		private class laminaCentro extends JPanel{
			
			public laminaCentro() {
				
			setLayout(null);
			
			
			JButton asignar = new JButton("Asignar");
			JButton limpiar = new JButton("Limpiar Lista");
			JButton aprobados = new JButton("Cursos Aprobados");
			JLabel eti = new JLabel("Cursos Asignados:");
			JLabel semestre = new JLabel("Semestre:");
			JLabel curso = new JLabel("Curso:");
			
			comboSemestre = new JComboBox();
			comboCurso = new JComboBox();
			
			comboSemestre.setEditable(false);
			
			comboSemestre.addItem("Segundo Semestre-2018");
			comboSemestre.addItem("Primer Semestre-2018");
			comboSemestre.addItem("Segundo Semestre-2017");
			comboSemestre.addItem("Primer Semestre-2017");
			
			comboCurso.setEditable(false);
			
			temporal = carga1.lista.inicio;
			
			for(int i =0; i< carga1.lista.getTamaño() ;i++) {
				
				comboCurso.addItem(temporal.getCurso());
				
				temporal = temporal.getSiguiente();
			}
			
			comboSemestre.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					
					limpiarTabla(tablaAlumno);
					contador=0;
				}
			});
			
			comboCurso.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					if(contador<4) {

					tablaAlumno.setDefaultRenderer(Object.class, new btnAlumnotabla());//AGREGAMOS BOTON A LA TABLA
												 //(LA CLASE OBJETO, LA CLASE DONDE SE CREO EL RENDERIZADO)
					
					JButton boton1 = new JButton("Eliminar");
					
					String curso = comboCurso.getSelectedItem().toString();
					int contar = 0;
					
					temporal = carga1.lista.inicio;
					
					while(!curso.equals(temporal.getCurso()) && contar< carga1.lista.getTamaño()-1) {
						
						temporal = temporal.getSiguiente();
						
						contar++;
					}
					
					String cuenta = Integer.toString(contador);
					
					Object [] filas = {cuenta, temporal.getCodigo(), temporal.getCurso(),temporal.getCatedratico(),temporal.getLaboratorio()
							,temporal.getSeccion(),temporal.getPreRequisitos(),temporal.getPostRequisitos(), boton1};
					
					
					tablamodel.addRow(filas);
					
					contador++;
					}
				}
			});
			
			asignar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
//					String dato = marco.log.getDato();
//					System.out.println("El valor es: "+dato);
					
					guardarCursos();
					JOptionPane.showMessageDialog(rootPane, "Cursos Asignados correctamente", "Asignacion", 3);
					
				}
			});
			
			limpiar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					limpiarTabla(tablaAlumno);
					contador = 0;
				}
			});
			
			semestre.setBounds(60, 40, 100, 30);
			comboSemestre.setBounds(150, 40, 200, 30);
			curso.setBounds(440,40,70,30);
			comboCurso.setBounds(540,40,200,30);
			asignar.setBounds(360,100,150,40);
			limpiar.setBounds(520,100,150,40);
			aprobados.setBounds(790,100,150,40);
			eti.setBounds(100,160, 140, 30);
			
			
			add(semestre);
			add(comboSemestre);
			add(curso);
			add(comboCurso);
			add(asignar);
			add(limpiar);
			add(aprobados);
			add(eti);
			
			
		}
	}		
		
		private class tablaLamina extends JPanel {
			
			public tablaLamina() {
				// TODO Auto-generated constructor stub
				
				setLayout(new GridLayout());
				
				
				tablaAlumno = new JTable();
				
				tablaAlumno.setModel(tablamodel);
				tablaAlumno.setRowHeight(30);
				
				
				add(tablaAlumno);
				add(new JScrollPane(tablaAlumno));
			}
		}
		
		public void limpiarTabla(JTable tabla) {
			
			try {
				
				if(tabla.getRowCount()!=0) {
					
	            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
	            int filas=tabla.getRowCount();
	            for (int i = 0;filas>i; i++) {
	                modelo.removeRow(0);
	            	}
				}
	        } catch (Exception e) {
	        	
	            JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
	        }
		}
		
		public void guardarCursos() {
			
			for(int i = 0; i<tablaAlumno.getRowCount(); i++) {
			
			String alumno = marco.log.getDato();
			String semestre = comboSemestre.getSelectedItem().toString();
			String catedra = tablaAlumno.getValueAt(i, 3).toString();
			String curso = tablaAlumno.getValueAt(i, 2).toString();
			String estado = "Reprobado";
			String nota = "0";
			
			System.out.println(alumno+" " +semestre+" "+ catedra+" "+ curso+" "+estado+" "+ nota);
			
			//listaNotas.agregarFinal(alumno, semestre, catedra, curso, estado, nota);
			}
		}
}
	

class catedratico extends JFrame{
	
	JButton mostrar, logout, regresar, guardar;
	JLabel etiqueta;
	JTable tabla;
	JComboBox comboSemestre, comboCurso;
	JLabel curso, semestre;
	
	String [] cabecera = {"Carné", "Nombre","Curso", "Nota"}; 
	DefaultTableModel modelo = new DefaultTableModel(null, cabecera);
	
	cargaCurso ccurso;
	nodoCurso1 temporal;
	
	Usuario alumnos;
	nodoFinal temporal3;
	
	cargaMasiva carga;
	nodoUsuario temporal2;
	
	marcologin marco;
	
	public catedratico() {
	
		setLayout(new GridLayout(2,1));
		
		setTitle("Ingreso de Notas");
		setSize(1000,500);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		laminaCat1 cat1 = new laminaCat1();
		add(cat1);
		
		laminaCat2 cat2 = new laminaCat2();
		add(cat2, BorderLayout.SOUTH);
		
	}
	
	private class laminaCat1 extends JPanel{
		
		public laminaCat1() {
			
			setLayout(null);
			
			mostrar = new JButton("Mostrar Listado");
			logout = new JButton("Logout");
			regresar = new JButton("Regresar");
			guardar = new JButton("Guardar");
			
			comboCurso = new JComboBox();
			comboSemestre = new JComboBox();
			
			curso = new JLabel("Curso:");
			semestre = new JLabel("Semestre:");
			
			comboSemestre.addItem("Segundo Semestre-2018");
			comboSemestre.addItem("Primer Semestre-2018");
			comboSemestre.addItem("Segundo Semestre-2017");
			comboSemestre.addItem("Primer Semestre-2017");
			
			temporal = ccurso.lista.inicio;
			
			for(int i =0; i<ccurso.lista.getTamaño();i++) {
				
				comboCurso.addItem(temporal.getCurso());
				
				temporal = temporal.getSiguiente();
			}
			
			mostrar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					desplegarLista();
				}
			});
			
			guardar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					guardarNota();
				}
			});
			
			logout.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					catedratico.this.setVisible(false);
				}
			});
			
			mostrar.setBounds(40, 40, 200, 40);
			logout.setBounds(850, 40, 100, 30);
			regresar.setBounds(850, 80, 100, 30);
			guardar.setBounds(40, 200, 100, 30);
			curso.setBounds(320, 40, 70, 30);
			comboSemestre.setBounds(420, 40, 250, 30);
			semestre.setBounds(320, 90, 70, 30);
			comboCurso.setBounds(420, 90, 200, 30);
			
			add(guardar);
			add(mostrar);
			add(logout);
			add(regresar);
			add(comboSemestre);
			add(comboCurso);
			add(curso);
			add(semestre);
		}
	}
	
	private class laminaCat2 extends JPanel{
		
		public laminaCat2() {
			
			setLayout(new GridLayout());
			
			tabla = new JTable();
			tabla.setModel(modelo);
			
			add(tabla);
			add(new JScrollPane(tabla));
			
		}
		
	}
	
	public void desplegarLista() {
		
		temporal = ccurso.lista.inicio;
		temporal2 = carga.lista.inicio;
		
		int contador =0;
		int contador2 =0;
		int contador3 =0;
		String espacio = " ";
		
		
		
	}
	
	public void guardarNota() {}
	
	public int devolverNum(String palabra) {
		
		try {
			
			int num = Integer.parseInt(palabra);
			
			return num;
		}catch(NumberFormatException e) {
			
			return 0;
		}
	}
}
	
