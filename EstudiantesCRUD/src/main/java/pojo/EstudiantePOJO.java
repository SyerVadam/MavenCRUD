
package pojo;

public class EstudiantePOJO {
    
    private int idEstudiante;
    private String primerNombre;
    private String segundoNombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private boolean estaAprobado;

    public EstudiantePOJO() {
    }

    public EstudiantePOJO(int idEstudiante, String primerNombre, String segundoNombre, String apellidoPaterno, String apellidoMaterno, boolean estaAprobado) {
        this.idEstudiante = idEstudiante;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.estaAprobado = estaAprobado;
    }

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public boolean isEstaAprobado() {
        return estaAprobado;
    }

    public void setEstaAprobado(boolean estaAprobado) {
        this.estaAprobado = estaAprobado;
    }
    
    
}