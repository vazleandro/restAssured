package br.exemplo.restAssured.steps;

import static org.hamcrest.Matchers.equalTo;

import cucumber.api.java.es.Dado;
import cucumber.api.java.it.Quando;
import cucumber.api.java.pt.Entao;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class MetodoDelete {

	String uriBase = "";
	Response response;
	int id_contato;
	
	private RequestSpecification request = RestAssured.given();
	private static final String BASE_URL_CONTATOS = "http://api-de-tarefas.herokuapp.com/contacts/";
	
	@Dado("^que eu tenha o id (\\d+) do contato a ser excluido$")
	public void que_eu_tenha_o_id_do_contato_a_ser_excluido(int contato) throws Throwable {
		
		id_contato = contato;
		uriBase = BASE_URL_CONTATOS;
		request.header("Content-Type", "application/json");
		request.header("Accept", "application/vnd.tasksmanager.v2");
		
		
	}

	@Quando("^eu realizar a exclusao do contato via api$")
	public void eu_realizar_a_exclusao_do_contato_via_api() throws Throwable {
		response = request.delete(uriBase + id_contato);
		
	}

	@Entao("^terei minha lista de contatos atualizadas$")
	public void terei_minha_lista_de_contatos_atualizadas() throws Throwable {
	    
		response.then()
		.statusCode(204);
	}
	
	@Entao("^terei uma mensagem informando que nao encontrou o contato$")
	public void terei_uma_mensagem_informando_que_nao_encontrou_o_contato() throws Throwable {
		
		response.then() //.log().body()
		.statusCode(404)
		.body("error", equalTo("Not Found"));
		
	}
}
