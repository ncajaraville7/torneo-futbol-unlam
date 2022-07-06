package ar.edu.unlam.pb1.parcial2;

public class PartidoDeFutbol {
	private EquipoDeFutbol local;
	private EquipoDeFutbol visitante;
	private Evento goles[];
	private Evento amontestados[];
	private Evento expulsados[];
	private int golesVisitante;
	private int golesLocal;
	private final int CANTIDAD_MAXIMA_GOLES_POR_PARTIDO = 100;
	private final int CANTIDAD_MAXIMA_DE_JUGADORES = 10;
	private final int CANTIDAD_MAXIMA_DE_AMONESTACIONES = 20;
	
	public PartidoDeFutbol(EquipoDeFutbol local, EquipoDeFutbol visitante) {
		this.local = local;
		this.visitante = visitante;
		goles = new Evento[CANTIDAD_MAXIMA_GOLES_POR_PARTIDO];
		amontestados = new Evento [CANTIDAD_MAXIMA_DE_AMONESTACIONES];
		expulsados = new Evento[CANTIDAD_MAXIMA_DE_JUGADORES];
		golesLocal =0;
		golesVisitante = 0;
	}
	
	/*
	 * Se debe marcar un nuevo Gol 
	 * Dependiendo del autor (según al equipo que pertenezca) y del tipo (si es a favor o en contra) se sabrá a quien contabilizarlo
	 */
	public void marcar(Evento gol) {
		boolean seGuardoElGol = false;
		
		for(int i=0; i<goles.length; i++) {
			if(goles[i]==null) {
				if(seGuardoElGol == false) {
				goles[i]=gol;
				seGuardoElGol = true;
				if((local.buscar(goles[i].getAutor().getNumero()) != null && goles[i].getTipo()==TipoDeEvento.GOL_A_FAVOR) || (visitante.buscar(goles[i].getAutor().getNumero()) != null && goles[i].getTipo()==TipoDeEvento.GOL_EN_CONTRA)) {
					golesLocal++;
					} else if((local.buscar(goles[i].getAutor().getNumero()) != null && goles[i].getTipo()==TipoDeEvento.GOL_EN_CONTRA) ||(visitante.buscar(goles[i].getAutor().getNumero()) != null && goles[i].getTipo()==TipoDeEvento.GOL_A_FAVOR)) {
					golesVisitante++;
				}
			}

			}

		}
	}
//	}
		
		
	
	/*
	 * Se registra un nuevo amonestado en el partido. 
	 * Si el mismo ya poseía una amonestación previa, se lo debe expulsar. 
	 * El método devuelve la cantidad de amonestaciones del jugador. 
	 * Los valores posibles de retorno son:
	 * 1 - Si no tenía amonestación previa o 
	 * 2 - Si ya poseía una amonestación previa y termina siendo expulsado
	 * 
	 */
	public int amonestar(Evento amonestado) {
		boolean seAmonesto = false;
		boolean habiaSidoAmonestado =false;
		int cantidadDeAmonestaciones = 0;
		for(int i=0; i<amontestados.length;i++) {
			if(amontestados[i] != null) {
				if(seAmonesto==false) {
					if(expulsados[i] != null) {
						if((amonestado.getAutor().getNumero()==expulsados[i].getAutor().getNumero())) {
								return cantidadDeAmonestaciones=9;
						}
						}
				if(amontestados[i] != null && (amontestados[i].getAutor().getNumero()==amonestado.getAutor().getNumero())) {
					habiaSidoAmonestado=true;
					cantidadDeAmonestaciones++;
					expulsados[i] = amonestado;
					}
				}
			} 
			else if(amontestados[i] == null ) {
				if(seAmonesto == false) {
					if(expulsados[i] != null) {
						if((amonestado.getAutor().getNumero()==expulsados[i].getAutor().getNumero())) {
							return cantidadDeAmonestaciones=9;
					}
				}
				amontestados[i] = amonestado;
				cantidadDeAmonestaciones++;
				seAmonesto = true;
				}
			} 
		}
		return cantidadDeAmonestaciones;
	}
	
	/*
	 * Se registra un nuevo expulsado en el partido. 
	 */
	public void expulsar(Evento expulsado) {
		boolean seExpulso = false;
		for(int i=0; i<expulsados.length; i++) {
			if(expulsados[i] != null) {
				if(seExpulso == false) {
					if(expulsados[i].getAutor().getNumero()==expulsado.getAutor().getNumero()) {
						seExpulso = true;
					}
				}
			}else if(expulsados[i] == null) {
				if(seExpulso == false) {
					expulsados[i] = expulsado;
					seExpulso = true;
				}
			}
		}

	}
	
	/*
	 * Se cuentan la cantidad de goles por equipo (Se debe considerar si el gol resultó a favor o en contra), y devuelve el equipo ganador (Si hubo un empate retorna null) 
	 */
	public EquipoDeFutbol getGanador() {
		if(golesLocal>golesVisitante) {
			return local;
		}else if(golesLocal<golesVisitante) {
			return visitante;
		}
		return null;
	}
	
	/*
	 * El método toString debe describir el ESTADO del partido (Equipos que se enfrentan, los goles realizados, los amonestado y expulsados).
	 */
	public String toString() {
		String ganador = "" + (visitante.buscar(goles[0].getAutor().getNumero()));
		String resultado = "";
		String todosLosGoles = "Los goles fueron realizados por: ";
		String todosLosAmonestados = "\nLos amonestados fueron:";
		String todosLosExpulsados = "\n Los expulsados fueron: ";
		resultado += ("Los equipos que se enfrentan son " + local + " como local que hizo " + golesLocal + " goles, y el equipo " + visitante + " como visitante que hizo " + golesVisitante + " goles.\n");
	if(getGanador()==null) {
			ganador = "empate";
		}else {
			ganador = getGanador().getNombre();
		}
		resultado += "Quien ganó el partido es " + ganador + ".\n";
		
		for(int i=0; i<goles.length;i++) {
			if(goles[i]!=null) {
				todosLosGoles += goles[i].getAutor().getNombre() + " en el minuto: " +goles[i].getMinuto() + ", ";
			}
		}
		resultado += todosLosGoles;
		
		for(int i=0; i<amontestados.length;i++) {
			if(amontestados[i]!=null) {
				todosLosAmonestados += amontestados[i].getAutor().getNombre() + " en el minuto: " +amontestados[i].getMinuto() + ", ";
			}
		}
		resultado += todosLosAmonestados;
		
		for(int i=0; i<expulsados.length;i++) {
			if(expulsados[i]!=null) {
				todosLosExpulsados += expulsados[i].getAutor().getNombre() + ", ";
			}
		}
		resultado += todosLosExpulsados;
	
		return resultado ;
		
		
	}

	public EquipoDeFutbol getLocal() {
		return local;
	}

	public EquipoDeFutbol getVisitante() {
		return visitante;
	}

}
