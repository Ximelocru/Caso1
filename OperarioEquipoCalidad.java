import java.util.Random;

public class OperarioEquipoCalidad extends Thread {
    private int id;
    private int productosRechazados;
    private double maximoProductosRechazados;
    private static int total_deposito;
    private BuzonRevision revision;
    private BuzonReproceso reproceso;
    private Deposito deposito;
    
    public OperarioEquipoCalidad(int id, int total_deposit, BuzonRevision revision, BuzonReproceso reproceso, Deposito deposito){
        this.id= id;
        this.total_deposito= total_deposit;
        this.revision = revision;
        this.reproceso= reproceso;
        this.deposito= deposito;
        this.productosRechazados=0;
        this.maximoProductosRechazados= Math.floor(this.total_deposito*0.10);
    }
    public void run() {
        System.out.println("----- Inicia a trabajar el operario de calidad "+id +" -----");
        Boolean terminar = true;
        while(terminar){
            Producto producto= revision.retirar();
            while (producto == null){
                Thread.yield();
                producto=revision.retirar();
            }
            int numero = numeror();
            if (numero%7==0 && productosRechazados<maximoProductosRechazados){
                reproceso.añadir(producto);
                System.out.println("Se rechaza el producto y se manda al reproceso.");
            }
            else{
                deposito.depositar(producto);
                System.out.println("Se deposita el porducto en el deposito.");
                if (deposito.productos.size()>=total_deposito){
                    Producto productico = new Producto(-1,"FIN");
                    reproceso.añadir(productico);
                    producto= revision.retirar();
                    while(producto != null){
                        deposito.depositar(producto);
                        System.out.println("Se deposita el porducto en el deposito, para desocupar el buzon de revisión.");
                        producto= revision.retirar();
                    }
                    terminar= false;
                }
            }  
        }
        
        System.out.println("*** El operario  "+this.id +" finaliza sus labores ***");
        
    }

    public int numeror(){
        Random rand = new Random();
        int numero = rand.nextInt(100) + 1;
        return numero;
    }


}
