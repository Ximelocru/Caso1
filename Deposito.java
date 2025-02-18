import java.util.ArrayList;
import java.util.List;

public class Deposito {
    public List<Producto> productos ;

    public Deposito(){
        this.productos= new ArrayList<>();
    }

    public synchronized int depositar(Producto producto){// precaucion acá, se debe de empezar a crear fin la cantidad de operarios
        System.out.println("Entra el producto numero "+producto.id+" al deposito.");

        productos.add(producto);
        return productos.size();
    }
    

}
