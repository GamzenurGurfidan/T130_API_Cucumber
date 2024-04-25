
  
  Feature: US02 JPH PUT request
    @api
    Scenario: TC02 JsonPlaceHolder PUT request
      
      Given kullanici "jphURL" adresine gider
      Then kullanici path parametreleri olarak "posts/70" girer
      Then kullanici post request icin "Ahmet", "Merhaba", 10, 70 bilgileri ile reqBody olusturur
      Then kullanici post request gonderir ve donen response kaydeder
      And kullanici donen cevabin status egerinin 200 oldugunu kontrol eder
      And kullanici donen cevabin content-type degerinin "application/json; charset=utf-8" oldugunu kontrol eder
      And kullanici donen cevabın "Connection" isimli header degerinin "keep-alive" oldugunu kontrol eder
      And kullanici donen cevabin attribute degerlerinin "Ahmet", "Merhaba", 10, 70 oldugunu kontrol eder
