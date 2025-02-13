import java.util.List;

public class BuzonReproceso {
    private List<Producto> productos;
    private int cantidad;

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
