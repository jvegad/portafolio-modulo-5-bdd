package com.feature.stepdefinitions;

import java.time.Duration;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegisterSteps {

    private final WebDriver driver = Hooks.driver;
    private final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @Given("que estoy en la página de registro")
    public void que_estoy_en_la_pagina_de_registro() {
        driver.get("https://mi-carnet-infantil.web.app/register");
    }

    @And("acepto el modal de términos")
    public void acepto_el_modal_de_terminos() {
        WebElement aceptarBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Acepto')]")));
        aceptarBtn.click();
    }

    @When("ingreso el nombre {string}")
    public void ingreso_el_nombre(String nombre) {
        WebElement input = driver.findElement(By.xpath("//input[@placeholder='Nombre completo']"));
        input.sendKeys(nombre);
    }

    @And("ingreso el correo {string}")
    public void ingreso_el_correo(String correo) {
        WebElement input = driver.findElement(By.xpath("//input[@placeholder='Correo electrónico']"));
        input.sendKeys(correo);
    }

    @And("ingreso la contraseña {string}")
    public void ingreso_la_contrasena(String contrasena) {
        WebElement input = driver.findElement(By.xpath("//input[@placeholder='Contraseña']"));
        input.sendKeys(contrasena);
    }

    @And("confirmo la contraseña {string}")
    public void confirmo_la_contrasena(String contrasena) {
        WebElement input = driver.findElement(By.xpath("//input[@placeholder='Confirmar contraseña']"));
        input.sendKeys(contrasena);
    }

    @And("ingreso el RUT {string}")
    public void ingreso_el_rut(String rut) {
        WebElement input = driver.findElement(By.xpath("//input[@placeholder='RUT']"));
        input.sendKeys(rut);
    }

    @And("ingreso el RUT de carga {string}")
    public void ingreso_el_rut_de_carga(String rutCarga) {
        WebElement input = driver.findElement(By.xpath("//input[@placeholder='RUT Carga']"));
        input.sendKeys(rutCarga);
    }

    @And("hago clic en el botón de registrar")
    public void hago_clic_en_registrar() {
        WebElement btn = driver.findElement(By.xpath("//button[contains(text(),'Registrar')]"));
        btn.click();
    }

    @Then("debería redirigirme a la página principal")
    public void deberia_redirigirme_a_la_pagina_principal() {
        wait.until(ExpectedConditions.urlContains("/login"));

        String currentUrl = driver.getCurrentUrl();
        System.out.println("🔍 URL actual luego del registro: " + currentUrl);

        Assertions.assertTrue(currentUrl.contains("/login"), "No se redirigió a la página de login después del registro.");

    }
}
