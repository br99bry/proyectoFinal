import java.util.ArrayList;

public class Jugador {
    private int numJugador;
    private ArrayList<Tarjeta> tarjetas;

    public Jugador(int numJugador){
        this.numJugador = numJugador;
    }


    public void tomarCartas(Mazo mazo,int n){
        mazo.proporcionarTarjetas(n);
    }

    public void revuelveMazo(Mazo mazo){
        mazo.barajeaMazo();
    }

    public void repartirCartas(ArrayList<Jugador> jugadores,Mazo m){

    }

    public Tarjeta jugarTarjeta(Tarjeta tarjeta){
        return tarjeta;
    }

    public void agregarTarjeta(Tarjeta tarjeta){
        tarjetas = new ArrayList<Tarjeta>();
        tarjetas.add(tarjeta);
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
