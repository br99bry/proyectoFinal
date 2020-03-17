import java.util.ArrayList;
import java.util.Collections;

public class Mazo {
    private int numTarjeta;
    private ArrayList<Tarjeta> tarjetas  = new ArrayList<Tarjeta>();;

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




    }

    public void barajeaMazo(){
        Collections.shuffle(tarjetas);
        //System.out.println(tarjetas.toString());
    }

    public void eliminaTarjeta(){
        tarjetas.remove(0);
    }

    public void agregaTarjeta(){

    }

    public Tarjeta proporcionaTarjeta(){

        return tarjetas.get(0);
    }

    public ArrayList<Tarjeta> proporcionarTarjetas(int num) {
        return tarjetas;
    }

    @Override
    public String toString() {
        return "Mazo{" +
                "numTarjeta=" + numTarjeta +
                ", tarjetas=\n" + tarjetas;
    }
}
