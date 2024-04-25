
  Feature: Collect API apikey kullanimi

    Scenario: Nobetci eczaneler listesi cagırma

      Given  kullanici "collectApi" test adresine gider
      Then kullanici path parametreleri olarak "health/dutyPharmacy" uri girer
      Then kullanici query parametrelerini key degeri "il" value degeri "Kırıkkale" olarak girer
      Then kullanici diger query parametrelerini key2 degeri "ilce" value2 degerini "Keskin" olarak girer
      Then kullanici donen response degerini kaydeder
      And kullanici donen response listesini yazdirir


    Scenario: doviz bilgileri yazdirma
      Given kullanici "collectApi" test adresine gider
      Then kullanici path parametreleri olarak "economy/currencyToAll" uri girer
      Then kullanici query parametrelerini key degeri "int" value degeri "1" olarak girer
      Then kullanici diger query parametrelerini key2 degeri "base" value2 degerini "TRY" olarak girer
      Then kullanici donen response degerini kaydeder
      Then kullanici donen response listesini yazdirir





