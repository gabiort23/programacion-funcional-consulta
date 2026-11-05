case class Producto(nombre: String, categoria: String, precio: Double, stock: Int)

object Main {
  def main(args: Array[String]): Unit = {
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

    // 3.1 Selección (filter)
    val resSeleccion = productos.filter(p => p.categoria == "Electrónica" && p.precio > 100.0)
    println("Selección: " + resSeleccion)

    val resTransformacion = productos.map(p => s"${p.nombre}: $${p.precio * 1.15}")
    println("Transformación: " + resTransformacion)

    val resExtremos = productos.minBy(p => p.stock)
    println("Extremos (Menor stock): " + resExtremos)

    val resConteo = productos.count(p => p.stock < 10)
    println("Conteo (Stock crítico < 10): " + resConteo)
  }
}
