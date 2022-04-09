package negocio;

import datos.AccesoDatos;
import datos.IAccesoDatos;
import domain.Pelicula;
import excepciones.AccesoDatosEx;
import excepciones.LecturaDatosEx;

public class CatalogoPeliculasImpl implements ICatalogoPeliculas {

	private final IAccesoDatos datos;

	public CatalogoPeliculasImpl() {

		this.datos = new AccesoDatos();
	}

	@Override
	public void agregarPelicula(String nombrePelicula) {
		Pelicula pelicula = new Pelicula(nombrePelicula);
		boolean anexar = false;
		try {
			anexar = datos.existe(NOMBRE_ARCHIVO);
			datos.escribir(pelicula, NOMBRE_ARCHIVO, anexar);
		} catch (AccesoDatosEx e) {
			System.out.println("Error de acceso a datos");
			e.printStackTrace();
		}
	}

	@Override
	public void buscarPelicula(String buscar) {
		String resultado = null;
		try {
			resultado = this.datos.buscar(NOMBRE_ARCHIVO, buscar);
		} catch (LecturaDatosEx e) {
			System.out.println("Error de acceso datos");
			e.printStackTrace();
		}
		System.out.println("resultado = " + resultado);

	}

	@Override
	public void iniciarCatalogoPeliculas() {
		try {
			if (this.datos.existe(NOMBRE_ARCHIVO)) {
				datos.borrar(NOMBRE_ARCHIVO);
				datos.crear(NOMBRE_ARCHIVO);

			} else {
				datos.crear(NOMBRE_ARCHIVO);

			}
		} catch (AccesoDatosEx e) {
			e.printStackTrace();
		}

	}

	@Override
	public void listarPelicula() {
		try {
			var peliculas = this.datos.listar(NOMBRE_ARCHIVO);
			for (var pelicula : peliculas) {
				System.out.println("pelicula: " + pelicula);
			}
		} catch (AccesoDatosEx e) {
			System.out.println("Error acceso datos");
			e.printStackTrace();
		}
	}

}
