
public class Planeta {

	//atributos
	private String nombre;
	private int vida;
	private int misiles_ronda;

	//contructores 
	
	
	public Planeta() {
		this.vida = 200;
		this.misiles_ronda = 50;
	}

	public Planeta(String n) {
		
		this.nombre = n;
		
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


	//metodos

	public void Combate(int misiles,  Planeta planeta) {


		int vida = planeta.getVida();

		int vidastotales = vida - misiles;


		System.out.println("¿Con cuantos misiles quieres atacar " + planeta.getNombre() + "?");


		//una vez hecho 
		//hacer get del objeto planeta
		//le pasamos el planeta atacado

	}
}
