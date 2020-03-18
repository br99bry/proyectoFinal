import java.util.ArrayList;

public class Mazo {
    private int numTarjeta;
    private ArrayList<Tarjeta> tarjetas;

    public Mazo(){
        
    }


    public void iniciaMazo (){
        tarjetas = new ArrayList<Tarjeta>();
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
        for (int j = 1; j < 4 ; j++) {
           for(int i =0; i < 8 ; i++){
            TarjetaCastigo tarjetaCastigo = new TarjetaCastigo();
            tarjetaCastigo.fijarCastigo(1);
            tarjetaCastigo.fijarColor(j);
            tarjetas.add(tarjetaCastigo);
           }
        }
    }

         System.out.println(tarjetas.toString());

    }

    public void barajeaMazo(){

    }

    public void eliminaTarjeta(){

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
                ", tarjetas=" + tarjetas +
                '}';
    }
}
