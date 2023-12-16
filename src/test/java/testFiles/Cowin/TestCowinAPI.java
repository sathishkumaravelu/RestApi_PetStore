package testFiles.Cowin;

import CowinPojo.Center;
import CowinPojo.CenterResponse;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class TestCowinAPI {
    @Test
    public void testCowinApplicaiton(){

        Response response = RestAssured.given()
                .get("https://cdn-api.co-vin.in/api/v2/appointment/sessions/public/calendarByDistrict?district_id=571&date=16-12-2023");
        response.then().statusCode(200);
        response.prettyPrint();

        String hospitalName = response.getBody().jsonPath().getString("centers[0].name");
        Assert.assertEquals("Vijaya Health Centre",hospitalName);

        CenterResponse centerResponse = response.getBody().as(CenterResponse.class);
        String name = centerResponse.getCenters().get(0).getName();
        System.out.println(name);
    }
}
