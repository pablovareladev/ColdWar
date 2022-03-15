import java.util.ArrayList;
import java.util.Scanner;

public class Planeta {

	//atributos
	private String nombre;
	private int vida;
	private int misiles_ronda;
	private int tipo;

	//contructores 
	public Planeta() {
		this.vida = 200;
		this.misiles_ronda = 50;
	}

	public Planeta(String n) {

		this.nombre = n;
	}

	public Planeta(int tipo) {

		this.tipo = tipo;
		//si es de los planetas que tienen estadisticas sin modificar
		if(tipo > 0 && tipo < 5) {
			this.vida = 200;
			this.misiles_ronda = 50;

		}else if(tipo == 5) {
			this.vida = 400;
			this.misiles_ronda = 10;

		}else if(tipo == 6) {
			this.vida = 100;
			this.misiles_ronda = 50;
		}
	}

	//getters y setters
	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getMisiles() {
		return misiles_ronda;
	}

	public void  setMisiles(int misiles) {
		this.misiles_ronda = misiles;

	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	//metodos

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
					Planeta.comprobarEmpate(planetas);
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

	public static void creacionEquipos(int cantidadEquipos, int escogerPlaneta, String nombre, boolean repetido, ArrayList<String>  tiposPlanetas, ArrayList<String> nombreEquipos, ArrayList<Planeta> planetas) {
		Scanner teclado = new Scanner(System.in);
		//bucle para controlar cuantos equipos jugarán
		while(cantidadEquipos <=2) {
			//control de errores
			try {
				System.out.println("¿Cuantos equipos van a jugar?");
				cantidadEquipos = teclado.nextInt();
				//para refrescar
				teclado.nextLine();

				if(cantidadEquipos <= 2) {
					System.out.println("Número no valido");
				}

			}catch(Exception ae) {
				System.out.println("No has introducido un numero");
				teclado.next();			
			}			
		}

		System.out.println("------------------------ \nCreando equipos...");
		//con un for rellenamos el arraylist con los nombres de los equipos
		for(int i = 0; i < cantidadEquipos ; i++) {
			//reseteamos la variable
			escogerPlaneta = -1;
			//pedimos datos al usuario
			do {
				System.out.println("Nombre del equipo " + (i+1) + ":");
				//esta variable se resetea cada vez que pasa por aqui
				nombre = teclado.nextLine();

				//hacemos esta comprobacion para que no haya equipos repetidos
				if(nombreEquipos.contains(nombre)) {
					System.out.println("Nombre repetido, por favor escoja otro");	
					repetido = false;
					//si el nombre no está repetido se añadirá al array
				}else {
					//se añade al arraylist de nombres
					nombreEquipos.add(nombre);
					repetido = true;
				}	
			}while (!repetido);


			//buclea mientras que no se seleccione una opcion valida
			while(escogerPlaneta < 0 || escogerPlaneta > 6) {
				//control de errores
				try {
					System.out.println("=====================================================");
					System.out.println("Selecciona el tipo de planeta: \n0- Planeta aleatorio: \n Se te asigna un planeta al azar \n" 
							+ "\n1- Normal: \n Sin modificaciones \n \n2- Planeta rojo: \n"
							+ "Le ataca el doble al verde \n Ataca la mitad al azul \n \n"
							+ "3- Planeta azul: \n Le ataca el doble al rojo \n Ataca la mitad al verde \n \n"
							+ "4- Planeta verde: \n Le ataca el doble al azul \n Ataca la mitad al rojo \n \n"
							+ "5- Planeta gigante: \n Tiene el doble de vida \n Empieza solo con 10 misiles, cada ronda +10 misiles \n \n"
							+ "6- Planeta enano: \n Mitad de vida \n Probabilidad de esquivar cada misil de 50%");
					System.out.println("=====================================================");
					//hacemos que el usuario introduzca el numero
					escogerPlaneta = teclado.nextInt();
					//para refrescar
					teclado.nextLine();

					if(escogerPlaneta < 0 || escogerPlaneta > 6) {
						//notificamos al usuario
						System.out.println("Número incorrecto");
					}

				}catch(Exception ae){
					System.out.println("No has introducido un numero");
					teclado.next();
				}	
			}
			//si escoge el planeta aleatorio, se le asigna uno
			if(escogerPlaneta == 0) {
				escogerPlaneta = (int) Math.floor(Math.random()*(6)+1);
			}

			//instanciamos un objeto 
			Planeta objetosPlaneta = new Planeta(escogerPlaneta);
			//concatenamos el nombre del equipo con el tipo de planeta
			nombre = nombre + tiposPlanetas.get(escogerPlaneta);
			//añadimos el objeto al arraylist y le setteamos el nombre
			objetosPlaneta.setNombre(nombre);
			planetas.add(objetosPlaneta);									

		}
		//hacemos un for para mostrar la vida que tienen los equipos
		for(int x = 0; x < cantidadEquipos; x++) {
			System.out.println( planetas.get(x).getNombre() + " " + planetas.get(x).getVida() + " vidas.");
		}

		System.out.println("------------------------");
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
			if(misilesAtaque > planetas.get(equipoActual).getMisiles()) {
				System.out.println("Has excedido el numero de misiles");
			}else if(misilesAtaque <= 0) {
				System.out.println("Numero de misiles no valido");
			}
			//condiciones para que no ponga numeros negativos ni mas misiles de los que tiene
		}while(misilesAtaque > planetas.get(equipoActual).getMisiles() || misilesAtaque <= 0);

		//planetas que se hacen el doble de daño
		if(planetas.get(equipoActual).getTipo() == 2 && planetasAtacados.get(opciones).getTipo() == 4 || 
				planetas.get(equipoActual).getTipo() == 3 && planetasAtacados.get(opciones).getTipo() == 2 || 
				planetas.get(equipoActual).getTipo() == 4 && planetasAtacados.get(opciones).getTipo() == 3) {
			//setteamos la vida del planeta atacado menos los misiles de ataque
			planetasAtacados.get(opciones).setVida(planetasAtacados.get(opciones).getVida() - (misilesAtaque * 2));

			defensaAtaque = defensaAtaque + ("El equipo " + planetas.get(equipoActual).getNombre() + 
					" ha atacado al equipo " + planetasAtacados.get(opciones).getNombre() + 
					" con " + misilesAtaque + " misiles \n" + "Es muy efectivo hace " + misilesAtaque * 2 + " de daño \n"); 

			//planetas que se hacen la mitad de daño
		}else if (planetas.get(equipoActual).getTipo() == 2 && planetasAtacados.get(opciones).getTipo() == 3 ||
				planetas.get(equipoActual).getTipo() == 3 && planetasAtacados.get(opciones).getTipo() == 4 ||
				planetas.get(equipoActual).getTipo() == 4 && planetasAtacados.get(opciones).getTipo() == 2) {
			//setteamos la vida del planeta atacado menos los misiles de ataque
			planetasAtacados.get(opciones).setVida(planetasAtacados.get(opciones).getVida() - (misilesAtaque / 2));

			defensaAtaque = defensaAtaque + ("El equipo " + planetas.get(equipoActual).getNombre() + 
					" ha atacado al equipo " + planetasAtacados.get(opciones).getNombre() + 
					" con " + misilesAtaque + " misiles \n" + "Es poco efectivo hace " + misilesAtaque / 2 + " de daño \n"); 	
			//para planetas enanos
		}else if(planetasAtacados.get(opciones).getTipo() == 6) {
			defensaAtaque = planetaEnano(planetasAtacados, opciones, misilesAtaque, defensaAtaque, planetas, equipoActual);

			//si no se atacan con daño especial...
		}else {
			//setteamos la vida del planeta atacado menos los misiles de ataque
			planetasAtacados.get(opciones).setVida(planetasAtacados.get(opciones).getVida() - misilesAtaque);

			//vamos a recoger en un string con cuantos msiles ataca cada equipo
			defensaAtaque = defensaAtaque + ("El equipo " + planetas.get(equipoActual).getNombre() + 
					" ha atacado al equipo " + planetasAtacados.get(opciones).getNombre() + 
					" con " + misilesAtaque + " misiles \n"); 
		}

		//setteamos los misiles restantes del equipo que ataca
		planetas.get(equipoActual).setMisiles(planetas.get(equipoActual).getMisiles() - misilesAtaque);
		System.out.println("Misiles restantes: " + planetas.get(equipoActual).getMisiles());
		//devolvemos el string
		return defensaAtaque;
	}

