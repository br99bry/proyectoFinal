import java.util.ArrayList;

public abstract class Tarjeta {
    protected ArrayList<String> colores;
    protected int numColor;
    protected int pos;


    public abstract int juegaTarjeta();

    public abstract void fijarColor(int i);




}
