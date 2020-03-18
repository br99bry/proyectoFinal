import java.util.ArrayList;

public class Jugador {
    private int numJugador;
    private ArrayList<Tarjeta> tarjetas;

    public Jugador(int numJugador){
        this.numJugador = numJugador;
    }


    public void tomarCartas(Mazo mazo,int n){
        for (int i = 0; i <n ; i++) {
            tarjetas.add(mazo.proporcionaTarjeta());
            mazo.eliminaTarjeta();
        }
    }

    public void revuelveMazo(Mazo mazo){
        mazo.barajeaMazo();
    }

    public void repartirCartas(ArrayList<Jugador> jugadores,Mazo mazo){

        for (int i = 0; i <jugadores.size() ; i++) {
                jugadores.get(i).tomarCartas(mazo,7);
        }
    }

    public Tarjeta jugarTarjeta(Tarjeta tarjeta){
        return tarjeta;
    }

    public void agregarTarjeta(Tarjeta tarjeta){
        tarjetas = new ArrayList<Tarjeta>();
        tarjetas.add(tarjeta);
    }

    public ArrayList<Tarjeta> getTarjetas() {
        return tarjetas;
    }

    public void decirUno(){

    }

    @Override
    public String toString() {
        return "Jugador{" +
                "numJugador=" + numJugador +
                ", tarjetas=" + tarjetas +
                '}';
    }
}
