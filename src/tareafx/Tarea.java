package tareafx;

public class Tarea {

    private String nombre;
    private boolean completo;

    // Constructor que acepta solo el nombre de la tarea
    public Tarea(String nombre) {
        this.nombre = nombre;
        this.completo = false;  // Por defecto, la tarea no está completada
    }
    public Tarea() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isCompleto() {
        return completo;
    }

    public void setCompleto(boolean completo) {
        this.completo = completo;
    }
    
       @Override
    public String toString() {
        return nombre + (completo ? " (Completada)" : "");
    }
    

}
