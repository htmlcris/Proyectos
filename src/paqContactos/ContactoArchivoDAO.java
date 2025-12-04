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
            file.getParentFile().mkdirs();
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
    
    public void guardarContactos(List<Contacto> lista) throws IOException{
        File file = new File(rutaArchivo);
        file.getParentFile().mkdirs();
        
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(file))){
            for(Contacto c : lista){
                bw.write(c.toLineaArchivo());
                bw.newLine();
            }
        }
    }
}// Fin de la clase
