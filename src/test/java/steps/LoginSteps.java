package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

    @Given("el usuario esta en la pagina de login")
    public void usuarioEnLogin() {
        System.out.println("🟢 El usuario abre la página de login");
    }

    @When("ingresa credenciales validas")
    public void ingresaCredenciales() {
        System.out.println("🟡 Usuario ingresa usuario y clave");
    }

    @Then("deberia acceder al sistema")
    public void accedeAlSistema() {
        System.out.println("✅ Acceso exitoso al sistema");
    }
}
