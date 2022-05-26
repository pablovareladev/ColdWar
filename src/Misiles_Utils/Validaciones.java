package Misiles_Utils;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validaciones {

	public static String identificador(ArrayList<String> idEquipos){
		Scanner teclado = new Scanner(System.in);	
		//declaramos variables
		String id = "";
		//definimos un patron para saber como tiene que ser el String
		Pattern pat = Pattern.compile("[0-9]{4}[A-Z]{3}");
		Matcher mat = null;
		do {
			System.out.println("============================== \n" + "Escriba un ID para su planeta \n"
					+ "Ejemplo de ID valido: 1111AAA \n" + "============================== \n");
			//recogemos datos del usuario
			id = teclado.next();
			mat = pat.matcher(id);
			
			//si se cumple el patron
			if (mat.matches() && !idEquipos.contains(id)) {
				System.out.println("ID correcto");

				//si no se cumple
			} else {
				System.out.println("Ese ID no es valido");
			}
			//si no se cumple el patron, buclea
		}while(!mat.matches());

		//retornamos el ID para concatenarlo con el nombre
		return id;
	}
}