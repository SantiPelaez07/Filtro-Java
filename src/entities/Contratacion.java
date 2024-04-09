package entities;

public class Contratacion {
private Vacante vacante;
private String nombre_empresa;
private String ubicacion_empresa;
private Coder coder;
private int id;
private String fecha_aplicacion;
private String estado;
private double salario;
private int vacante_id;
private int coder_id;

    public Contratacion(Vacante vacante, String nombre_empresa, String ubicacion_empresa, Coder coder, int id, String fecha_aplicacion, String estado, double salario, int vacante_id, int coder_id) {
        this.vacante = vacante;
        this.nombre_empresa = nombre_empresa;
        this.ubicacion_empresa = ubicacion_empresa;
        this.coder = coder;
        this.id = id;
        this.fecha_aplicacion = fecha_aplicacion;
        this.estado = estado;
        this.salario = salario;
        this.vacante_id = vacante_id;
        this.coder_id = coder_id;
    }

    public String getNombre_empresa() {
        return nombre_empresa;
    }

    public void setNombre_empresa(String nombre_empresa) {
        this.nombre_empresa = nombre_empresa;
    }

    public String getUbicacion_empresa() {
        return ubicacion_empresa;
    }

    public void setUbicacion_empresa(String ubicacion_empresa) {
        this.ubicacion_empresa = ubicacion_empresa;
    }

    public Vacante getVacante() {
        return vacante;
    }

    public void setVacante(Vacante vacante) {
        this.vacante = vacante;
    }

    public Coder getCoder() {
        return coder;
    }

    public void setCoder(Coder coder) {
        this.coder = coder;
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
        return "\nContratación\n" +
                "id: " + id +
                ", fecha de aplicación: '" + fecha_aplicacion + '\'' +
                ", estado: '" + estado + '\'' +
                ", salario: " + salario +
                ", vacante_id: " + vacante_id +
                ", coder_id:" + coder_id;
    }

    public String toStringEdit() {
        return "\nContratación\n" +
                "Titulo: " + vacante.getTitulo() + ", " +
                "descripción: '" + vacante.getDescripcion() + ", " +
                "empresa: " + nombre_empresa + ", " +
                "ubicación de la empresa: " + ubicacion_empresa + "\n" +
                "Nombre del coder: " + coder.getNombre() + ", " +
                "apellidos: " + coder.getApellidos() + ", " +
                "documento de identificación: " + coder.getDocumento() + ", " +
                "tecnología: " + coder.getCv();
    }
}
