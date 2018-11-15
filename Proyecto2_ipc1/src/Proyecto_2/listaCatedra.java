package Proyecto_2;


public class listaCatedra {

	listaCurso lista;
	nodoCurso1 temp;
	
	nodoCatedra inicio, ultimo;
	int size;
	
	public listaCatedra() {

		inicio = null; 
		ultimo = null;
		size = 0;
	}
	
	public void agregarCatedra(String nombre, String contraseña) {
		
		nodoCatedra nuevo = new nodoCatedra(nombre, contraseña);
		
		if(inicio == null) {
			
			inicio = nuevo;
			ultimo = nuevo;
			size++;
			
		}else {
			
			nodoCatedra temporal = inicio;
			int cont =0;
			
			while(cont < size-1) {//MENOS 1 PARA QUE SE SALTE EL PRIMERO Y NO PASE DESPUES DEL ULTIMO NODO
				
				temporal = temporal.getSiguiente();
				
				cont++;
								
			}
			
			temporal.enlazarSiguiente(nuevo);
			nuevo.enlazarAnterior(temporal);
			nuevo.enlazarSiguiente(inicio);
			inicio.enlazarAnterior(nuevo);
			size++;
		}
	}
	
	public int getTamaño() {
		
		return size;
	}

}


