import java.util.Queue;

public class BuzonRevision {
    private Queue<Producto> productos;
    private int capacidadMaxima;

    public synchronized Producto retirar(){// preguntar donde se pone la espera semi-activa
        while(productos.isEmpty()){
            //semi-activa
        }
        Producto producto = productos.remove();
        notify();
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
        notify();
    }



}
