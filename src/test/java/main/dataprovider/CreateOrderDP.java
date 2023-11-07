package main.dataprovider;

import entities.storePOJO.CreateOrderRequestBody;
import org.joda.time.DateTime;
import org.testng.annotations.DataProvider;

import java.util.Date;
import java.util.Random;

public class CreateOrderDP {

    public static int generateRandomId() {
        Random random = new Random();
        return random.nextInt(10) + 1;
    }

    public static int generateRandomPetId() {
        Random random = new Random();
        return random.nextInt(10) + 1;
    }

    public static int generateRandomQuantity() {
        Random random = new Random();
        return random.nextInt(50) + 1;
    }

    public static String generateRandomShipDate() {
        Date juDate = new Date();
        DateTime dt = new DateTime(juDate);
        String shipDate = dt.toLocalDateTime().toString() + "Z";
        return shipDate;
    }

    public static String generateRandomStatus() {
        Random random = new Random();
        String[] statusList = {"placed", "approved", "delivered"};
        return statusList[random.nextInt(statusList.length)];
    }

    public static boolean generateRandomComplete() {
        Random random = new Random();
        return random.nextBoolean();
    }

    @DataProvider
    public Object[][] getData() {
        CreateOrderRequestBody order = new CreateOrderRequestBody();
        order.setId(generateRandomId());
        order.setPetId(generateRandomPetId());
        order.setQuantity(generateRandomQuantity());
        order.setShipDate(generateRandomShipDate());
        order.setStatus(generateRandomStatus());
        order.setComplete(generateRandomComplete());

        return new Object[][]{{order}};
    }


}
