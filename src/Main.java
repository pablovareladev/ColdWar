import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		//Variables
		int jugar=-1;

		//Menu
		do {
			try {
				System.out.println("Bienvenido/a al ColdWar. ¿Que quieres hacer? \n1-Jugar \n2-Reglas del juego \n3-Informacion \n0-Salir");
				jugar = teclado.nextInt();

			}catch(Exception e) {
				System.out.println("No introduciste un numero");
				teclado.next();
			}
		}while(jugar >3 || jugar <0);

		switch (jugar) {

		case 1:
			System.out.println("Has entrado en Jugar:");
			//iniciamos una boolean para comprobar errores
			boolean repetido = false;
			System.out.println("------------------------ \nCreando equipos...");
			//declaramos Un arraylist de strings con los nombres de los equipos
			ArrayList<String> nombreEquipos = new ArrayList<String>();
			//variable para mostrar el numero correspondiente para cada equipo
			int numeroEquipo = 0;
			//variable contador para cuando juega cada equipo
			int equipoActual = 0;
			//variable para misiles de defensa y ataque
			int misilesDef = -1;
			int misilesAtaque = -1; 
			//contador de rondas para tirar el dado
			int contDado = 0;
			//para imprimir los resultados al final de los ataques y defensas de equipos
			String defensaAtaque = "";

			//con un for rellenamos el arraylist con los nombres de los equipos
			for(int i = 0; i < 5; i++) {

				//pedimos datos al usuario
				do {
					System.out.println("Nombre del equipo " + (i+1) + ":");
					//esta variable se resetea cada vez que pasa por aqui
					String nombre = teclado.next();

					//hacemos esta comprobacion para que no haya equipos repetidos
					if(nombreEquipos.contains(nombre)) {
						System.out.println("Nombre repetido, por favor escoja otro");	
						repetido = false;
						//si el nombre no está repetido se añadirá al array
					}else {
						nombreEquipos.add(nombre);
						repetido = true;
					}	
				}while (!repetido);
			}
			System.out.println("------------------------");
			//instanciamos los objetos
			Planeta equipoUno = new Planeta ();
			Planeta equipoDos = new Planeta ();
			Planeta equipoTres = new Planeta ();
			Planeta equipoCuatro = new Planeta ();
			Planeta equipoCinco = new Planeta ();

			//guardamos los objetos en un arraylist
			ArrayList<Planeta> planetas = new ArrayList<Planeta>(Arrays.asList(equipoUno, equipoDos, equipoTres, equipoCuatro, equipoCinco));

			//con este for le setteamos los nombres a los equipos
			for(int i = 0; i < planetas.size(); i++) {
				//ponemos los nombres con el indice
				planetas.get(i).setNombre(nombreEquipos.get(i));
			}

			//variable para saber que quiere hacer el usuario
			int opciones = -1;

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
						//el no puede ser menor que 0 no mayor o igual que el tamaño del arraylist
					}while(opciones >= planetas.size() || opciones < 0);

					//si el usuario selecciona 0 entra en defensa y rellenamos el String
					if(opciones == 0) {

						defensaAtaque = defensaAtaque + defensa(misilesDef, planetas, equipoActual);

						//si quiere atacar, entrará aqui y siempre que no se defienda y rellenamos el String
					}else if (opciones > 0 && opciones < planetas.size()) {

						defensaAtaque = defensaAtaque + ataque(misilesAtaque, planetas, equipoActual, opciones, planetasAtacados);
					}				
					//aqui controlamos que el usuario use los 50 misiles en cada ronda y 
					//que seleccione una opcion valida
				}while(opciones < 0 || opciones >= planetas.size() || planetas.get(equipoActual).getMisiles() != 0);

				//para jugar los turnos de los equipos
				if(planetas.size() > equipoActual+1) {
					equipoActual++;

					//una vez terminen los turnos...
				}else{
					System.out.println(defensaAtaque);
					//reseteamos la variable al final del turno
					defensaAtaque = "";

					//le decimos a los usuarios cuantos planetas quedan vivos
					planetas = comprobarEquiposVivos(planetas);
					System.out.println("Equipos vivos: " + planetas.size());
					//sumamos al contador de rondas para el dado
					contDado++;

					//reseteamos los misiles para que tengan los mismos en cada ronda
					for(int i = 0; i < planetas.size(); i++) {
						planetas.get(i).setMisiles(50);
					}

					//se lanzará el dado cuando haya al menos 2 equipos vivos
					if(planetas.size() > 1) {
						//cada 4 rondas se tira un dado
						dado(contDado, planetas);
					}

					//reseteamos el contador para que jueguen los equipos
					equipoActual = 0;
				}
				//condicion
			}while(planetas.size() > 1);

			//llamamos a las funciones
			finalizarPartida();
			mostrarGanador(planetas);		
			break;
		case 2:
			System.out.println("Has entrado en Reglas del juego \n==================\nREGLAS DE COLDWAR\n==================\n"
					+ "-----------\nCOMPONENTES\n-----------\n5 Jugadores\n200 puntos de inicio a cada jugador\n50 misiles por ronda\n"
					+ "Un dado\n");
			System.out.println("------------------");
			System.out.println("OBJETIVO DEL JUEGO");
			System.out.println("------------------");
			System.out.println("COLDWAR es un juego en equipo o individual en el que todos los jugadores empiezan con 200 puntos. Para ganar los jugadores" + "\n" + "deberan atacar o defenderse con 50 misiles, distribuidos estategicamente para conseguir no quedarse a 0 y matar a los" +"\n" + " oponentes.\n");
			System.out.println("-----------------");
			System.out.println("APRENDER EL JUEGO");
			System.out.println("-----------------");
			System.out.println("COLDWARD solo tiene una regla, y es con los 50 misiles que tendras en cada ronda. Los misiles los podras dividir de " + "\n" + "cualquier forma la unica condicion es que si te defiendes con x numero solo te defiendes con la midad (ejemplo: atacas con" + "\n" + "20 puntos al equipo2 y te defiendes con 30 lo que supone que solo tienes defensa de la mitad que serian 15 misiles).\n");
			System.out.println("Cada 4 rondas se lanza un dado y quien acierte el numero se lleva un misil de 15 puntos\n");
			System.out.println("En el juego puedes hacer las convinaciones de ataque y defensa que quieres, y tambien puedes solo atacar o solo defender.\n");
			System.out.println("No hay un maximo de rondas, sino que termina cuando solo uno de los jugadores quede en pie.\n");
			System.out.println("--------------------\nLA PANTALLA DE JUEGO\n--------------------");
			System.out.println("Primero se crearan los 5 equipos poniendo el nombre que quieras a cada uno. Se inicializan las vidad iniciales a cada uno\n(200 puntos) y los 50 misiles de cada ronda.\n");
			System.out.println("Despues comenzaran las rondas en la que cada jugador elige a quien o quienes quiere atacar y con cuantos puntos se quiere defender.\n");
			break;
		case 3:
			System.out.println("Has entrado en Informacion");
			System.out.println("========\nVERSION\n========");
			System.out.println("Estas jugando en la version 1.0 de COLDWAR\n");
			System.out.println("========\nAUTORES\n========");
			System.out.println("Nerea Freije Calderon, 1DAW\nPablo Varela Varela, 1DAW (DAM)\nLucia Viqueira Fuentes, 1DAW\n");
			System.out.println("========\nCONTACTO\n========");
			System.out.println("Nerea Freije: nerefreije@gmail.com\nPablo Varela: pablovarelafp@gmail.com\nLucia Viqueira: luciaviqueira9@gmail.com");
			break;
		case 0:
			System.out.println("Escogiste salir");
			break;
		}
	}

	//funcion para comprobar los equipos que estan vivos
	public static ArrayList<Planeta> comprobarEquiposVivos(ArrayList<Planeta> planetas) {

		//comprobamos la vida de los planetas, si no tiene vida
		for(int i = 0; i < planetas.size(); i++) {

			//condicion para ver saber los planetas vivos
			if(planetas.get(i).getVida() > 0) {
				//contador de equipos vivos

				//syso para que lo vea el usuario
				System.out.println(planetas.get(i).getNombre() + ": " + planetas.get(i).getVida() + " vidas");

				//para saber que equipos estan muertos
			}else if(planetas.get(i).getVida() <= 0) {
				//comprobacion para saber si quedan empate
				if(planetas.size() == 2) {
					comprobarEmpate(planetas);
				}
				//hacemos saber al usuario cuantos equipos se han muerto
				System.out.println("El equipo " + planetas.get(i).getNombre() + " ha muerto");
				//los borramos del arraylist
				planetas.remove(i);
				//decrementamos i al quitar un planeta
				i--;
			}
		}
		//devolvemos el array
		return planetas;
	}

	public static String defensa (int misilesDef, ArrayList<Planeta> planetas, int equipoActual) {
		Scanner teclado = new Scanner(System.in);	
		String defensaAtaque ="";
		//le preguntamos con cuantos misiles quiere defenderse
		do {
			//control de erroes por si mete un caracter	
			try {
				System.out.println("¿Con cuantos misiles te quieres defender?");	
				misilesDef = teclado.nextInt();

				if(misilesDef > planetas.get(equipoActual).getMisiles()) {
					System.out.println("Has excedido el número de misiles");
				}
			}catch(Exception ae) {
				System.out.println("No has introducido un numero");
				teclado.next();
			}
			//aqui controlamos que no pueda usar numeros negativos o mas misiles
			//de los que tiene
		}while(misilesDef > planetas.get(equipoActual).getMisiles() || misilesDef <= 0);

		//restamos los misiles y lo setteamos
		planetas.get(equipoActual).setMisiles(planetas.get(equipoActual).getMisiles() - misilesDef);

		//le sumamos la vida de los misiles con los que se defiende
		planetas.get(equipoActual).setVida(planetas.get(equipoActual).getVida()+(misilesDef /2));

		//le hacemos saber cuantos misiles le quedan
		System.out.println("Misiles restantes: " + planetas.get(equipoActual).getMisiles());

		//vamos a recoger en un string con cuantos msiles se defiende cada equipo
		defensaAtaque = defensaAtaque + ("El equipo " + planetas.get(equipoActual).getNombre() + " se ha defendido con " + misilesDef + " misiles \n");
		return defensaAtaque;
	}

	public static String ataque(int misilesAtaque, ArrayList<Planeta> planetas, int equipoActual, int opciones, ArrayList<Planeta> planetasAtacados) {
		Scanner teclado = new Scanner(System.in);
		String defensaAtaque = "";
		do {
			try {
				System.out.println("Introduce el numero de misiles con el que quieres atacar");
				misilesAtaque = teclado.nextInt();

			}catch(Exception ae) {
				System.out.println("No has introducido un numero");
				teclado.next();
			}
			//condiciones para que no ponga numeros negativos ni mas misiles de los que tiene
		}while(misilesAtaque > planetas.get(equipoActual).getMisiles() || misilesAtaque <= 0);

		//setteamos la vida del planeta atacado menos los misiles de ataque
		planetasAtacados.get(opciones).setVida(planetasAtacados.get(opciones).getVida() - misilesAtaque);

		//setteamos los misiles restantes del equipo que ataca
		planetas.get(equipoActual).setMisiles(planetas.get(equipoActual).getMisiles() - misilesAtaque);

		System.out.println("Misiles restantes: " + planetas.get(equipoActual).getMisiles());

		//vamos a recoger en un string con cuantos msiles ataca cada equipo
		defensaAtaque = defensaAtaque + ("El equipo " + planetas.get(equipoActual).getNombre() + 
				" ha atacado al equipo " + planetasAtacados.get(opciones).getNombre() + 
				" con " + misilesAtaque + " misiles \n"); 	
		return defensaAtaque;
	}

	public static void dado(int contDado, ArrayList<Planeta> planetas) {
		Scanner teclado = new Scanner(System.in);

		//cada 4 rondas se hará esta funcion
		if(contDado % 4 == 0) {
			//declaramos el array para rellenar con las apuestas de los usuarios
			int apuestasEquipos []  = new int [5];
			//hacemos la funcion math random para el dado
			int randomDado = (int) Math.floor(Math.random()*(6)+1);
			//variable para contador para el array de apuestas
			int contApuestas = 0;
			//contador por si nadie acierta el dado
			int contSinGanador = 0;
			//hacemos saber al usuario que se lanzó un dado
			System.out.println("Se ha lanzado un dado, ¡adivinad el numero para 20 misiles extra!");
			//hacemos un for para saber los planetas que estan vivos
			for(int i = 0; i < planetas.size(); i++) {
				//solo podran apostar los equipos vivos
				if(planetas.get(i).getVida() > 0 ) {
					//si el equipo está vivo, podrá apostar

					//control de errores
					do {
						try {
							System.out.println("Equipo " + (planetas.get(contApuestas).getNombre()) +  " ¿Cual es tu apuesta?");
							apuestasEquipos[contApuestas] = teclado.nextInt();							

						}catch(Exception e) {
							System.out.println("No has introducido un número");
							teclado.next();
						}
						//condicion, numeros del dado
					}while(apuestasEquipos[contApuestas] <= 0 || apuestasEquipos[contApuestas] > 6);

					//incrementamos el contador de apuestas
					contApuestas++;
					//si un equipo está muerto, se rellena con un 0
				}else if(planetas.get(i).getVida() <= 0 ) {
					apuestasEquipos[i] = 0;
					contApuestas++;
				}
			}
			System.out.println("El número del dado es: |" + randomDado + "|");
			//hacemos un for para notificar al usuario los ganadores y para sumar los misiles correspondientes
			for(int x = 0; x < apuestasEquipos.length; x++ ) {
				//si aciertan el numero del dado...
				if(apuestasEquipos[x] == randomDado) {
					//hacemos saber a quien ganó que se le suman misiles
					System.out.println("Equipo " + (planetas.get(x).getNombre()) + " has recibido 20 misiles extra");

					//sumamos los misiles en el array
					planetas.get(x).setMisiles(planetas.get(x).getMisiles()+20);

					//condicion por si no coincide con el numero del dado
				}else if(apuestasEquipos[x] != randomDado) {
					//incrementamos contador
					contSinGanador++;
				}
				//si nadie acierta, se hacer saber a los equipos
				if(contSinGanador == 5) {
					System.out.println("¡Ningun equipo ha acertado el número!");
				}
			}
		}
	}
	//creamos la funcion para anunciar el ganador
	public static void mostrarGanador(ArrayList<Planeta> planetas) {
		//recorremos el array para saber que usuario ha ganado
		for(int i = 0; i < planetas.size(); i++) {
			//miramos que equipo está vivo y mostramos cual es
			if(planetas.get(i).getVida() > 0) {
				System.out.println("------------------------------------------");
				System.out.println("¡Enhorabuena " + planetas.get(i).getNombre() + " has ganado!");
				System.out.println("------------------------------------------");
			}
		}
	}
	//funcion para saber que ha terminado el juego
	public static void finalizarPartida() {
		//mostramos al usuario que la partida ha finalizado
		System.out.println("¡Fin de la partida!");
	}
	//funcion por si quedan empate
	public static void comprobarEmpate(ArrayList<Planeta> planetas) {
		//recorremos el arraaylist para comprobar empate
		//condicion para saber si ha ganado el primer jugador en el array
		if(planetas.size() == 2 && planetas.get(0).getVida() <=0 && planetas.get(1).getVida() <=0 && planetas.get(0).getVida() < planetas.get(1).getVida()) {
			//mostramos resultados
			System.out.println("¡Os habeis matado a la vez! ha ganado " + planetas.get(0).getNombre());
			System.out.println("Vida de " + planetas.get(0).getNombre() + ":\n" + "Vida de " + planetas.get(1).getNombre() + ":");
			//pueden empatar por completo
		}else if(planetas.size() == 2 && planetas.get(0).getVida() <=0 && planetas.get(1).getVida() <=0 && planetas.get(0).getVida() == planetas.get(1).getVida()){
			System.out.println("¡Habeis empatado!");
			System.out.println("Vida de " + planetas.get(0).getNombre() + ":\n" + "Vida de " + planetas.get(1).getNombre() + ":");
			//ha ganado el equipo en la segunda posicion del arraylist
		}else if(planetas.size() == 2 && planetas.get(0).getVida() <=0 && planetas.get(1).getVida() <=0 && planetas.get(0).getVida() > planetas.get(1).getVida()) {
			System.out.println("¡Os habeis matado a la vez! ha ganado " + planetas.get(1).getNombre());
			System.out.println("Vida de " + planetas.get(0).getNombre() + ": " + planetas.get(0).getVida() + ":\n" + "Vida de " + planetas.get(1).getNombre() + ": " + planetas.get(1).getVida());
		}
	}
}