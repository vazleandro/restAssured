package br.exemplo.restAssured.steps;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import cucumber.api.java.es.Dado;
import cucumber.api.java.it.Quando;
import cucumber.api.java.pt.Entao;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;


public class MetodoGet {

	private static final String BASE_URL_CONTATOS = "http://api-de-tarefas.herokuapp.com/contacts/";
	Response response;
	String uriBase;
	int  id_contatos = 0;

	@Dado("^que eu possua minha lista de contados$")
	public void que_eu_possua_minha_lista_de_contados() throws Throwable {

		uriBase = BASE_URL_CONTATOS;
		
	}

	@Quando("^eu realizar uma consulta$")
	public void eu_realizar_uma_consulta() throws Throwable {

		response = given().
				contentType("application/json")
				.accept("application/vnd.tasksmanager.v2")
				.when()
				.get(uriBase);
	}

	@Entao("^terei todos os dados de meus contatos$")
	public void terei_todos_os_dados_de_meus_contatos() throws Throwable {

		response.then()
		.statusCode(200)
		.contentType(ContentType.JSON)
		.assertThat()
				.body(matchesJsonSchemaInClasspath("schema/json-schema-contatos.json"));

	}
	
	
	@Quando("^eu realizar uma consulta pelo id (\\d+)$")
	public void eu_realizar_uma_consulta_pelo_id(int id) throws Throwable {
		id_contatos = id;
		response = given()
				.relaxedHTTPSValidation()
				.contentType("application/json")
				.accept("application/vnd.tasksmanager.v2")
				.when()//.log().all()
				.get(uriBase + id_contatos);
		
	 	}

	@Entao("^terei os dados pessoais do meu contato$")
	public void terei_os_dados_pessoais_do_meu_contato() throws Throwable {
	  
		
		response.then()
		.statusCode(200)
		.contentType(ContentType.JSON)
		.body("data.attributes.name", equalTo("Henrique"))
		.body("data.attributes.last-name", equalTo("Madureira"))
		.body("data.attributes.email", equalTo("henrique01@gmail.com"))
		.body("data.attributes.age", is(24))
		.body("data.attributes.phone", equalTo("21994897645"))
		.body("data.attributes.address", equalTo("Rua one"))
		.body("data.attributes.state", equalTo("Minas Gerais"))
		.body("data.attributes.city", equalTo("Belo Horizonte"))
		.assertThat()
				.body(matchesJsonSchemaInClasspath("schema/json-schema-contatos-especifico.json"));
	}

}
