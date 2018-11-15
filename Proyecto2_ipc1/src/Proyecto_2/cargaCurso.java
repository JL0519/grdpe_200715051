package Proyecto_2;

public class cargaCurso {

static listaCurso lista = new listaCurso();
	
	public void cargaCadena(String cadena) {
		
		String codigo = "";
		String curso ="";
		String catedratico =""; 
		String creditos ="";
		String laboratorio="";
		String seccion ="";
		String preRequisito="";
		String postRequisito ="";
		String estado = "Reprobado";
		
		int contador = 0;
		int cont1 = 0;	
		int contVueltas =0;
		int contCaracter =0;
		
		if(!cadena.equals(""))
			
		
		for(int b =0; b< cadena.length();b++) {
			
			if(cadena.charAt(b)==';') 
				contador++;
		}
		
	
		
	while(contVueltas < contador/7) {
		
			
		while(contCaracter < cadena.length() && cont1 < 8) {//SE DEBE PONER cont1 < "NUMERO MENOR DE ";" DE CADA ELEMENTO"
			
			if(cadena.charAt(contCaracter)==';' && cont1 == 0) {//EJ: EL VALOR DE LA POSICION ES 4(5to. ELEMENTO)
				
				if(contCaracter>20) {
					
					int cont2 =0;
					
					for(int j =0; j<contCaracter; j++) {//EL VALOR DE i AL MOMENTO DE ENTRAR EN EL BUCLE
						
						if(cadena.charAt(j)==';') {
						
							cont2=j+1;
						}	 
					}
					
					char [] nom = new char [contCaracter-cont2];
					
					for(int k =0; k < contCaracter-cont2 && cadena.charAt(contCaracter)!='\n'; k++) {
						
						
						nom[k] = cadena.charAt(k+cont2);
								 
					}
					
					codigo = new String(nom);
					
				}else {
			
				char [] nom = new char [contCaracter];//EJ: EL VALOR DEL TAMAÑO DEL ARRAY ES 4
				
				for(int j =0; j<contCaracter ; j++) {
					
					nom[j] = cadena.charAt(j);

				}
				
				codigo = new String(nom);
				}
			}
			
			//----------------------------------------------------------------------------------------------
			else if(cadena.charAt(contCaracter)==';' && cont1 == 1 ) {
				
				
				int cont2 =0;
				
				for(int j =0; j<contCaracter; j++) {//EL VALOR DE i AL MOMENTO DE ENTRAR EN EL BUCLE
					
					if(cadena.charAt(j)==';') {
					
						cont2=j+1;
					}	 
				}
				
				char [] id = new char [contCaracter-cont2];
				
				for(int k =0; k < contCaracter-cont2 ; k++) {
					
					id[k] = cadena.charAt(k+cont2);
							 
				}
				
				curso = new String(id);
			}
			
			//------------------------------------------------------------------------------------------------
			else if(cadena.charAt(contCaracter)==';' && cont1 == 2) {
				
				
				int cont2 =0;
				
				for(int j =0; j<contCaracter; j++) {//EL VALOR DE i AL MOMENTO DE ENTRAR EN EL BUCLE
					
					if(cadena.charAt(j)==';') {
					
						cont2=j+1;
					}	 
				}
				
				char [] nom = new char [contCaracter-cont2];
				
				
				
				for(int l = 0; l< nom.length; l++) {
					
					nom[l] = cadena.charAt(l+cont2); 
				}
				
				 catedratico = new String(nom);

			}
			
			//-------------------------------------------------------------------------------------------------
			if(cadena.charAt(contCaracter)==';' && cont1 == 3) {
				
				int cont2 =0;
				
				for(int j =0; j<contCaracter; j++) {//EL VALOR DE i AL MOMENTO DE ENTRAR EN EL BUCLE
					
					if(cadena.charAt(j)==';') {
					
						cont2=j+1;
					}	 
				}
				
				char [] mail = new char [contCaracter-cont2];
				
				
				
				for(int l = 0; l< mail.length; l++) {
					
					mail[l] = cadena.charAt(l+cont2); 
				}
				
				creditos = new String(mail);
			}
			
			//----------------------------------------------------------------------------------------------
			if(cadena.charAt(contCaracter)==';' && cont1 == 4) {
				
				int cont2 =0;
				
				for(int j =0; j<contCaracter; j++) {//EL VALOR DE i AL MOMENTO DE ENTRAR EN EL BUCLE
					
					if(cadena.charAt(j)==';') {
					
						cont2=j+1;
					}	 
				}
				
				char [] dir = new char [contCaracter-cont2];
					
				for(int l = 0; l< dir.length; l++) {
					
					dir[l] = cadena.charAt(l+cont2); 
				}
				
				laboratorio = new String(dir);
			}
			
			//---------------------------------------------------------------------------------------------
			if(cadena.charAt(contCaracter)==';' && cont1 == 5) {				
				
				int cont2 =0;
				
				for(int j =0; j<contCaracter; j++) {//EL VALOR DE i AL MOMENTO DE ENTRAR EN EL BUCLE
					
					if(cadena.charAt(j)==';') {
					
						cont2=j+1;
					}	 
				}
				
				char [] credit = new char [contCaracter-cont2];
				
				
				
				for(int l = 0; l< credit.length; l++) {
					
					credit[l] = cadena.charAt(l+cont2); 
				}
				
				seccion = new String(credit);
				
			}
			
			if(cadena.charAt(contCaracter)==';' && cont1 == 6) {				
				
				int cont2 =0;
				
				for(int j =0; j<contCaracter; j++) {//EL VALOR DE i AL MOMENTO DE ENTRAR EN EL BUCLE
					
					if(cadena.charAt(j)==';') {
					
						cont2=j+1;
					}	 
				}
				
				char [] pre = new char [contCaracter-cont2];
				
				
				
				for(int l = 0; l< pre.length; l++) {
					
					pre[l] = cadena.charAt(l+cont2); 
				}
				
				preRequisito = new String(pre);
				
			}
			
			if(cadena.charAt(contCaracter)==';' && cont1 == 7) {				
				
				int cont2 =0;
				
				for(int j =0; j<contCaracter; j++) {//EL VALOR DE i AL MOMENTO DE ENTRAR EN EL BUCLE
					
					if(cadena.charAt(j)==';') {
					
						cont2=j+1;
					}	 
				}
				
				char [] post = new char [contCaracter-cont2];
				
				
				
				for(int l = 0; l< post.length; l++) {
					
					post[l] = cadena.charAt(l+cont2); 
				}
				
				postRequisito = new String(post);
			}
			
			if(cadena.charAt(contCaracter)==';')
				cont1++;
			
			contCaracter++;
		}
		
		
		lista.agregarFinal(codigo, curso, catedratico, creditos, laboratorio, seccion, preRequisito, postRequisito, estado);
		
		contCaracter = contCaracter+1;
		
		cont1=0;
		
		contVueltas++;
		}
	}
}


