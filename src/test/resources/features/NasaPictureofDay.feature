
  Feature: 
    Scenario: 
      Given kullanici resim icin "nasa" adresine gider
      Then kullanici path parametresi olarak "planetary/apod" girer
      Then kullanici query1 parametrelerini key degeri "api_key" value degeri "g1V51A5buYkeonVxgOoCV5W7aLDsPVwmgo7jFL7B" olarak girer
      Then kullanici diger1 query parametrelerini key2 degeri "date" value2 degerini "2024-04-25" olarak girer
      Then kullanici donen response degerini kaydederr
      Then kullanici donen response listesini yazdirirr