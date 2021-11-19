import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;

public class Persona {
    private String nombre;
    private int dni;
    private String sexo;

    public Persona() {
    }

    public Persona(String nombre, int dni, String sexo) {
        this.nombre = nombre;
        this.dni = dni;
        this.sexo = sexo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDni(int dni) {
        return this.dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public JSONObject crearJson() {
        JSONObject objeto = new JSONObject();
        objeto.put("nombre", this.nombre);
        objeto.put("dni", this.dni);
        objeto.put("sexo", this.sexo);
        return objeto;
    }

    public static Persona reconstruir(JSONObject obj){
        Persona persona= new Persona();
        persona.nombre= obj.get("nombre").toString();
        persona.dni= (int)(long)obj.get("dni");
        persona.sexo= obj.get("sexo").toString();
        return persona;

    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Persona{");
        sb.append("nombre='").append(nombre).append('\'');
        sb.append(", dni=").append(dni);
        sb.append(", sexo='").append(sexo).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
