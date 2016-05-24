package gradle.cucumber;

public class Pantalla {
    private String nombre = null;

    public String saluda() {
        if (this.nombre == null) {
            return "Buenos dias";
        } else {
            return "Buenos dias " + this.nombre;
        }
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
