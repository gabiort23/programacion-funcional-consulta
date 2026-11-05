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
```val alertasFraude = streamTransacciones
  .filter(tx => tx.monto > 5000.0 && tx.ubicacion != tx.usuario.paisOrigen)
  .map(tx => Alerta(tx.id, "Posible fraude detectado"))
```
## Segundo caso: Uber / Cálculo de Tarifas y Rutas en Tiempo Real
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
  
## Parte 2 – Entender: ¿que es una funcion anonima?
### Responde con tus palabras y apoya cada respuesta con un fragmento corto de codigo:

### ¿Que es una funcion anonima y de donde viene el nombre lambda?
 Es una función que no tiene un nombre asignado y se escribe directamente en el lugar donde se va a utilizar. Su nombre proviene del Cálculo Lambda (λ-calculus) de Alonzo Church.
 
### ¿En que se diferencia de una funcion nombrada? Escribe la misma logica de ambas formas.
La función nombrada se declara con un identificador (def miFuncion()), mientras que la anónima se define como una expresión directa (n => n * 2).
// Función nombrada
def esPar(n: Int): Boolean = n % 2 == 0
// Función anónima equivalente
(n: Int) => n % 2 == 0

### ¿Que significa que las funciones sean ciudadanos de primera clase? ¿Por que eso permite pasar una lambda a map o filter?
Significa que las funciones pueden tratarse como cualquier otro valor: se pueden guardar en variables, pasarse como argumentos a otras funciones o retornarse desde ellas.

### ¿Que es un closure? Muestra una lambda que use una variable definida fuera de ella.
Es una función anónima que captura o "recuerda" una variable declarada fuera de su propio cuerpo.
val limite = 100
// La lambda accede a 'limite', variable definida fuera de su cuerpo
val esMayorQueLimite = (monto: Double) => monto > limite


## Parte 3 – Aplicar: ¿en que problemas sirven las funciones anonimas?
Para garantizar comparaciones homogéneas, utilizaremos la misma colección de datos de ejemplo en Scala, Java y Python:
Entidad base: 
Producto(nombre: String, categoria: String, precio: Double, stock: Int)
Dataset inicial (10 productos):
Laptop (Electrónica, $1200.0, 5)
Mouse (Electrónica, $25.0, 50)
Teclado (Electrónica, $45.0, 30)
Monitor (Electrónica, $300.0, 12)
Silla Gamer (Muebles, $250.0, 8)
Escritorio (Muebles, $180.0, 4)
Lámpara (Hogar, $15.0, 60)
Cuaderno (Papelería, $3.5, 100)
Esfero (Papelería, $1.2, 200)
Mochila (Accesorios, $50.0, 15)

### 3.1 Tipo 1: Selección (filter)
### Situación real: 
Un comercio electrónico necesita filtrar los productos de la categoría "Electrónica" que cuestan más de $100.
### Scala

case class Producto(nombre: String, categoria: String, precio: Double, stock: Int)

val productos = List(
  Producto("Laptop", "Electrónica", 1200.0, 5),
  Producto("Mouse", "Electrónica", 25.0, 50),
  Producto("Teclado", "Electrónica", 45.0, 30),
  Producto("Monitor", "Electrónica", 300.0, 12),
  Producto("Silla Gamer", "Muebles", 250.0, 8),
  Producto("Escritorio", "Muebles", 180.0, 4),
  Producto("Lámpara", "Hogar", 15.0, 60),
  Producto("Cuaderno", "Papelería", 3.5, 100),
  Producto("Esfero", "Papelería", 1.2, 200),
  Producto("Mochila", "Accesorios", 50.0, 15)
)

val resScala = productos.filter(p => p.categoria == "Electrónica" && p.precio > 100.0)println(resScala)

### Java

import java.util.*;
import java.util.stream.Collectors;

record Producto(String nombre, String categoria, double precio, int stock) {}

