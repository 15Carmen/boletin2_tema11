import Principal.Cliente;
import Principal.GestionClientes;

import java.io.File;

public class Main {

    public static void main(String[] args) {

        Cliente cliente = new Cliente("Carmen", "Martin", "764268826A", 1, "calle de la lloreria_12");
        Cliente cliente2 = new Cliente("Carmen", "Martin", "764268826D", 1, "calle de la lloreria_12");
        Cliente cliente3 = new Cliente("Carmen", "Martin", "764268826B", 1, "calle de la lloreria_12");

        int id = cliente.compareTo(cliente2);
        System.out.println(id);

        GestionClientes gc = new GestionClientes();
        File f = new File("Clientes.txt");

        /*gc.altaCliente(f, cliente);
        gc.altaCliente(f, cliente2);
        gc.altaCliente(f, cliente3);
*/
        gc.ordenarFichero(f);

    }
}
