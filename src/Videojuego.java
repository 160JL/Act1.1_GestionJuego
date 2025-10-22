public class Videojuego {
    private String titulo;
    private String genero;
    private String plataforma;
    private int year;
    private int valoracion;
    private int ID;

    public Videojuego(String titulo, String genero, String plataforma, int year, int valoracion, int ID) {
        this.titulo = titulo;
        this.genero = genero;
        this.plataforma = plataforma;
        this.year = year;
        this.valoracion = valoracion;
        this.ID = ID;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getGenero() {
        return genero;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public int getYear() {
        return year;
    }

    public int getValoracion() {
        return valoracion;
    }

    public int getID() {
        return ID;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setValoracion(int valoracion) {
        this.valoracion = valoracion;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    @Override
    public String toString() {
        return ("\n Título: " + this.titulo
        + "\n Género: " + this.genero
        + "\n Plataforma: " + this.plataforma
        + "\n Año: " + this.year
        + "\n Valoración: " + this.valoracion
        + "\n ID: " + this.ID);
    }
}
