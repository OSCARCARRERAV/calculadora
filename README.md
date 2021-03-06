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
	- Test para operador no válido 
	- Test para comprobar que las sumas se hacen correctamente
	- Test para comprobar que las restas se hacen correctamente
	- Test para comprobar que la operación de resta devuelve un valor negativo cuando el número a restar es mayor que el número del que se 	resta.  
	
 	En los tests de operaciones correctas comprobaremos el resultado su signo y su precisión con el resultado esperado.
 	
 * Creación de excepción personalizada y servicio.
 	
 * Se implementa el servicio principal y una excepción para tratar los posibles errores.
   
 * Se añade controlador y DTO para la request.
 
  * Se añaden tests para el controlador.
  
  * Se añade librería de trazas y trazas en el servicio de calculadora.
  
  * Se sustituye el switch en el servicio por una lista de Componentes de Spring para poder añadir nuevas operaciones simplemente creando la clase pertinente sin tocar el servicio.
  
  Para su utilización es necesario añadir las librería de trazas al repositorio local, esto puede hacerse mediante el comando de maven:
  
  mvn install:install-file -Dfile=<Ruta a la carpeta src/main/resources del proyecto en la máquina>\tracer-1.0.0.jar -DgroupId=io.corp.calculator -DartifactId=tracer -Dversion=1.0.0 -Dpackaging=jar
  
  