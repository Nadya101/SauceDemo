package tests;

import lombok.extern.log4j.Log4j2;
import objects.Car;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Matchers;

@Log4j2
public class CarTest {
    Matchers matcher;

    @Test
    public void carComparisonTest() {
        Car car1 = new Car();
        Car car2 = new Car();
        car1.setMake("tesla");
        car2.setMake("tesla");
        Car car3 = new Car();
        Assert.assertEquals(car1.getModel(), car2.getModel());
    }

    @Test
    public void carComparison2To() {
        Car car1 = Car.builder()
                .make("bmw")
                .model("bmw")
                .build();
        Car car2 = Car.builder()
                .make("aston martin")
                .build();
        Assert.assertEquals(car1.getMake(), car2.getMake());
        Assert.assertTrue(matcher.verifyObjects(car1, car2));
    }

    @Test
    public void loggerTest() {
        log.fatal("fatal");
        log.error("error");
        log.warn("warn");
        log.info("info");
        log.debug("debug");
        log.trace("trace");
    }
}
