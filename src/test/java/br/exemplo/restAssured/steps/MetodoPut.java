package br.exemplo.restAssured.steps;

import cucumber.api.java.es.Dado;
import cucumber.api.java.it.Quando;
import cucumber.api.java.pt.Entao;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class MetodoPut {

	String uriBase = "";
	Response response;
	MetodoPost alterarApi = new MetodoPost();
	int id_contato = 0;

	private RequestSpecification request = RestAssured.given();

	private static final String BASE_URL_CONTATOS = "http://api-de-tarefas.herokuapp.com/contacts/";

	/*
	@Dado("^que eu tenha o id (\\d+) do contato a ser alterado$")
	public void que_eu_tenha_o_id_do_contato_a_ser_alterado(int contato) throws Throwable {
		id_contato = contato;
		
		String payload = "{\"address\":\"Kub Street\",\"phone\": \"19992\",\"city\":\"Missourishire\",\r\n" + 
				"\"name\":\"Clara\",\"state\":\"Florida\",\"email\":\"vaz@hotmail.com\",\"age\":\"4\",\"last-name\":\"Kreiger\"}";
		
		uriBase = BASE_URL_CONTATOS;
		request.header("Content-Type", "application/json");
		request.header("Accept", "application/vnd.tasksmanager.v2");
		request.body(payload);
	
	}

*/
	@Dado("^que eu tenha o id (\\d+) e os dados do contato a ser alterado$")
	public void que_eu_tenha_o_id_e_os_dados_do_contato_a_ser_alterado(int contato, String payload) throws Throwable {
	
		id_contato = contato;
		uriBase = BASE_URL_CONTATOS;
		request.header("Content-Type", "application/json");
		request.header("Accept", "application/vnd.tasksmanager.v2");
		request.body(payload);
	}

	
	@Quando("^eu realizar a alteracao do contato via api$")
	public void eu_realizar_a_alteracao_do_contato_via_api() throws Throwable {
		response = request.put(uriBase + id_contato);
	}

	@Entao("^terei todos os dados do contato atualizado$")
	public void terei_todos_os_dados_do_contato_atualizado() throws Throwable {

		response.then() //.log().body()
		.statusCode(200);
	}

}
