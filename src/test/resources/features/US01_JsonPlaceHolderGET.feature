
Feature: US 01 JsonPlaceHolder GET request

  Scenario: TC01 JsonPlaceHolder GET request

    Given kullanici "jphURL" adresine gider
    Then kullanici path parametreleri olarak "posts/70" girer
    Then kullanici bir GET request gonderir ve donen response degerini kaydeder
    And kullanici donen cevabin status egerinin 200 oldugunu kontrol eder
    And kullanici donen cevabin content-type degerinin "application/json; charset=utf-8" oldugunu kontrol eder
    And kullanici donen cevaptaki userId degerinin 7 oldugunu kontrol eder
    And kullanici donen cevaptaki title degerinin "voluptatem laborum magni" oldugunu kontrol eder