public class Main {
    public static void main(String[] args) {
        List<Producto> productos = List.of(
            new Producto("Laptop", "Electrónica", 1200.0, 5),
            new Producto("Mouse", "Electrónica", 25.0, 50),
            new Producto("Teclado", "Electrónica", 45.0, 30),
            new Producto("Monitor", "Electrónica", 300.0, 12),
            new Producto("Silla Gamer", "Muebles", 250.0, 8),
            new Producto("Escritorio", "Muebles", 180.0, 4),
            new Producto("Lámpara", "Hogar", 15.0, 60),
            new Producto("Cuaderno", "Papelería", 3.5, 100),
            new Producto("Esfero", "Papelería", 1.2, 200),
            new Producto("Mochila", "Accesorios", 50.0, 15)
        );

        List<Producto> resJava = productos.stream()
            .filter(p -> p.categoria().equals("Electrónica") && p.precio() > 100.0)
            .collect(Collectors.toList());

        System.out.println(resJava);
    }
}

### Python

from dataclasses import dataclass

@dataclass
class Producto:
    nombre: str
    categoria: str
    precio: float
    stock: int

productos = [
    Producto("Laptop", "Electrónica", 1200.0, 5), 
    Producto("Mouse", "Electrónica", 25.0, 50), 
    Producto("Teclado", "Electrónica", 45.0, 30),       
    Producto("Monitor", "Electrónica", 300.0, 12), 
    Producto("Silla Gamer", "Muebles", 250.0, 8), 
    Producto("Escritorio", "Muebles", 180.0, 4), 
    Producto("Lámpara", "Hogar", 15.0, 60), 
    Producto("Cuaderno", "Papelería", 3.5, 100), 
    Producto("Esfero", "Papelería", 1.2, 200), 
    Producto("Mochila", "Accesorios", 50.0, 15)

]

res_python = list(filter(lambda p: p.categoria == "Electrónica" and p.precio > 100.0, productos))

### 3.2 Tipo 2: Transformación (map)
Situación real: El sistema de inventario necesita calcular el precio con un 15% de impuesto IVA incluido para cada producto y devolver una lista de cadenas con formato "Nombre: $PrecioConIVA".print(res_python)

### Scala
val resScala = productos.map(p => s"${p.nombre}: $$${p.precio * 1.15}")

### Java
List<String> resJava = productos.stream()
    .map(p -> p.nombre() + ": $" + (p.precio() * 1.15))
    .collect(Collectors.toList());
    
### Python

res_python = list(map(lambda p: f"{p.nombre}: ${p.precio * 1.15}", productos))

### 3.3 Tipo 3: Extremos (maxBy / minBy)
Situación real: Un gerente de compras quiere identificar el producto con menor existencias en stock para realizar una reorden urgente

### Scala
val resScala = productos.minBy(p => p.stock)

### Java
Producto resJava = productos.stream()
    .min(Comparator.comparingInt(Producto::stock))
    .orElseThrow();
    
### Python
res_python = min(productos, key=lambda p: p.stock)

### 3.4 Tipo 4: Conteo (count)
Situación real: El área de logística necesita saber cuántos productos tienen un nivel de stock crítico (menos de 10 unidades) para planificar la reposición en bodega.

### Scala
val resScala = productos.count(p => p.stock < 10)
println(resScala)

### Java
long resJava = productos.stream()
    .filter(p => p.stock() < 10)
    .count();

System.out.println(resJava);
    
### Python
res_python = sum(1 for p in productos if p.stock < 10) 

print(res_python)

## Parte 4 – Ampliar: cuatro operaciones nuevas

### 4.1 Elección de operaciones
Para cumplir con la rúbrica, seleccionaremos cuatro operaciones avanzadas de colecciones en Scala:

groupBy (Familia: Agrupar)

sortBy (Familia: Ordenar)

partition (Familia: Dividir una lista)

zipWithIndex (Familia: Combinar listas)

### 4.2 Fichas de cada operación
### Ficha 1: groupBy
Qué hace: Agrupa los elementos de la colección en un mapa (Map[K, List[A]]) utilizando una clave calculada a partir de cada elemento.

