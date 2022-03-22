import  static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import  static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class APITests {

    @Test
    void APITest1() {

        Response response = get("https://reqres.in/api/users?page=2");
        System.out.println("Response: " + response.asString());
        System.out.println("Status code: " + response.getStatusCode());
        System.out.println("Body: " + response.getBody());
        System.out.println("Time Taken: " + response.getTime());
        System.out.println("Header: " + response.getHeader("content-type"));

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }
    @Test
    void APITestDeneme(){

        given()
                .get("\"https://reqres.in/api/users?page=2")
        .then()
                .statusCode(201)
                .body("data.id[0]",equalTo(7));

    }

    @Test
    void  test2(){

        given()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .statusCode(200);
    }
}
//REST API --> JSON, SOAP ---> XML

//Endpoint: API üzerinde belirli bir amaç için oluşturulmuş metodunuza verilen isim.


//GET: Veri çekmek için kullanılır.
//
//POST:Yeni bir kayıt oluşturmak için kullanılır.
//
//PUT: Varolan bir kayıtı güncellemek için kullanılır.
//
//PATCH: Varolan bir kayıtta belirli bir parça üzerinde güncelleme yapılacaksa kullanılabilir. Bu işlem istek yerine tüm güncellemeler için PUT kullanımı da yaygındır.
//
//DELETE: Varolan bir kayıtı silmek için kullanılır.



//Status alanında çıkabilen diğer sonuç kodları ve anlamları:
//
//201 — Başarılı istek ve veriler için.
//204 — Boş cevaplar için.
//400 — Kötü cevap için. İstek anlaşılamadı veya gerekli parametreler eksikti.
//401 — Yetkisiz erişim için. Kimlik doğrulama başarısız oldu veya kullanıcının istenen işlem için izinleri yok.
//403 — Yasak için. Erişim reddedildi.
//404 — Bilgi bulunamadığı için.
//405 — İstek desteklenmediği veya metoda izin verilmediği için.
//500 — Dahili Sunucu Hatası için.
//503 — Kullanılamayan Servis İçin.


