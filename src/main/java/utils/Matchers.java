package utils;

import lombok.extern.log4j.Log4j2;
import objects.Car;

@Log4j2
public class Matchers {
    public static boolean verifyObjects(Car car, Car car2) {
        log.info(String.format("Verify objects: '%s' and '%s'", car, car2));
        log.info("1st object model is:" + car.getModel() + "2nd object model is: " + car2);
        boolean result = car.getModel().equals(car2.getModel());
        result &= car.getMake().equals(car2.getMake());
        return result;
    }
}