	public static String planetaEnano(ArrayList<Planeta> planetasAtacados, int opciones,  int misilesAtaque, String defensaAtaque, ArrayList<Planeta> planetas, int equipoActual ) {

		int esquiva = (int) Math.floor(Math.random()*(2)+1);
		if(esquiva == 1) {
			planetasAtacados.get(opciones).setVida(planetasAtacados.get(opciones).getVida() - misilesAtaque);

			//vamos a recoger en un string con cuantos msiles ataca cada equipo
			defensaAtaque = defensaAtaque + ("El equipo " + planetas.get(equipoActual).getNombre() + 
					" ha atacado al equipo " + planetasAtacados.get(opciones).getNombre() + 
					" con " + misilesAtaque + " misiles \n"); 
		}else {
			defensaAtaque = defensaAtaque + ("El equipo " + planetas.get(equipoActual).getNombre() + 
					" ha atacado al equipo " + planetasAtacados.get(opciones).getNombre() + 
					" con " + misilesAtaque + " misiles \n" + "¡PERO HA LOGRADO ESQUIVARLO! \n"); 
		}
		return defensaAtaque;
	}

	public static String defensa (int misilesDef, ArrayList<Planeta> planetas, int equipoActual) {
		Scanner teclado = new Scanner(System.in);	
		Planeta defendido =  planetas.get(equipoActual);
		String defensaAtaque ="";
		//le preguntamos con cuantos misiles quiere defenderse
		do {
			//control de erroes por si mete un caracter	
			try {
				System.out.println("¿Con cuantos misiles te quieres defender?");	
				misilesDef = teclado.nextInt();


			}catch(Exception ae) {
				System.out.println("No has introducido un numero");
				teclado.next();
			}

			if(misilesDef > planetas.get(equipoActual).getMisiles()) {
				System.out.println("Has excedido el número de misiles");
			}else if(misilesDef <= 0) {
				System.out.println("Numero de misiles no valido");
			}
			//aqui controlamos que no pueda usar numeros negativos o mas misiles
			//de los que tiene
		}while(misilesDef > planetas.get(equipoActual).getMisiles() || misilesDef <= 0);

		//restamos los misiles y lo setteamos
		defendido.setMisiles(defendido.getMisiles()- misilesDef);

		//le sumamos la vida de los misiles con los que se defiende
		defendido.setVida(planetas.get(equipoActual).getVida()+(misilesDef /2));

		//le hacemos saber cuantos misiles le quedan
		System.out.println("Misiles restantes: " + planetas.get(equipoActual).getMisiles());

		//vamos a recoger en un string con cuantos msiles se defiende cada equipo
		defensaAtaque = defensaAtaque + ("El equipo " + planetas.get(equipoActual).getNombre() + " se ha defendido con " + misilesDef + " misiles \n");
		return defensaAtaque;
	}
	//funcion por si quedan empate
	public static void comprobarEmpate(ArrayList<Planeta> planetas) {
		//recorremos el arraaylist para comprobar empate
		//condicion para saber si ha ganado el primer jugador en el array
		if(planetas.size() == 2 && planetas.get(0).getVida() <=0 && planetas.get(1).getVida() <=0) {

			if(planetas.get(0).getVida() < planetas.get(1).getVida()) {
				//mostramos resultados
				System.out.println("¡Os habeis matado a la vez! ha ganado " + planetas.get(1).getNombre());
				System.out.println("Vida de " + planetas.get(0).getNombre() + ":\n" + "Vida de " + planetas.get(1).getNombre() + ":");

				//pueden empatar por completo
			}else if(planetas.get(0).getVida() == planetas.get(1).getVida()){
				System.out.println("¡Habeis empatado!");
				System.out.println("Vida de " + planetas.get(0).getNombre() + ":\n" + "Vida de " + planetas.get(1).getNombre() + ":");

				//ha ganado el equipo en la segunda posicion del arraylist
			}else if(planetas.get(0).getVida() > planetas.get(1).getVida()) {
				System.out.println("¡Os habeis matado a la vez! ha ganado " + planetas.get(0).getNombre());
				System.out.println("Vida de " + planetas.get(0).getNombre() + ": " + planetas.get(0).getVida() + ":\n" + "Vida de " + planetas.get(1).getNombre() + ": " + planetas.get(1).getVida());
			}
		}
	}

	public static void dado(int contRondas, ArrayList<Planeta> planetas) {
		Scanner teclado = new Scanner(System.in);
		//cada 4 rondas se hará esta funcion
		if(contRondas % 4 == 0) {
			//declaramos el array para rellenar con las apuestas de los usuarios
			int apuestasEquipos []  = new int [planetas.size()];
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

						if(apuestasEquipos[contApuestas] <= 0 || apuestasEquipos[contApuestas] > 6) {
							System.out.println("Numero no valido");	
						}
						//condicion, numeros del dado
					}while(apuestasEquipos[contApuestas] <= 0 || apuestasEquipos[contApuestas] > 6);

					//incrementamos el contador de apuestas
					contApuestas++;
					//si un equipo está muerto, se rellena con un 0
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
				if(contSinGanador == planetas.size()) {
					System.out.println("¡Ningun equipo ha acertado el número!");
				}
			}
		}
	}
}
