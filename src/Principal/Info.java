package Principal;

public class Info {

	public static void reglasJuego() {
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
	}

	public static void informacion() {
		System.out.println("Has entrado en Informacion");
		System.out.println("========\nVERSION\n========");
		System.out.println("Estas jugando en la version 1.0 de COLDWAR\n");
		System.out.println("========\nAUTORES\n========");
		System.out.println("Nerea Freije Calderon, 1DAW\nPablo Varela Varela, 1DAW (DAM)\nLucia Viqueira Fuentes, 1DAW\n");
		System.out.println("========\nCONTACTO\n========");
		System.out.println("Nerea Freije: nerefreije@gmail.com\nPablo Varela: pablovarelafp@gmail.com\nLucia Viqueira: luciaviqueira9@gmail.com");
	}
}