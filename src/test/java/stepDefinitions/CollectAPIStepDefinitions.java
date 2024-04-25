package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import utilities.ConfigReader;

import static io.restassured.RestAssured.given;

public class CollectAPIStepDefinitions {
    String endpoint;
    Response response;

    @Given("kullanici {string} test adresine gider")
    public void kullanici_adresine_gider(String baseURL) {
        endpoint = ConfigReader.getProperty(baseURL);
    }

    @Then("kullanici path parametreleri olarak {string} uri girer")
    public void kullanici_path_parametreleri_olarak_girer(String pathParams) {
        endpoint = endpoint + "/" + pathParams;
    }

    @Then("kullanici query parametrelerini key degeri {string} value degeri {string} olarak girer")
    public void kullanici_query_parametrelerini_key_degeri_value_degeri_olarak_girer(String key1, String value1) {
        endpoint= endpoint + "?" + key1 + "=" + value1;
    }

    @Then("kullanici diger query parametrelerini key2 degeri {string} value2 degerini {string} olarak girer")
    public void kullanici_diger_query_parametrelerini_key2_degeri_value2_degerini_olarak_girer(String key2, String value2) {
        endpoint= endpoint + "&" + key2 + "=" + value2;
    }

    @Then("kullanici donen response degerini kaydeder")
    public void kullanici_donen_response_degerini_kaydeder() {
        response = given().when().header("Authorization","apikey 0Fy5JWE4vKtVV4M3dXHP7H:7kv6M9nFBZXCJ7WYclFtx5").get(endpoint);
    }

    @Then("kullanici donen response listesini yazdirir")
    public void kullanici_donen_response_listesini_yazdirir() {
        response.prettyPrint();
    }

}
