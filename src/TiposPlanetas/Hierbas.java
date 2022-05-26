package TiposPlanetas;
import Interface.InterfaceEnano;
import Principal.Vecino;

public class Hierbas extends Vecino implements InterfaceEnano{

	public Hierbas(String nombre, String url) {
		super(100, 50, nombre, url);

	}

	@Override
	public String ataque(int eurosAtaque, Vecino vecinoAtacado) {
		String defensaAtaque = "";
		int contadorRecibeDanio = 0;

		//si es un planeta enano
		if(vecinoAtacado instanceof Hierbas) {
			Hierbas Hierbas = (Hierbas) vecinoAtacado;

			for(int i = 0; i < eurosAtaque; i++) {
				int esquiva = (int) Math.floor(Math.random()*(2)+1);

				if(esquiva == 1) {
					contadorRecibeDanio ++;
				}
			}

			//al salir del for, decumos cuantos misiles esquiva y cuantos recibe, setteamos las vidas tambien
			Hierbas.setEurosPagar(Hierbas.getEurosPagar() - contadorRecibeDanio);		
			defensaAtaque = defensaAtaque + ("El jugador " + getNombre() + 
					" le quiere robar al jugador " + Hierbas.getNombre() + 
					+ contadorRecibeDanio + " euros " +"\n" + "¡PERO HA HECHO UNA HUMAREDA PARA EVITAR QUE LE ROBEN " + 
					(eurosAtaque - contadorRecibeDanio) +" euros! \n"); 

			//daño neutro
		}else {
			vecinoAtacado.setEurosPagar(vecinoAtacado.getEurosPagar() - eurosAtaque);	

			defensaAtaque = defensaAtaque + ("El jugador " + getNombre() + 
					" le quiere robar al jugador " + vecinoAtacado.getNombre() + 
					+ eurosAtaque + " euros " + "\n"); 
		}
		//le restamos los misiles del ataque
		setEuros(getEuros() - eurosAtaque);
		//mostramos por consola
		System.out.println("Euros restantes: " + getEuros());

		return defensaAtaque;
	}
}
