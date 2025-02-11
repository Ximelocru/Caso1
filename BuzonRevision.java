import java.util.ArrayList;
import java.util.List;

public class BuzonRevision {
    private List<Producto> productos = new ArrayList<>();
    private int capacidadMaxima;

    public BuzonRevision(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    public synchronized Producto retirar(){
        if (productos.size()==0){
            return null;
        }
        Producto producto = productos.remove(0);
        notifyAll();
        return producto;
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
    }



}
