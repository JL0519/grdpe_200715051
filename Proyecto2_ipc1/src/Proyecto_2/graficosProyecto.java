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
	
	registroAlumno registro = new registroAlumno();
	cargaMasiva carga = new cargaMasiva();

	nodoUsuario temporal, temporal2;
	
	Usuario usu1 = new Usuario();
	
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
			
		if(texto1.getText().equals(admin) && password.equals(pass)) {
		
			MarcoAdmin base= new MarcoAdmin();
			
			base.setVisible(true);
			
			marcologin.this.setVisible(false);
			
		}else {
			
			if(!texto1.getText().equals(admin) && !texto1.getText().equals("")) {
				
				temporal = registro.lista.inicio;
				temporal2 = carga.lista.inicio;
				
				for(int i = 0; i< registro.lista.getTamaño(); i++){
					
					if(texto1.getText().equals(temporal.getCarnet())) {
						
						if(password.equals(temporal.getContraseña())) {
							
							usu1.setVisible(true);
							
							marcologin.this.setVisible(false);
							
							break;
							
						}else {
							
							JOptionPane.showMessageDialog(rootPane,"El usuario no existe. Por favor ponerse en contacto con "
									+"el administrador para solicitar un registro.","ERROR",0);
						}
						
						
					}
					
					temporal = temporal.getSiguiente();
				}
				
				for(int j =0; j < carga.lista.getTamaño(); j++) {
					
					if(texto1.getText().equals(temporal2.getCarnet())) {
						
						if(password.equals(temporal2.getContraseña())) {
							
							usu1.setVisible(true);
							
							marcologin.this.setVisible(false);
							
						}else {
											
							JOptionPane.showMessageDialog(rootPane,"El usuario no existe. Por favor ponerse en contacto con "
									+"el administrador para solicitar un registro.","ERROR",0);

						}
						
						break;
					}
					
					temporal2 = temporal2.getSiguiente();
				}
				
				
			}
			
			else if(texto1.getText().equals("")) {
				
				JOptionPane.showMessageDialog(rootPane, "Ingrese un usuario por favor.", "EROOR", 1);
			}
			
			else {
			
			JOptionPane.showMessageDialog(rootPane,"El usuario no existe. Por favor ponerse en contacto con "
									+"el administrador para solicitar un registro.","ERROR",0);
			}
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
			JLabel adminBiblio= new JLabel("Notas:");
			JLabel adminCatedratico = new JLabel("Catedratico:");
			
			JButton botonlog = new JButton("Logout");
			JButton botonAlumno = new JButton("Alumnos");
			JButton botonNota = new JButton("Notas");
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
			
			
			logo.setBounds(150, 100, 50, 20);
			botonlog.setBounds(830, 100, 95, 30);
			botonCatedra.setBounds(400, 350, 150, 30);
			botonNota.setBounds(700, 350, 150, 30);
			botonAlumno.setBounds(100, 350, 150, 30);
			adminUsu.setBounds(70, 300, 75, 25);
			adminBiblio.setBounds(690, 300, 75, 25);
			adminCatedratico.setBounds(360, 300, 80, 20);
			
			
			add(logo);
			add(botonlog);
			add(adminUsu);
			add(adminBiblio);
			add(botonCatedra);
			add(adminCatedratico);
			add(botonAlumno);
			add(botonNota);
			
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
				}
			});
			
			mostrar.addActionListener( new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					visualizarUsuario visual = new visualizarUsuario();
					
					visual.setVisible(true);
					
					System.out.println("El tamaño de la lista es: "+alumno1.lista.getTamaño());
				}
			});
			
			modificar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					modificarAlumno modi = new modificarAlumno();
					
					modi.setVisible(true);
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
	
	static listaUsu lista = new listaUsu();//SE INSTANCIA AFUERA PARA QUE NO INICIE DESDE CER0 LA LISTA(PARA QUE SE PUEDAN AGREGAR ELEMENTOS NUEVOS)
	static listaUsu listaMasiva = new listaUsu(); 
	
	public registroAlumno(){
		
		
		setTitle("Registro de Usuarios");
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
		JButton crearContra = new JButton("contraseña");
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
		
		lista.agregarFinal(carnet2, id2, nombre2, correo2, direccion2, creditos2, contraseña2);
		
		JOptionPane.showMessageDialog(rootPane, "Alumno registrado de manera exitosa!!!");
	}
	
	public void visualizar() {
		
		lista.mostrarListaUsu();
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
			
			System.out.println(contenido);
			
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

			visualUsu = new JButton("Individual");
			visualCarga = new JButton("Carga Masiva");
			
			visualUsu.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
				
					System.out.println(alumno.lista.getTamaño());
					
					temporal = alumno.lista.inicio;
							
					
					for(int i = 0 ; i< alumno.lista.getTamaño(); i++) {
						
						System.out.println(temporal.getNombre());
						
						temporal = temporal.getSiguiente();
						
					}
					
					TablaIndividual();
				}
			});
			
			visualCarga.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					tablaMasiva();
				}
			});
		
			add(visualUsu);
			add(visualCarga);
		}
	}
	
	public void TablaIndividual() {
		
		temporal = alumno.lista.inicio;
		
		for(int i =0; i < alumno.lista.getTamaño(); i++) {
			
				String [] filas = {temporal.getCarnet(),temporal.getID(), temporal.getNombre(),temporal.getCorreo()
						, temporal.getDireccion(), temporal.getCreditos(), temporal.getContraseña()};
				
				tabla1.addRow(filas);
				
				temporal = temporal.getSiguiente();
		}
		
		tablaUsu.setModel(tabla1);
		
		visualUsu.setEnabled(false);
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
			modificar = new JButton("modificar");
			cancelar = new JButton("Cancelar");
			
			mostrar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					mostrarDatos();
				}
			});
			
			add(mostrar);
			add(modificar);
			add(cancelar);
		}
		
	}
	
	public void mostrarDatos() {
		
	
		if(!carnet2.getText().equals("")) {
			
			temporal = regis.lista.inicio;
			temporal2 = carga.lista.inicio;
			
			
			for(int i =0; i<regis.lista.getTamaño(); i++) {
				
				if(carnet.getText().equals(temporal.getCarnet())) {
					
					dpi2 .setText(temporal.getID());
					nombre2.setText(temporal.getNombre());
					direccion2.setText(temporal.getDireccion());
					correo2.setText(temporal.getCorreo());
					creditos2.setText(temporal.getCreditos());
					contraseña2.setText(temporal.getContraseña());
					
					break;
				}else {
					
					temporal = temporal.getSiguiente();
				}
				
			}
			
			
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
}


//USUARIO
//--------------------------------------------------------------------------------------------------------------
class Usuario extends JFrame{
	
	String columna [] = {"Curso", "Catedratico", "Creditos", "Laboratorio", "Pre-requisito","Post-requisito"};
	
	String [][] fila = {};
	
	DefaultTableModel tablamodel= new DefaultTableModel(fila, columna);
	
	private Image javaU, usuImagen;
	
	JTable tabla;
	
	JScrollPane sc;
	
	
	
	public Usuario() {
		
		setLayout(new GridLayout(2,1));
		setTitle("usuario");
		setSize(1100,550);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		laminausuario lamina = new laminausuario();
		add(lamina);
		
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
			
			d.drawImage(usuImagen, 485, 25, null);
			
			d.drawImage(javaU,35,60,null);
			
		}
		
		public laminausuario(){
			
			setLayout(null);
			
			JLabel logo = new JLabel("Logo");
			
			JButton logout = new JButton("Logout");
			JButton buscar = new JButton("Buscar");
			JButton favorito = new JButton("Favoritos");
			
			JLabel eti = new JLabel("Titulo");
			
			JLabel text1 = new JLabel("Buscar Registros Disponibles");
			
			logout.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					
					
					Usuario.this.setVisible(false);
					
			}

			});
			
			buscar.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
				
				}
				
				
			});
			
			logout.setBounds(900, 55, 95, 30);
			logo.setBounds(80,10,65,30);
			buscar.setBounds(100, 205, 95, 30);
			favorito.setBounds(700,205,95,30);
			text1.setBounds(270,205,250,30);
			eti.setBounds(100, 180, 95, 30);
			
			add(logout);
			add(logo);
			add(buscar);
			add(text1);
			add(favorito);
			add(eti);
			
			
		}
	}	
		private class tablaLamina extends JPanel{
			
			public tablaLamina() {
				// TODO Auto-generated constructor stub
				
				setLayout(new GridLayout());
			
				tabla = new JTable(tablamodel);
				
				add(tabla);
				add(new JScrollPane(tabla));
			}
			
		}

	}
	
	


