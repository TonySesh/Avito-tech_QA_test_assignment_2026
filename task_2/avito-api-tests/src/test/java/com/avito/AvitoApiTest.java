package com.avito;

import io.qameta.allure.*;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@Epic("API Тестирование Авито")
@Feature("Avito API Tests")
public class AvitoApiTest {

    private static final String BASE_URL = "https://qa-internship.avito.com";
    private int sellerId;

    private int generateSellerId() {
        Random random = new Random();
        return 111111 + random.nextInt(888889);
    }

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = BASE_URL;
        RestAssured.filters(new AllureRestAssured());
    }

    @BeforeEach
    public void setUpSellerId() {
        sellerId = generateSellerId();
    }

    // ==================== POST TESTS ====================

    @Test
    @Story("Создание объявления")
    @Description("Проверяет успешное создание объявления с валидными данными")
    @Severity(SeverityLevel.CRITICAL)
    void testPostCreateIsSuccess() {
        String requestBody = String.format("""
                {
                  "sellerID": %d,
                  "name": "Itachi",
                  "price": 122221,
                  "statistics": {
                    "likes": 1,
                    "viewCount": 11,
                    "contacts": 1111
                  }
                }
                """, sellerId);

        Response response = RestAssured.given()
                .contentType("application/json")
                .body(requestBody)
                .post("/api/1/item");

        System.out.println("TC-POST-01: Status code: " + response.statusCode() + " ||| Response body: " + response.body().asString());

        assertThat(response.statusCode()).isEqualTo(200);
    }

    @Test
    @Story("Создание объявления")
    @Description("Проверяет, что без поля sellerID возвращается 400")
    @Severity(SeverityLevel.NORMAL)
    void testPostCreateNoSellerId() {
        String requestBody = """
                {
                  "name": "Itachi",
                  "price": 122221,
                  "statistics": {
                    "likes": 1,
                    "viewCount": 11,
                    "contacts": 1111
                  }
                }
                """;

        Response response = RestAssured.given()
                .contentType("application/json")
                .body(requestBody)
                .post("/api/1/item");

        System.out.println("TC-POST-02: Status code: " + response.statusCode() + " || Response body: " + response.body().asString());

        assertThat(response.statusCode()).isEqualTo(400);
    }

    @Test
    @Story("Создание объявления")
    @Description("Проверяет, что без поля name возвращается 400")
    @Severity(SeverityLevel.NORMAL)
    void testPostCreateNoName() {
        String requestBody = String.format("""
                {
                  "sellerID": %d,
                  "price": 122221,
                  "statistics": {
                    "likes": 1,
                    "viewCount": 11,
                    "contacts": 1111
                  }
                }
                """, sellerId);

        Response response = RestAssured.given()
                .contentType("application/json")
                .body(requestBody)
                .post("/api/1/item");

        System.out.println("TC-POST-03: Status code: " + response.statusCode() + " || Response body: " + response.body().asString());

        assertThat(response.statusCode()).isEqualTo(400);
    }

    @Test
    @Story("Создание объявления")
    @Description("Проверяет, что без поля price возвращается 400")
    @Severity(SeverityLevel.NORMAL)
    void testPostCreateNoPrice() {
        String requestBody = String.format("""
                {
                  "sellerID": %d,
                  "name": "Itachi",
                  "statistics": {
                    "likes": 1,
                    "viewCount": 11,
                    "contacts": 1111
                  }
                }
                """, sellerId);

        Response response = RestAssured.given()
                .contentType("application/json")
                .body(requestBody)
                .post("/api/1/item");

        System.out.println("TC-POST-04: Status code: " + response.statusCode() + " || Response body: " + response.body().asString());

        assertThat(response.statusCode()).isEqualTo(400);
    }

    @Test
    @Story("Создание объявления")
    @Description("Проверяет, что без поля statistics возвращается 400")
    @Severity(SeverityLevel.NORMAL)
    void testPostCreateNoStatistics() {
        String requestBody = String.format("""
                {
                  "sellerID": %d,
                  "name": "Itachi",
                  "price": 122221
                }
                """, sellerId);

        Response response = RestAssured.given()
                .contentType("application/json")
                .body(requestBody)
                .post("/api/1/item");

        System.out.println("TC-POST-05: Status code: " + response.statusCode() + " || Response body: " + response.body().asString());

        assertThat(response.statusCode()).isEqualTo(400);
    }

    @Test
    @Story("Создание объявления")
    @Description("Проверяет, что без поля likes возвращается 400")
    @Severity(SeverityLevel.NORMAL)
    void testPostCreateNoLikes() {
        String requestBody = String.format("""
                {
                  "sellerID": %d,
                  "name": "Itachi",
                  "price": 122221,
                  "statistics": {
                    "viewCount": 11,
                    "contacts": 1111
                  }
                }
                """, sellerId);

        Response response = RestAssured.given()
                .contentType("application/json")
                .body(requestBody)
                .post("/api/1/item");

        System.out.println("TC-POST-06: Status code: " + response.statusCode() + " || Response body: " + response.body().asString());

        assertThat(response.statusCode()).isEqualTo(400);
    }

    @Test
    @Story("Создание объявления")
    @Description("Проверяет, что без поля viewCount возвращается 400")
    @Severity(SeverityLevel.NORMAL)
    void testPostCreateNoViewCount() {
        String requestBody = String.format("""
                {
                  "sellerID": %d,
                  "name": "Itachi",
                  "price": 122221,
                  "statistics": {
                    "likes": 1,
                    "contacts": 1111
                  }
                }
                """, sellerId);

        Response response = RestAssured.given()
                .contentType("application/json")
                .body(requestBody)
                .post("/api/1/item");

        System.out.println("TC-POST-07: Status code: " + response.statusCode() + " || Response body: " + response.body().asString());

        assertThat(response.statusCode()).isEqualTo(400);
    }

    @Test
    @Story("Создание объявления")
    @Description("Проверяет, что без поля contacts возвращается 400")
    @Severity(SeverityLevel.NORMAL)
    void testPostCreateNoContacts() {
        String requestBody = String.format("""
                {
                  "sellerID": %d,
                  "name": "Itachi",
                  "price": 122221,
                  "statistics": {
                    "likes": 1,
                    "viewCount": 11
                  }
                }
                """, sellerId);

        Response response = RestAssured.given()
                .contentType("application/json")
                .body(requestBody)
                .post("/api/1/item");

        System.out.println("TC-POST-08: Status code: " + response.statusCode() + " || Response body: " + response.body().asString());

        assertThat(response.statusCode()).isEqualTo(400);
    }

    @Test
    @Story("Создание объявления")
    @Description("Проверяет, что пустое тело запроса возвращает 400")
    @Severity(SeverityLevel.NORMAL)
    void testPostNoParams() {
        String requestBody = "{}";

        Response response = RestAssured.given()
                .contentType("application/json")
                .body(requestBody)
                .post("/api/1/item");

        System.out.println("TC-POST-09: Status code: " + response.statusCode() + " || Response body: " + response.body().asString());

        assertThat(response.statusCode()).isEqualTo(400);
    }

    @Test
    @Story("Создание объявления")
    @Description("Проверяет, что JSON со всеми полями null возвращает 400")
    @Severity(SeverityLevel.NORMAL)
    void testPostParamsIsNull() {
        String requestBody = """
                {
                  "sellerID": null,
                  "name": null,
                  "price": null,
                  "statistics": null
                }
                """;

        Response response = RestAssured.given()
                .contentType("application/json")
                .body(requestBody)
                .post("/api/1/item");

        System.out.println("TC-POST-10: Status code: " + response.statusCode() + " || Response body: " + response.body().asString());

        assertThat(response.statusCode()).isEqualTo(400);
    }

    @Test
    @Story("Создание объявления")
    @Description("Проверяет, что sellerID = null возвращает 400")
    @Severity(SeverityLevel.NORMAL)
    void testPostSellerIdIsNull() {
        String requestBody = """
                {
                  "sellerID": null,
                  "name": "Itachi",
                  "price": 122221,
                  "statistics": {
                    "likes": 1,
                    "viewCount": 11,
                    "contacts": 1111
                  }
                }
                """;

        Response response = RestAssured.given()
                .contentType("application/json")
                .body(requestBody)
                .post("/api/1/item");

        System.out.println("TC-POST-11: Status code: " + response.statusCode() + " || Response body: " + response.body().asString());

        assertThat(response.statusCode()).isEqualTo(400);
    }

    @Test
    @Story("Создание объявления")
    @Description("Проверяет, что name = null возвращает 400")
    @Severity(SeverityLevel.NORMAL)
    void testPostNameIsNull() {
        String requestBody = String.format("""
                {
                  "sellerID": %d,
                  "name": null,
                  "price": 122221,
                  "statistics": {
                    "likes": 1,
                    "viewCount": 11,
                    "contacts": 1111
                  }
                }
                """, sellerId);

        Response response = RestAssured.given()
                .contentType("application/json")
                .body(requestBody)
                .post("/api/1/item");

        System.out.println("TC-POST-12: Status code: " + response.statusCode() + " || Response body: " + response.body().asString());

        assertThat(response.statusCode()).isEqualTo(400);
    }

    @Test
    @Story("Создание объявления")
    @Description("Проверяет, что price = null возвращает 400")
    @Severity(SeverityLevel.NORMAL)
    void testPostPriceIsNull() {
        String requestBody = String.format("""
                {
                  "sellerID": %d,
                  "name": "Itachi",
                  "price": null,
                  "statistics": {
                    "likes": 1,
                    "viewCount": 11,
                    "contacts": 1111
                  }
                }
                """, sellerId);

        Response response = RestAssured.given()
                .contentType("application/json")
                .body(requestBody)
                .post("/api/1/item");

        System.out.println("TC-POST-13: Status code: " + response.statusCode() + " || Response body: " + response.body().asString());

        assertThat(response.statusCode()).isEqualTo(400);
    }

    @Test
    @Story("Создание объявления")
    @Description("Проверяет, что statistics = null возвращает 400")
    @Severity(SeverityLevel.NORMAL)
    void testPostStatisticsIsNull() {
        String requestBody = String.format("""
                {
                  "sellerID": %d,
                  "name": "Itachi",
                  "price": 122221,
                  "statistics": null
                }
                """, sellerId);

        Response response = RestAssured.given()
                .contentType("application/json")
                .body(requestBody)
                .post("/api/1/item");

        System.out.println("TC-POST-14: Status code: " + response.statusCode() + " || Response body: " + response.body().asString());

        assertThat(response.statusCode()).isEqualTo(400);
    }

    @Test
    @Story("Создание объявления")
    @Description("Проверяет, что likes = null возвращает 400")
    @Severity(SeverityLevel.NORMAL)
    void testPostLikesIsNull() {
        String requestBody = String.format("""
                {
                  "sellerID": %d,
                  "name": "Itachi",
                  "price": 122221,
                  "statistics": {
                    "likes": null,
                    "viewCount": 11,
                    "contacts": 1111
                  }
                }
                """, sellerId);

        Response response = RestAssured.given()
                .contentType("application/json")
                .body(requestBody)
                .post("/api/1/item");

        System.out.println("TC-POST-15: Status code: " + response.statusCode() + " || Response body: " + response.body().asString());

        assertThat(response.statusCode()).isEqualTo(400);
    }

    @Test
    @Story("Создание объявления")
    @Description("Проверяет, что viewCount = null возвращает 400")
    @Severity(SeverityLevel.NORMAL)
    void testPostViewCountIsNull() {
        String requestBody = String.format("""
                {
                   "sellerID": %d,
                   "name": "Itachi",
                   "price": 122221,
                   "statistics": {
                     "likes": 1,
                     "viewCount": null,
                     "contacts": 1111
                   }
                 }
                """, sellerId);

        Response response = RestAssured.given()
                .contentType("application/json")
                .body(requestBody)
                .post("/api/1/item");

        System.out.println("TC-POST-16: Status code: " + response.statusCode() + " || Response body: " + response.body().asString());

        assertThat(response.statusCode()).isEqualTo(400);
    }

    @Test
    @Story("Создание объявления")
    @Description("Проверяет, что contacts = null возвращает 400")
    @Severity(SeverityLevel.NORMAL)
    void testPostContactsIsNull() {
        String requestBody = String.format("""
                {
                  "sellerID": %d,
                  "name": "Itachi",
                  "price": 122221,
                  "statistics": {
                    "likes": 1,
                    "viewCount": 11,
                    "contacts": null
                  }
                }
                """, sellerId);

        Response response = RestAssured.given()
                .contentType("application/json")
                .body(requestBody)
                .post("/api/1/item");

        System.out.println("TC-POST-17: Status code: " + response.statusCode() + " || Response body: " + response.body().asString());

        assertThat(response.statusCode()).isEqualTo(400);
    }

    @Test
    @Story("Создание объявления")
    @Description("Проверяет, что sellerID строкой возвращает 400")
    @Severity(SeverityLevel.NORMAL)
    void testPostIncorrectSellerId() {
        String requestBody = """
                {
                  "sellerID": "abc",
                  "name": "Itachi",
                  "price": 122221,
                  "statistics": {
                    "likes": 1,
                    "viewCount": 11,
                    "contacts": 1111
                  }
                }
                """;

        Response response = RestAssured.given()
                .contentType("application/json")
                .body(requestBody)
                .post("/api/1/item");

        System.out.println("TC-POST-18: Status code: " + response.statusCode() + " || Response body: " + response.body().asString());

        assertThat(response.statusCode()).isEqualTo(400);
    }

    @Test
    @Story("Создание объявления")
    @Description("Проверяет, что price строкой возвращает 400")
    @Severity(SeverityLevel.NORMAL)
    void testPostIncorrectPrice() {
        String requestBody = String.format("""
                {
                  "sellerID": %d,
                  "name": "Itachi",
                  "price": "abc",
                  "statistics": {
                    "likes": 1,
                    "viewCount": 11,
                    "contacts": 1111
                  }
                }
                """, sellerId);

        Response response = RestAssured.given()
                .contentType("application/json")
                .body(requestBody)
                .post("/api/1/item");

        System.out.println("TC-POST-19: Status code: " + response.statusCode() + " || Response body: " + response.body().asString());

        assertThat(response.statusCode()).isEqualTo(400);
    }

    @Test
    @Story("Создание объявления")
    @Description("Проверяет, что likes строкой возвращает 400")
    @Severity(SeverityLevel.NORMAL)
    void testPostIncorrectLikes() {
        String requestBody = String.format("""
                {
                  "sellerID": %d,
                  "name": "Itachi",
                  "price": 122221,
                  "statistics": {
                    "likes": "abc",
                    "viewCount": 11,
                    "contacts": 1111
                  }
                }
                """, sellerId);

        Response response = RestAssured.given()
                .contentType("application/json")
                .body(requestBody)
                .post("/api/1/item");

        System.out.println("TC-POST-20: Status code: " + response.statusCode() + " || Response body: " + response.body().asString());

        assertThat(response.statusCode()).isEqualTo(400);
    }

    @Test
    @Story("Создание объявления")
    @Description("Проверяет, что viewCount строкой возвращает 400")
    @Severity(SeverityLevel.NORMAL)
    void testPostIncorrectViewCount() {
        String requestBody = String.format("""
                {
                  "sellerID": %d,
                  "name": "Itachi",
                  "price": 122221,
                  "statistics": {
                    "likes": 1,
                    "viewCount": "abc",
                    "contacts": 1111
                  }
                }
                """, sellerId);

        Response response = RestAssured.given()
                .contentType("application/json")
                .body(requestBody)
                .post("/api/1/item");

        System.out.println("TC-POST-21: Status code: " + response.statusCode() + " || Response body: " + response.body().asString());

        assertThat(response.statusCode()).isEqualTo(400);
    }

    @Test
    @Story("Создание объявления")
    @Description("Проверяет, что contacts строкой возвращает 400")
    @Severity(SeverityLevel.NORMAL)
    void testPostIncorrectContacts() {
        String requestBody = String.format("""
                {
                  "sellerID": %d,
                  "name": "Itachi",
                  "price": 122221,
                  "statistics": {
                    "likes": 1,
                    "viewCount": 11,
                    "contacts": "abc"
                  }
                }
                """, sellerId);

        Response response = RestAssured.given()
                .contentType("application/json")
                .body(requestBody)
                .post("/api/1/item");

        System.out.println("TC-POST-22: Status code: " + response.statusCode() + " || Response body: " + response.body().asString());

        assertThat(response.statusCode()).isEqualTo(400);
    }

    @Test
    @Story("Создание объявления")
    @Description("Проверяет, что отрицательный sellerID возвращает 400")
    @Severity(SeverityLevel.NORMAL)
    void testPostNegativeSellerId() {
        String requestBody = """
                {
                  "sellerID": -100,
                  "name": "Itachi",
                  "price": 122221,
                  "statistics": {
                    "likes": 1,
                    "viewCount": 11,
                    "contacts": 1111
                  }
                }
                """;

        Response response = RestAssured.given()
                .contentType("application/json")
                .body(requestBody)
                .post("/api/1/item");

        System.out.println("TC-POST-23: Status code: " + response.statusCode() + " || Response body: " + response.body().asString());

        assertThat(response.statusCode()).isEqualTo(400);
    }

    @Test
    @Story("Создание объявления")
    @Description("Проверяет, что отрицательная цена возвращает 400")
    @Severity(SeverityLevel.NORMAL)
    void testPostNegativePrice() {
        String requestBody = String.format("""
                {
                  "sellerID": %d,
                  "name": "Itachi",
                  "price": -100,
                  "statistics": {
                    "likes": 1,
                    "viewCount": 11,
                    "contacts": 1111
                  }
                }
                """, sellerId);

        Response response = RestAssured.given()
                .contentType("application/json")
                .body(requestBody)
                .post("/api/1/item");

        System.out.println("TC-POST-24: Status code: " + response.statusCode() + " || Response body: " + response.body().asString());

        assertThat(response.statusCode()).isEqualTo(400);
    }

    @Test
    @Story("Создание объявления")
    @Description("Проверяет, что отрицательные likes возвращают 400")
    @Severity(SeverityLevel.NORMAL)
    void testPostNegativeLikes() {
        String requestBody = String.format("""
                {
                  "sellerID": %d,
                  "name": "Itachi",
                  "price": -100,
                  "statistics": {
                    "likes": -5,
                    "viewCount": 11,
                    "contacts": 1111
                  }
                }
                """, sellerId);

        Response response = RestAssured.given()
                .contentType("application/json")
                .body(requestBody)
                .post("/api/1/item");

        System.out.println("TC-POST-25: Status code: " + response.statusCode() + " || Response body: " + response.body().asString());

        assertThat(response.statusCode()).isEqualTo(400);
    }

    @Test
    @Story("Создание объявления")
    @Description("Проверяет, что отрицательный viewCount возвращает 400")
    @Severity(SeverityLevel.NORMAL)
    void testPostNegativeViewCount() {
        String requestBody = String.format("""
                {
                  "sellerID": %d,
                  "name": "Itachi",
                  "price": 122221,
                  "statistics": {
                    "likes": 1,
                    "viewCount": -3,
                    "contacts": 1111
                  }
                }
                """, sellerId);

        Response response = RestAssured.given()
                .contentType("application/json")
                .body(requestBody)
                .post("/api/1/item");

        System.out.println("TC-POST-26: Status code: " + response.statusCode() + " || Response body: " + response.body().asString());

        assertThat(response.statusCode()).isEqualTo(400);
    }

    @Test
    @Story("Создание объявления")
    @Description("Проверяет, что отрицательный contacts возвращает 400")
    @Severity(SeverityLevel.NORMAL)
    void testPostNegativeContacts() {
        String requestBody = String.format("""
                {
                  "sellerID": %d,
                  "name": "Itachi",
                  "price": 122221,
                  "statistics": {
                    "likes": 1,
                    "viewCount": 11,
                    "contacts": -1
                  }
                }
                """, sellerId);

        Response response = RestAssured.given()
                .contentType("application/json")
                .body(requestBody)
                .post("/api/1/item");

        System.out.println("TC-POST-27: Status code: " + response.statusCode() + " || Response body: " + response.body().asString());

        assertThat(response.statusCode()).isEqualTo(400);
    }

    @Test
    @Story("Создание объявления")
    @Description("Проверяет, что цена = 0 обрабатывается")
    @Severity(SeverityLevel.NORMAL)
    void testPostZeroPrice() {
        String requestBody = String.format("""
                {
                  "sellerID": %d,
                  "name": "Itachi",
                  "price": 0,
                  "statistics": {
                    "likes": 1,
                    "viewCount": 11,
                    "contacts": 1111
                  }
                }
                """, sellerId);

        Response response = RestAssured.given()
                .contentType("application/json")
                .body(requestBody)
                .post("/api/1/item");

        System.out.println("TC-POST-28: Status code: " + response.statusCode() + " || Response body: " + response.body().asString());

        assertThat(response.statusCode()).isEqualTo(400);
    }

    @Test
    @Story("Создание объявления")
    @Description("Проверяет, что sellerID = 1 возвращает 400")
    @Severity(SeverityLevel.NORMAL)
    void testPostOutOfBoundsMinSellerId() {
        String requestBody = """
                {
                  "sellerID": 1,
                  "name": "Itachi",
                  "price": 122221,
                  "statistics": {
                    "likes": 1,
                    "viewCount": 11,
                    "contacts": 1111
                  }
                }
                """;

        Response response = RestAssured.given()
                .contentType("application/json")
                .body(requestBody)
                .post("/api/1/item");

        System.out.println("TC-POST-29: Status code: " + response.statusCode() + " || Response body: " + response.body().asString());

        assertThat(response.statusCode()).isEqualTo(400);
    }

    @Test
    @Story("Создание объявления")
    @Description("Проверяет, что sellerID = 9999999 возвращает 400")
    @Severity(SeverityLevel.NORMAL)
    void testPostOutOfBoundsMaxSellerId() {
        String requestBody = """
                {
                  "sellerID": 9999999,
                  "name": "Itachi",
                  "price": 122221,
                  "statistics": {
                    "likes": 1,
                    "viewCount": 11,
                    "contacts": 1111
                  }
                }
                """;

        Response response = RestAssured.given()
                .contentType("application/json")
                .body(requestBody)
                .post("/api/1/item");

        System.out.println("TC-POST-30: Status code: " + response.statusCode() + " || Response body: " + response.body().asString());

        assertThat(response.statusCode()).isEqualTo(400);
    }

    @Test
    @Story("Создание объявления")
    @Description("Проверяет, что очень большая цена возвращает 400")
    @Severity(SeverityLevel.NORMAL)
    void testPostBigNumberPrice() {
        String requestBody = String.format("""
                {
                  "sellerID": %d,
                  "name": "Itachi",
                  "price": 1000000000,
                  "statistics": {
                    "likes": 1,
                    "viewCount": 11,
                    "contacts": 1111
                  }
                }
                """, sellerId);

        Response response = RestAssured.given()
                .contentType("application/json")
                .body(requestBody)
                .post("/api/1/item");

        System.out.println("TC-POST-31: Status code: " + response.statusCode() + " || Response body: " + response.body().asString());

        assertThat(response.statusCode()).isEqualTo(400);
    }

    @Test
    @Story("Создание объявления")
    @Description("Проверяет, что спецсимволы в name допустимы")
    @Severity(SeverityLevel.NORMAL)
    void testPostSpecSymbolInName() {
        String requestBody = """
                {
                  "sellerID": 122221,
                  "name": "!@#$%&*()",
                  "price": 122221,
                  "statistics": {
                    "likes": 1,
                    "viewCount": 11,
                    "contacts": 1111
                  }
                }
                """;

        Response response = RestAssured.given()
                .contentType("application/json")
                .body(requestBody)
                .post("/api/1/item");

        System.out.println("TC-POST-32: Status code: " + response.statusCode() + " || Response body: " + response.body().asString());

        assertThat(response.statusCode()).isEqualTo(400);
    }

    @Test
    @Story("Создание объявления")
    @Description("Проверяет, что очень длинное name допустимо")
    @Severity(SeverityLevel.NORMAL)
    void testPostBigLengthOfName() {
        String requestBody = String.format("""
                {
                  "sellerID": %d,
                  "name": "aaaaabbbbbaaaaabbbbbaaaaabbbbbaaaaabbbbbaaaaabbbbb",
                  "price": 122221,
                  "statistics": {
                    "likes": 1,
                    "viewCount": 11,
                    "contacts": 1111
                  }
                }
                """, sellerId);

        Response response = RestAssured.given()
                .contentType("application/json")
                .body(requestBody)
                .post("/api/1/item");

        System.out.println("TC-POST-33: Status code: " + response.statusCode() + " || Response body: " + response.body().asString());

        assertThat(response.statusCode()).isEqualTo(400);
    }

    @Test
    @Story("Создание объявления")
    @Description("Проверяет, что пустое имя возвращает 400")
    @Severity(SeverityLevel.NORMAL)
    void testPostEmptyName() {
        String requestBody = String.format("""
                {
                  "sellerID": %d,
                  "name": "",
                  "price": 122221,
                  "statistics": {
                    "likes": 1,
                    "viewCount": 11,
                    "contacts": 1111
                  }
                }
                """, sellerId);

        Response response = RestAssured.given()
                .contentType("application/json")
                .body(requestBody)
                .post("/api/1/item");

        System.out.println("TC-POST-34: Status code: " + response.statusCode() + " || Response body: " + response.body().asString());

        assertThat(response.statusCode()).isEqualTo(400);
    }

    @Test
    @Story("Создание объявления")
    @Description("Проверяет идемпотентность: два одинаковых запроса создают разные объявления")
    @Severity(SeverityLevel.NORMAL)
    void testPostIdempotency() {
        String requestBody = String.format("""
                {
                  "sellerID": %d,
                  "name": "Itachi",
                  "price": 122221,
                  "statistics": {
                    "likes": 1,
                    "viewCount": 11,
                    "contacts": 1111
                  }
                }
                """, sellerId);

        Response response1 = RestAssured.given()
                .contentType("application/json")
                .body(requestBody)
                .post("/api/1/item");

        Response response2 = RestAssured.given()
                .contentType("application/json")
                .body(requestBody)
                .post("/api/1/item");

        String id1 = response1.jsonPath().getString("status");
        String id2 = response2.jsonPath().getString("status");

        System.out.println("TC-POST-35/1: Status code: " + response1.statusCode() + " || Response body: " + response1.body().asString());
        System.out.println("TC-POST-35/2: Status code: " + response2.statusCode() + " || Response body: " + response2.body().asString());

        assertAll(
                () -> assertThat(response1.statusCode()).isEqualTo(200),
                () -> assertThat(response2.statusCode()).isEqualTo(200),
                () -> assertThat(id1).isNotEqualTo(id2)
        );
    }

    @Test
    @Story("Создание объявления")
    @Description("Проверяет, что лишнее поле в запросе возвращает 400")
    @Severity(SeverityLevel.NORMAL)
    void testPostExtraField() {
        String requestBody = String.format("""
                {
                  "sellerID": %d,
                  "name": "Itachi",
                  "price": 122221,
                  "statistics": {
                    "likes": 1,
                    "viewCount": 11,
                    "contacts": 1111
                  },
                  "extra" : "value"
                }
                """, sellerId);

        Response response = RestAssured.given()
                .contentType("application/json")
                .body(requestBody)
                .post("/api/1/item");

        System.out.println("TC-POST-36: Status code: " + response.statusCode() + " || Response body: " + response.body().asString());

        assertThat(response.statusCode()).isEqualTo(400);
    }

    @Test
    @Story("Создание объявления")
    @Description("Проверяет, что некорректный JSON возвращает 400")
    @Severity(SeverityLevel.NORMAL)
    void testPostIncorrectJson() {
        String requestBody = String.format("""
                {
                  "sellerID": %d,
                  "name": "Itachi",
                  "price": 122221,
                  "statistics": {
                    "likes": 1,
                    "viewCount": 11,
                    "contacts": 1111
                  },
                """, sellerId);

        Response response = RestAssured.given()
                .contentType("application/json")
                .body(requestBody)
                .post("/api/1/item");

        System.out.println("TC-POST-37: Status code: " + response.statusCode() + " || Response body: " + response.body().asString());

        assertThat(response.statusCode()).isEqualTo(400);
    }

    @Test
    @Story("Создание объявления")
    @Description("Проверяет время ответа")
    @Severity(SeverityLevel.NORMAL)
    void testPostTimeOut() {
        String requestBody = String.format("""
                {
                  "sellerID": %d,
                  "name": "Itachi",
                  "price": 122221,
                  "statistics": {
                    "likes": 1,
                    "viewCount": 11,
                    "contacts": 1111
                  }
                }
                """, sellerId);

        long startTime = System.currentTimeMillis();

        Response response = RestAssured.given()
                .contentType("application/json")
                .body(requestBody)
                .post("/api/1/item");

        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;

        System.out.println("TC-POST-38: Result time: " + resultTime + " || Status code: " + response.statusCode() + " || Response body: " + response.body().asString());

        assertThat(response.statusCode()).isEqualTo(200);
        assertThat(resultTime).isLessThan(5000);
    }

    @Test
    @Story("Создание объявления")
    @Description("Проверяет sellerID = 111111 (минимальное допустимое)")
    @Severity(SeverityLevel.NORMAL)
    void testPostSellerIdMin() {
        String requestBody = """
                {
                  "sellerID": 111111,
                  "name": "Itachi",
                  "price": 122221,
                  "statistics": {
                    "likes": 1,
                    "viewCount": 11,
                    "contacts": 1111
                  }
                }
                """;

        Response response = RestAssured.given()
                .contentType("application/json")
                .body(requestBody)
                .post("/api/1/item");

        System.out.println("TC-POST-39: Status code: " + response.statusCode() + " || Response body: " + response.body().asString());

        assertThat(response.statusCode()).isEqualTo(200);
    }

    @Test
    @Story("Создание объявления")
    @Description("Проверяет sellerID = 999999 (максимальное допустимое)")
    @Severity(SeverityLevel.NORMAL)
    void testPostSellerIdMax() {
        String requestBody = """
                {
                  "sellerID": 999999,
                  "name": "Itachi",
                  "price": 122221,
                  "statistics": {
                    "likes": 1,
                    "viewCount": 11,
                    "contacts": 1111
                  }
                }
                """;

        Response response = RestAssured.given()
                .contentType("application/json")
                .body(requestBody)
                .post("/api/1/item");

        System.out.println("TC-POST-40: Status code: " + response.statusCode() + " || Response body: " + response.body().asString());

        assertThat(response.statusCode()).isEqualTo(200);
    }

    @Test
    @Story("Создание объявления")
    @Description("Проверяет sellerID = 111110 (ниже минимума)")
    @Severity(SeverityLevel.NORMAL)
    void testPostSellerIdMinMinusOne() {
        String requestBody = """
                {
                  "sellerID": 111110,
                  "name": "Itachi",
                  "price": 122221,
                  "statistics": {
                    "likes": 1,
                    "viewCount": 11,
                    "contacts": 1111
                  }
                }
                """;

        Response response = RestAssured.given()
                .contentType("application/json")
                .body(requestBody)
                .post("/api/1/item");

        System.out.println("TC-POST-41: Status code: " + response.statusCode() + " || Response body: " + response.body().asString());

        assertThat(response.statusCode()).isEqualTo(400);
    }

    @Test
    @Story("Создание объявления")
    @Description("Проверяет sellerID = 1000000 (выше максимума)")
    @Severity(SeverityLevel.NORMAL)
    void testPostSellerIdMaxPlusOne() {
        String requestBody = """
                {
                  "sellerID": 1000000,
                  "name": "Itachi",
                  "price": 122221,
                  "statistics": {
                    "likes": 1,
                    "viewCount": 11,
                    "contacts": 1111
                  }
                }
                """;

        Response response = RestAssured.given()
                .contentType("application/json")
                .body(requestBody)
                .post("/api/1/item");

        System.out.println("TC-POST-42: Status code: " + response.statusCode() + " || Response body: " + response.body().asString());

        assertThat(response.statusCode()).isEqualTo(400);
    }

    @Test
    @Story("Получение объявления по ID")
    @Description("Проверяет успешное получение существующего объявления")
    @Severity(SeverityLevel.CRITICAL)
    void testGetAd() {
        String requestBody = String.format("""
                {
                  "sellerID": %d,
                  "name": "Itachi",
                  "price": 122221,
                  "statistics": {
                    "likes": 1,
                    "viewCount": 11,
                    "contacts": 1111
                  }
                }
                """, sellerId);

        Response postResponse = RestAssured.given()
                .contentType("application/json")
                .body(requestBody)
                .post("/api/1/item");

        assertThat(postResponse.statusCode()).isEqualTo(200);

        String statusPostText = postResponse.jsonPath().getString("status");
        String postId = statusPostText.substring(statusPostText.indexOf("-") + 1).trim();

        Response getResponse = RestAssured.given()
                .get("/api/1/item/" + postId);

        assertThat(getResponse.statusCode()).isEqualTo(200);

        String getId = getResponse.jsonPath().getString("[0].id");

        System.out.println("TC-GET-01: POST ID: Status code: " + postResponse.statusCode() + " id: " + postId +
                " || GET ID: Status code: " + getResponse.statusCode() + " id: " + getId
                + " || postResponse body: " + postResponse.body().asString()
                + " || getResponse body: " + getResponse.body().asString());

        assertThat(getId).isEqualTo(postId);
    }

    @Test
    @Story("Получение объявления по ID")
    @Description("Проверяет, что несуществующий ID возвращает 404")
    @Severity(SeverityLevel.NORMAL)
    void testGetFalseId() {
        String falseId = "111aaa11-111a-11aa-1a11-1a1111aa11aa";

        Response getResponse = RestAssured.given()
                .get("/api/1/item/" + falseId);

        System.out.println("TC-GET-02: " + getResponse.statusCode() + " || Response body: " + getResponse.body().asString());
        assertThat(getResponse.statusCode()).isEqualTo(404);
    }

    @Test
    @Story("Получение объявления по ID")
    @Description("Проверяет, что ID в неправильном формате возвращает 400")
    @Severity(SeverityLevel.NORMAL)
    void testGetIncorrectFormatId() {
        String falseId = "abc123";

        Response getResponse = RestAssured.given()
                .get("/api/1/item/" + falseId);

        System.out.println("TC-GET-03: " + getResponse.statusCode() + " || Response body: " + getResponse.body().asString());
        assertThat(getResponse.statusCode()).isEqualTo(400);
    }

    @Test
    @Story("Получение объявления по ID")
    @Description("Проверяет, что пустой ID возвращает 404")
    @Severity(SeverityLevel.NORMAL)
    void testGetEmptyId() {
        String id = "";

        Response getResponse = RestAssured.given()
                .get("/api/1/item/" + id);

        System.out.println("TC-GET-04: " + getResponse.statusCode() + " || Response body: " + getResponse.body().asString());
        assertThat(getResponse.statusCode()).isEqualTo(404);
    }

    @Test
    @Story("Получение объявления по ID")
    @Description("Проверяет, что ID = null возвращает 400")
    @Severity(SeverityLevel.NORMAL)
    void testGetNullId() {
        Response getResponse = RestAssured.given()
                .get("/api/1/item/" + null);

        System.out.println("TC-GET-05: " + getResponse.statusCode() + " || Response body: " + getResponse.body().asString());
        assertThat(getResponse.statusCode()).isEqualTo(400);
    }

    @Test
    @Story("Получение объявления по ID")
    @Description("Проверяет, что ID с пробелами возвращает 400")
    @Severity(SeverityLevel.NORMAL)
    void testGetIdWithSpaces() {
        String falseId = " 111aaa11-111a-11aa-1a11-1a1111aa11aa ";

        Response getResponse = RestAssured.given()
                .get("/api/1/item/" + falseId);

        System.out.println("TC-GET-06: " + getResponse.statusCode() + " || Response body: " + getResponse.body().asString());
        assertThat(getResponse.statusCode()).isEqualTo(400);
    }

    @Test
    @Story("Получение объявления по ID")
    @Description("Проверяет, что слишком длинный ID возвращает 400")
    @Severity(SeverityLevel.NORMAL)
    void testGetLongId() {
        String falseId = "111aaa11-111a-11aa-1a11-1a1111aa11aa123123";

        Response getResponse = RestAssured.given()
                .get("/api/1/item/" + falseId);

        System.out.println("TC-GET-07: " + getResponse.statusCode() + " || Response body: " + getResponse.body().asString());
        assertThat(getResponse.statusCode()).isEqualTo(400);
    }

    @Test
    @Story("Получение объявления по ID")
    @Description("Проверяет время ответа")
    @Severity(SeverityLevel.NORMAL)
    void testGetTimeOut() {
        String falseId = "111aaa11-111a-11aa-1a11-1a1111aa11aa";

        long startTime = System.currentTimeMillis();

        Response getResponse = RestAssured.given()
                .get("/api/1/item/" + falseId);

        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;

        System.out.println("TC-GET-08: " + getResponse.statusCode() + " || Response body: " + getResponse.body().asString());
        assertThat(getResponse.statusCode()).isEqualTo(404);
        assertThat(resultTime).isLessThan(5000);
    }

    @Test
    @Story("Получение объявлений по sellerId")
    @Description("Проверяет успешное получение списка объявлений у продавца с объявлениями")
    @Severity(SeverityLevel.CRITICAL)
    void testGetItemsBySellerId() {
        int testSellerId = sellerId;
        String requestBody1 = String.format("""
                {
                  "sellerID": %d,
                  "name": "Объявление 1",
                  "price": 100,
                  "statistics": {
                    "likes": 1,
                    "viewCount": 10,
                    "contacts": 1111
                  }
                }
                """, testSellerId);

        String requestBody2 = String.format("""
                {
                  "sellerID": %d,
                  "name": "Объявление 2",
                  "price": 200,
                  "statistics": {
                    "likes": 2,
                    "viewCount": 20,
                    "contacts": 2222
                  }
                }
                """, testSellerId);

        Response postResponse1 = RestAssured.given()
                .contentType("application/json")
                .body(requestBody1)
                .post("/api/1/item");
        assertThat(postResponse1.statusCode()).isEqualTo(200);

        Response postResponse2 = RestAssured.given()
                .contentType("application/json")
                .body(requestBody2)
                .post("/api/1/item");
        assertThat(postResponse2.statusCode()).isEqualTo(200);

        Response getResponse = RestAssured.given()
                .get("/api/1/" + testSellerId + "/item");

        System.out.println("TC-SELLER-01: Status code: " + getResponse.statusCode() + " || Response body: " + getResponse.body().asString());

        assertThat(getResponse.statusCode()).isEqualTo(200);

        List<Object> items = getResponse.jsonPath().getList("$");
        assertThat(items.size()).isGreaterThanOrEqualTo(2);
    }

    @Test
    @Story("Получение объявлений по sellerId")
    @Description("Проверяет, что у продавца без объявлений возвращается пустой список")
    @Severity(SeverityLevel.NORMAL)
    void testGetItemsBySellerIdNoItems() {
        Response getResponse = RestAssured.given()
                .get("/api/1/" + sellerId + "/item");

        System.out.println("TC-SELLER-02: Status code: " + getResponse.statusCode() + " || Response body: " + getResponse.body().asString());

        assertThat(getResponse.statusCode()).isEqualTo(200);

        List<Object> items = getResponse.jsonPath().getList("$");
        assertThat(items).isEmpty();
    }

    @Test
    @Story("Получение объявлений по sellerId")
    @Description("Проверяет, что несуществующий sellerId возвращает 404")
    @Severity(SeverityLevel.NORMAL)
    void testGetItemsByNonExistentSellerId() {
        int nonExistentSellerId = 999999999;

        Response getResponse = RestAssured.given()
                .get("/api/1/" + nonExistentSellerId + "/item");

        System.out.println("TC-SELLER-03: Status code: " + getResponse.statusCode() + " || Response body: " + getResponse.body().asString());

        assertThat(getResponse.statusCode()).isEqualTo(404);
    }

    @Test
    @Story("Получение объявлений по sellerId")
    @Description("Проверяет, что sellerId = 1 возвращает 400")
    @Severity(SeverityLevel.NORMAL)
    void testGetItemsBySellerIdBelowMinimum() {
        int sellerIdBelowMin = 1;

        Response getResponse = RestAssured.given()
                .get("/api/1/" + sellerIdBelowMin + "/item");

        System.out.println("TC-SELLER-04: Status code: " + getResponse.statusCode() + " || Response body: " + getResponse.body().asString());

        assertThat(getResponse.statusCode()).isEqualTo(400);
    }

    @Test
    @Story("Получение объявлений по sellerId")
    @Description("Проверяет, что sellerId = 999999999 возвращает 400")
    @Severity(SeverityLevel.NORMAL)
    void testGetItemsBySellerIdAboveMaximum() {
        int sellerIdAboveMax = 999999999;

        Response getResponse = RestAssured.given()
                .get("/api/1/" + sellerIdAboveMax + "/item");

        System.out.println("TC-SELLER-05: Status code: " + getResponse.statusCode() + " || Response body: " + getResponse.body().asString());

        assertThat(getResponse.statusCode()).isEqualTo(400);
    }

    @Test
    @Story("Получение объявлений по sellerId")
    @Description("Проверяет, что sellerId = 0 возвращает 400")
    @Severity(SeverityLevel.NORMAL)
    void testGetItemsBySellerIdZero() {
        int sellerIdZero = 0;

        Response getResponse = RestAssured.given()
                .get("/api/1/" + sellerIdZero + "/item");

        System.out.println("TC-SELLER-06: Status code: " + getResponse.statusCode() + " || Response body: " + getResponse.body().asString());

        assertThat(getResponse.statusCode()).isEqualTo(400);
    }

    @Test
    @Story("Получение объявлений по sellerId")
    @Description("Проверяет, что отрицательный sellerId возвращает 400")
    @Severity(SeverityLevel.NORMAL)
    void testGetItemsBySellerIdNegative() {
        int negativeSellerId = -100;

        Response getResponse = RestAssured.given()
                .get("/api/1/" + negativeSellerId + "/item");

        System.out.println("TC-SELLER-07: Status code: " + getResponse.statusCode() + " || Response body: " + getResponse.body().asString());

        assertThat(getResponse.statusCode()).isEqualTo(400);
    }

    @Test
    @Story("Получение объявлений по sellerId")
    @Description("Проверяет, что очень большое число sellerId возвращает 400")
    @Severity(SeverityLevel.NORMAL)
    void testGetItemsBySellerIdVeryLarge() {
        long veryLargeSellerId = 1000000000L;

        Response getResponse = RestAssured.given()
                .get("/api/1/" + veryLargeSellerId + "/item");

        System.out.println("TC-SELLER-08: Status code: " + getResponse.statusCode() + " || Response body: " + getResponse.body().asString());

        assertThat(getResponse.statusCode()).isEqualTo(400);
    }

    @Test
    @Story("Получение объявлений по sellerId")
    @Description("Проверяет, что sellerId строкой возвращает 400")
    @Severity(SeverityLevel.NORMAL)
    void testGetItemsBySellerIdString() {
        String stringSellerId = "abc";

        Response getResponse = RestAssured.given()
                .get("/api/1/" + stringSellerId + "/item");

        System.out.println("TC-SELLER-09: Status code: " + getResponse.statusCode() + " || Response body: " + getResponse.body().asString());

        assertThat(getResponse.statusCode()).isEqualTo(400);
    }

    @Test
    @Story("Получение объявлений по sellerId")
    @Description("Проверяет, что пустой sellerId возвращает 404")
    @Severity(SeverityLevel.NORMAL)
    void testGetItemsBySellerIdEmpty() {
        Response getResponse = RestAssured.given()
                .get("/api/1//item");

        System.out.println("TC-SELLER-10: Status code: " + getResponse.statusCode() + " || Response body: " + getResponse.body().asString());

        assertThat(getResponse.statusCode()).isEqualTo(404);
    }

    @Test
    @Story("Получение объявлений по sellerId")
    @Description("Проверяет, что sellerId = null возвращает 400")
    @Severity(SeverityLevel.NORMAL)
    void testGetItemsBySellerIdNull() {
        Response getResponse = RestAssured.given()
                .get("/api/1/null/item");

        System.out.println("TC-SELLER-11: Status code: " + getResponse.statusCode() + " || Response body: " + getResponse.body().asString());

        assertThat(getResponse.statusCode()).isEqualTo(400);
    }

    @Test
    @Story("Получение объявлений по sellerId")
    @Description("Проверяет время ответа")
    @Severity(SeverityLevel.NORMAL)
    void testGetItemsBySellerIdResponseTime() {
        String requestBody = String.format("""
            {
              "sellerID": %d,
              "name": "Time Test",
              "price": 100,
              "statistics": {
                "likes": 1,
                "viewCount": 10,
                "contacts": 1111
              }
            }
            """, sellerId);

        RestAssured.given()
                .contentType("application/json")
                .body(requestBody)
                .post("/api/1/item");

        long startTime = System.currentTimeMillis();

        Response getResponse = RestAssured.given()
                .get("/api/1/" + sellerId + "/item");

        long endTime = System.currentTimeMillis();
        long responseTime = endTime - startTime;

        System.out.println("TC-SELLER-12: Status code: " + getResponse.statusCode() + " || Response body: " + getResponse.body().asString());
        System.out.println("TC-SELLER-12: Response time: " + responseTime + " ms");

        assertThat(getResponse.statusCode()).isEqualTo(200);
        assertThat(responseTime).isLessThan(5000);
    }

    @Test
    @Story("Получение статистики")
    @Description("Проверяет успешное получение статистики по существующему объявлению")
    @Severity(SeverityLevel.CRITICAL)
    void testGetStatisticByExistingItemId() {
        String requestBody = String.format("""
            {
              "sellerID": %d,
              "name": "Statistic Test",
              "price": 500,
              "statistics": {
                "likes": 10,
                "viewCount": 100,
                "contacts": 5555
              }
            }
            """, sellerId);

        Response postResponse = RestAssured.given()
                .contentType("application/json")
                .body(requestBody)
                .post("/api/1/item");

        assertThat(postResponse.statusCode()).isEqualTo(200);

        String statusText = postResponse.jsonPath().getString("status");
        String itemId = statusText.substring(statusText.lastIndexOf("-") + 1).trim();

        Response getResponse = RestAssured.given()
                .get("/api/1/statistic/" + itemId);

        System.out.println("TC-STAT-01: Status code: " + getResponse.statusCode() + " || Response body: " + getResponse.body().asString());

        assertThat(getResponse.statusCode()).isEqualTo(200);
        assertThat(getResponse.jsonPath().getInt("[0].likes")).isEqualTo(10);
        assertThat(getResponse.jsonPath().getInt("[0].viewCount")).isEqualTo(100);
        assertThat(getResponse.jsonPath().getInt("[0].contacts")).isEqualTo(5555);
    }

    @Test
    @Story("Получение статистики")
    @Description("Проверяет, что несуществующий itemId возвращает 404")
    @Severity(SeverityLevel.NORMAL)
    void testGetStatisticByNonExistentItemId() {
        String nonExistentId = "00000000-0000-0000-0000-000000000000";

        Response getResponse = RestAssured.given()
                .get("/api/1/statistic/" + nonExistentId);

        System.out.println("TC-STAT-02: Status code: " + getResponse.statusCode() + " || Response body: " + getResponse.body().asString());

        assertThat(getResponse.statusCode()).isEqualTo(404);
    }

    @Test
    @Story("Получение статистики")
    @Description("Проверяет, что itemId в неправильном формате возвращает 400")
    @Severity(SeverityLevel.NORMAL)
    void testGetStatisticByInvalidFormatId() {
        String invalidId = "abc123";

        Response getResponse = RestAssured.given()
                .get("/api/1/statistic/" + invalidId);

        System.out.println("TC-STAT-03: Status code: " + getResponse.statusCode() + " || Response body: " + getResponse.body().asString());

        assertThat(getResponse.statusCode()).isEqualTo(400);
    }

    @Test
    @Story("Получение статистики")
    @Description("Проверяет, что пустой itemId возвращает 404")
    @Severity(SeverityLevel.NORMAL)
    void testGetStatisticByEmptyId() {
        Response getResponse = RestAssured.given()
                .get("/api/1/statistic/");

        System.out.println("TC-STAT-04: Status code: " + getResponse.statusCode() + " || Response body: " + getResponse.body().asString());

        assertThat(getResponse.statusCode()).isEqualTo(404);
    }

    @Test
    @Story("Получение статистики")
    @Description("Проверяет, что itemId = null возвращает 400")
    @Severity(SeverityLevel.NORMAL)
    void testGetStatisticByNullId() {
        Response getResponse = RestAssured.given()
                .get("/api/1/statistic/null");

        System.out.println("TC-STAT-05: Status code: " + getResponse.statusCode() + " || Response body: " + getResponse.body().asString());

        assertThat(getResponse.statusCode()).isEqualTo(400);
    }

    @Test
    @Story("Получение статистики")
    @Description("Проверяет, что itemId с пробелами возвращает 400")
    @Severity(SeverityLevel.NORMAL)
    void testGetStatisticByIdWithSpaces() {
        String idWithSpaces = " 123e4567-e89b-12d3-a456-426614174000 ";

        Response getResponse = RestAssured.given()
                .get("/api/1/statistic/" + idWithSpaces);

        System.out.println("TC-STAT-06: Status code: " + getResponse.statusCode() + " || Response body: " + getResponse.body().asString());

        assertThat(getResponse.statusCode()).isEqualTo(400);
    }

    @Test
    @Story("Получение статистики")
    @Description("Проверяет, что слишком длинный itemId возвращает 400")
    @Severity(SeverityLevel.NORMAL)
    void testGetStatisticByTooLongId() {
        String tooLongId = "12345678-1234-1234-1234-1234567890123456";

        Response getResponse = RestAssured.given()
                .get("/api/1/statistic/" + tooLongId);

        System.out.println("TC-STAT-07: Status code: " + getResponse.statusCode() + " || Response body: " + getResponse.body().asString());

        assertThat(getResponse.statusCode()).isEqualTo(400);
    }

    @Test
    @Story("Получение статистики")
    @Description("Проверяет, что статистика содержит все поля")
    @Severity(SeverityLevel.NORMAL)
    void testGetStatisticContainsAllFields() {
        String requestBody = String.format("""
            {
              "sellerID": %d,
              "name": "Fields Test",
              "price": 777,
              "statistics": {
                "likes": 7,
                "viewCount": 77,
                "contacts": 7777
              }
            }
            """, sellerId);

        Response postResponse = RestAssured.given()
                .contentType("application/json")
                .body(requestBody)
                .post("/api/1/item");

        assertThat(postResponse.statusCode()).isEqualTo(200);

        String statusText = postResponse.jsonPath().getString("status");
        String itemId = statusText.substring(statusText.lastIndexOf("-") + 1).trim();

        Response getResponse = RestAssured.given()
                .get("/api/1/statistic/" + itemId);

        System.out.println("TC-STAT-08: Status code: " + getResponse.statusCode() + " || Response body: " + getResponse.body().asString());

        assertThat(getResponse.statusCode()).isEqualTo(200);
        assertThat(getResponse.jsonPath().getInt("[0].likes")).isNotNull();
        assertThat(getResponse.jsonPath().getInt("[0].viewCount")).isNotNull();
        assertThat(getResponse.jsonPath().getInt("[0].contacts")).isNotNull();
    }

    @Test
    @Story("Получение статистики")
    @Description("Проверяет время ответа")
    @Severity(SeverityLevel.NORMAL)
    void testGetStatisticResponseTime() {
        String requestBody = String.format("""
            {
              "sellerID": %d,
              "name": "Time Test",
              "price": 300,
              "statistics": {
                "likes": 3,
                "viewCount": 30,
                "contacts": 3333
              }
            }
            """, sellerId);

        Response postResponse = RestAssured.given()
                .contentType("application/json")
                .body(requestBody)
                .post("/api/1/item");

        assertThat(postResponse.statusCode()).isEqualTo(200);

        String statusText = postResponse.jsonPath().getString("status");
        String itemId = statusText.substring(statusText.indexOf("-") + 1).trim();

        long startTime = System.currentTimeMillis();

        Response getResponse = RestAssured.given()
                .get("/api/1/statistic/" + itemId);

        long endTime = System.currentTimeMillis();
        long responseTime = endTime - startTime;

        System.out.println("TC-STAT-09: Status code: " + getResponse.statusCode() + " || Response body: " + getResponse.body().asString());
        System.out.println("TC-STAT-09: Response time: " + responseTime + " ms");

        assertThat(getResponse.statusCode()).isEqualTo(200);
        assertThat(responseTime).isLessThan(5000);
    }
}