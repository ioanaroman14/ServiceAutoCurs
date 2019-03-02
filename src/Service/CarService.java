package Service;

import Domain.Car;
import Repository.CarRepository;

import java.util.List;

public class CarService {

    private CarRepository repository;

    /**
     * ...
     * @param repository
     */
    public CarService(CarRepository repository) {
        this.repository = repository;
    }

    /**
     * ...
     * @param id
     * @param stand
     * @param license
     * @param days
     */
    public void enterService(int id, int stand, String license, int days) {

        Car car = new Car(id, stand, license, days);
        List<Car> cars = repository.getAll();
        for (Car c : cars) {
            if (c.getStand() == stand && !c.isLeftService()) {
                throw new RuntimeException("That stand is already taken!");
            }
        }
        repository.add(car);
    }

    /**
     *
     * @param stand
     * @param report
     * @param price
     */
    public void exitService(int stand, String report, double price) {
        Car carOnStand = null;
        List<Car> cars = repository.getAll();
        for (Car c : cars) {
            if (c.getStand() == stand && !c.isLeftService()) {
                carOnStand = c;
            }
        }

        if (carOnStand != null) {
            carOnStand.setReport(report);
            carOnStand.setPrice(price);
            repository.update(carOnStand);
        } else {
            throw new RuntimeException("There is no car on the given stand!");
        }
    }

    public List<Car> getAll() {
        return repository.getAll();
    }
}
