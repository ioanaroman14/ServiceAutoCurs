package Repository;

import Domain.Car;
import Domain.CarValidator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarRepository {

    private Map<Integer, Car> storage = new HashMap<>();

    private CarValidator validator;

    /**
     * Instantiates a repository for cars.
     * @param validator the validator used.
     */
    public CarRepository(CarValidator validator) {
        this.validator = validator;
        // low coupling, high cohesion
//        this.validator = new CarValidator();
    }

    // metode CRUD: Create, Read, Update, Delete

    /**
     * ...
     * @param car
     */
    public void add(Car car) {
        if (storage.containsKey(car.getId())) {
            throw new RuntimeException("A car with that id already exists!");
        }

        validator.validate(car);
        storage.put(car.getId(), car);
    }

    /**
     * ...
     * @param car
     */
    public void update(Car car) {
        if (!storage.containsKey(car.getId())) {
            throw new RuntimeException("There is no car with the given id to update!");
        }

        validator.validate(car);
        storage.put(car.getId(), car);
    }

    /**
     * @return a list of all cars.
     */
    public List<Car> getAll() {

        return new ArrayList<>(storage.values());
//        return (List<Car>)storage.values();
        //return storage.values().toArray();
    }
}
