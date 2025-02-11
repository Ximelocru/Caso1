import java.util.List;

public class BuzonReproceso {
    private List<Producto> productos;
    private int cantidad;

    public synchronized Producto retirar(){
        return productos.removeFirst();
    }

    public synchronized Boolean saber(){
        if (productos.size()==0){
            return false;
        }
        return true;
    }

}
