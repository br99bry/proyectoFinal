import sun.misc.JavaUtilJarAccess;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class Uno {

    private int numJugadores;
    private int sentido;
    private Tarjeta tarjeta;
    private Mazo mazo;
    private Mazo pila;
    private ArrayList<Jugador> jugadores;

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

        jugadores = new ArrayList<Jugador>();
        for (int i = 0; i <getNumJugadores() ; i++) {
            Jugador jugador = new Jugador(i+1);
            jugadores.add(jugador);
        }

        Iterator<Jugador> nombreIterator = jugadores.iterator();
        while(nombreIterator.hasNext()){
            Jugador jugador = nombreIterator.next();
            System.out.print(jugador+" / ");
        }

    }

    public void  jugar(){

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
