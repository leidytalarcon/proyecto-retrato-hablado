
package archivos.texto;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import pojo.Rasgo;

/**
 *
 * @author Leidy Alarcon Y Andres Acosta
 */


public class Ficheros {

    public Ficheros() {
        //Siempre que se llame la clase, se valida si el archivo ya esta creado
        validarArchivoRasgos();
    }

    //ruta del archivo
    private String rutaLista = "listaRasgos.txt";

    private void validarArchivoRasgos() {
        try {

            File file = new File(rutaLista);

            //valida si el archivo no existe
            if (!file.exists()) {
                
                //crear el archivo vacio
                file.createNewFile();
                //obtiene la lista de datos a guardar
                PrecargarLista precarga = new PrecargarLista();
                List<Rasgo> rasgos = precarga.cargarLista();
                //guarda la lista de datos
                escribirRasgos(rasgos);

            }
        } catch (Exception e) {
            System.out.println(e.getMessage()+" validar");
        }

    }

    public void escribirRasgos(List<Rasgo> rasgos) {
        try {
            //crear un objeto de escritura
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(rutaLista));
            for (Rasgo rasgo : rasgos) {
                //escribe cada objeto de la lista
                oos.writeObject(rasgo);
            }
            //cierra el objeto de escritura
            oos.close();
        } catch (Exception e) {
            System.out.println(e.getMessage()+" escribir");
        } 
          
    }

    public List<Rasgo> LeerRasgos() {
        List<Rasgo> rasgos = new ArrayList<Rasgo>();
        
        try {
            //crea un objeto de lectura de archivos
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(rutaLista));
            Object aux = ois.readObject();

            // Mientras haya objetos
            while (aux != null) {
                //valda que el objeto pueda convertirse a Rasgo
                if (aux instanceof Rasgo) {
                    Rasgo rasgo = new Rasgo();
                    rasgo = (Rasgo)aux;
                    //guarda cada objeto leido en la lista
                    rasgos.add(rasgo);
                }
                
                    aux = ois.readObject();
                
            }
            //cierra el objeto de lectura
            ois.close();

        } catch (Exception e) {
            //System.out.println(e+" leer");
            
        }
        return rasgos;
    }

   
}
