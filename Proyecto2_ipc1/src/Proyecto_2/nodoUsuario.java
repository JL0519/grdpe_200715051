package Proyecto_2;


public class nodoUsuario {
	
	String id, carnet, nombre, direccion, creditos, correo, contrase�a;
	nodoUsuario siguiente, anterior;
	
	public nodoUsuario(String id, String carnet, String nombre, String direccion, String correo
			, String creditos ,String contrase�a) {
		
		this.id = id;
		this.carnet = carnet;
		this.nombre = nombre;
		this.direccion = direccion;
		this.correo = correo;
		this.creditos = creditos;
		this.contrase�a = contrase�a;
		
		siguiente = null;//APUNTADOR HACIA EL SIGUIENTE NODO
		anterior = null;//APUNTADOR HACIA EL NODO ANTERIOR
		
	}
	
	public String getID() {
		
		return id;
	}
	
	public String getCarnet() {
		
		return carnet;
	}
	
	public String getNombre() {
		
		return nombre;
	}
	
	public String getDireccion() {
			
			return direccion;
		}
	
	public String getCreditos() {
		
		return creditos;
	}
	
	public String getCorreo() {
		
		return correo;
	}
	
	public String getContrase�a() {
		
		return contrase�a;
	}
	
	public void setCarnet(String carnet) {
		
		this.carnet = carnet;
	}
		
	public void setDPI(String id) {
			
			this.id = id;
		}
	
	public void setNombre(String nombre) {
		
		this.nombre = nombre;
	}
	
	public void setDireccion(String direccion) {
		
		this.direccion = direccion;
	}
	
	public void setCreditos(String creditos) {
		
		this.creditos = creditos;
	}
	
	public void setCorreo(String correo) {
		
		this.correo = correo;
	}
	
	public void setContrase�a(String contrase�a) {
		
		this.contrase�a = contrase�a;
	}
	
	
	public void enlazarSiguiente(nodoUsuario siguiente) {
		
		this.siguiente = siguiente;
	}
	
	public void enlazarAnterior(nodoUsuario anterior) {
		
		this.anterior = anterior;
	}
	
	public nodoUsuario getSiguiente() {
		
		return siguiente;
	}
	
	public nodoUsuario getAnterior() {
		
		return anterior;
	}
}






