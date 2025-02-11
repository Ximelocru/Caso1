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
    public void run() {
        while(reproceso.saber()){
            Producto produc= reproceso.retirar();
            revision.añadir(produc);
        }
    }




    public void reprocesar(){

    }

    public Producto generar(){
        return new Producto();
    }

    public void almacenarBuzon(Producto producto){
        revision.añadir(producto);
    }
    

}
