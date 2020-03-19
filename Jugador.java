import java.util.ArrayList;

public class Jugador {
    private int numJugador;
    private ArrayList<Tarjeta> tarjetas;

    public Jugador(int numJugador){
        this.numJugador = numJugador;
    }


    public void tomarCartas(Mazo mazo,int n){
        int pos =0;
        for (int i = 0; i <n ; i++) {
            tarjetas.add(mazo.proporcionaTarjeta());
            pos = tarjetas.size();
            tarjetas.get(pos-1).setPos(pos-1);
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
        System.out.println("La tarjeta en juego es: ");
        System.out.println(tarjeta.toString());

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
        System.out.println("Uno");
    }

    @Override
    public String toString() {
        return "Jugador ||" +
                " numJugador=" + numJugador +
                " || tarjetas=" + tarjetas ;
    }
}
