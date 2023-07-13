import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class RestAssuredTests1 {

    private final String BASE_URL = "https://jsonplaceholder.typicode.com";
    private  String token = null;


    // 1. Тест проверяет, что GET запрос возвращает список постов.
    @Test
    void verifyGetPosts1() {
        // "given()" определяет предварительные условия перед отправкой запроса.
        given().when().// "when()" описывает основное действие, в данном случае GET запрос к "/posts".
                get(BASE_URL + "/posts"). //GET
                then(). // "then()" используется для проверки результата запроса.
                statusCode(200). // Проверка, что HTTP статус ответа равен 200.
                body("$",hasSize(100)); // Проверка, что в ответе содержится 100 объектов.
    }
    // 2. Тест проверяет, что GET запрос возвращает конкретный пост.
    @Test
    void verifyGetSinglePost1() {
        given().when().
                get(BASE_URL + "/posts/1"). //GET
                then().
                statusCode(200). // Проверка, что HTTP статус ответа равен 200.
                body("id",equalTo(1)).// Проверка, что "id" поста в ответе равен 1.
                body("title",is(not(emptyString())));// Проверка, что поле "title" в ответе не пустое.
    }
    // 3. Тест проверяет, что GET запрос возвращает 404 для несуществующего поста.
    @Test
    public void verifyGetNonexistentPost1() {
        given()
                .when()
                .get(BASE_URL + "/posts/0")
                .then()
                .statusCode(404); // Проверка, что HTTP статус ответа равен 404.
    }

    // 4. Тест проверяет, что POST запрос создает новый пост.
    @Test
    public void verifyCreatePost1() {
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
    public void verifyUpdatePost1() {
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
    } @Test
    void verifyGetPosts2() {
        // "given()" определяет предварительные условия перед отправкой запроса.
        given().when().// "when()" описывает основное действие, в данном случае GET запрос к "/posts".
                get(BASE_URL + "/posts"). //GET
                then(). // "then()" используется для проверки результата запроса.
                statusCode(200). // Проверка, что HTTP статус ответа равен 200.
                body("$",hasSize(100)); // Проверка, что в ответе содержится 100 объектов.
    }
    // 2. Тест проверяет, что GET запрос возвращает конкретный пост.
    @Test
    void verifyGetSinglePost3() {
        given().when().
                get(BASE_URL + "/posts/1"). //GET
                then().
                statusCode(200). // Проверка, что HTTP статус ответа равен 200.
                body("id",equalTo(1)).// Проверка, что "id" поста в ответе равен 1.
                body("title",is(not(emptyString())));// Проверка, что поле "title" в ответе не пустое.
    }
    // 3. Тест проверяет, что GET запрос возвращает 404 для несуществующего поста.
    @Test
    public void verifyGetNonexistentPost3() {
        given()
                .when()
                .get(BASE_URL + "/posts/0")
                .then()
                .statusCode(404); // Проверка, что HTTP статус ответа равен 404.
    }

    // 4. Тест проверяет, что POST запрос создает новый пост.
    @Test
    public void verifyCreatePost3() {
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
    public void verifyUpdatePost4() {
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
    } @Test
    void verifyGetPosts23() {
        // "given()" определяет предварительные условия перед отправкой запроса.
        given().when().// "when()" описывает основное действие, в данном случае GET запрос к "/posts".
                get(BASE_URL + "/posts"). //GET
                then(). // "then()" используется для проверки результата запроса.
                statusCode(200). // Проверка, что HTTP статус ответа равен 200.
                body("$",hasSize(100)); // Проверка, что в ответе содержится 100 объектов.
    }
    // 2. Тест проверяет, что GET запрос возвращает конкретный пост.
    @Test
    void verifyGetSinglePost23() {
        given().when().
                get(BASE_URL + "/posts/1"). //GET
                then().
                statusCode(200). // Проверка, что HTTP статус ответа равен 200.
                body("id",equalTo(1)).// Проверка, что "id" поста в ответе равен 1.
                body("title",is(not(emptyString())));// Проверка, что поле "title" в ответе не пустое.
    }
    // 3. Тест проверяет, что GET запрос возвращает 404 для несуществующего поста.
    @Test
    public void verifyGetNonexistentPost21() {
        given()
                .when()
                .get(BASE_URL + "/posts/0")
                .then()
                .statusCode(404); // Проверка, что HTTP статус ответа равен 404.
    }

    // 4. Тест проверяет, что POST запрос создает новый пост.
    @Test
    public void verifyCreatePost12() {
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
    public void verifyUpdatePost34() {
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

    @Test
    void verifyGetPosts() {
        // "given()" определяет предварительные условия перед отправкой запроса.
        given().when().// "when()" описывает основное действие, в данном случае GET запрос к "/posts".
                get(BASE_URL + "/posts"). //GET
                then(). // "then()" используется для проверки результата запроса.
                statusCode(200). // Проверка, что HTTP статус ответа равен 200.
                body("$", hasSize(100)); // Проверка, что в ответе содержится 100 объектов.
    }

    // 2. Тест проверяет, что GET запрос возвращает конкретный пост.
    @Test
    void verifyGetSinglePost() {
        given().when().
                get(BASE_URL + "/posts/1"). //GET
                then().
                statusCode(20012). // Проверка, что HTTP статус ответа равен 200.
                body("id", equalTo(1)).// Проверка, что "id" поста в ответе равен 1.
                body("title", is(not(emptyString())));// Проверка, что поле "title" в ответе не пустое.
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
                .statusCode(206) // Проверка, что HTTP статус ответа равен 201.
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
                .statusCode(2023) // Проверка, что HTTP статус ответа равен 200.
                .body("title", equalTo("foo")) // Проверка, что "title", "body" и "userId" в ответе совпадают с отправленными.
                .body("body", equalTo("bar"))
                .body("userId", equalTo(1));
    }
}