Función anónima: Recibe una lambda que extrae la clave de agrupación (por ejemplo, p => p.categoria), la cual debe devolver un tipo evaluable como clave (como un String).

Ejemplo en Scala:

val resScala = productos.groupBy(p => p.categoria)
println(resScala)

Problema que resuelve: Permite categorizar el inventario general por departamentos en una tienda virtual para organizar los pasillos de una bodega. Se asemeja al tipo de problema de Transformación / Conteo.

### Ficha 2: sortBy
Qué hace: Ordena los elementos de la colección basándose en el valor obtenido al aplicar una función a cada elemento, permitiendo especificar el criterio de orden.

Función anónima: Recibe una lambda que extrae el valor comparable por el cual se ordenará (por ejemplo, p => p.precio).

Ejemplo en Scala :

val resScala = productos.sortBy(p => p.precio) // Orden ascendente por precio
resScala.foreach(p => println(s"${p.nombre}: $$${p.precio}"))

Problema que resuelve: Mostrar un catálogo ordenado del producto más económico al más costoso para clientes con presupuestos ajustados. Se asemeja al tipo de problema de Extremos / Selección.

### Ficha 3: partition
Qué hace: Divide una colección en una tupla de dos listas utilizando un predicado: la primera lista contiene los elementos que cumplen la condición y la segunda los que la rechazan.

Función anónima: Recibe un predicado (una lambda que retorna un booleano, por ejemplo, p => p.precio > 100).

Ejemplo en Scala :

val (caros, economicos) = productos.partition(p => p.precio > 100)
println(s"Caros: ${caros.map(_.nombre)}")
println(s"Económicos: ${economicos.map(_.nombre)}")

Problema que resuelve: Separar automáticamente el inventario de alto valor (para requerir seguridad especial) de los artículos comunes. Se asemeja al tipo de problema de Selección (filter).

### Ficha 4: zipWithIndex
Qué hace: Combina cada elemento de la colección con su posición numérica (índice comenzando en 0), generando una secuencia de pares (elemento, indice).

Función anónima: Esta operación estructural no recibe una lambda de forma directa, por lo que típicamente se encadena con un map o se aplica directamente sobre la lista antes de transformar.

Ejemplo en Scala :

val resScala = productos.map(p => p.nombre).zipWithIndex
resScala.foreach{ case (nombre, idx) => println(s"${idx + 1}. $nombre")

Problema que resuelve: Generar un menú enumerado en consola o un reporte formal donde cada artículo necesite un número de orden correlativo. Se asemeja al tipo de problema de Transformación.

### 4.3 Combinar operaciones
Pregunta de negocio:

"¿Cuáles son los nombres de los productos de la categoría 'Electrónica' que tienen un stock mayor a 10 unidades, ordenados alfabéticamente?"

Cadena de operaciones en Scala:

Scala
val resultado = productos
  .filter(p => p.categoria == "Electrónica" && p.stock > 10) // Vista en clase (Selección)
  .map(p => p.nombre)                                        // Vista en clase (Transformación)
  .sortBy(identity)                                          // Nueva operación (Ordenar)

println(resultado)

Explicación paso a paso de la cadena:

Paso 1 (filter): Se aplica un filtro lógico para reducir el conjunto de 10 productos globales únicamente a aquellos de la categoría "Electrónica" cuyo stock sea estrictamente mayor a 10. Esto descarta la Laptop (stock 5) y deja el Mouse (50), Teclado (30) y Monitor (12).

Paso 2 (map): Toma la lista resultante de objetos Producto y los transforma extrayendo exclusivamente el atributo nombre, convirtiendo la estructura en una lista de cadenas (List[String] con valores "Mouse", "Teclado", "Monitor").

Paso 3 (sortBy): Utiliza la función nueva sortBy con identity para ordenar alfabéticamente los nombres de forma ascendente, obteniendo el orden final limpio: List(Monitor, Mouse, Teclado).
