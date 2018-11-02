package Proyecto_2;

public class cargaMasiva {
	
	String cadena, carnet, dpi, nombre, correo, direccion, creditos;
	char caracter;
	
	public void cargaCadena(String cadena) {
		
		int contador = 0;
		int cont1 = 0;
		
		for(int i = 0; i< cadena.length();i++) {
			
			cadena.charAt(i);
			
			if(cadena.charAt(i)==';' && cont1 == 0) {//EJ: EL VALOR DE LA POSICION ES 4(5to. ELEMENTO)
			
				char [] nom = new char [i];//EJ: EL VALOR DEL TAMAÑO DEL ARRAY ES 4
				
				for(int j =0; j<i; j++) {
					
					nom[j] = cadena.charAt(j);
						 
				}
				
				carnet = new String(nom);
				
				System.out.println("El carnet es: " +carnet);
				
				cont1++;
			}
			
			//----------------------------------------------------------------------------------------------
			else if(cadena.charAt(i)==';' && cont1 == 1) {
				
				
				int cont2 =0;
				
				for(int j =0; j<i; j++) {//EL VALOR DE i AL MOMENTO DE ENTRAR EN EL BUCLE
					
					if(cadena.charAt(j)==';') {
					
						cont2=j+1;
					}	 
				}
				
				char [] num = new char [i-cont2];
				
				for(int k =0; k < i-cont2; k++) {
					
					num[k] = cadena.charAt(k+cont2);
							 
				}
				
				dpi = new String(num);
				

				cont1++;
			}
			
			//------------------------------------------------------------------------------------------------
			else if(cont1 == 2) {
				
				short contpuntocoma =0;
				short contpuntocoma2 =0;
				short contInicio =0;
				short contFinal =0;
				
				for(int j =0; j<cadena.length() && contpuntocoma<2 ; j++) {
					
					if(cadena.charAt(j)==';') {
					
						contpuntocoma++;
					}
					
					contInicio++;
				}
				
				
				for(int k =0; k<cadena.length() && contpuntocoma2<3 ; k++) {
					
					if(cadena.charAt(k)==';') {
					
						contpuntocoma2++;
						
					}
					
					contFinal++;
				}
					
				contFinal =(short)(contFinal-1);
				
				
				char [] nom = new char [ contFinal-contInicio];
				
				for(int l = 0; l< nom.length; l++) {
					
					nom[l] = cadena.charAt(l+contInicio); 
				}
				
				String nombre = new String(nom);
				
				System.out.println("El nombre es: "+nombre );
				
				cont1++;
			}
			
			//-------------------------------------------------------------------------------------------------
			if(cont1 == 3) {
				
				short contpuntocoma =0;
				short contpuntocoma2 =0;
				short contInicio3 =0;
				short contFinal3 =0;
				
				for(int j =0; j<cadena.length() && contpuntocoma<3 ; j++) {
					
					if(cadena.charAt(j)==';') {
					
						contpuntocoma++;
					}
					
					contInicio3++;
				}
							
				for(int k =0; k<cadena.length() && contpuntocoma2<4 ; k++) {
					
					if(cadena.charAt(k)==';') {
					
						contpuntocoma2++;
						
					}
					
					contFinal3++;
				}
				
				contFinal3 =(short)(contFinal3-1);
							
				char [] mail = new char [ contFinal3-contInicio3];
				
				for(int l = 0; l< mail.length; l++) {
					
					mail[l] = cadena.charAt(l+contInicio3); 
				}
				
				correo = new String(mail);
				
				System.out.println("El correo es: "+ correo);
				
				cont1++;
				
			}
			
			//----------------------------------------------------------------------------------------------
			if(cont1 == 4) {
				
				short contpuntocoma =0;
				short contpuntocoma2 =0;
				short contInicio4 =0;
				short contFinal4 =0;
				
				for(int j =0; j<cadena.length() && contpuntocoma<4 ; j++) {
					
					if(cadena.charAt(j)==';') {
					
						contpuntocoma++;
					}
					
					contInicio4++;
				}
							
				for(int k =0; k<cadena.length() && contpuntocoma2<5 ; k++) {
					
					if(cadena.charAt(k)==';') {
					
						contpuntocoma2++;
						
					}
					
					contFinal4++;
				}
				
				contFinal4 =(short)(contFinal4-1);
							
				char [] dir = new char [ contFinal4-contInicio4];
				
				for(int l = 0; l< dir.length; l++) {
					
					dir[l] = cadena.charAt(l+contInicio4); 
				}
				
				direccion = new String(dir);
				
				System.out.println("La direccion es: "+ direccion);
				
				cont1++;
				
			}
			
			//---------------------------------------------------------------------------------------------
			if(cont1 == 5) {
				
				short contpuntocoma =0;
				short contpuntocoma2 =0;
				short contInicio5 =0;
				short contFinal5 =0;
				
				for(int j =0; j<cadena.length() && contpuntocoma<5 ; j++) {
					
					if(cadena.charAt(j)==';') {
					
						contpuntocoma++;
					}
					
					contInicio5++;
				}
							
				for(int k =0; k<cadena.length() && contpuntocoma2<6 ; k++) {
					
					if(cadena.charAt(k)==';') {
					
						contpuntocoma2++;
						
					}
					
					contFinal5++;
				}
				
				contFinal5 =(short)(contFinal5-1);
							
				char [] credit = new char [ contFinal5-contInicio5];
				
				for(int l = 0; l< credit.length; l++) {
					
					credit[l] = cadena.charAt(l+contInicio5); 
				}
				
				creditos = new String(credit);
				
				System.out.println("Los creditos son: "+ creditos);
				
				cont1++;
				
			}
			
			contador++;
		}
		
		//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		if(cont1>0) {
			
			int pass;
			
			do {
				
			pass = (int)(Math.random()*150);
			
			}while(pass>49);
			
			System.out.println("Hay " + cont1 + " ; en " + contador + " caracteres."
					+ " y la contraseña es "+ carnet+pass);
		
		}else {
			
			System.out.println("No hay ; en " + contador +" caracteres.");
		}
			
	}
}

//System.out.println("inicio bucle 3: "+ contInicio3 + " y hay ; igual a: "+ contpuntocoma);
//System.out.println("numero de elementos dentro de nombre: "+ (contFinal-contInicio));
//System.out.println(contInicio + " valor de inicio");
//System.out.println("El DPI es: " +dpi + " y tiene "+ dpi.length() + " caracteres.");
//System.out.println(cont1+ " contador de variables");



