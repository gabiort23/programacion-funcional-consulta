object Operaciones {
  case class Producto(nombre: String, categoria: String, precio: Double, stock: Int)

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

    println("=== 4.2 FICHAS DE OPERACIONES NUEVAS ===")

    val resGroupBy = productos.groupBy(p => p.categoria)
    println("\n1. groupBy (por categoría):")
    resGroupBy.foreach { case (cat, lista) => println(s"  $cat -> ${lista.map(_.nombre)}") }

    val resSortBy = productos.sortBy(p => p.precio)
    println("\n2. sortBy (por precio ascendente):")
    resSortBy.foreach(p => println(s"  ${p.nombre}: $${p.precio}"))

    val (caros, economicos) = productos.partition(p => p.precio > 100)
    println(s"\n3. partition (Precio > 100):")
    println(s"  Caros: ${caros.map(_.nombre)}")
    println(s"  Económicos: ${economicos.map(_.nombre)}")

    val resZip = productos.map(p => p.nombre).zipWithIndex
    println("\n4. zipWithIndex (Menú enumerado):")
    resZip.foreach { case (nombre, idx) => println(s"  ${idx + 1}. $nombre") }

    println("\n=== 4.3 COMBINAR OPERACIONES ===")
    val resultadoCombinado = productos
      .filter(p => p.categoria == "Electrónica" && p.stock > 10)
      .map(p => p.nombre)
      .sortBy(identity)

    println("Resultado de la combinación de operaciones:")
    println(resultadoCombinado)
  }
}