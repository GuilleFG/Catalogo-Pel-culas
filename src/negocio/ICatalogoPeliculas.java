package negocio;

public interface ICatalogoPeliculas {
	
	String NOMBRE_ARCHIVO = "peliculas.txt";
	
	void agregarPelicula(String nombrePelicula);
	
	void listarPelicula();

	void buscarPelicula(String buscar);
	
	void iniciarCatalogoPeliculas();
	
	

}
