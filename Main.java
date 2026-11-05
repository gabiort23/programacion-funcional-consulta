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

        // 3.1 Selección (filter)
        List<Producto> resSeleccion = productos.stream()
            .filter(p -> p.categoria().equals("Electrónica") && p.precio() > 100.0)
            .collect(Collectors.toList());
        System.out.println("Selección: " + resSeleccion);

        // 3.2 Transformación (map con formato limpio de precios)
        List<String> resTransformacion = productos.stream()
            .map(p -> String.format("%s: $%.2f", p.nombre(), p.precio() * 1.15))
            .collect(Collectors.toList());
        System.out.println("Transformación: " + resTransformacion);

        // 3.3 Extremos (min)
        Producto resExtremos = productos.stream()
            .min(Comparator.comparingInt(Producto::stock))
            .orElseThrow();
        System.out.println("Extremos (Menor stock): " + resExtremos);

        // 3.4 Conteo (count)
        long resConteo = productos.stream()
            .filter(p -> p.stock() < 10)
            .count();
        System.out.println("Conteo (Stock crítico < 10): " + resConteo);
    }
}
