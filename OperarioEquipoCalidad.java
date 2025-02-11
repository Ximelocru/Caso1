public class OperarioEquipoCalidad extends Thread {
    private int id;
    private int productosRechazados;
    private int maximoProductosRechazados;
    private static int total_deposito;
    private BuzonRevision revision;

    public void run() {
        Producto producto= revision.retirar();
        while (producto == null){
            Thread.yield();
            producto=revision.retirar();
        }
    }


}
