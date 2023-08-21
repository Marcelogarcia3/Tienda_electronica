package tienda_electronica;

import java.util.ArrayList;

public class TiendaOnline {

    private ArrayList<Producto> productos;

    public TiendaOnline() {
        productos = new ArrayList<>();
    }


    public void mostrarProductos() {

        for(Producto producto : productos) {
            System.out.println(producto);
        }

    }

    public Producto buscarProducto(String nombreABuscar) {
        for (Producto producto : productos) {
            if (producto.getNombre().equals(nombreABuscar)) {
                return producto;  // Retorna el producto
            }
        }
        return null;  // Producto no encontrado
    }


    public void agregarProducto(Producto nuevoProducto) {
        productos.add(nuevoProducto);
    }
    public void modificarProducto(String nombre, Producto productoModificado) {
        for (int i = 0; i < productos.size(); i++) {
            Producto producto = productos.get(i);
            if (producto.getNombre().equals(nombre)) {
                productos.set(i, productoModificado);
                System.out.println("Producto modificado: " + productoModificado.getNombre());
                return;
            }
        }
        System.out.println("Producto no encontrado para modificar.");
    }

    public void eliminarProducto(Producto producto) {
        productos.remove(producto);
    }
    public void realizarVenta(Producto productoVenta, int cantidad) {
        Producto productoEnInventario = buscarProducto(productoVenta.getNombre());

        if (productoEnInventario != null) {
            if (productoEnInventario.getStock() > 0) {
                productoEnInventario.vender(cantidad); //
                System.out.println("Compra realizada: " + productoVenta.getNombre());
            } else {
                System.out.println("No hay suficiente stock para realizar la compra.");
            }
        } else {
            System.out.println("Producto no encontrado para realizar la compra.");
        }
    }

}
