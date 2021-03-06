import sun.misc.JavaUtilJarAccess;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class Uno {

    private int numJugadores;
    private int sentido;
    private Tarjeta tarjeta;
    private Mazo mazo = new Mazo();
    private Mazo pila = new Mazo();
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
                    System.out.println("Digito un caracter no valido, intenta de nuevo");
                    iniciar();
                }


        for (int i = 0; i <getNumJugadores() ; i++) {
            Jugador jugador = new Jugador(i+1);
            jugadores.add(jugador);
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("aqui se muestran los jugadores creados");
        System.out.println(jugadores.toString());

        mazo.iniciaMazo();
        mazo.barajeaMazo();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("aqui se muestra mazo barajeado");
        System.out.println(mazo.toString());
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

    }

    public void  jugar(){
        Scanner respuesta = new Scanner(System.in);
        //System.out.println(mazo.toString());

        System.out.println();
        System.out.println("carta del inicio tomada");
        for (int i = 0; i <getNumJugadores() ; i++) {
            jugadores.get(i).agregarTarjeta(mazo.proporcionaTarjeta());
            jugadores.get(i).getTarjetas().get(0).setPos(0);
            System.out.println(jugadores.get(i).toString());
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
                if(tc.getSimbolo()=="comodin de castigo +4"){
                    System.out.println("Elige un color para tu tarjeta comodin de castigo +4");
                    System.out.println("0. azul\n1.rojo\n2.verde\n3.amarillo");
                    int colorElegido = respuesta.nextInt();
                    tc.fijarColor(colorElegido);
                }else if(tc.getSimbolo()=="comodin de color"){
                    System.out.println("Elige un color para tu tarjeta comodin de castigo +4");
                    System.out.println("0. azul\n1.rojo\n2.verde\n3.amarillo");
                    int colorElegido = respuesta.nextInt();
                    tc.fijarColor(colorElegido);
                }
            }
        }
        System.out.println();
        System.out.println("El jugador que reparte es el No. " + (jugadorQueReparte+1));
        jugadores.get(jugadorQueReparte).repartirCartas(jugadores,mazo);









        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("Se han repartido las cartas de la siguiente manera");


        for (int i = 0; i <numJugadores ; i++) {
            System.out.println(jugadores.get(i).getTarjetas().toString());
        }




        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        int turnoDeJugar = jugadorQueReparte;
        System.out.println("Es turno del jugador No.  " + (turnoDeJugar+1));
        System.out.println("El jugador No. "+(turnoDeJugar+1)+" tomo la siguiente carta del mazo para jugar");
        jugadores.get(turnoDeJugar).tomarCartas(mazo,1);
        int pos = jugadores.get(turnoDeJugar).getTarjetas().size() -1;
        System.out.println(jugadores.get(turnoDeJugar).getTarjetas().get(pos).toString());

        Tarjeta TarjetaAPila = jugadores.get(turnoDeJugar).jugarTarjeta( jugadores.get(turnoDeJugar).getTarjetas().get(pos));
        jugadores.get(turnoDeJugar).getTarjetas().remove(pos);
        pila.iniciaMazo(TarjetaAPila);
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("se muestra la pila");
        System.out.println(pila.toString());
        System.out.println();
        System.out.println();

        turnoDeJugar++;
        int respuestaJugador=0;
        //System.out.println("");
        do{

                    System.out.println("Es turno del jugador No. : " + (turnoDeJugar+1));
                    System.out.println("Tus tarjetas son: \n");
                    System.out.println(jugadores.get(turnoDeJugar-1).getTarjetas().toString());

                    boolean esIncorrecto = true;
                    while(esIncorrecto) {

                        try {

                            System.out.println("Elige la tarjeta que deseas jugar");
                            respuestaJugador = respuesta.nextInt();

                            // Si no ocurren exepciones, modificas el valor del condicional del while a false para detener el ciclo.
                            esIncorrecto = false;
                        } catch (Exception e) {
                            System.out.println("Has introducido un valor incorrecto");
                        }
                        // esta linea siempre debe ir despues de nextInt()
                        respuesta.nextLine();
                    }

                    TarjetaNumerica tn=null;
                    TarjetaCastigo tc=null;
                    TarjetaNumerica tnp=null;
                    TarjetaCastigo tcp=null;




                    Tarjeta t = jugadores.get(turnoDeJugar-1).getTarjetas().get(respuestaJugador-1);
                    Tarjeta tp = pila.getTarjetas().get(pila.getTarjetas().size()-1);


                    if(t instanceof  TarjetaNumerica){
                        tn = (TarjetaNumerica) t;


                    }else if(t instanceof TarjetaCastigo){
                        tc = (TarjetaCastigo) t;
                        if(tc.getSimbolo()=="comodin de castigo +4"){
                            System.out.println("Elige un color para tu tarjeta comodin de castigo +4");
                            System.out.println("0. azul\n1.rojo\n2.verde\n3.amarillo");
                            int colorElegido = respuesta.nextInt();
                            tc.fijarColor(colorElegido);
                        }else if(tc.getSimbolo()=="comodin de color"){
                            System.out.println("Elige un color para tu tarjeta comodin de castigo +4");
                            System.out.println("0. azul\n1.rojo\n2.verde\n3.amarillo");
                            int colorElegido = respuesta.nextInt();
                            tc.fijarColor(colorElegido);
                        }

                    }

                    if(tp instanceof TarjetaNumerica){
                        tnp = (TarjetaNumerica) tp;

                    }else if(tp instanceof  TarjetaCastigo){
                        tcp = (TarjetaCastigo) tp;

                    }

                    if(tnp!=null && tn!=null){
                        if (tn.getColor() == tnp.getColor()){
                            System.out.println("tarjeta valida por color igual");
                        } else if(tn.getNumero() == tnp.getNumero()){
                            System.out.println("Tarjeta valida por numero");
                        }else{
                            System.out.println("tarjeta no valida");
                        }
                    }else if(tnp!=null && tn==null){
                        if (tc.getColor()==tnp.getColor()){
                            System.out.println("Puedes poner esta especial");
                        }
                    }else if(tnp==null && tn!=null){
                        System.out.println("Obedece castigo");

                    }else if(tnp==null && tn==null){
                        System.out.println("valido");
                    }


                    int pos1 = (respuestaJugador-1);
                    Tarjeta TarjetaAPila2 = jugadores.get(turnoDeJugar-1).jugarTarjeta( jugadores.get(turnoDeJugar-1).getTarjetas().get(pos1));
                    jugadores.get(turnoDeJugar-1).getTarjetas().remove(pos1);
                    pila.iniciaMazo(TarjetaAPila2);


                    turnoDeJugar++;

                    if (turnoDeJugar>numJugadores-1){
                        turnoDeJugar=0;
                    }

        }while (mazo.getTarjetas().size()>0);



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
