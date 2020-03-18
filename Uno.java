import sun.misc.JavaUtilJarAccess;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class Uno {

    private int numJugadores;
    private int sentido;
    private Tarjeta tarjeta;
    private Mazo mazo = new Mazo();
    private Mazo pila;
    private ArrayList<Jugador> jugadores = new ArrayList<Jugador>();

    public Uno(){

    }
    public void iniciar(){
        Scanner entrada = new Scanner(System.in);
        boolean bandera  = false;

                try{
                    do{

                        System.out.println("¿Digite el numero de jugadores?");
                        setNumJugadores(entrada.nextInt());
                        if(getNumJugadores()<2 || getNumJugadores()>4){
                            System.out.println("Numero de jugadores no permitido");
                        }
                    }while(getNumJugadores()<2 || getNumJugadores()>4);
                }catch (InputMismatchException e){
                    System.out.println("Digito un caracter no valido, intenta de nuevo puto");
                    iniciar();
                }


        for (int i = 0; i <getNumJugadores() ; i++) {
            Jugador jugador = new Jugador(i+1);
            jugadores.add(jugador);
        }

        Iterator<Jugador> nombreIterator = jugadores.iterator();
        while(nombreIterator.hasNext()){
            Jugador jugador = nombreIterator.next();
            System.out.print(jugador+"\n");
        }


        mazo.iniciaMazo();
        mazo.barajeaMazo();
        /*System.out.println();
        System.out.println(mazo.toString());
        System.out.println();*/
    }

    public void  jugar(){
        //System.out.println(mazo.toString());
        for (int i = 0; i <getNumJugadores() ; i++) {
            jugadores.get(i).agregarTarjeta(mazo.proporcionaTarjeta());
            //System.out.println(jugadores.get(i).toString());
            mazo.eliminaTarjeta();
        }
        int mayor=-1;
        int jugadorQueReparte=-1;
        //En el siguiente fragmento se elige la carta mas alta obtenida al empezar el juego
        for (int i = 0; i <getNumJugadores() ; i++) {
            TarjetaNumerica tn;
            TarjetaCastigo tc;
            Tarjeta t = jugadores.get(i).getTarjetas().get(0);
            if(t instanceof  TarjetaNumerica){
                tn = (TarjetaNumerica) t;
                if(tn.getNumero()>=mayor){
                    mayor = tn.getNumero();
                    jugadorQueReparte = i;
                    //System.out.println(jugadorQueReparte);
                }
            }else if(t instanceof TarjetaCastigo){
                tc = (TarjetaCastigo) t;
            }
        }

        System.out.println("El jugador que reparte es: \n" + jugadores.get(jugadorQueReparte).toString());
        jugadores.get(jugadorQueReparte).repartirCartas(jugadores,mazo);
        System.out.println("Se han repartido las cartas");
        do{
            sentido = 1;
            while (sentido==1){
                System.out.println("Es turno de: " + jugadores.get(jugadorQueReparte));

            }
        }while (mazo.getTarjetas().size()>0);




        /*System.out.println();
        System.out.println(mazo);*/




    }

    public void finalizar(){

    }

    public int getNumJugadores() {
        return numJugadores;
    }

    public void setNumJugadores(int numJugadores) {
        this.numJugadores = numJugadores;
    }
}
