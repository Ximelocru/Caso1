import java.util.Random;

public class OperarioEquipoCalidad extends Thread {
    private int id;
    private int productosRechazados;
    private int maximoProductosRechazados;
    private static int total_deposito;
    private BuzonRevision revision;

    public void run() {
        while(true){
            Producto producto= revision.retirar();
            while (producto == null){
                Thread.yield();
                producto=revision.retirar();
            }
            int numero = numeror();
            if (numero%7==0){

            }
        }
        
    }

    public int numeror(){
        Random rand = new Random();
        int numero = rand.nextInt(100) + 1;
        return numero;
    }


}
