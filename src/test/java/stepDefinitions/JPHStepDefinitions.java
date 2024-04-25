package stepDefinitions;

import com.google.gson.JsonObject;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import utilities.ConfigReader;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;


public class JPHStepDefinitions {
    String endpoint;
    Response response;
    JsonPath resJP;
    JSONObject postRequestbody;


    @Given("kullanici {string} adresine gider")
    public void kullanici_adresine_gider(String baseURL) {
        endpoint = ConfigReader.getProperty(baseURL);
    }

    @Then("kullanici path parametreleri olarak {string} girer")
    public void kullanici_path_parametreleri_olarak_girer(String pathParams) {
        endpoint = endpoint + "/" + pathParams;
    }

    @Then("kullanici bir GET request gonderir ve donen response degerini kaydeder")
    public void kullanici_bir_get_request_gonderir_ve_donen_response_degerini_kaydeder() {
        response = given().when().get(endpoint);
    }

    @Then("kullanici donen cevabin status egerinin {int} oldugunu kontrol eder")
    public void kullanici_donen_cevabin_status_egerinin_oldugunu_kontrol_eder(int statusCode) {
        assertEquals(statusCode,response.getStatusCode());
    }

    @Then("kullanici donen cevabin content-type degerinin {string} oldugunu kontrol eder")
    public void kullanici_donen_cevabin_content_type_degerinin_oldugunu_kontrol_eder(String contentType) {
        assertEquals(contentType, response.getContentType());

    }

    @Then("kullanici donen cevaptaki userId degerinin {int} oldugunu kontrol eder")
    public void kullanici_donen_cevaptaki_user_ıd_degerinin_oldugunu_kontrol_eder(int userId) {
        resJP = response.jsonPath();
        assertEquals(userId, resJP.getInt("userId"));
    }

    @Then("kullanici donen cevaptaki title degerinin {string} oldugunu kontrol eder")
    public void kullanici_donen_cevaptaki_title_degerinin_oldugunu_kontrol_eder(String title) {
        resJP = response.jsonPath();
        assertEquals(title, resJP.getString("title"));
    }

    @Then("kullanici post request icin {string}, {string}, {int}, {int} bilgileri ile reqBody olusturur")
    public void kullanici_post_request_icin_ahmet_merhaba_bilgileri_ile_req_body_olusturur(String title, String body, int userId, int id) {
        postRequestbody = new JSONObject();
        postRequestbody.put("title",title);
        postRequestbody.put("body",body);
        postRequestbody.put("userId",userId);
        postRequestbody.put("id",id);
    }

    @Then("kullanici post request gonderir ve donen response kaydeder")
    public void kullanici_post_request_gonderir_ve_donen_response_kaydeder() {
        response=given().when().body(postRequestbody.toString()).contentType(ContentType.JSON).post(endpoint);

        // Eger yetki istenseydi nasıl bir request gonderilirdi?
        // .post() demeden once .header("Authorization","apikey vjdkfhg8934ythıjgıu49ugdoırjg9034")
    }

    @Then("kullanici donen cevabın {string} isimli header degerinin {string} oldugunu kontrol eder")
    public void kullanici_donen_cevabın_isimli_header_degerinin_oldugunu_kontrol_eder(String headerAttribute, String headerValue) {
        assertEquals(headerValue,response.header(headerAttribute));

    }

    @Then("kullanici donen cevabin attribute degerlerinin {string}, {string}, {int}, {int} oldugunu kontrol eder")
    public void kullanici_donen_cevabin_attribute_degerlerinin_ahmet_merhaba_oldugunu_kontrol_eder(String title, String body, int userId, int id) {
        resJP=response.jsonPath();
        assertEquals(title,resJP.getString("title"));
        assertEquals(body,resJP.getString("body"));
        assertEquals(userId,resJP.getInt("userId"));
        assertEquals(id, resJP.getInt("id"));
        //resJP.getInt("id")---->
    }

}
