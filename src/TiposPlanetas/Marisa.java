package TiposPlanetas;

import Principal.Vecino;

public class Marisa extends Vecino{

	public Marisa(String nombre, String url) {
		super(200, 50, nombre, url);		
	}

	@Override
	public String ataque(int eurosAtaque, Vecino vecinoAtacado) {
		String defensaAtaque = "";	
		int contadorRecibeDanio = 0;

		//daño x2
		if(vecinoAtacado instanceof Concha) {
			Concha Concha = (Concha)vecinoAtacado;

			//setteamos la vida del planeta atacado menos los misiles de ataque
			Concha.setEurosPagar(Concha.getEurosPagar() - (eurosAtaque * 2));

			defensaAtaque = defensaAtaque + ("El jugador " + getNombre() + 
					" ha robado al jugador " + Concha.getNombre() + 
					 + eurosAtaque + " euros "+" \n" + "Como se ha venido arriba con el chinchon, le ha robado " + eurosAtaque * 2 + " euros \n");

			//cuando le hace la mitad de daño
		}else if(vecinoAtacado instanceof Vicenta) {
			Vicenta PlanetaVerde = (Vicenta)vecinoAtacado;
			PlanetaVerde.setEurosPagar(PlanetaVerde.getEurosPagar() - (eurosAtaque / 2));

			defensaAtaque = defensaAtaque + ("El jugador " + getNombre() + 
					" ha robado al jugador " + PlanetaVerde.getNombre() + 
					 + eurosAtaque + " euros "+" \n" + "Como es su hermana se apiada y solo le roba " + eurosAtaque / 2 + " euros \n"); 


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
					 + eurosAtaque + " euros "+" \n"); 
		}

		//le restamos los misiles del ataque
		setEuros(getEuros() - eurosAtaque);
		//mostramos por consola
		System.out.println("Euros restantes: " + getEuros());

		return defensaAtaque;
	}
}
