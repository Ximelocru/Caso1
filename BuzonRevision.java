import java.util.ArrayList;
import java.util.List;

public class BuzonRevision {
    private List<Producto> productos = new ArrayList<>();
    private int capacidadMaxima;

    public synchronized Producto retirar(){// preguntar donde se pone la espera semi-activa
        if (productos.size()==0){
            return null;
        }
        return productos.remove(0);
    }
    public synchronized void añadir(Producto producto){
        while(productos.size()>=capacidadMaxima){
            try{
                wait();
            }catch(InterruptedException e){
                throw new RuntimeException(e);
            }
        }
        productos.add(producto);
        notify();
    }



}
