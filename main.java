import java.util.Scanner;

public class main {
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);

        //lecturad de parametros
        System.out.println("Ingresar el número de operarios productores y operarios de calidad: ");
        int numOperarios = scanner.nextInt();
        System.out.println("Ingresar el número total de productos para producir: ");
        int totalProductos = scanner.nextInt();
        System.out.println("Ingresar capacidad máxima del buzón de revisión: ");
        int capacidadBuzonRevision = scanner.nextInt();

        //buzones-deposito
        BuzonRevision revision = new BuzonRevision(capacidadBuzonRevision);
        BuzonReproceso reproceso = new BuzonReproceso();
        Deposito deposito = new Deposito();
        //operarios productores
        for (int i = 0; i < numOperarios; i++) {
            System.out.println("Se crea el productor: " + i);
            new OperarioProductor(i, reproceso, revision).start();
        }
        //operarios de calidad
        for (int i = 0; i < numOperarios; i++) {
            System.out.println("Se crea el operario de calidad: " + i);
            new OperarioEquipoCalidad(i, totalProductos, revision, reproceso, deposito).start();
        }
        scanner.close();
    }



}
