# Proyecto Calculadora
En este proyecto elaboraremos una calculadora para operaciones de suma y resta de dos números. 
	
* Creación de tests:
  	
  	En primer lugar elaboramos unos tests para el futuro servicio que implementaremos. La realización de dichos tests nos ayudará luego sirviendo como mapa del servicio a realizar.  
  	
  	En este punto decidimos hacer uso de la clase BigDecimal frente a las alternativas (double, float...) que son más propensas a errores en el 	redondeo de las partes decimales 	para poder así obtener una mayor precisión.  
  	  
  	Durante la realización de los tests decidimos que el servicio tendrá que recibir tres parámetros, los dos números a operar y un signo que 	identifique el operador.  
  	Además decidimos utilizar una excepción personalizada para poder informar de posibles errores.  
  	  
  	Se realizarán los siguientes tests: 
  	 
  	- Test para primer operando no válido
	- Test para segundo operando no válido
	- Test para operador no válido (aquí vemos la necesidad de establecer cuáles serán los operadores admitidos por el servicio)
	- Test para comprobar que las sumas se hacen correctamente
	- Test para comprobar que las restas se hacen correctamente
	- Test para comprobar que la operación de resta devuelve un valor negativo cuando el número a restar es mayor que el número del que se 	resta.  
	
 	En los tests de operaciones correctas comprobaremos el resultado su signo y su precisión con el resultado esperado.
 	
 * Creación de excepción personalizada y servicio
 	
   Se implementa el servicio principal y una excepción para tratar los posibles errores.
 	
   Se añaden las librería para trazas y las trazas
   
 * Se añade controlador y DTO para la request