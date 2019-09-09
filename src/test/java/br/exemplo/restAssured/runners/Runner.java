package br.exemplo.restAssured.runners;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features ="src/test/resources/features/", tags = {"@GET, @PUT, @DELETE, @PATCH, @TOKEN, @POST"}, 
		//tags={"@TOKEN","@POST"}, AND
		//tags = {"@GET, @PUT, @DELETE, @PATCH, @TOKEN, @POST"}  OR
		
		glue = "br.exemplo.restAssured.steps",
		plugin = {"pretty", "html:target/report-html", "json:target/cucumber-reports/cucumber.json" },
		monochrome = true, //utilizado para definir a formatação do resultado dos testes na saída da console
		dryRun = false    // Caso algum setado como true nao mostra o erro. Se setado como false apresenta o step que deu erro.
		
		)

public class Runner {

}
