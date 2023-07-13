import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class RestAssuredTests {

    private final String BASE_URL = "https://jsonplaceholder.typicode.com";
//    private  String token = null;
//    private  String password = System.getProperty("password","password");
//
//    @BeforeEach
//    public void setup() {
//        // Запрос на получение токена.
//        String authPayload = "{ \"username\": \"admin\", \"password\": \"admin\" }";
//
//        Response response = given()
//                .contentType(ContentType.JSON)
//                .body(authPayload)
//                .when()
//                .post(BASE_URL + "/auth/login");
//        // Проверяем, что статус ответа равен 200.
//        response.then().statusCode(200);
//        // Извлекаем токен из ответа.
//        JsonPath jsonPath = response.jsonPath();
//        token = jsonPath.get("token");
//    }


//    @Test
//    public void verifyGetPostsAuthorization() {
//        // Для доступа к защищенным ресурсам в запросе передаем полученный токен.
//        given()
//                .header("Authorization", "Bearer " + token)
//                .when()
//                .get(BASE_URL + "/posts")
//                .then()
//                .statusCode(200)
//                .body("$", hasSize(100));
//    }

    // 1. Тест проверяет, что GET запрос возвращает список постов.
    @Test
    void verifyGetPosts() {
        // "given()" определяет предварительные условия перед отправкой запроса.
        given().when().// "when()" описывает основное действие, в данном случае GET запрос к "/posts".
                get(BASE_URL + "/posts"). //GET
                then(). // "then()" используется для проверки результата запроса.
                statusCode(200). // Проверка, что HTTP статус ответа равен 200.
                body("$",hasSize(100)); // Проверка, что в ответе содержится 100 объектов.
    }
    // 2. Тест проверяет, что GET запрос возвращает конкретный пост.
    @Test
    void verifyGetSinglePost() {
        given().when().
                get(BASE_URL + "/posts/1"). //GET
                then().
                statusCode(200). // Проверка, что HTTP статус ответа равен 200.
                body("id",equalTo(1)).// Проверка, что "id" поста в ответе равен 1.
                body("title",is(not(emptyString())));// Проверка, что поле "title" в ответе не пустое.
    }
    // 3. Тест проверяет, что GET запрос возвращает 404 для несуществующего поста.
    @Test
    public void verifyGetNonexistentPost() {
        given()
                .when()
                .get(BASE_URL + "/posts/0")
                .then()
                .statusCode(404); // Проверка, что HTTP статус ответа равен 404.
    }

    // 4. Тест проверяет, что POST запрос создает новый пост.
    @Test
    public void verifyCreatePost() {
        String postBodyJson = "{ \"title\": \"foo\", \"body\": \"bar\", \"userId\": 1 }";

        given()
                .contentType(ContentType.JSON) // Указание, что тип контента запроса - JSON.
                .body(postBodyJson) // Указание тела запроса.
                .when()
                .post(BASE_URL + "/posts")
                .then()
                .statusCode(201) // Проверка, что HTTP статус ответа равен 201.
                .body("title", equalTo("foo")) // Проверка, что "title", "body" и "userId" в ответе совпадают с отправленными.
                .body("body", equalTo("bar"))
                .body("userId", equalTo(1));
    }

    // 5. Тест проверяет, что PUT запрос обновляет существующий пост.
    @Test
    public void verifyUpdatePost() {
        String postBodyJson = "{ \"id\": 1, \"title\": \"foo\", \"body\": \"bar\", \"userId\": 1 }";

        given()
                .contentType(ContentType.JSON) // Указание, что тип контента запроса - JSON.
                .body(postBodyJson) // Указание тела запроса.
                .when()
                .put(BASE_URL + "/posts/1")
                .then()
                .statusCode(200) // Проверка, что HTTP статус ответа равен 200.
                .body("title", equalTo("foo")) // Проверка, что "title", "body" и "userId" в ответе совпадают с отправленными.
                .body("body", equalTo("bar"))
                .body("userId", equalTo(1));
    }
}
