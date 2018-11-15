package Proyecto_2;



public class nodoCatedra {

String nombre, contraseña;
	
	nodoCatedra siguiente,anterior;
	
	public nodoCatedra(String nombre, String contraseña) {
		
		this.nombre = nombre;
		this.contraseña = contraseña;
		
		siguiente = null;
		anterior = null;
	}
	
	public String  getNombre() {
		
		return nombre;
	}
	
	public String getContraseña() {
		
		return contraseña;
	}
	
	public void enlazarSiguiente(nodoCatedra siguiente) {
		
		this.siguiente = siguiente;
	}
	
	public void enlazarAnterior(nodoCatedra anterior) {
		
		this.anterior = anterior;
	}
	
	public nodoCatedra getSiguiente() {
		
		return siguiente;
	}
	
	public nodoCatedra getAnterior() {
		
		return anterior;
	}
}

