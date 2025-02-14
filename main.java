public class main {
    public static void main(String [] args){
        BuzonRevision revision= new BuzonRevision(10);
        BuzonReproceso reproceso = new BuzonReproceso();
        Deposito deposito = new Deposito();
        for( int i=0; i<5;i++){
            System.out.println("Se crea el productor: "+i);
            new OperarioProductor(i,reproceso,revision).start();
            System.out.println("Se crea el operario: "+i);
            new OperarioEquipoCalidad(i, 20, revision, reproceso, deposito).start();
        }



    }

}
