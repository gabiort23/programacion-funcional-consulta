# programacion-funcional-consulta
Trabajo de consulta sobre funciones anónimas en Scala, Java y Python.

Materia: Programación Funcional (Semana 5)
Estudiante: Gabriela Ortega
Carrera: Computación – UTPL (Tercer Ciclo)
Lenguajes aplicados: Scala, Java y Python
 # Parte 1: Explorar — La Programación Funcional en el Mundo Real
En las primeras semanas de clase aprendimos sobre las funciones de orden superior. Investigando cómo se aplica esto fuera del aula, encontré que grandes tecnologías y empresas dependen de este paradigma:

1. Apache Spark (Procesamiento de Big Data)
¿Qué problema resuelven?: Procesar grandes volúmenes de datos (Big Data) distribuidos en clústeres de manera rápida y eficiente.

Lenguaje / Herramienta: Creado principalmente en Scala (aunque también se usa con Python vía PySpark).

Ventaja funcional: Spark utiliza colecciones distribuidas (RDDs y DataFrames) sobre las cuales aplicamos operaciones funcionales como map, filter y flatMap. Al ser funciones puras sin efectos secundarios, Spark puede paralelar el trabajo en cientos de computadoras sin errores de concurrencia.

Ejemplo de código(Scala):
// Filtrado y transformación de datos en Spark
val transaccionesAltas = rddTransacciones
  .filter(t => t.monto > 1000.0)
  .map(t => (t.clienteId, t.monto))
  
