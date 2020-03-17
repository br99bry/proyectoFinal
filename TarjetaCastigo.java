import java.util.ArrayList;

public class TarjetaCastigo extends Tarjeta {
    private String simbolo;
    private int tipoCastigo;
    private String color;

    public TarjetaCastigo(){
        super();
    }

    public void setSimbolo(String simbolo, int tipoCastigo){
        this.simbolo = simbolo;
        this.tipoCastigo = tipoCastigo;
    }

    public int juegaTarjeta(){
        int i=0;
        return i;
    }

    public int getCastigo(){
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
        return "TarjetaCastigo{" +
                "simbolo=" + simbolo +
                ", color='" + color +
                ", castigo='" + tipoCastigo + '\'' +
                '}'+"\n";
    }
}
