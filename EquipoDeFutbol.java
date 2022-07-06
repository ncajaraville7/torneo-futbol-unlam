package ar.edu.unlam.pb1.parcial2;

public class EquipoDeFutbol {
	private String nombre;
	private Jugador jugadores[];
	private final int CANTIDAD_MAXIMA_DE_JUGADORES_POR_EQUIPO = 5;
	
	public EquipoDeFutbol(String nombre) {
		this.nombre = nombre;
		jugadores = new Jugador[CANTIDAD_MAXIMA_DE_JUGADORES_POR_EQUIPO];  
	}

	/*
	 * La capacidad máxima de un equipo es 5. No se permiten jugadores repetidos (ya sea el número o nombre del jugador)
	 * Se retorna el resultado de la operación
	 */
	public boolean agregarJugador(Jugador nuevo) {
		for(int i = 0; i<CANTIDAD_MAXIMA_DE_JUGADORES_POR_EQUIPO; i++) {
			if(jugadores[i]!=null && (jugadores[i].getNombre().equals(nuevo.getNombre()) || jugadores[i].getNumero()== nuevo.getNumero())) {
				return false;
			}
			if (jugadores[i]==null) {
				jugadores[i] = nuevo;
				return true;
			}
		}
		return false;
	}
	
	/*
	 * Permite buscar un jugador por su numero. 
	 * 
	 */
	public Jugador buscar(int numero) {
		for(int i = 0; i<jugadores.length; i++) {
			if(jugadores[i] != null && jugadores[i].getNumero() == numero) {
				return jugadores[i];
			}
		}
		return null;
	}
	
	/*
	 * Permite buscar un jugador por su nombre. 
	 * 
	 */
	public Jugador buscar(String nombre) {
		for(int i = 0; i<jugadores.length; i++) {
			if(jugadores[i] != null && jugadores[i].getNombre().equals(nombre)) {
				return jugadores[i];
			}
		}
		return null;
	}
	
	/*
	 * Calcula el valor del equipo. 
	 * 
	 */
	public double calcularLaEdadPromedioDelEquipo() {
		double laEdadPromedioDeMiEquipo = 0.0;
		int contadorDeJugadores=0;
		for(int i = 0; i<jugadores.length; i++) {
			if(jugadores[i] != null) {
				laEdadPromedioDeMiEquipo += jugadores[i].getEdad();
				contadorDeJugadores++;
				}
			}
		return (laEdadPromedioDeMiEquipo/contadorDeJugadores);
	}
	
	/*
	 * Calcula el valor del equipo
	 * 
	 */
	public double calcularElValorDelEquipo() {
		double elValorDelEquipo = 0.0;
		int contadorDeJugadores=0;
		for(int i = 0; i<jugadores.length; i++) {
			if(jugadores[i] != null) {
				elValorDelEquipo += jugadores[i].getPrecio();
				contadorDeJugadores++;
				}
			}
		return (elValorDelEquipo/contadorDeJugadores);
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public String toString() {
		return this.nombre;
	}
	
}
