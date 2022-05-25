package Controller;

import Entidades.Cliente;

import java.io.File;

public interface IGestionClientes {
    void altaCliente(File fichero, Cliente cliente);

    void altaClienteOrdenado(File fichero, Cliente cliente, boolean flag);

    void realizarAltas(File cliente, File altas);

    void consultarElementoPorApellidos(File fichero, String apellidos);

    String buscarElementoPorApellidos(File fichero, String apellidos);

    void consultarElementoPorCif(File fichero, String cif);

    String buscarElementoPorCif(File fichero, String cif);

    void insertarModificacionCliente(File fichero, Cliente cliente);

    void realizarModificaciones(File clientes, File modificaciones);

    void modificarElemento(File fichero, String registroViejo, Cliente registroNuevo);

    void insertarBajaClientes(File fichero, Cliente cli);

    void realizarBajas(File clientes, File bajas);

    void bajaElemento(File fichero, String registro);

    Cliente transformarAObjeto(String registro);

    void ordenarFichero(File fichero);
}
