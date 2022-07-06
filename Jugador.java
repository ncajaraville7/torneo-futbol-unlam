package ar.edu.unlam.pb1.parcial2;

public class Jugador {

	private int numero;
	private String nombre;
	private int edad;
	private double precio;
	
	public Jugador(int numero, String nombre, int edad, double precio) {
		this.nombre = nombre;
		this.numero = numero;
		this.edad = edad;
		this.precio = precio;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public String toString() {
		String LoQueQuieroMostrarDelJugador ="";
		LoQueQuieroMostrarDelJugador = "El jugador se llama " + nombre + " y utiliza el número " + numero;
		return LoQueQuieroMostrarDelJugador;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
}
