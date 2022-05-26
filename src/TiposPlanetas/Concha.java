package TiposPlanetas;

import Principal.Vecino;

public class Concha extends Vecino{

	public Concha(String nombre, String url) {
		super(200,50, nombre, url);

	}

	@Override
	public String ataque(int eurosAtaque, Vecino vecinoAtacado) {
		String defensaAtaque = "";
		int contadorRecibeDanio = 0;

		//daño x2
		if(vecinoAtacado instanceof Vicenta) {
			Vicenta Vicenta = (Vicenta)vecinoAtacado;

			//setteamos la vida del planeta atacado menos los misiles de ataque
			Vicenta.setEurosPagar(Vicenta.getEurosPagar() - (eurosAtaque * 2));

			defensaAtaque = defensaAtaque + ("El jugador " + getNombre() + 
					" ha robado al jugador " + Vicenta.getNombre() + 
					 + eurosAtaque + " euros "+"\n" + "Le ha cobrado " + eurosAtaque * 2 + " de alquiler \n");

			//cuando le hace la mitad de daño
		}else if(vecinoAtacado instanceof Marisa) {
			Marisa Marisa = (Marisa) vecinoAtacado;
			Marisa.setEurosPagar(Marisa.getEurosPagar() - (eurosAtaque / 2));

			defensaAtaque = defensaAtaque + ("El equipo " + getNombre() + 
					" ha atacado al equipo " + Marisa.getNombre() + 
					" con " + eurosAtaque + " misiles \n" + "Se apiada y le cobra " + eurosAtaque / 2 + " de alquiler \n");

		}//si es un planeta enano
		else if(vecinoAtacado instanceof Hierbas) {
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
					 + contadorRecibeDanio + " euros "+" \n" + "¡PERO HA HECHO UNA HUMAREDA PARA EVITAR QUE LE ROBEN " + 
					(eurosAtaque - contadorRecibeDanio) +" euros! \n"); 

			//daño neutro
		}else {
			vecinoAtacado.setEurosPagar(vecinoAtacado.getEurosPagar() - eurosAtaque);	

			defensaAtaque = defensaAtaque + ("El jugador " + getNombre() + 
					" le quiere robar al jugador " + vecinoAtacado.getNombre() + 
					 + eurosAtaque + " euros " + " \n"); 
		}

		//le restamos los misiles del ataque
		setEuros(getEuros() - eurosAtaque);
		//mostramos por consola
		System.out.println("Euros restantes: " + getEuros());

		return defensaAtaque;
	}
}
