package tienda_electronica;

public class Producto {
    private String nombre;
    private String descripcion;
    private double precio;
    private int stock;
    private String categoria;


    public String toString() {
        return "Nombre: " + nombre + "\n" +
                "Descripción: " + descripcion + "\n" +
                "Precio: " + precio + "\n" +
                "Stock: " + stock + "\n" +
                "Categoría: " + categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Producto(String nombre, String descripcion, double precio, int stock, String categoria) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.categoria = categoria;
    }
    public void vender(int cantidad) {
        if (cantidad <= stock) {
            stock -= cantidad;
            System.out.println("Venta realizada. Stock actual: " + stock);
        } else {
            System.out.println("No hay suficiente stock.");
        }
    }

}
