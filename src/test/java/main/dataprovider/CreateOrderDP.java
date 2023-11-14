package main.dataprovider;

import entities.storePOJO.CreateOrderRequestBody;
import org.joda.time.DateTime;
import org.testng.annotations.DataProvider;

import java.util.Date;
import java.util.Random;

public class CreateOrderDP {
    private static final Random random = new Random();

    private static int generateRandomNumber(int bound) {
        return random.nextInt(bound) + 1;
    }

    private static String generateRandomShipDate() {
        Date juDate = new Date();
        DateTime dt = new DateTime(juDate);
        return dt.toLocalDateTime().toString() + "Z";
    }

    private static String generateRandomStatus() {
        String[] statusList = {"placed", "approved", "delivered"};
        return statusList[random.nextInt(statusList.length)];
    }

    private static boolean generateRandomComplete() {
        return random.nextBoolean();
    }

    @DataProvider
    public Object[][] getData() {
        CreateOrderRequestBody order = new CreateOrderRequestBody();
        order.setId(generateRandomNumber(10));
        order.setPetId(generateRandomNumber(10));
        order.setQuantity(generateRandomNumber(50));
        order.setShipDate(generateRandomShipDate());
        order.setStatus(generateRandomStatus());
        order.setComplete(generateRandomComplete());
        return new Object[][]{{order}};
    }
}
