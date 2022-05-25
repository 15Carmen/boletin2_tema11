package Principal;

import java.io.Serializable;

public class Cliente implements Comparable, Serializable {

    private String nombre;
    private String apellido;
    private String cif;
    private int categoria;
    private String direccion;

    StringBuffer sb1 = new StringBuffer(50);
    StringBuffer sb2 = new StringBuffer(10);

    public Cliente(){}

    public Cliente(String nombre, String apellido, String cif, int categoria, String direccion) {
        setNombre(nombre);
        setApellido(apellido);
        setCif(cif);
        this.categoria = categoria;
        setDireccion(direccion);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        sb1.append(nombre);
        this.nombre = sb1.toString();
        sb1.setLength(0);
        //sb1.delete(0,sb1.length()); otra forma de vaciar el buffer
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        sb1.append(apellido);
        this.apellido = sb1.toString();
        sb1.setLength(0);
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        sb2.append(cif);
        this.cif = sb2.toString();
        sb2.setLength(0);
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        sb1.append(direccion);
        this.direccion = sb1.toString();
        sb1.setLength(0);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", cif='" + cif + '\'' +
                ", categoria=" + categoria +
                ", direccion='" + direccion + '\'' +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        int salida = 0;
        if (o instanceof Cliente){
            Cliente cliente = (Cliente) o;
            salida=this.cif.compareTo(cliente.cif);
        }
        return salida;
    }
}
