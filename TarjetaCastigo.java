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

    @Override
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

        public void fijarCastigo(int i){

        switch (i){
            case 1:
                    this.tipoCastigo = i;
                break;
            case 2:
                    this.tipoCastigo = i;
                break;
            case 3:
                    this.tipoCastigo = i;
                break;
            case 4:
                    this.tipoCastigo = i;
                break;
            case 5:
                    this.tipoCastigo = i;
            break;
        }
    }

    public void fijarSimbolo(int i){
        switch (i){
            case 1:
                this.simbolo = "castigo mas dos";
                break;
            case 2:
                this.simbolo = "salto de turno";
                break;
            case 3:
                this.simbolo = "cambio de sentido";
                break;
            case 4:
                this.simbolo = "comodin de castigo +4";
                break;
            case 5:
                this.simbolo = "comodin de color";
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
