package Proyecto_2;



public class nodoCatedra {

String nombre, contrase�a;
	
	nodoCatedra siguiente,anterior;
	
	public nodoCatedra(String nombre, String contrase�a) {
		
		this.nombre = nombre;
		this.contrase�a = contrase�a;
		
		siguiente = null;
		anterior = null;
	}
	
	public String  getNombre() {
		
		return nombre;
	}
	
	public String getContrase�a() {
		
		return contrase�a;
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

