# Ejercicio visibilidad stock




- Clase Main Principal: Application.java
- Logica Algoritmo: Alghoritm.java
 

Estructura Datos Utilizadas:

- Set<String> :Se utilizo para guardar Id de Productos a Desplegar y no tener elementos repetidos al momento de agregarlos.
- List<String> :Para almacenar tallas.

Adicionalmente se utilizo:

-	HashMap :Para almacenar productos y stock, ya que ambos aplicaban para clave/valor y asi evitaba iterar con arrays que harían mas costosa la busqueda.

Complejidad Temporal Algoritmo:
- Complejidad:O(n) + O(n)   --> Dado principalmente por el recorrido del tamaño de tallas.
- No encontre otra opción de Mejora, sin modificar los datos.


Consideraciones: No se utilizaron objetos Custom, enfoque solo fue en Algoritmo y se mantuvo intacto el tipo de dato obtenido de csv.
