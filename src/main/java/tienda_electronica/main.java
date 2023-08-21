package tienda_electronica;

import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        TiendaOnline tienda = new TiendaOnline();

        InterfazUsuario interfaz = new InterfazUsuario();

        interfaz.setTienda(tienda);
        interfaz.setEntrada(entrada);

        interfaz.iniciar();

    }

}