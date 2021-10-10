package Lesson2.poly;

public class TransportApp {

    public static void main(String[] args) {
        Transport[] transports = new Transport[]{new Cater(), new Ship(), new Bus()}; // is a
        for (Transport transport : transports) {
            transport.load();

            if (transport instanceof Swimmable) {
                System.out.println("Эта штука плавает");
                Swimmable swimmable = (Swimmable) transport; // type-cast (приведение типа)
                swimmable.swim();
            }

            if (transport instanceof Bus) {
                Bus bus = (Bus) transport;
                System.out.println("Маршрут " + bus.getMarshrout());
            }
            System.out.println();
        }

        NewsService newsService = new OracleNewsService();
        //some logig

    }
}
