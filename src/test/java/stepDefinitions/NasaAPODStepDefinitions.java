package stepDefinitions;

import io.cucumber.java.en.*;
import io.restassured.response.Response;
import utilities.ConfigReader;

import static io.restassured.RestAssured.given;

public class NasaAPODStepDefinitions {

    String endpoint;
    Response response;

    @Given("kullanici resim icin {string} adresine gider")
    public void kullanici_resim_icin_adresine_gider(String baseURL) {
        endpoint = ConfigReader.getProperty(baseURL);
    }

    @Then("kullanici path parametresi olarak {string} girer")
    public void kullanici_path_parametresi_olarak_girer(String pathParams) {
        endpoint = endpoint + pathParams;
    }

    @Then("kullanici query1 parametrelerini key degeri {string} value degeri {string} olarak girer")
    public void kullanici_query_parametrelerini_key_degeri_value_degeri_string_olarak_girer(String key1,String value1) {
        endpoint= endpoint + "?" + key1 + "=" + value1;
    }

    @Then("kullanici diger1 query parametrelerini key2 degeri {string} value2 degerini {string} olarak girer")
    public void kullanici_diger1_query_parametrelerini_key2_degeri_value2_degerini_olarak_girer(String key2, String value2) {
        endpoint= endpoint + "&" + key2 + "=" + value2;
    }

    @Then("kullanici donen response degerini kaydederr")
    public void kullanici_donen_response_degerini_kaydederr() {
        response = given().when().get(endpoint);
    }

    @Then("kullanici donen response listesini yazdirirr")
    public void kullanici_donen_response_listesini_yazdirirr() {
        response.prettyPrint();
    }
}
