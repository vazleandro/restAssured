package br.exemplo.restAssured.steps;

import cucumber.api.java.es.Dado;
import cucumber.api.java.it.Quando;
import cucumber.api.java.pt.Entao;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class MetodoPost {
	
	String uriBase = "";
	Response response;
	private RequestSpecification request = RestAssured.given();

	private static final String BASE_URL_CONTATOS = "http://api-de-tarefas.herokuapp.com/contacts";
	
	@Dado("^que eu tenha os dados do contato$")
	public void que_eu_tenha_os_dados_do_contato() throws Throwable {

		String payload = "{\"address\":\"Kub Street\",\"phone\": \"1-648-635-4812\",\"city\":\"Missourishire\",\r\n" + 
				"\"name\":\"Clara\",\"state\":\"Florida\",\"email\":\"e@hotmail.com\",\"age\":\"4\",\"last-name\":\"Kreiger\"}";
		
		uriBase = BASE_URL_CONTATOS;
		request.header("Content-Type", "application/json");
		request.header("Accept", "application/vnd.tasksmanager.v2");
		request.body(payload); //.log().all();
		
	}

	@Quando("^eu realizar a inclusao do contato via api$")
	public void eu_realizar_a_inclusao_do_contato_via_api() throws Throwable {

		response = request.post(uriBase);
	}

	@Entao("^terei os dados cadastrados com sucesso$")
	public void terei_os_dados_cadastrados_com_sucesso() throws Throwable {

		response.then() //.log().all()
		.statusCode(201)
		.contentType(ContentType.JSON);
		
	}
	
}