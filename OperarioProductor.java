public class OperarioProductor extends Thread {
    private int id;
    private String estado;
    private BuzonReproceso reproceso;
    private BuzonRevision revision;

    public OperarioProductor(int id, BuzonReproceso reproceso, BuzonRevision revision){
        this.id= id;
        this.reproceso= reproceso;
        this.revision= revision;
    }
    public void run() {
        Boolean terminar = true;
        while(terminar){
            Producto produc= reproceso.retirar();
            if (produc!=null&& produc.estado== "FIN"){
                terminar= false;
            }
            while(produc!=null&& terminar){
                revision.añadir(produc);
                produc= reproceso.retirar();
                System.out.println("Se saca de reproceso el producto: ");
            }

            Producto producto = new Producto("normal");
            System.out.println("Se crea el producto: ");
            revision.añadir(producto);

        }

        System.out.println("El productor: "+this.id +"finaliza");
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
