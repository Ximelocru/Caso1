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
        while(true){
            Producto produc= reproceso.retirar();
            while(produc!=null){
                revision.añadir(produc);
                produc= reproceso.retirar();
            }
            Producto producto = new Producto();
            revision.añadir(producto);

        }
    }

    //Ensayo
    public Boolean reproceso(){
        Producto produc= reproceso.retirar();
        if(produc!=null){
            revision.añadir(produc);
            return true;
        }
        return false;
    }

}
