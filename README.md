# Proyecto I Kitt

### ## Write a brief explanation of why you have chosen the DP algorithm to solve the problem.
El algoritmo LCS lo elegi para encontrar la secuencia de palabras comunes entre dos oraciones esto permitió determinar qué partes de los textos coincidían entre sí lo que proporciona una medida de similitud entre los textos.

Por otro lado, elegi por el algoritmo de Levenshtein Distance para detectar errores tipográficos. Al comparar directamente una palabra con otra, pude calcular el número mínimo de operaciones (inserciones, eliminaciones o sustituciones) necesarias para convertir una palabra en la otra. Si esta distancia era mayor al 55% de la longitud de la palabra, la consideraba un posible misspelings
### Identify the time complexity of your solution.
La complejidad del algoritmo completo es O(n * m), donde n y m son las longitudes de las dos cadenas de entrada.
### Is there a non-dynamic programming solution? if so, please explain the idea and compare it with your solution.

Si se podria resolver sin dp haciendo en lugar de utilizar una matriz de DP para calcular la distancia de edición y LCS, implementando un enfoque basado en métodos de procesamiento de cadenas.

Para resolver el problema de manera se puede utilizar un enfoque recursivo o iterativo para implementar el algoritmo de levenshtein Distance

### Evidencias de los resultados 
![Captura desde 2024-03-05 02-04-35](https://github.com/SebasthianSalpozz/Algoritmia2/assets/90279053/d3dbbe37-bd53-4bfb-9c6a-36e1ef2a8393)
