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
            while(produc!=null&& produc.estado!="FIN"){
                revision.añadir(produc);
                produc= reproceso.retirar();
                System.out.println("Se saca un producto de fila de reprocesos ");
            }

            if (produc== null){
                Producto producto = new Producto("normal");
                System.out.println("Se crea un nuevo producto");
                revision.añadir(producto);
            }
            if (produc!=null && (produc.estado=="FIN")){
                terminar= false;
            }

        }

        System.out.println("El productor "+this.id +" finaliza");
    }

}
