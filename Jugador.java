import java.util.ArrayList;

public class Jugador {
    private int numJugador;
    private ArrayList<Tarjeta> tarjetas;

    public Jugador(int numJugador){
        this.numJugador = numJugador;
    }


    public void tomarCartas(Mazo m,int n){

    }

    public void revuelveMazo(Mazo m){

    }

    public void repartirCartas(ArrayList<Jugador> jugadores,Mazo m){

    }

    public Tarjeta jugarTarjeta(Tarjeta tarjeta){
        return tarjeta;
    }

    public void agregarTarjeta(Tarjeta tarjeta){

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
