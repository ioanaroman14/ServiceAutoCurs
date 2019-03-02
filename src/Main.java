import Domain.CarValidator;
import Repository.CarRepository;
import Service.CarService;
import UI.Console;

public class Main {

    public static void main(String[] args) {
        CarValidator validator = new CarValidator();
        CarRepository repository = new CarRepository(validator);
        CarService service = new CarService(repository);
        Console console = new Console(service);
        console.run();
    }
}
