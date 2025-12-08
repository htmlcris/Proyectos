package paqContactos;

public class Contacto {
    private int id;
    private String nombre;
    private String apellido;
    private String telefono;
    private String correo;

    public Contacto(int id, String nombre, String apellido, String telefono, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.correo = correo;    
    }

    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    @Override
    public String toString() {
        return "Contacto:" + "\nId=" + id + " \nNombre=" + nombre + " \nApellido=" + apellido + " \nTelefono=" + telefono + " \nCorreo=" + correo;
    }
    
    public String toLineaArchivo(){
        return id + ";" + nombre + ";" + apellido + ";" + telefono + ";"+ correo+";";
    }
    
    public static Contacto desdeLineaArchivo(String linea){
        String[] partes = linea.split(",");
        if(partes.length != 5){
            return null;
        }
        
        try{
            int id = Integer.parseInt(partes[0]);
            String nombre = partes[1];
            String apellido = partes[2];
            String telefono = partes[3];
            String correo = partes[4];
            
            return new Contacto(id,nombre,apellido,telefono,correo);
            
        }catch(NumberFormatException e){
            System.out.println("Error"+linea);
            e.printStackTrace();
            return null;
        }

        
        
    }
} //FIN DE LA CLASE CONTACTO
