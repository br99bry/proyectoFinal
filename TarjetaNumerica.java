import java.util.ArrayList;

public class TarjetaNumerica extends  Tarjeta{
    private int numero;
    private String color;

    public TarjetaNumerica(){
        super();

    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    @Override
    public int juegaTarjeta(){
        int i=0;

        return i;
    }

    @Override
    public void fijarColor(int i){
        super.colores = new ArrayList<String>();
        colores.add("Azul");
        colores.add("Rojo");
        colores.add("Verde");
        colores.add("Amarillo");

        switch (i){
            case 1:
                    color = colores.get(0);
                break;
            case 2:
                    color = colores.get(1);
                break;
            case 3:
                    color = colores.get(2);
                break;
            case 4:
                    color = colores.get(3);
                break;
        }
    }


    @Override
    public String toString() {
        return "TarjetaNumerica{" +
                "numero=" + numero +
                ", color='" + color + '\'' +
                '}'+"\n";
    }
}
