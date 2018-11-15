package Proyecto_2;

public class nodoCurso1 {
	
String codigo, catedratico,curso, creditos, laboratorio, seccion, preRequisito, postRequisito, estado;
	
	nodoCurso1 siguiente; 
	
	public nodoCurso1(String codigo, String curso, String catedratico, String creditos, String laboratorio,
			String seccion, String preRequisito,
					String postRequisito, String estado) {
		
		this.codigo = codigo;
		this.catedratico = catedratico;
		this.curso = curso;
		this.creditos = creditos;
		this.laboratorio = laboratorio;
		this.seccion = seccion;
		this.preRequisito = preRequisito;
		this.postRequisito = postRequisito;
		this.estado = estado;
		
		siguiente = null;
	}
	
	public String getCodigo() {
		
		return codigo;
	}
	
	public String getCurso() {
		
		return curso;
	}
	
	public String getCatedratico() {
		
		return catedratico;
	}
	
	public String getCreditos() {
		
		return creditos;
	}
	
	public String getLaboratorio() {
		
		return laboratorio;
	}
	
	public String getSeccion() {
		
		return seccion;
	}

	public String getPreRequisitos() {
			
			return preRequisito;
		}
	
	public String getPostRequisitos() {
		
		return postRequisito;
	}
	
	public String getEstado () {
		
		return estado;
	}
	
	public void setEstado(String estado) {
		
		this.estado = estado;
	}
	
	public void enlazarSiguiente(nodoCurso1 siguiente) {
		
		this.siguiente = siguiente;
	}
	
	public nodoCurso1 getSiguiente() {
		
		return siguiente;
	}
	
	
}
