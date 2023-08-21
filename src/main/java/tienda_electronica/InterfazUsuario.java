package tienda_electronica;

import java.util.Scanner;

public class InterfazUsuario {

    private TiendaOnline tienda;

    public InterfazUsuario() {
        tienda = null;
        entrada = null;
    }
    public void setEntrada(Scanner entrada) {
        this.entrada = entrada;
    }

    public void setTienda(TiendaOnline tienda) {
        this.tienda = tienda;
    }
    private static final int OPCIONES = 7;
    private Scanner entrada;
    public InterfazUsuario(TiendaOnline tienda) {
        entrada = new Scanner(System.in);
        tienda = new TiendaOnline();
    }

    public void iniciar() {

        int opcion;

        Scanner entrada = new Scanner(System.in);

        do {

            mostrarMenu();
            opcion = leerOpcion(entrada);
            Menu(opcion);

        } while(opcion != 0);

        entrada.close();

    }

    private void mostrarMenu() {

        System.out.println("Menú Principal");
        System.out.println("1. Mostrar Productos");
        System.out.println("2. Buscar Producto");
        System.out.println("3. Agregar Producto");
        System.out.println("4. Modificar Producto");
        System.out.println("5. Eliminar Producto");
        System.out.println("6. Vender Producto");

    }
    private int leerOpcion(Scanner entrada) {

        int opcion;

        do {

            mostrarMenu();

            System.out.print("Ingrese opción: ");
            opcion = this.entrada.nextInt();

            if(opcion < 0 || opcion >= OPCIONES) {
                System.out.println("Opción inválida");
            }

        } while(opcion < 0 || opcion >= OPCIONES);

        return opcion;

    }


    private void Menu(int opcion) {

        switch(opcion) {


            case 1:
                mostrarProductos();
                break;

            case 2:
                buscarProducto();
                break;

            case 3:
                agregarProducto();
                break;

            case 4:
                modificarProducto();
                break;

            case 5:
                eliminarProducto();
                break;

            case 6:
                realizarVenta();
                break;


            }

    }

    private void mostrarProductos() {
        tienda.mostrarProductos();
    }

    private void buscarProducto() {

        Scanner entrada = new Scanner(System.in);

        System.out.print("Nombre del producto a buscar: ");
        String nombre = entrada.nextLine();

        tienda.buscarProducto(nombre);

    }


    private void agregarProducto() {

        Scanner entrada = new Scanner(System.in);

        System.out.println("Agregar producto");

        // Capturar datos del producto

        System.out.println("Escriba el Nombre del producto");
        String nombre = entrada.nextLine();

        System.out.println("Escriba la Descripcion del producto");
        String descripcion = entrada.nextLine();

        System.out.println("Escriba el Precio del producto");
        double precio = entrada.nextDouble();


        System.out.println("Escriba el Stock del producto");
        int stock = entrada.nextInt();

        entrada.nextLine();

        System.out.println("Escriba la Categoria del producto");
        String categoria = entrada.next();



        Producto producto = new Producto(nombre, descripcion, precio, stock, categoria);

        tienda.agregarProducto(producto);

    }
    private void modificarProducto() {
        Scanner entrada = new Scanner(System.in);

        tienda.mostrarProductos();

        System.out.print("Ingrese nombre del producto a modificar: ");
        String nombreABuscar = entrada.nextLine();

        Producto productoOriginal = tienda.buscarProducto(nombreABuscar);

        if (productoOriginal != null) {
            System.out.println("Producto encontrado: " + productoOriginal);


            System.out.print("Nuevo nombre: ");
            String nuevoNombre = entrada.nextLine();

            System.out.print("Nueva descripcion: ");
            String nuevaDescripcion = entrada.nextLine();

            System.out.print("Nuevo precio: ");
            double nuevoPrecio = entrada.nextDouble();

            System.out.print("Nuevo Stock: ");
            int nuevoStock = entrada.nextInt();
            entrada.nextLine(); //consume el enter

            System.out.print("Nueva categoria: ");
            String nuevaCategoria = entrada.nextLine();




            // Crea producto modificado
            Producto productoModificado = new Producto(
                    nuevoNombre,
                    nuevaDescripcion,
                    nuevoPrecio,
                    nuevoStock,
                    nuevaCategoria);

            // Modifica en tienda
            tienda.modificarProducto(productoOriginal.getNombre(), productoModificado);

            System.out.println("Producto modificado exitosamente.");
        } else {
            System.out.println("Producto no encontrado");
        }
    }

    private void eliminarProducto() {

        Scanner entrada = new Scanner(System.in);

        tienda.mostrarProductos();

        System.out.print("Ingrese nombre del producto a eliminar: ");

        String nombreABuscar = entrada.nextLine();

        Producto producto = tienda.buscarProducto(nombreABuscar);

        // Buscar y eliminar producto

        tienda.eliminarProducto(producto);

    }
//tuve problemas a la hora de vender, no pude realizar esta parte, el codigo no tiene problema, pero no funciona
    private void realizarVenta() {

        Scanner entrada = new Scanner(System.in);

        tienda.mostrarProductos();

        System.out.print("Ingrese nombre del producto a vender: ");
        String nombre = entrada.nextLine();

        Producto producto = tienda.buscarProducto(nombre);

        if(producto == null) {
            System.out.println("Producto no encontrado");
            return;
        }

        System.out.println("Producto encontrado: " + producto.getNombre());

        System.out.print("Ingrese cantidad: ");
        int cantidad = entrada.nextInt();

        if(cantidad > producto.getStock()) {
            System.out.println("Stock insuficiente");
        } else {

            tienda.realizarVenta(producto, cantidad);

            System.out.println("Venta realizada");
            System.out.println("Stock actual: " + producto.getStock());

        }

        entrada.close();

    }



}