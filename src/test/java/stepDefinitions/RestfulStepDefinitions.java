package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import utilities.ConfigReader;

import static io.restassured.RestAssured.given;

public class RestfulStepDefinitions {
    String endPoint;
    Response response;
    JSONObject requestBody;

    @Given("kullanici update icin {string} adresine gider")
    public void kullaniciUpdateIcinAdresineGider(String baseurl) {
        endPoint= ConfigReader.getProperty(baseurl);
    }

    @Then("kullanici update icin path parametresi olarak {string} girer")
    public void kullaniciUpdateIcinPathParametresiOlarakGirer(String pathparams1) {
        endPoint=endPoint+"/"+pathparams1;
    }

    @Then("kullanici update icin {string} girer")
    public void kullaniciUpdateIcinGirer(String bookingid) {
        endPoint=endPoint+"/"+bookingid;

    }
    /*
    {
        "firstname": "Tarık",
        "lastname": "Yiğit",
        "totalprice": 285,
        "depositpaid": false,
        "bookingdates": {
            "checkin": "2018-01-01",
            "checkout": "2019-01-01"
        },
        "additionalneeds": "Breakfast,wifi"
    }
     */
    @Then("kullanici update icin bir body olusturur")
    public void kullaniciUpdateIcinBirBodyOlusturur() {
        requestBody=new JSONObject();
        JSONObject bookingDates=new JSONObject();
        bookingDates.put("checkin","2023-01-01");
        bookingDates.put("checkout","2024-01-01");
        requestBody.put("firstname","Murat");
        requestBody.put("lastname","Yiğit");
        requestBody.put("totalprice",485);
        requestBody.put("depositpaid",false);
        requestBody.put("bookingdates",bookingDates);
        requestBody.put("additionalneeds","Breakfast,lunch,wifi");

    }

    @Then("kullanici bir put request gonderip donen response degerini kaydeder")
    public void kullaniciBirPutRequestGonderipDonenResponseDegeriniKaydeder() {
        response=given().when().body(requestBody.toString()).contentType(ContentType.JSON).header("Cookie","token=f2aaddf47bf2d7e").put(endPoint);
    }

    @Then("kullanici donen response degerini yazdirir")
    public void kullaniciDonenResponseDegeriniYazdirir() {
        response.prettyPrint();

    }
}