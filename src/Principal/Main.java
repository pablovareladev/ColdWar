package Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import TiposPlanetas.Marisa;
import TiposPlanetas.Vicenta;
import Ventanas.VentanaPrincipal;

public class Main {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		VentanaPrincipal VentanaPrincipal = new VentanaPrincipal();
		
			
		//Variables
		int opcionesMenu = -1;

		do {
			//Menu
			do {
				try {
					System.out.println("Bienvenido/a al ColdWar. ¿Que quieres hacer? \n1-Jugar \n2-Reglas del juego \n3-Información \n4-Mostrar ganadores \n0-Salir");
					opcionesMenu = teclado.nextInt();
					teclado.nextLine();

				}catch(Exception e) {
					System.out.println("No introduciste un numero");
					teclado.next();
				}

				if(opcionesMenu < 0 || opcionesMenu > 4) {
					//notificamos al usuario
					System.out.println("¡Esa opcion no es valida!");
				}
			}while(opcionesMenu > 4 || opcionesMenu <0);

			switch (opcionesMenu) {

			case 1:
				System.out.println("Has entrado en Jugar:");
				//iniciamos una boolean para comprobar errores
				boolean repetido = false;
				//arrayList de objetos Planeta
				ArrayList<Vecino> vecinos = new ArrayList<Vecino>();
				//declaramos Un arraylist de strings con los nombres de los equipos
				ArrayList<String> nombreJugadores = new ArrayList<String>();
				//declaramos Un arraylist de strings con los id de los equipos
				ArrayList<String> idJugadores = new ArrayList<String>();
				//declaramos Un arraylist de strings con los nombres de los equipos... la primera posicion nunca se podrá escoger porque 
				//tiene asignada otra
				ArrayList<String> tiposVecinos = new ArrayList<String>(Arrays.asList("", " (Normal)", " (Planeta rojo)", 
						" (Planeta azul)",  " (Planeta verde)",  " (Planeta gigante)",   " (Planeta enano)"));
				//String para los nombres de los equipos
				String nombre = "";
				//variable para mostrar el numero correspondiente para cada equipo
				int numeroJugador = 0;
				//variable contador para cuando juega cada equipo
				int jugadorActual = 0;
				//variable para saber que quiere hacer el usuario
				int opciones = -1;
				//variable para misiles de defensa y ataque
				int eurosGuardar = -1;
				int eurosAtaque = -1; 
				//contador de rondas para diferentes funciones
				int contRondas = 0;
				//para imprimir los resultados al final de los ataques y defensas de equipos
				String defensaAtaque = "";
				//para saber cuantos equipos van a jugar
				int cantidadJugadores = 0;
				//variable para escoger planeta
				int escogerVecino = -1;
				//identificador de planeta
				String id = "";

				Vecino.creacionEquipos(cantidadJugadores, escogerVecino, nombre, repetido, tiposVecinos, nombreJugadores, vecinos, id, idJugadores);

				//hacemos un do para que vaya mostrando los turnos equipos
				do {
					System.out.println("Turno de ataque del equipo: " + vecinos.get(jugadorActual).getNombre() + "\n -------------------------------");

					//reseteamos la variable
					numeroJugador = 0;
					//hacemos una arraylist para que muestre los equipos de forma dinamica
					ArrayList<Vecino> planetasAtacados = new ArrayList<Vecino>();
					//se añade un planeta vacio en la primera posicion del array
					planetasAtacados.add(new Vicenta("", nombre));

					//en este for se muestran los equipos a atacar
					for(int x = 0; x < vecinos.size(); x++) {

						//mostramos los nombres de los equipos
						if(x != jugadorActual) {
							System.out.println((numeroJugador+1) + " " + vecinos.get(x).getNombre());
							numeroJugador++;
							//añadimos los equipos al arraylist
							planetasAtacados.add(vecinos.get(x));
						}
					}
					System.out.println("0. Misiles de defensa \n" + "------------------------------- \n" + "Misiles disponibles: " + vecinos.get(jugadorActual).getEuros());
					//Le preguntamos al usuario que quiere hacer, si quiere atacar, a quien o defenderse
					//hacemos tambien control de errores

					do {
						//reseteamos la variable cada vez que le toca atacar a un nuevo equipo
						opciones = -1;

						//preguntamos al usuario a quien quiere atacar
						do {
							//hacemos control de errores
							try {
								System.out.println("¿A quien quieres atacar?");
								opciones = teclado.nextInt();

							}catch(Exception ae) {
								System.out.println("No has introducido un numero");
								teclado.next();			
							}

							if(opciones < 0 || opciones > vecinos.size()-1) {
								System.out.println("Esa opcion no es valida");	
							}
							//el no puede ser menor que 0 no mayor o igual que el tamaño del arraylist
						}while(opciones >= vecinos.size() || opciones < 0);



						//si el usuario selecciona 0 entra en defensa y rellenamos el String
						if(opciones == 0) {

							//le preguntamos con cuantos misiles quiere defenderse
							do {
								//control de erroes por si mete un caracter	
								try {
									System.out.println("¿Con cuantos misiles te quieres defender?");	
									eurosGuardar = teclado.nextInt();


								}catch(Exception ae) {
									System.out.println("No has introducido un numero");
									teclado.next();
								}

								if(eurosGuardar > vecinos.get(jugadorActual).getEuros()) {
									System.out.println("Has excedido el número de misiles");
								}else if(eurosGuardar <= 0) {
									System.out.println("Numero de misiles no valido");
								}
								//aqui controlamos que no pueda usar numeros negativos o mas misiles
								//de los que tiene
							}while(eurosGuardar > vecinos.get(jugadorActual).getEuros() || eurosGuardar <= 0);

							//concatenamos los string
							defensaAtaque = defensaAtaque + Vecino.defensa(eurosGuardar, vecinos, jugadorActual);


							//si quiere atacar, entrará aqui y siempre que no se defienda y rellenamos el String
						}else if (opciones > 0 && opciones < vecinos.size()) {

							do {
								try {
									System.out.println("Introduce el numero de misiles con el que quieres atacar");
									eurosAtaque = teclado.nextInt();

								}catch(Exception ae) {
									System.out.println("No has introducido un numero");
									teclado.next();
								}
								if(eurosAtaque > vecinos.get(jugadorActual).getEuros()) {
									System.out.println("Has excedido el numero de misiles");
								}else if(eurosAtaque <= 0) {
									System.out.println("Numero de misiles no valido");
								}
								//condiciones para que no ponga numeros negativos ni mas misiles de los que tiene
							}while(eurosAtaque > vecinos.get(jugadorActual).getEuros() || eurosAtaque <= 0);

							defensaAtaque = defensaAtaque + vecinos.get(jugadorActual).ataque(eurosAtaque, planetasAtacados.get(opciones));
						}	

						//aqui controlamos que el usuario use los 50 misiles en cada ronda y 
						//que seleccione una opcion valida
					}while(opciones < 0 || opciones >= vecinos.size() || vecinos.get(jugadorActual).getEuros() != 0);

					//para jugar los turnos de los equipos
					if(vecinos.size() > jugadorActual+1) {
						jugadorActual++;

						//una vez terminen los turnos...
					}else{
						System.out.println("||Resultados de fin de ronda||");
						System.out.println(defensaAtaque);
						//reseteamos la variable al final del turno
						defensaAtaque = "";

						//le decimos a los usuarios cuantos planetas quedan vivos
						vecinos = Vecino.comprobarEquiposVivos(vecinos);
						System.out.println("Equipos vivos: " + vecinos.size());
						//sumamos al contador de rondas para el dado
						contRondas++;

						//reseteamos los misiles para que tengan los mismos en cada ronda
						Vecino.reiniciarEuros(vecinos, contRondas);

						//se lanzará el dado cuando haya al menos 2 equipos vivos
						if(vecinos.size() > 1) {
							//cada 4 rondas se tira un dado
							Vecino.dado(contRondas, vecinos);
						}

						//reseteamos el contador para que jueguen los equipos
						jugadorActual = 0;
					}
					//condicion
				}while(vecinos.size() > 1);

				//llamamos a las funciones
				FinPartida.finalizarPartida();
				FinPartida.mostrarGanador(vecinos);		
				break;
				
			case 2:
				Info.reglasJuego();
				break;
			case 3:
				Info.informacion();
				break;

			case 4:
				//ruta del fichero con los ganadores 
				String ruta = "tmp/ganadores.txt";

				FinPartida.leerFichero(ruta);
				break;
			case 0:
				System.out.println("Escogiste salir");
				break;
			}
			//nos buclea el menu hasta que entremos en jugar o salgamos
		}while(opcionesMenu != 1 && opcionesMenu != 0);
	}
}