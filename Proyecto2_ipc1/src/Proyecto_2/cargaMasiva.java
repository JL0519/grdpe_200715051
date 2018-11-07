package Proyecto_2;

public class cargaMasiva {
	
static listaUsu lista = new listaUsu();
	
	public void cargaCadena(String cadena) {
		
		String carnet = "";
		String dpi="";
		String nombre=""; 
		String correo="";
		String direccion="";
		String creditos="";
		String contraseña;
		
		int contador = 0;
		int cont1 = 0;	
		int contVueltas =0;
		int contCaracter =0;
		
		if(!cadena.equals(""))
			
		
		for(int b =0; b< cadena.length();b++) {
			
			if(cadena.charAt(b)==';') 
				contador++;
		}
		
	
		
	while(contVueltas < contador/6) {
		
			
		while(contCaracter < cadena.length() && cont1 < 6) {
			
			if(cadena.charAt(contCaracter)==';' && cont1 == 0) {//EJ: EL VALOR DE LA POSICION ES 4(5to. ELEMENTO)
				
				if(contCaracter>20) {
					
					int cont2 =0;
					
					for(int j =0; j<contCaracter; j++) {//EL VALOR DE i AL MOMENTO DE ENTRAR EN EL BUCLE
						
						if(cadena.charAt(j)==';') {
						
							cont2=j+1;
						}	 
					}
					
					char [] nom = new char [contCaracter-cont2];
					
					for(int k =0; k < contCaracter-cont2; k++) {
						
						nom[k] = cadena.charAt(k+cont2);
								 
					}
					
					carnet = new String(nom);
				}else {
			
				char [] nom = new char [contCaracter];//EJ: EL VALOR DEL TAMAÑO DEL ARRAY ES 4
				
				for(int j =0; j<contCaracter ; j++) {
					
					nom[j] = cadena.charAt(j);
						 
				}
				
				carnet = new String(nom);
				
				}
			}
			
			//ESTOS METODOS QUE SE ENCUENTRAN EN LOS ELSE-IF SE USARAN CUANDO NO SEA LA PRIMERA SEPARACION
			//(";" EN ESTE CASO) PARA PODER ALMACENAR LAS VARIABLES
			//----------------------------------------------------------------------------------------------
			else if(cadena.charAt(contCaracter)==';' && cont1 == 1) {
				
				
				int cont2 =0;
				
				for(int j =0; j<contCaracter; j++) {//EL VALOR DE i AL MOMENTO DE ENTRAR EN EL BUCLE
					
					if(cadena.charAt(j)==';') {
					
						cont2=j+1;
					}	 
				}
				
				char [] num = new char [contCaracter-cont2];
				
				for(int k =0; k < contCaracter-cont2; k++) {
					
					num[k] = cadena.charAt(k+cont2);
							 
				}
				
				dpi = new String(num);
				

//				cont1++;
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
				
				 nombre = new String(nom);
				
//				cont1++;
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
				
				correo = new String(mail);
				
				
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
				
				direccion = new String(dir);
				
				
//				cont1++;
				
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
				
				creditos = new String(credit);
				
			}
			
			if(cadena.charAt(contCaracter)==';')
				cont1++;
			
			contCaracter++;
		}
		
		//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		if(cont1>0 ) {
			
			int pass;
			
			do {
				
			pass = (int)(Math.random()*150);
			
			}while(pass<=49);
			
			contraseña = carnet +Integer.toString(pass);
			
			System.out.println(carnet+" + "+dpi+" + "+nombre+" + "+ direccion+" + "+correo+" + " +contraseña+" + "+creditos);
			
			
			lista.agregarFinal(carnet, dpi, nombre, correo, direccion, creditos, contraseña);
			
		}else {
			
			System.out.println("No hay ; en " + contador +" caracteres.");
			
		}
		
		contCaracter = contCaracter+1;
		
		cont1=0;
		
		contVueltas++;
	}
}
}




