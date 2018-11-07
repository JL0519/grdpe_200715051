package Proyecto_2;

public class listaUsu {

	nodoUsuario inicio;
	nodoUsuario ultimo;
	int size;
	
	public listaUsu() {
		
		inicio = null;
		ultimo = null;
		size = 0;
	}
	
	public void agregarFinal(String carnet, String dpi, String nombre, String correo, String direccion, 
			String creditos, String contraseña ) {
		
		nodoUsuario nuevo = new  nodoUsuario(carnet, dpi, nombre, direccion, correo, creditos, contraseña);
		
		if(inicio == null) {//O SE PUEDE USAR "SIZE == 0"
			
			inicio = nuevo;
			ultimo = nuevo;
			size++;
			
//			System.out.println("agregado el primero!!!!!!!!!!!!!!!!");
//			System.out.println(size);
			
			System.out.println(inicio.getNombre());
		}else {
			
			nodoUsuario temporal = inicio;
			int cont =0;
			
			while(cont < size-1) {
				
				temporal = temporal.getSiguiente();
				
				cont++;
				
				
			}
			
			temporal.enlazarSiguiente(nuevo);
			nuevo.enlazarAnterior(temporal);
			nuevo.enlazarSiguiente(inicio);
			inicio.enlazarAnterior(nuevo);
			size++;
			

			System.out.println(size);
		}
	}
	
	public int getTamaño() {
		
		return size;
	}
	
	public void mostrarListaUsu() {
		
		nodoUsuario nodo = inicio;
		
		System.out.println("Inicia visualizacion!!!!");
		
		for(int i =0; i<size; i++) {
			
			System.out.println(nodo.getNombre() +" "+ nodo.getCarnet()+ " "+ nodo.getID()+ " "+ nodo.getContraseña());
			
			nodo = nodo.getSiguiente();
		}
		
		System.out.println("Termina visualizacion");
	}

}
