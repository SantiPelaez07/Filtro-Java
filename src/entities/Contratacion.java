package entities;

public class Contratacion {

private int id;
private String fecha_aplicacion;
private String estado;
private double salario;
private int vacante_id;
private int coder_id;

    public Contratacion(int id, String fecha_aplicacion, String estado, double salario, int vacante_id, int coder_id) {
        this.id = id;
        this.fecha_aplicacion = fecha_aplicacion;
        this.estado = estado;
        this.salario = salario;
        this.vacante_id = vacante_id;
        this.coder_id = coder_id;
    }

    public Contratacion(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha_aplicacion() {
        return fecha_aplicacion;
    }

    public void setFecha_aplicacion(String fecha_aplicacion) {
        this.fecha_aplicacion = fecha_aplicacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getVacante_id() {
        return vacante_id;
    }

    public void setVacante_id(int vacante_id) {
        this.vacante_id = vacante_id;
    }

    public int getCoder_id() {
        return coder_id;
    }

    public void setCoder_id(int coder_id) {
        this.coder_id = coder_id;
    }

    @Override
    public String toString() {
        return "Contratación\n" +
                "id: " + id +
                ", fecha de aplicación: '" + fecha_aplicacion + '\'' +
                ", estado: '" + estado + '\'' +
                ", salario: " + salario +
                ", vacante_id: " + vacante_id +
                ", coder_id:" + coder_id +
                '}';
    }
}
