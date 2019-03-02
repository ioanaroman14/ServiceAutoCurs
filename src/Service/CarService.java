package Service;

import Domain.Car;
import Repository.CarRepository;

import java.util.*;

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
            carOnStand.setLeftService(true);
            repository.update(carOnStand);
        } else {
            throw new RuntimeException("There is no car on the given stand!");
        }
    }

    public List<Car> getAll() {
        return repository.getAll();
    }
    public Set<Integer> getAllStand(){ //declarat
        Set<Integer> stands = new HashSet<>(); //initializat
        List<Car> cars = getAll();
        for(Car car:cars) { //fiecare masina din lista
            stands.add(car.getStand());
        }
        return stands;
    }

    //todo getAllByStand
    public List<Double> getAllByStand(int stand){
        List<Double> prices = new ArrayList<>();
        for (Car car:getAll()){
            if (car.getStand() == stand){
                prices.add (car.getPrice());
            }
        }
        return prices;
    }
    public Double getAvarage (List<Double> prices){
        double sum = 0;
        for (Double price: prices){
            sum += price;

        }
        return sum / prices.size();

    }
    //todo compute average price of a list of cars

    public Map<Double, Integer> getReports(){

        Map<Double, Integer> reports = new TreeMap<>();
        for(Integer stand:getAllStand()){
            List<Double> prices = getAllByStand(stand);
            Double average = getAvarage(prices);
            reports.put(average, stand);

        }
        Map<Double,Integer> descReports = new TreeMap<>(new Comparator<Double>() {
            @Override
            public int compare(Double price1, Double price2) {
                return price2.compareTo(price1);
            }
        });
        descReports.putAll(reports);
        return descReports;



    }

}
