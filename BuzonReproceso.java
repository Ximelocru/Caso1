import java.util.ArrayList;
import java.util.List;

public class BuzonReproceso {
    public List<Producto> productos;
    private int cantidad;

    public BuzonReproceso(){
        this.productos= new ArrayList<>();
    }

    public synchronized Producto retirar(){
        if (productos.size()==0){
            return null;
        }
        Producto producto = productos.removeFirst();
        return producto;

    }
    public synchronized void añadir(Producto producto){
        productos.add(producto);
    }


}
