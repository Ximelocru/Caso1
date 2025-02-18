public class OperarioProductor extends Thread {
    private int id;
    private String estado;
    private BuzonReproceso reproceso;
    private BuzonRevision revision;
    private static int idProducto;

    public OperarioProductor(int id, BuzonReproceso reproceso, BuzonRevision revision){
        this.id= id;
        this.reproceso= reproceso;
        this.revision= revision;
        this.idProducto=1;
    }
    public void run() {
        Boolean terminar = true;
        System.out.println("----- Inicia a trabajar el productor "+ id+" -----");
        while(terminar){
            Producto produc= reproceso.retirar();
            while(produc!=null&& produc.estado!="FIN"){
                revision.añadir(produc);
                produc= reproceso.retirar();
                System.out.println("Operario " + id+" saca un producto de fila de reprocesos ");
            }

            if (produc== null){
                Producto producto = new Producto(idProducto,"normal");
                idProducto++;
                System.out.println("Operario " + id+" crea un nuevo producto con id "+ producto.id);
                revision.añadir(producto);
            }
            if (produc!=null && (produc.estado=="FIN")){
                terminar= false;
            }

        }

        System.out.println("*** El productor "+this.id +" finaliza ***");
    }

}
