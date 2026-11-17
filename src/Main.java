public class Main {

    public static void main(String[] args) {
        
        Red red = new Red("Laboratorio");

        System.out.println("=== RED VACIA ===");
        System.out.println(red.mostrarDispositivos());

        DispositivoRed r1 =
                new DispositivoRed(
                        "RouterCentral",
                        "192.168.1.1",
                        "Router",
                        true);

        DispositivoRed s1 =
                new DispositivoRed(
                        "Switch01",
                        "192.168.1.10",
                        "Switch",
                        true);

        DispositivoRed ap1 =
                new DispositivoRed(
                        "AP01",
                        "192.168.1.20",
                        "Access Point",
                        true);

        DispositivoRed srv1 =
                new DispositivoRed(
                        "Servidor01",
                        "192.168.1.100",
                        "Servidor",
                        false);

        DispositivoRed s2 =
                new DispositivoRed(
                        "Switch02",
                        "192.168.1.11",
                        "Switch",
                        true);

        red.agregarDispositivo(r1);
        red.agregarDispositivo(s1);
        red.agregarDispositivo(ap1);
        red.agregarDispositivo(srv1);
        red.agregarDispositivo(s2);

        System.out.println("\n=== DISPOSITIVOS ===");
        System.out.println(red.mostrarDispositivos());

        System.out.println("=== BUSCAR 192.168.1.10 ===");

        DispositivoRed encontrado =
                red.buscarPorIP("192.168.1.10");

        if (encontrado != null) {
            System.out.println(
                    encontrado.mostrarInformacion());
        }

        System.out.println("\n=== BUSCAR 10.10.10.10 ===");

        DispositivoRed noExiste =
                red.buscarPorIP("10.10.10.10");

        if (noExiste == null) {
            System.out.println("No encontrado");
        }

        System.out.println("\n=== ELIMINAR 192.168.1.20 ===");
        System.out.println(
                red.eliminarDispositivo("192.168.1.20"));

        System.out.println("\n=== ELIMINAR 10.10.10.10 ===");
        System.out.println(
                red.eliminarDispositivo("10.10.10.10"));

        System.out.println("\n=== ACTIVOS ===");
        System.out.println(red.contarActivos());

        System.out.println("\n=== SWITCHES ===");
        System.out.println(red.contarPorTipo("Switch"));

        System.out.println("\n=== PRIMER SWITCH ACTIVO ===");

        DispositivoRed activo =
                red.buscarActivoPorTipo("Switch");

        if (activo != null) {
            System.out.println(
                    activo.mostrarInformacion());
        }
    }
}