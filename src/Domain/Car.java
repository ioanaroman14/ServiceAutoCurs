package Domain;

public class Car {
    private int id, stand;
    private String license;
    private int days;
    private boolean leftService;
    private String report;
    private double price;

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", stand=" + stand +
                ", license='" + license + '\'' +
                ", days=" + days +
                ", leftService=" + leftService +
                ", report='" + report + '\'' +
                ", price=" + price +
                '}';
    }

    public Car(int id, int stand, String license, int days) {
        this.id = id;
        this.stand = stand;
        this.license = license;
        this.days = days;
        leftService = false; // nu e necesar, e default
    }

    public Car(int id, int stand, String license, int days, boolean leftService, String report, double price) {
        this.id = id;
        this.stand = stand;
        this.license = license;
        this.days = days;
        this.leftService = leftService;
        this.report = report;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStand() {
        return stand;
    }

    public void setStand(int stand) {
        this.stand = stand;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public boolean isLeftService() {
        return leftService;
    }

    public void setLeftService(boolean leftService) {
        this.leftService = leftService;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
