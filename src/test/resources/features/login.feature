@SmokeTest
Feature: Login de usuario

  Scenario: Login exitoso
    Given el usuario esta en la pagina de login
    When ingresa credenciales validas
    Then deberia acceder al sistema
