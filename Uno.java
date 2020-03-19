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


        mazo.iniciaMazo();
        mazo.barajeaMazo();
        /*System.out.println();
        System.out.println(mazo.toString());
        System.out.println();*/
    }

    public void  jugar(){
        Scanner respuesta = new Scanner(System.in);
        //System.out.println(mazo.toString());
        for (int i = 0; i <getNumJugadores() ; i++) {
            jugadores.get(i).agregarTarjeta(mazo.proporcionaTarjeta());
            jugadores.get(i).getTarjetas().get(0).setPos(0);
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
        System.out.println("Se han repartido las cartas");
        int turnoDeJugar = jugadorQueReparte;
        System.out.println("Es turno del jugador No.  " + (turnoDeJugar+1));
        System.out.println("El jugador No. "+(turnoDeJugar+1)+" tomo la siguiente carta del mazo para jugar");
        jugadores.get(turnoDeJugar).tomarCartas(mazo,1);
        int pos = jugadores.get(turnoDeJugar).getTarjetas().size() -1;

        /*System.out.println("Este es el mazo antes de jugar tarjeta");
        System.out.println(jugadores.get(turnoDeJugar).getTarjetas().toString());*/

        Tarjeta TarjetaAPila = jugadores.get(turnoDeJugar).jugarTarjeta( jugadores.get(turnoDeJugar).getTarjetas().get(pos));
        jugadores.get(turnoDeJugar).getTarjetas().remove(pos);
        pila.iniciaMazo(TarjetaAPila);
        //System.out.println(pila.toString());

        /*System.out.println();
        System.out.println("Este es el mazo individual de cada jugardor");
        for (int i = 0; i <getNumJugadores() ; i++) {
            System.out.println(jugadores.get(i).getTarjetas().toString());
        }*/


        int respuestaJugador=0;
        //System.out.println("");
        do{
            sentido = 1;
            while (sentido==1){
                //System.out.println(turnoDeJugar+1);
                //System.out.println(numJugadores);
                if ((turnoDeJugar+1)==numJugadores){


                    turnoDeJugar = 0;
                    System.out.println("Es turno del jugador No. : " + (turnoDeJugar+1));
                    System.out.println("Tus tarjetas son: \n");
                    for (int i = 0; i <10 ; i++) {
                        System.out.println();
                    }
                    System.out.println(jugadores.get(turnoDeJugar).getTarjetas().toString());

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
                    Tarjeta t = jugadores.get(turnoDeJugar).getTarjetas().get(respuestaJugador-1);
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

                    if (tn.getColor() == tnp.getColor()){
                        System.out.println("tarjeta valida por color igual");
                    } else if(tn.getNumero() == tnp.getNumero()){
                        System.out.println("Tarjeta valida por numero");
                    }else if(tc.getSimbolo()=="cambio de sentido" && (tc.getColor() == tnp.getColor() || tcp.getSimbolo()=="cambio de sentido")){
                        System.out.println("Tarjeta valida para castigar con cambio de sentido");
                        sentido = 0;
                    }else if(tc.getSimbolo()=="salto de turno" && (tc.getColor() == tnp.getColor() || tcp.getSimbolo()=="salto de turno")){
                        System.out.println("Tarjeta valida para castigar con bloqueo");
                    }else if(tc.getSimbolo()=="castigo mas dos" && tc.getColor() == tnp.getColor() || tcp.getSimbolo()=="castigo mas dos"){
                        System.out.println("Tarjeta valida para castigo mas dos");
                    }else if(tc.getSimbolo()=="comodin de castigo +4"){
                        System.out.println("Tarjeta valida para comodin +4");
                    }else if(tc.getSimbolo()=="comodin de color"){
                        System.out.println("Tarjeta valida para comodin color");
                    }else if(tcp.getSimbolo()=="cambio de sentido" && (tc.getColor() == tnp.getColor() || tcp.getSimbolo()=="cambio de sentido")){
                        System.out.println("se invirtio sentido del juego");
                    }else if(tcp.getSimbolo()=="salto de turno" && (tc.getColor() == tnp.getColor() || tcp.getSimbolo()=="salto de turno")){
                        System.out.println("saltamos al jugador anterior pon tarjeta de este color");
                    }else if(tcp.getSimbolo()=="castigo mas dos" && tc.getColor() == tnp.getColor() || tcp.getSimbolo()=="castigo mas dos"){
                        System.out.println("como dos y valida");
                    }else if(tcp.getSimbolo()=="comodin de castigo +4"){
                        System.out.println("come 4 y pon del color que te elegigieron");
                    }else if(tc.getSimbolo()=="comodin de color"){
                        System.out.println("pon del color que te indican");
                    }else{
                        System.out.println("Tarjeta invalida");
                    }


                    turnoDeJugar+=2;


                }
                else{
                    System.out.println("Es turno del jugador No. : " + (turnoDeJugar+2));
                    System.out.println("Tus tarjetas son: \n");
                    for (int i = 0; i <10 ; i++) {
                        System.out.println();
                    }
                    System.out.println(jugadores.get(turnoDeJugar+1).getTarjetas().toString());


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
                    Tarjeta t = jugadores.get(turnoDeJugar).getTarjetas().get(respuestaJugador-1);
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


                    if (tn.getColor() == tnp.getColor()){
                        System.out.println("tarjeta valida por color igual");
                    } else if(tn.getNumero() == tnp.getNumero()){
                        System.out.println("Tarjeta valida por numero");
                    }else if(tc.getSimbolo()=="cambio de sentido" && (tc.getColor() == tnp.getColor() || tcp.getSimbolo()=="cambio de sentido")){
                        System.out.println("Tarjeta valida para castigar con cambio de sentido");
                        //sentido = 0;
                    }else if(tc.getSimbolo()=="salto de turno" && (tc.getColor() == tnp.getColor() || tcp.getSimbolo()=="salto de turno")){
                        System.out.println("Tarjeta valida para castigar con bloqueo");
                    }else if(tc.getSimbolo()=="castigo mas dos" && tc.getColor() == tnp.getColor() || tcp.getSimbolo()=="castigo mas dos"){
                        System.out.println("Tarjeta valida para castigo mas dos");
                    }else if(tc.getSimbolo()=="comodin de castigo +4"){
                        System.out.println("Tarjeta valida para comodin +4");
                    }else if(tc.getSimbolo()=="comodin de color"){
                        System.out.println("Tarjeta valida para comodin color");
                    }else if(tcp.getSimbolo()=="cambio de sentido" && (tc.getColor() == tnp.getColor() || tcp.getSimbolo()=="cambio de sentido")){
                        System.out.println("se invirtio sentido del juego");
                    }else if(tcp.getSimbolo()=="salto de turno" && (tc.getColor() == tnp.getColor() || tcp.getSimbolo()=="salto de turno")){
                        System.out.println("saltamos al jugador anterior pon tarjeta de este color");
                    }else if(tcp.getSimbolo()=="castigo mas dos" && tc.getColor() == tnp.getColor() || tcp.getSimbolo()=="castigo mas dos"){
                        System.out.println("como dos y valida");
                    }else if(tcp.getSimbolo()=="comodin de castigo +4"){
                        System.out.println("come 4 y pon del color que te elegigieron");
                    }else if(tc.getSimbolo()=="comodin de color"){
                        System.out.println("pon del color que te indican");
                    }else{
                        System.out.println("Tarjeta invalida");
                    }

                    turnoDeJugar+=2;

                }





            }
        }while (mazo.getTarjetas().size()>0 && sentido!=0);




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
