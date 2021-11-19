
import jdk.swing.interop.SwingInterOpUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.sound.midi.spi.SoundbankReader;
import java.io.*;
;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException, IOException {
      /*  Persona persona1= new Persona("camilo",101112, "M");
        Persona persona2= new Persona("lucia",789, "F");
        Persona persona3= new Persona("mateo",456, "M");
        Persona persona4= new Persona("rosa",1234, "F");

        JSONArray array =new JSONArray();
        array.add(persona1.crearJson());
        array.add(persona2.crearJson());
        array.add(persona3.crearJson());
        array.add(persona4.crearJson());

        try {
            escribirObjeto(crearJson(array,"Personas"),"prueba");
        } catch (IOException e) {
            e.printStackTrace();
        }
*/
        Persona persona = Persona.reconstruir(objFinal(2,"Personas",objArray("prueba")));
        System.out.println(persona);

    }
    //obtiene un objeto desde un archivo.json

    public static JSONObject objArray(String nombreArchivo) throws IOException, ParseException {

        FileReader reader = new FileReader(nombreArchivo + ".json");
        JSONParser parser = new JSONParser();
        JSONObject obj = (JSONObject) parser.parse(reader);
        reader.close();
        return obj;
    }
    //retorna el objeto que se encuentra en una posicion de un array
        public static JSONObject objFinal( int pos, String nombreObj, JSONObject obj){

        JSONArray miArray = (JSONArray) obj.get(nombreObj);
        JSONObject otro = (JSONObject) miArray.get(pos);
        return otro;
    }

//crea un obj con un array
    public static JSONObject crearJson(JSONArray array, String nombre) {
        JSONObject objeto = new JSONObject();
        objeto.put(nombre, array);
        return objeto;
    }
// escribe el objeto en el archivo
    public static void escribirObjeto(JSONObject objeto, String nombre) throws IOException {
        PrintWriter printWriter = new PrintWriter(new FileWriter(nombre + ".json"));
        printWriter.println(objeto);
        printWriter.flush();
        printWriter.close();
    }
}

