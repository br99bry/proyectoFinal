import java.util.ArrayList;
import java.util.Collections;

public class Mazo {
    private int numTarjeta;
    private ArrayList<Tarjeta> tarjetas= new ArrayList<Tarjeta>();

    public Mazo(){

    }


    public void iniciaMazo (){

        for (int j = 0; j <2 ; j++) {
            for (int i = 1; i <10 ; i++) {
                TarjetaNumerica tarjetaNumerica = new TarjetaNumerica();
                tarjetaNumerica.fijarColor(1);
                tarjetaNumerica.setNumero(i);
                tarjetas.add(tarjetaNumerica);

            }

            for (int i = 1; i <10 ; i++) {
                TarjetaNumerica tarjetaNumerica = new TarjetaNumerica();
                tarjetaNumerica.fijarColor(2);
                tarjetaNumerica.setNumero(i);
                tarjetas.add(tarjetaNumerica);
            }
            for (int i = 1; i <10 ; i++) {
                TarjetaNumerica tarjetaNumerica = new TarjetaNumerica();
                tarjetaNumerica.fijarColor(3);
                tarjetaNumerica.setNumero(i);
                tarjetas.add(tarjetaNumerica);
            }
            for (int i = 1; i <10 ; i++) {
                TarjetaNumerica tarjetaNumerica = new TarjetaNumerica();
                tarjetaNumerica.fijarColor(4);
                tarjetaNumerica.setNumero(i);
                tarjetas.add(tarjetaNumerica);
            }
        }

        for (int i = 1; i <5 ; i++) {
            TarjetaNumerica tarjetaNumerica = new TarjetaNumerica();
            tarjetaNumerica.fijarColor(i);
            tarjetaNumerica.setNumero(0);
            tarjetas.add(tarjetaNumerica);
        }

    for (int k= 0; k < 2; k++) {

            for(int i =0; i < 4 ; i++){
                TarjetaCastigo tarjetaCastigo = new TarjetaCastigo();
                tarjetaCastigo.fijarCastigo(1);
                tarjetaCastigo.fijarColor(i+1);
                tarjetaCastigo.fijarSimbolo(1);
                tarjetas.add(tarjetaCastigo);
            }
        }

        for (int k= 0; k < 2; k++) {

            for(int i =0; i < 4 ; i++){
                TarjetaCastigo tarjetaCastigo = new TarjetaCastigo();
                tarjetaCastigo.fijarCastigo(2);
                tarjetaCastigo.fijarColor(i+1);
                tarjetaCastigo.fijarSimbolo(2);
                tarjetas.add(tarjetaCastigo);
            }
        }

        for (int k= 0; k < 2; k++) {

            for(int i =0; i < 4 ; i++){
                TarjetaCastigo tarjetaCastigo = new TarjetaCastigo();
                tarjetaCastigo.fijarCastigo(3);
                tarjetaCastigo.fijarColor(i+1);
                tarjetaCastigo.fijarSimbolo(3);
                tarjetas.add(tarjetaCastigo);
            }
        }

        for(int i =0; i < 4 ; i++){
            TarjetaCastigo tarjetaCastigo = new TarjetaCastigo();
            tarjetaCastigo.fijarCastigo(4);
            tarjetaCastigo.fijarSimbolo(4);
            tarjetas.add(tarjetaCastigo);
        }

        for(int i =0; i < 4 ; i++){
            TarjetaCastigo tarjetaCastigo = new TarjetaCastigo();
            tarjetaCastigo.fijarCastigo(5);
            tarjetaCastigo.fijarSimbolo(5);
            tarjetas.add(tarjetaCastigo);
        }

         //System.out.println(tarjetas.toString());


    }

    public void barajeaMazo(){
        Collections.shuffle(tarjetas);
        //System.out.println(tarjetas.toString());
    }

    public void eliminaTarjeta(){
        tarjetas.remove(0);
    }

    public void agregaTarjeta(Tarjeta tarjeta){
        tarjetas.add(0,tarjeta);
    }

    public Tarjeta proporcionaTarjeta(){

        return tarjetas.get(0);
    }

    public ArrayList<Tarjeta> proporcionarTarjetas(int num) {
        ArrayList<Tarjeta> t = new ArrayList<Tarjeta>();


        for (int i = 0; i <num ; i++) {
            t.add(tarjetas.get(0));
            eliminaTarjeta();
        }
        return t;
    }

    @Override
    public String toString() {
        return "Mazo{" +
                "tarjetas=\n" + tarjetas;
    }
}
