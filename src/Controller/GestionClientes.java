package Controller;

import Entidades.Cliente;

import java.io.*;
import java.util.*;

public class GestionClientes implements IGestionClientes{

    public static final String FILE = "Clientes.txt";
    public static final String AUX = "aux.txt";
    public static final String MODIFICACIONES = "modificaciones.txt";



    /**
     * Metodo que registrará un cliente en el final del fichero CLIENTE.txt
     *
     * @param fichero
     * @param cliente
     */

    public void altaCliente(File fichero, Cliente cliente) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fichero, true))){

            bw.write(cliente.toString());
            bw.newLine();

        } catch (Exception e) {
            System.out.println("Error al crear el fichero" + e.getMessage());
        }

    }

    /**
     *  Método por el cual se registra un cliente el el lugar que corresponde en el fichero
     *  de texto según su cif.
     * @param fichero
     * @param cliente
     */

    public void altaClienteOrdenado(File fichero, Cliente cliente) {
        String linea;
        Cliente cliente1;
        boolean encontrado= false;
        File aux=null;
        try (BufferedReader br = new BufferedReader(new FileReader(fichero))){
            aux = new File(AUX);
            linea = br.readLine();

            while (linea != null){
                cliente1 = transformarAObjeto(linea);
                if (encontrado || cliente1.compareTo(cliente) <=0){
                    altaCliente(aux, cliente1);
                    linea = br.readLine();
                }else {
                    altaCliente(aux, cliente);
                    encontrado=true;
                }
            }
        } catch (Exception e) {
            System.out.println("Error al crear el fichero" + e.getMessage());
        }finally {
            fichero.delete();
            aux.renameTo(fichero);
        }
    }

    /**
     *  Método que crea un fichero nuevo donde aparezcan todas las altas que haya en
     *  el fichero Clientes.txt
     * @param cliente
     * @param altas
     */

    public void realizarAltas(File cliente, File altas) {

    }

    /**
     * Método por el cual se mostrará el cliente que el usuario elija cuando el mismo
     * pase por parámetros el apellido del cliente.
     *
     * @param fichero
     * @param apellidos
     */

    public void consultarElementoPorApellidos(File fichero, String apellidos) {
        String linea;
        String salida= "Fichero no encontrado";
        boolean salir=false;

        try (BufferedReader br = new BufferedReader(new FileReader(fichero))){
            String[] lineaCliente;
            linea = br.readLine();
            while (linea != null || !salir) {
                lineaCliente=linea.split(",");
                if (Objects.equals(lineaCliente[2], apellidos)){
                   salida=linea;
                   salir=true;
                }else {
                    linea= br.readLine();
                }
            }
            System.out.println(salida);

        } catch (IOException ioException) {
            System.out.println("Error al crear el fichero"+ ioException.getMessage());
        }
    }

    /**
     * Método por el cual se mostrarán los clientes que tengan el apellido pasado por
     * parámetros
     * @param fichero
     * @param apellidos
     * @return
     */

    public String buscarElementoPorApellidos(File fichero, String apellidos) {

        String linea = "Fichero no encontrado";
        boolean salir = false;
        try (BufferedReader br = new BufferedReader(new FileReader(fichero))) {
            String[] lineaCliente;
            linea = br.readLine();
            while (linea != null || !salir) {
                lineaCliente = linea.split(",");
                if (Objects.equals(lineaCliente[2], apellidos)) {
                    salir = true;
                } else {
                    linea = br.readLine();
                }
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return linea;

    }

    /**
     * Método por el cual se mostrará por pantalla el cliente con el cif pasado por
     * parámetros
     * @param fichero
     * @param cif
     */
    public void consultarElementoPorCif(File fichero, String cif) {

    }

    /**
     * Método por el cual se mostrará por pantalla el cliente con el cif pasado por
     * parámetros
     * @param fichero
     * @param cif
     * @return
     */
    public String buscarElementoPorCif(File fichero, String cif) {
        return "holi";
    }

    /**
     * Método que inserta en un nuevo fichero de modificaciones un cliente para ser modificado en un futuro
     * sobre el fichero original 'Clientes.txt'
     * @param ficheroModificado
     * @param cliente
     */

    public void insertarModificacionCliente(File ficheroModificado, Cliente cliente) {
        altaCliente(ficheroModificado, cliente);
    }


    /**
     * Método que recoge todas las modificaciones del fichero modificaciones registradas
     * en el fichero de modificaciones
     * @param clientes
     * @param modificaciones
     */
    public void realizarModificaciones(File clientes, File modificaciones) {

        String linea;

        try (BufferedReader br = new BufferedReader(new FileReader(modificaciones))) {

            String[] lineaCliente;
            linea = br.readLine();

            while (linea != null) {
                altaCliente(clientes,transformarAObjeto(linea));
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    /**
     * Método por el cual se modifica un elemento del fichero directamente
     * con ayuda de un fichero auxiliar
     * @param fichero
     * @param registroViejo
     * @param registroNuevo
     */
    public void modificarElemento(File fichero, String registroViejo, Cliente registroNuevo) {

    }

    /**
     * Método que inserta en el fichero de bajas un cliente para ser
     * dado de baja en un futuro sobre el fichero original de clientes. No se valida que el cliente
     * exista en el fichero maestro
     * @param fichero
     * @param cli
     */
    public void insertarBajaClientes(File fichero, Cliente cli) {

    }

    /**
     * Método que inserta en el fichero de bajas un cliente para ser
     * dado de baja en un futuro sobre el fichero original de clientes. No se valida que el cliente
     * exista en el fichero maestro
     * @param clientes
     * @param bajas
     */
    public void realizarBajas(File clientes, File bajas) {

    }

    /**
     * Método que borra del fichero un elemento directamente con ayuda
     * de un fichero auxiliar.
     * @param fichero
     * @param registro
     */
    public void bajaElemento(File fichero, String registro) {

    }

    /**
     * Metodo que transforma un registro cliente que es un String a un objeto cliente
     * usando el metodo .split()
     *
     * @param registro
     * @return
     */
    public Cliente transformarAObjeto(String registro) {

        String[] clienteText = registro.split(",");
        return new Cliente(clienteText[0],clienteText[1],clienteText[2], Integer.parseInt(clienteText[3]), clienteText[4]);
    }

    /**
     * Método que va a ordenar el fichero de texto según el compareTo que está creado en
     * la clase Cliente.
     *
     * @param fichero
     */

    public void ordenarFichero(File fichero) {

        try (BufferedReader br = new BufferedReader(new FileReader(fichero))){

        } catch (Exception e) {
            System.out.println("Error");
        }
    }

}
