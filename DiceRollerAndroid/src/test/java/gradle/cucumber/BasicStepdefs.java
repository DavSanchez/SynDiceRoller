package test.java.gradle.cucumber;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.java.gradle.cucumber.Pantalla;

import static org.junit.Assert.assertEquals;

public class BasicStepdefs {
    private Pantalla obj;
    private String resultado;

    @Given("^Una pantalla de entrada$")
    public void una_pantalla_de_entrada() throws Throwable {
        obj = new Pantalla();
    }

    @When("^le digo mi nombre \"([^\"]*)\"$")
    public void le_digo_mi_nombre(String arg1) throws Throwable {
        obj.setNombre(arg1);
    }

    @When("^le pido que salude$")
    public void le_pido_que_salude() throws Throwable {
        resultado = obj.saluda();
    }

    @Then("^me contesta con \"([^\"]*)\"$")
    public void me_contesta_con(String arg1) throws Throwable {
        assertEquals(arg1, resultado);
    }


}
