# Programacion-funcional-consulta
Trabajo de consulta sobre funciones anónimas en Scala, Java y Python.

Materia: Programación Funcional (Semana 5)

Estudiante: Gabriela Ortega

Carrera: Computación – UTPL (Tercer Ciclo)

Lenguajes aplicados: Scala, Java y Python

## Parte 1: Explorar — La Programación Funcional en el Mundo Real
En las primeras semanas de clase aprendimos sobre las funciones de orden superior. Investigando cómo se aplica esto fuera del aula, encontré que grandes tecnologías y empresas dependen de este paradigma:

### Primer caso: PayPal / Sistemas Antifraude (Procesamiento de Transacciones en Tiempo Real)
### ¿Qué problema resuelven?
Analizar millones de transacciones de pago por segundo para detectar y bloquear fraudes o anomalías antes de que la operación sea aprobada.
### Lenguaje / Herramienta: 
Scala y Java con motores de streaming de eventos.
### Ventaja funcional: 
Utilizan funciones anónimas dentro de operaciones sobre colecciones en tiempo real (como filter y map) para evaluar reglas de seguridad de forma instantánea. Al trabajar con colecciones inmutables, se evita que varios hilos de ejecución modifiquen los datos al mismo tiempo, garantizando la seguridad y precisión financiera.

### Ejemplo de código:
val alertasFraude = streamTransacciones
  .filter(tx => tx.monto > 5000.0 && tx.ubicacion != tx.usuario.paisOrigen)
  .map(tx => Alerta(tx.id, "Posible fraude detectado"))

### Segundo caso: Uber / Cálculo de Tarifas y Rutas en Tiempo Real
### ¿Qué problema resuelven?
Procesar solicitudes de miles de usuarios para filtrar conductores cercanos, calcular tarifas dinámicas y transformar coordenadas GPS al instante.

### Lenguaje / Herramienta: 
Scala y Java con procesamiento distribuido.

### Ventaja funcional: 
Utilizan funciones de orden superior (filter y map) para aplicar reglas de precios y distancias de forma limpia y rápida, sin alterar los datos originales de los mapas o usuarios.

### Ejemplo de código:
val conductoresCercanos = conductores
  .filter(c => c.distanciaKm <= 3.0 && c.disponible)
  .map(c => tarifaBase * c.multiplicadorZona)
  
