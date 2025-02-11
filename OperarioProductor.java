public class OperarioProductor extends Thread {
    private int id;
    private String estado;
    private BuzonReproceso reproceso;
    private BuzonRevision revision;

    public OperarioProductor(int id, String estado, BuzonReproceso reproceso, BuzonRevision revision){
        this.id= id;
        this.estado= estado;
        this.reproceso= reproceso;
        this.revision= revision;
    }



    public void reprocesar(){

    }

    public void generar(){
// new Producto
    }

    public void almacenarBuzon(Producto producto){
        revision.añadir(producto);
    }
    

}
