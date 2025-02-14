import java.util.ArrayList;
import java.util.List;

public class Deposito {
    public List<Producto> productos ;
    public int contador = 0;

    public Deposito(){
        this.productos= new ArrayList<>();
            
        
    }

    public synchronized int depositar(Producto producto){// precaucion acá, se debe de empezar a crear fin la cantidad de operarios
        contador++;
        System.out.println(contador);
        productos.add(producto);
        return productos.size();
    }
    

}
