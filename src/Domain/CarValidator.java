package Domain;

public class CarValidator {

    /**
     * Validates a car.
     * @param car the car to validate.
     * @throws RuntimeException if there are validation errors.
     */
    public void validate(Car car) {

        if (car.getDays() <= 0) {
            throw new RuntimeException("The number of days cannot be 0 or negative!");
        }
        if (car.getLicense().length() != 7) {
            throw new RuntimeException("The license plate must have 7 characters!");
        }
        String license = car.getLicense();
        if (license.charAt(0) < 'A' || license.charAt(0) > 'Z' ||
            (!Character.isUpperCase(license.charAt(1)) && !Character.isDigit(license.charAt(1))) ||
            !Character.isDigit(license.charAt(2)) ||
            !Character.isDigit(license.charAt(3)) ||
            !Character.isUpperCase(license.charAt(4)) ||
            !Character.isUpperCase(license.charAt(5)) ||
            !Character.isUpperCase(license.charAt(6))
        ) {
            throw new RuntimeException("License plate not valid!");
        }

        if (car.isLeftService() && car.getPrice() <= 0) {
            throw new RuntimeException("Price must be positive!");
        }
    }
}
