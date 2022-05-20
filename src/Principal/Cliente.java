package Principal;

public class Cliente implements Comparable{

    private String nombre;
    private String apellido;
    private String cif;
    private int categoría;
    private String direccion;

    StringBuffer sb1 = new StringBuffer(50);
    StringBuffer sb2 = new StringBuffer(10);

    public Cliente(String nombre, String apellido, String cif, int categoría, String direccion) {
        setNombre(nombre);
        setApellido(apellido);
        setCif(cif);
        this.categoría = categoría;
        setDireccion(direccion);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        sb1.append(nombre);
        this.nombre = sb1.toString();
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        sb1.append(apellido);
        this.apellido = sb1.toString();
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        sb2.append(cif);
        this.cif = sb2.toString();
    }

    public int getCategoría() {
        return categoría;
    }

    public void setCategoría(int categoría) {
        this.categoría = categoría;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        sb1.append(direccion);
        this.direccion = sb1.toString();
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
