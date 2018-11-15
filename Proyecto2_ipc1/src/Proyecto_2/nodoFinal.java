package Proyecto_2;

public class nodoFinal {


	String alumno, semestre, curso, estado, nota;
	nodoFinal siguiente,anterior;
	
	public nodoFinal(String alumno, String semestre, String catedra,String curso, String estado, String nota) {
	
		this.alumno = alumno;
		this.semestre = semestre;
		this.curso = curso;
		this.estado = estado;
		this.nota = nota;
		
		siguiente = null;
		anterior = null;
	}
	
	public String getAlumno() {
		
		return alumno;
	}
	
	public String getSemestre() {
		
		return semestre;
	}
	
	public String getCurso() {
		
		return curso;
	}
	
	public String getEstado() {
		
		return estado;
	}
	
	public String getNota() {
		
		return nota;
	}
	
	public void setNota(String nota) {
		
		this.nota = nota;
	}
	
	public void setEstado(String estado) {
		
		this.estado = estado;
	}
	
	public void enlazarSiguiente(nodoFinal siguiente) {
		
		this.siguiente = siguiente;
	}
	
	public nodoFinal getSiguiente() {
		
		return siguiente;
	}
	
	public void enlazarAnterior(nodoFinal anterior) {
		
		this.anterior = anterior;
	}
	
	public nodoFinal getAnterior() {
		
		return anterior;
	}

}