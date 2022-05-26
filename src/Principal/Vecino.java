package Principal;
import java.util.ArrayList;
import java.util.Scanner;

import Misiles_Utils.Validaciones;
import TiposPlanetas.Marisa;
import TiposPlanetas.Hierbas;
import TiposPlanetas.Emilio;
import TiposPlanetas.Belen;
import TiposPlanetas.Concha;
import TiposPlanetas.Vicenta;
import Ventanas.VentanaAtaqueDefensa;
import Ventanas.VentanaCreacionEquipos;

public abstract class Vecino {

	//atributos
	protected String nombre;
	protected int eurosPagar;
	protected int euros_ronda;
	protected int tipo;
	protected String url;

	//contructores 
	public Vecino(int eurosPagar, int euros_ronda, String nombre, String url) {
		this.eurosPagar = eurosPagar;
		this.euros_ronda = euros_ronda;
		this.nombre = nombre;
		this.url = url;
	}

	public Vecino() {	
	}

	public Vecino(int tipo) {

		this.tipo = tipo;
		
	}

	//getters y setters
	public int getEurosPagar() {
		return eurosPagar;
	}

	public void setEurosPagar(int eurosPagar) {
		this.eurosPagar = eurosPagar;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getEuros() {
		return euros_ronda;
	}

	public void  setEuros(int euros_ronda) {
		this.euros_ronda = euros_ronda;

	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	//metodos

	//funcion para comprobar los equipos que estan vivos
	public static ArrayList<Vecino> comprobarEquiposVivos(ArrayList<Vecino> vecinos) {

		//comprobamos la vida de los planetas, si no tiene vida
		for(int i = 0; i < vecinos.size(); i++) {

			//condicion para ver saber los planetas vivos
			if(vecinos.get(i).getEurosPagar() > 0) {
				//contador de equipos vivos

				//syso para que lo vea el usuario
				System.out.println(vecinos.get(i).getNombre() + ": " + vecinos.get(i).getEurosPagar() + " euros");

				//para saber que equipos estan muertos
			}else if(vecinos.get(i).getEurosPagar() <= 0) {
				//comprobacion para saber si quedan empate
				if(vecinos.size() == 2) {
					Vecino.comprobarEmpate(vecinos);
				}
				//hacemos saber al usuario cuantos equipos se han muerto
				System.out.println("El jugador " + vecinos.get(i).getNombre() + " no tiene dinero");
				//los borramos del arraylist
				vecinos.remove(i);
				
				//decrementamos i al quitar un planeta
				i--;
			}
		}
		//devolvemos el array
		return vecinos;
	}

	public static void creacionEquipos(int cantidadJugadores, int escogerVecino, String nombre, boolean repetido, ArrayList<String>  tiposVecinos, ArrayList<String> nombreJugadores, ArrayList<Vecino> vecinos, String id, ArrayList<String> idJugadores) {
		Scanner teclado = new Scanner(System.in);
		//bucle para controlar cuantos equipos jugarán
		while(cantidadJugadores < 3 || cantidadJugadores > 6) {
			//control de errores
			try {
				System.out.println("¿Cuantos jugadores van a jugar?");
				cantidadJugadores = teclado.nextInt();
				//para refrescar
				teclado.nextLine();

				if(cantidadJugadores < 3 || cantidadJugadores > 6) {
					System.out.println("Número no valido");
				}

			}catch(Exception ae) {
				System.out.println("No has introducido un numero");
				teclado.next();			
			}			
		}

		System.out.println("------------------------ \nCreando jugadores...");
		//con un for rellenamos el arraylist con los nombres de los equipos
		for(int i = 0; i < cantidadJugadores ; i++) {
			//reseteamos la variable
			escogerVecino = -1;
			//pedimos datos al usuario
			do {
				System.out.println("Nombre del jugador " + (i+1) + ":");
				//esta variable se resetea cada vez que pasa por aqui
				nombre = teclado.nextLine();

				//hacemos esta comprobacion para que no haya equipos repetidos
				if(nombreJugadores.contains(nombre)) {
					System.out.println("Nombre repetido, por favor escoja otro");	
					repetido = false;
					//si el nombre no está repetido se añadirá al array
				}else {
					//se añade al arraylist de nombres
					nombreJugadores.add(nombre);
					repetido = true;
				}	
			}while (!repetido);
			//reseteamos la variable
			repetido = false;
			
			//buclea mientras que no se seleccione una opcion valida
			while(escogerVecino < 0 || escogerVecino > 6) {
				//control de errores
				try {
					System.out.println("=====================================================");
					System.out.println("Selecciona el tipo de planeta: \n0- Planeta aleatorio: \n Se te asigna un planeta al azar \n" 
							+ "\n1- Normal: \n Sin modificaciones \n \n2- Planeta rojo: \n"
							+ "Le ataca el doble al verde \n Ataca la mitad al azul \n \n"
							+ "3- Planeta azul: \n Le ataca el doble al rojo \n Ataca la mitad al verde \n \n"
							+ "4- Planeta verde: \n Le ataca el doble al azul \n Ataca la mitad al rojo \n \n"
							+ "5- Planeta gigante: \n Tiene el doble de vida \n Empieza solo con 10 misiles, cada ronda +2 misiles \n \n"
							+ "6- Planeta enano: \n Mitad de vida \n Probabilidad de esquivar cada misil de 50%");
					System.out.println("=====================================================");
					//hacemos que el usuario introduzca el numero
					escogerVecino = teclado.nextInt();
					//para refrescar
					teclado.nextLine();

					if(escogerVecino < 0 || escogerVecino > 6) {
						//notificamos al usuario
						System.out.println("Número incorrecto");
					}

				}catch(Exception ae){
					System.out.println("No has introducido un numero");
					teclado.next();
				}	
			}
			//si escoge el planeta aleatorio, se le asigna uno
			if(escogerVecino == 0) {
				escogerVecino = (int) Math.floor(Math.random()*(6)+1);
			}
			
			//pedimos datos al usuario
			do {
				//llamamos al metodo para poner un identificador a cada planeta	
				id = Validaciones.identificador(idJugadores);

				//hacemos esta comprobacion para que no haya equipos repetidos
				if(idJugadores.contains(id)) {
					System.out.println("ID repetido, por favor escoja otro");	
					repetido = false;
					//si el id no está repetido se añadirá al array
				}else {
					//se añade al arraylist de nombres
					idJugadores.add(id);
					repetido = true;
				}	
			}while (!repetido);
			//reseteamos la variable
			repetido = false;
			
			//concatenamos el nombre  con el tipo de planeta
			nombre = nombre + tiposVecinos.get(escogerVecino);

			//tipos de planetas
			if(escogerVecino == 1) {
				//instanciamos un objeto 
				Belen vecino = new Belen(nombre, id);
				vecinos.add(vecino);	
			}else if(escogerVecino == 2) {
				Concha vecino = new Concha(nombre, id);
				vecinos.add(vecino);			
			}else if(escogerVecino == 3) {
				Marisa vecino = new Marisa(nombre, id);
				vecinos.add(vecino);	
			}else if(escogerVecino == 4) {
				Vicenta vecino = new Vicenta(nombre, id);
				vecinos.add(vecino);	
			}else if(escogerVecino == 5) {
				Emilio vecino = new Emilio(nombre, id);
				vecinos.add(vecino);	
			}else if(escogerVecino == 6) {
				Hierbas vecino = new Hierbas(nombre, id);
				vecinos.add(vecino);				
			}								
		}
		//hacemos un for para mostrar la vida que tienen los equipos
		for(int x = 0; x < cantidadJugadores; x++) {
			System.out.println( vecinos.get(x).getNombre() + " " + vecinos.get(x).getEurosPagar() + " vidas.");
		}

		System.out.println("------------------------");
	}

	public static String defensa (int eurosGuardar, ArrayList<Vecino> vecinos, int jugadorActual) {
		Scanner teclado = new Scanner(System.in);	
		Vecino defendido =  vecinos.get(jugadorActual);
		String defensaAtaque ="";

		//restamos los misiles y lo setteamos
		defendido.setEuros(defendido.getEuros()- eurosGuardar);

		//le sumamos la vida de los misiles con los que se defiende
		defendido.setEurosPagar(vecinos.get(jugadorActual).getEurosPagar()+(eurosGuardar /2));

		//le hacemos saber cuantos misiles le quedan
		System.out.println("Euros restantes: " + vecinos.get(jugadorActual).getEuros());

		//vamos a recoger en un string con cuantos msiles se defiende cada equipo
		defensaAtaque = defensaAtaque + ("El jugador " + vecinos.get(jugadorActual).getNombre() + " se ha guardado " + eurosGuardar + " euros \n");
		return defensaAtaque;
	}
	//funcion por si quedan empate
	public static void comprobarEmpate(ArrayList<Vecino> vecinos) {
		//recorremos el arraaylist para comprobar empate
		//condicion para saber si ha ganado el primer jugador en el array
		if(vecinos.size() == 2 && vecinos.get(0).getEurosPagar() <=0 && vecinos.get(1).getEurosPagar() <=0) {

			if(vecinos.get(0).getEurosPagar() < vecinos.get(1).getEurosPagar()) {
				//mostramos resultados
				System.out.println("¡Os habeis robado a la vez! ha ganado " + vecinos.get(1).getNombre());
				System.out.println("Euros de " + vecinos.get(0).getNombre() + ":" + vecinos.get(0).getEurosPagar() + "\n" + "Euros de " + vecinos.get(1).getNombre() + ":" + vecinos.get(1).getEurosPagar());
				//pasamos el ganador a la funcion para que se guarde en el fichero
				FinPartida.fichero(vecinos.get(1).getNombre());
				
				//pueden empatar por completo
			}else if(vecinos.get(0).getEurosPagar() == vecinos.get(1).getEurosPagar()){
				System.out.println("¡Habeis empatado!");
				System.out.println("Euros de " + vecinos.get(0).getNombre()  + ":" + vecinos.get(0).getEurosPagar() + "\n" + "Euros de " + vecinos.get(1).getNombre()  + ":" + vecinos.get(1).getEurosPagar());
				FinPartida.fichero(vecinos.get(0).getNombre()  + " y " + vecinos.get(1).getNombre() + " han empatado por completo");
				
				//ha ganado el equipo en la segunda posicion del arraylist
			}else if(vecinos.get(0).getEurosPagar() > vecinos.get(1).getEurosPagar()) {
				System.out.println("¡Os habeis robado a la vez! ha ganado " + vecinos.get(0).getNombre());
				//pasamos el ganador a la funcion para que se guarde en el fichero
				FinPartida.fichero(vecinos.get(0).getNombre());
				
				System.out.println("Euros de " + vecinos.get(0).getNombre() + ": " + vecinos.get(0).getEurosPagar() + ":\n" + "Euros de " + vecinos.get(1).getNombre() + ": " + vecinos.get(1).getEurosPagar());
			}
		}
	}

	public static void dado(int contRondas, ArrayList<Vecino> vecinos) {
		Scanner teclado = new Scanner(System.in);
		//cada 4 rondas se hará esta funcion
		if(contRondas % 4 == 0) {
			//declaramos el array para rellenar con las apuestas de los usuarios
			int apuestasJugadores []  = new int [vecinos.size()];
			//hacemos la funcion math random para el dado
			int randomDado = (int) Math.floor(Math.random()*(6)+1);
			//variable para contador para el array de apuestas
			int contApuestas = 0;
			//contador por si nadie acierta el dado
			int contSinGanador = 0;
			//hacemos saber al usuario que se lanzó un dado
			System.out.println("Se ha lanzado un dado, ¡adivinad el numero para 20 misiles extra!");
			//hacemos un for para saber los planetas que estan vivos
			for(int i = 0; i < vecinos.size(); i++) {
				//solo podran apostar los equipos vivos
				if(vecinos.get(i).getEurosPagar() > 0 ) {
					//si el equipo está vivo, podrá apostar

					//control de errores
					do {
						try {
							System.out.println("Jugador " + (vecinos.get(contApuestas).getNombre()) +  " ¿Cual es tu apuesta?");
							apuestasJugadores[contApuestas] = teclado.nextInt();							

						}catch(Exception e) {
							System.out.println("No has introducido un número");
							teclado.next();
						}

						if(apuestasJugadores[contApuestas] <= 0 || apuestasJugadores[contApuestas] > 6) {
							System.out.println("Numero no valido");	
						}
						//condicion, numeros del dado
					}while(apuestasJugadores[contApuestas] <= 0 || apuestasJugadores[contApuestas] > 6);

					//incrementamos el contador de apuestas
					contApuestas++;
					//si un equipo está muerto, se rellena con un 0
				}
			}
			System.out.println("El número del dado es: |" + randomDado + "|");
			//hacemos un for para notificar al usuario los ganadores y para sumar los misiles correspondientes
			for(int x = 0; x < apuestasJugadores.length; x++ ) {
				//si aciertan el numero del dado...
				if(apuestasJugadores[x] == randomDado) {
					//hacemos saber a quien ganó que se le suman misiles
					System.out.println("Jugador " + (vecinos.get(x).getNombre()) + " has recibido 20 euros extra");

					//sumamos los misiles en el array
					vecinos.get(x).setEuros(vecinos.get(x).getEuros()+20);

					//condicion por si no coincide con el numero del dado
				}else if(apuestasJugadores[x] != randomDado) {
					//incrementamos contador
					contSinGanador++;
				}
				//si nadie acierta, se hacer saber a los equipos
				if(contSinGanador == vecinos.size()) {
					System.out.println("¡Ningun jugador ha acertado el número!");
				}
			}
		}
	}
	public static void reiniciarEuros (ArrayList<Vecino> vecinos, int contRondas) {

		//recorremos con un for el arraylist
		for(Vecino vecino : vecinos) {

			// si es un planeta gigante
			if(vecino instanceof Emilio) {
				Emilio p1 = (Emilio)vecino;

				p1.setEuros(10 + (2 * (contRondas + 1)));
				
				//resto de planetas
			}else {
				vecino.setEuros(50);
			}

		}
	}
	
	public abstract String ataque(int euros, Vecino vecino);
}


