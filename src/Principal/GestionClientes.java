package Principal;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class GestionClientes {

    /**
     * Metodo que registrará un cliente en el final del fichero CLIENTE.txt
     * @param fichero
     * @param cliente
     */

    public void altaCliente(File fichero, Cliente cliente){

        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(fichero, true));

            bw.write(cliente.getCif()+",");
            bw.write(cliente.getNombre()+",");
            bw.write(cliente.getApellido()+",");
            bw.write(cliente.getCategoría()+",");
            bw.write(cliente.getDireccion());
            bw.newLine();

            System.out.println(cliente.toString());
            bw.close();

        }catch (Exception e){
            System.out.println("Error al crear el fichero"+ e.getMessage());
        }

    }

    public void consultarElementoPorApellidos(File fichero, String apellidos){

    }

    public String buscarElementoPorApellidos(File fichero, String apellidos){
        return "holi";
    }

    public void consultarElementoPorCif(File fichero, String cif){

    }

    public String buscarElementoPorCif(File fichero, String cif){
        return "holi";
    }

    public void insertarModificacionCliente(File fichero, Cliente cliente){

    }

    public void realizarModificaciones(File clientes, File modificaciones){

    }

    public void insertarBajaClientes(File fichero, Cliente cli){

    }

    public void realizarBajas(File clientes, File bajas){

    }

    public void realizarAltas(File cliente, File altas){

    }

    /**
     * Metodo que transforma un registro cliente que es un String a un objeto cliente
     * usando el metodo .split()
     * @param registro
     * @return
     */
    public Cliente transformarAObjeto(String registro){
        Cliente cliente=new Cliente();

        cliente.setCif(registro.split(",")[0]);
        cliente.setNombre(registro.split(",")[1]);
        cliente.setApellido(registro.split(",")[2]);
        cliente.setCategoría(Integer.parseInt(registro.split(",")[3]));
        cliente.setDireccion(registro.split(",")[4]);

        return cliente;
    }


    public void ordenarFichero(File fichero){

        ArrayList <Cliente> clientes = new ArrayList<Cliente>();

        try (BufferedReader br= new BufferedReader(new FileReader(fichero))){
            String linea= br.readLine();
            while ((linea = br.readLine())!=null){

                Cliente cli = new Cliente();
                cli.setCif(linea.split(",")[0]);
                cli.setNombre(linea.split(",")[1]);
                cli.setApellido(linea.split(",")[2]);
                cli.setCategoría(Integer.parseInt(linea.split(",")[3]));
                cli.setDireccion(linea.split(",")[4]);

                clientes.add(cli);
            }
            br.close();
            System.out.println("cierra archivo");

            Collections.sort(clientes, Cliente::compareTo);

            this.append=false;
            for (int i = 0; i < clientes.size(); i++) {
                System.out.println(clientes.get(i).toString());
                if (i>0){
                    this.append=true;
                }


                altaClienteOrdenado(fichero, clientes.get(i),this.append);
            }
            System.out.println("hjg");

        }catch (Exception e){
            System.out.println("Error");
        }
    }

    public boolean append=false;

    public void altaClienteOrdenado(File fichero, Cliente cliente, boolean flag){

        try{

            BufferedWriter bw=null;

            if (flag){
                 bw = new BufferedWriter(new FileWriter(fichero, true));
            }else {
                 bw = new BufferedWriter(new FileWriter(fichero));
            }
            bw.write(cliente.getCif()+",");
            bw.write(cliente.getNombre()+",");
            bw.write(cliente.getApellido()+",");
            bw.write(cliente.getCategoría()+",");
            bw.write(cliente.getDireccion());
            bw.newLine();

            System.out.println(cliente.toString());
            bw.close();

        }catch (Exception e){
            System.out.println("Error al crear el fichero"+ e.getMessage());
        }
    }

    public void altaClienteOrdenado(File fichero, String registroViejo, Cliente registroNuevo){

    }

    public void bajaElemento(File fichero, String registro){

    }

}
