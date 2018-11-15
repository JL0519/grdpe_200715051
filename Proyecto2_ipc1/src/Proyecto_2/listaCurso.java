package Proyecto_2;


public class listaCurso {
	
	nodoCurso1 inicio;
	int size;
	
	public listaCurso() {
		
		inicio = null;
		size=0;
	}
	
	public void agregarFinal(String codigo, String curso , String catedratico, String creditos, String laboratorio, 
			String seccion, String preRequisito, String postRequisito, String estado) {
		
		nodoCurso1 nuevo = new nodoCurso1(codigo, curso, catedratico,  creditos, laboratorio, seccion,
				preRequisito, postRequisito, estado);
		
		if(inicio == null) {
			
			inicio = nuevo;
			size++;
			
		}else {
			
			nodoCurso1 temporal = inicio;
			int contador =0;
			
			while(contador < size -1) {
				
				temporal = temporal.getSiguiente();
				contador++;
				
			}
			
			temporal.enlazarSiguiente(nuevo);
			nuevo.enlazarSiguiente(inicio);
			size++;
			
		}
	}
	
	public int getTamaño() {
		
		return size;
	}
	
	
}

