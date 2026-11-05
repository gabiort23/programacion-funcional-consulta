# programacion-funcional-consulta
Trabajo de consulta sobre funciones anónimas en Scala, Java y Python.

Materia: Programación Funcional (Semana 5)
Estudiante: Gabriela Ortega
Carrera: Computación – UTPL (Tercer Ciclo)
Lenguajes aplicados: Scala, Java y Python
# Parte 1: Explorar — La Programación Funcional en el Mundo Real
En las primeras semanas de clase aprendimos sobre las funciones de orden superior. Investigando cómo se aplica esto fuera del aula, encontré que grandes tecnologías y empresas dependen de este paradigma:

# 1. PayPal / Sistemas Antifraude (Procesamiento de Transacciones en Tiempo Real)
¿Qué problema resuelven?
Analizar millones de transacciones de pago por segundo para detectar y bloquear fraudes o anomalías antes de que la operación sea aprobada.
# Lenguaje / Herramienta: 
Scala y Java con motores de streaming de eventos.
# Ventaja funcional: 
Utilizan funciones anónimas dentro de operaciones sobre colecciones en tiempo real (como filter y map) para evaluar reglas de seguridad de forma instantánea. Al trabajar con colecciones inmutables, se evita que varios hilos de ejecución modifiquen los datos al mismo tiempo, garantizando la seguridad y precisión financiera.
