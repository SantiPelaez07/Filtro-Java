package entities;

public class Vacante {
    private int id;
    private String titulo;

    private String descripcion;
    private String duracion;
    private String estado;
    private int empresa_id;
    private String tecnologia;

    public Vacante(int id, String titulo, String descripcion, String duracion, String estado, int empresa_id, String tecnologia) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.estado = estado;
        this.empresa_id = empresa_id;
        this.tecnologia = tecnologia;
    }

    public Vacante(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getEmpresa_id() {
        return empresa_id;
    }

    public void setEmpresa_id(int empresa_id) {
        this.empresa_id = empresa_id;
    }

    public String getTecnologia() {
        return tecnologia;
    }

    public void setTecnologia(String tecnologia) {
        this.tecnologia = tecnologia;
    }

    @Override
    public String toString() {
        return "\nVacante\n" +
                "id: " + id +
                ", titulo: '" + titulo + '\'' +
                ", descripción: '" + descripcion + '\'' +
                ", duración: '" + duracion + '\'' +
                ", estado: '" + estado + '\'' +
                ", empresa_id: " + empresa_id +
                ", tecnología: " + tecnologia;
    }
}
