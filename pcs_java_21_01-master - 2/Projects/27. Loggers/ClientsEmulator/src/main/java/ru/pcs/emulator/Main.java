package ru.pcs.emulator;

/**
 * 11.10.2021
 * ClientsEmulator
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main {
    public static void main(String[] args) {
        Clients clients = new Clients();
        clients.newClient(() -> System.out.println("Hello"));
        clients.newClient(() -> System.out.println("Hello"));
        clients.newClient(() -> System.out.println("Hello"));
        clients.newClient(() -> System.out.println("Hello"));
        clients.run();
        clients.stop();
    }
}
