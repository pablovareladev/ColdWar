import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
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
				ArrayList<Planeta> planetas = new ArrayList<Planeta>();
				//declaramos Un arraylist de strings con los nombres de los equipos
				ArrayList<String> nombreEquipos = new ArrayList<String>();
				//declaramos Un arraylist de strings con los nombres de los equipos... la primera posicion nunca se podrá escoger porque 
				//tiene asignada otra
				ArrayList<String> tiposPlanetas = new ArrayList<String>(Arrays.asList("", " (Normal)", " (Planeta rojo)", 
						" (Planeta azul)",  " (Planeta verde)",  " (Planeta gigante)",   " (Planeta enano)"));
				//String para los nombres de los equipos
				String nombre = "";
				//variable para mostrar el numero correspondiente para cada equipo
				int numeroEquipo = 0;
				//variable contador para cuando juega cada equipo
				int equipoActual = 0;
				//variable para saber que quiere hacer el usuario
				int opciones = -1;
				//variable para misiles de defensa y ataque
				int misilesDef = -1;
				int misilesAtaque = -1; 
				//contador de rondas para diferentes funciones
				int contRondas = 0;
				//para imprimir los resultados al final de los ataques y defensas de equipos
				String defensaAtaque = "";
				//para saber cuantos equipos van a jugar
				int cantidadEquipos = 0;
				//variable para escoger planeta
				int escogerPlaneta = -1;

				Planeta.creacionEquipos(cantidadEquipos, escogerPlaneta, nombre, repetido, tiposPlanetas, nombreEquipos, planetas);

				//hacemos un do para que vaya mostrando los turnos equipos
				do {
					System.out.println("Turno de ataque del equipo: " + planetas.get(equipoActual).getNombre() + "\n -------------------------------");

					//reseteamos la variable
					numeroEquipo = 0;
					//hacemos una arraylist para que muestre los equipos de forma dinamica
					ArrayList<Planeta> planetasAtacados = new ArrayList<Planeta>();
					//se añade un planeta vacio en la primera posicion del array
					planetasAtacados.add(new Planeta());

					//en este for se muestran los equipos a atacar
					for(int x = 0; x < planetas.size(); x++) {

						//mostramos los nombres de los equipos
						if(x != equipoActual) {
							System.out.println((numeroEquipo+1) + " " + planetas.get(x).getNombre());
							numeroEquipo++;
							//añadimos los equipos al arraylist
							planetasAtacados.add(planetas.get(x));
						}
					}
					System.out.println("0. Misiles de defensa \n" + "------------------------------- \n" + "Misiles disponibles: " + planetas.get(equipoActual).getMisiles());
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

							if(opciones < 0 || opciones > planetas.size()-1) {
								System.out.println("Esa opcion no es valida");	
							}
							//el no puede ser menor que 0 no mayor o igual que el tamaño del arraylist
						}while(opciones >= planetas.size() || opciones < 0);

						//si el usuario selecciona 0 entra en defensa y rellenamos el String
						if(opciones == 0) {

							defensaAtaque = defensaAtaque + Planeta.defensa(misilesDef, planetas, equipoActual);

							//si quiere atacar, entrará aqui y siempre que no se defienda y rellenamos el String
						}else if (opciones > 0 && opciones < planetas.size()) {

							defensaAtaque = defensaAtaque + Planeta.ataque(misilesAtaque, planetas, equipoActual, opciones, planetasAtacados);
						}	

						//aqui controlamos que el usuario use los 50 misiles en cada ronda y 
						//que seleccione una opcion valida
					}while(opciones < 0 || opciones >= planetas.size() || planetas.get(equipoActual).getMisiles() != 0);

					//para jugar los turnos de los equipos
					if(planetas.size() > equipoActual+1) {
						equipoActual++;

						//una vez terminen los turnos...
					}else{
						System.out.println("||Resultados de fin de ronda||");
						System.out.println(defensaAtaque);
						//reseteamos la variable al final del turno
						defensaAtaque = "";

						//le decimos a los usuarios cuantos planetas quedan vivos
						planetas = Planeta.comprobarEquiposVivos(planetas);
						System.out.println("Equipos vivos: " + planetas.size());
						//sumamos al contador de rondas para el dado
						contRondas++;

						//reseteamos los misiles para que tengan los mismos en cada ronda
						for(int i = 0; i < planetas.size(); i++) {

							//si el planeta es gigante se le sumará 10 misiles extra cada ronda.
							if(planetas.get(i).getTipo() == 5) {
								//le setteamos los misiles a los planetas gigantes
								planetas.get(i).setMisiles(10 * (contRondas + 1)); //+1 ya que en este punto sería 1 y tiene que settear 20 misiles

								//si no se le settean a 50
							}else {
								planetas.get(i).setMisiles(50);
							}
						}

						//se lanzará el dado cuando haya al menos 2 equipos vivos
						if(planetas.size() > 1) {
							//cada 4 rondas se tira un dado
							Planeta.dado(contRondas, planetas);
						}

						//reseteamos el contador para que jueguen los equipos
						equipoActual = 0;
					}
					//condicion
				}while(planetas.size() > 1);

				//llamamos a las funciones
				FinPartida.finalizarPartida();
				FinPartida.mostrarGanador(planetas);		
				break;
			case 2:
				Info.reglasJuego();
				break;
			case 3:
				Info.informacion();
				break;

			case 4:
				//ruta del fichero con los ganadores 
				String ruta = "C:/Users/FP/eclipse-workspace/Misiles/tmp/ganadores.txt";

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