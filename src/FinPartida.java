import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class FinPartida {
	//funcion para saber que ha terminado el juego
	public static void finalizarPartida() {
		//mostramos al usuario que la partida ha finalizado
		System.out.println("¡Fin de la partida!");
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
				//guardamos el ganador en un String
				String ganador = planetas.get(i).getNombre();
				//llamamos a la funcion
				fichero(ganador);
			}
		}
	}

	public static void fichero(String ganador){

		String ruta = "C:/Users/FP/eclipse-workspace/Misiles/tmp/ganadores.txt";
		escribirFichero(ruta, ganador);
	}

	public static void escribirFichero(String ruta, String ganador) {
		//Creamos un String que va a contener todo el texto del archivo

		try {
			FileWriter fileWriter = new FileWriter(ruta,true);
			//Crear un objeto BufferedWriter
			BufferedWriter bufferWritter = new BufferedWriter(fileWriter);

			//usamos esta funcion para poner tambien la fecha y hora en la que se da el ganador
			DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm:ss");
			ganador = ganador + " " + dtf2.format(LocalDateTime.now());

			//Escrbir en el fichero el texto
			bufferWritter.write(ganador);
			//Escribir en el fichero un salto de línea
			bufferWritter.newLine();

			//Cerrar el buffer
			bufferWritter.close();
			fileWriter.close();

		}catch(IOException e){
			System.out.println("Error E/S: "+e);
		}
	}
	
	public static void leerFichero(String ruta) {
		//Creamos un String que va a contener todo el texto del archivo
		String resultadosPartida = ""; 
		try {
			//Abrir el fichero indicado en la variable nombreFichero
			FileReader fileWriter = new FileReader(ruta);
			BufferedReader bufferReader = new BufferedReader(fileWriter); 

			do { 
				resultadosPartida = bufferReader.readLine();

				if (resultadosPartida != null) {
					System.out.println(resultadosPartida);
				}

			} while(resultadosPartida != null);

			//Cerrar el fichero
			fileWriter.close();
			bufferReader.close();
		}catch(IOException e){ 
			System.out.println("No se ha generado aun un archivo con los ganadores");
		}
	}
}