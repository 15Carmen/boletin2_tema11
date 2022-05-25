import Entidades.Cliente;
import Controller.GestionClientes;

import java.io.File;

public class Main {

    public static void main(String[] args) {

        Cliente cliente = new Cliente("Carmen1", "Martin", "764268826A", 1, "Espartero 53");
        Cliente cliente2 = new Cliente("Carmen2", "Martin", "764268826D", 1, "Espartero 53");
        Cliente cliente3 = new Cliente("Carmen3", "Martin", "764268826B", 1, "Espartero 53");
        Cliente cliente4 = new Cliente("Penelope", "Martin", "69697893P", 69, "Espartero 13");

        GestionClientes gc = new GestionClientes();

        File master = new File(GestionClientes.FILE);
        File modificaciones = new File(GestionClientes.MODIFICACIONES);

        gc.altaCliente(master,cliente);
        gc.altaCliente(master,cliente2);
        gc.altaClienteOrdenado(master,cliente3);

        gc.insertarModificacionCliente(modificaciones,cliente4);
        gc.realizarModificaciones(master,modificaciones);


    }
}
