package br.exemplo.restAssured.steps;

import cucumber.api.java.es.Dado;
import cucumber.api.java.it.Quando;
import cucumber.api.java.pt.Entao;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class MetodoPatch {

	String uriBase = "";
	Response response;
	int id_contato = 0;
	private RequestSpecification request = RestAssured.given();
	private static final String BASE_URL_CONTATOS = "http://api-de-tarefas.herokuapp.com/contacts/";

	@Dado("^que eu tenha o id (\\d+) do contato para alterar o e-mail$")
	public void que_eu_tenha_o_id_do_contato_para_alterar_o_e_mail(int contato) throws Throwable {
		
		uriBase = BASE_URL_CONTATOS;
		id_contato = contato;
		String payload = "{\"email\":\"teste@hotmail.com\"}";

		request.header("Content-Type", "application/json");
		request.header("Accept", "application/vnd.tasksmanager.v2");
		request.body(payload);
	}

	@Quando("^eu realizar a atualização do e-mail do contato via api$")
	public void eu_realizar_a_atualização_do_e_mail_do_contato_via_api() throws Throwable {

		response = request.patch(uriBase + id_contato);
	}

	@Entao("^terei o e-mail do contato atualizado$")
	public void terei_o_e_mail_do_contato_atualizado() throws Throwable {
		response.then() //.log().body()
		.statusCode(200)
		.contentType(ContentType.JSON);
	}
	
}
