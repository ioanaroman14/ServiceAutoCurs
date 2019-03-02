package UI;

import Domain.Car;

import Service.CarService;

import java.util.Map;
import java.util.Scanner;

public class Console {

    private CarService service;
    private Scanner scanner;

    public Console(CarService service) {
        this.service = service;
        scanner = new Scanner(System.in);
    }

    private void showMenu() {
        System.out.println("1. Intrare in service");
        System.out.println("2. Iesire din service");
        System.out.println("3. Raport pret standuri");
        System.out.println("a. Afisare toate masinile");
        System.out.println("x. Iesire");
    }

    public void run() {

        while (true) {
            showMenu();
            String option = scanner.nextLine();
            if (option.equals("1")) {
                handleServiceEntry();
            } else if (option.equals("2")) {
                handleServiceExit();
            } else if (option.equals("3")) {
                handleStandsReport();
            } else if (option.equals("a")) {
                handleShowAll();
            } else if (option.equals("x")) {
                break;
            }
        }
    }

    private void handleStandsReport() {
        Map<Double, Integer> reports = service.getReports();
        for(Double price:reports.keySet())
            System.out.println("Stand:  " +  reports.get(price)   + "  price:  " + price);


    }

    private void handleServiceExit() {
        try {
            System.out.println("Dati standul:");
            int stand = Integer.parseInt(scanner.nextLine());
            System.out.println("Dati raportul de service:");
            String report = scanner.nextLine();
            System.out.println("Dati pretul facturat:");
            double price = Double.parseDouble(scanner.nextLine());

            service.exitService(stand, report, price);
        } catch (RuntimeException runtimeException) {
            System.out.println("Avem erori: " + runtimeException.getMessage());
        }
    }

    private void handleShowAll() {
        for (Car c : service.getAll())
            System.out.println(c);
    }

    private void handleServiceEntry() {

        try {
            System.out.println("Dati id-ul:");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.println("Dati standul:");
            int stand = Integer.parseInt(scanner.nextLine());
            System.out.println("Dati numarul de inmatriculare:");
            String license = scanner.nextLine();
            System.out.println("Dati numarul de zile:");
            int days = Integer.parseInt(scanner.nextLine());

            service.enterService(id, stand, license, days);
        } catch (RuntimeException runtimeException) {
            System.out.println("Avem erori: " + runtimeException.getMessage());
        }
    }
}
