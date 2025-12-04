package paqContactos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ContactoArchivoDAO {
    private String rutaArchivo;

    public ContactoArchivoDAO(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }
    
    public List<Contacto> leerContactos() throws IOException{
        List<Contacto> lista = new ArrayList<>();
        File file = new File(rutaArchivo); 
        if(!file.exists()){
            file.getParentFile().mkdir();
            file.createNewFile();
            return lista;
        }
        
        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            String linea;
            while((linea = br.readLine()) != null){
                Contacto c = Contacto.desdeLineaArchivo(linea);
                if(c != null){
                    lista.add(c);
                }
            }
            
        }
        return lista;
    } //Fin del metodo leer contactos
    
}// Fin de la clase
