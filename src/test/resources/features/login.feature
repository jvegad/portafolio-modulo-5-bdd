Feature: Funcionalidad de inicio de sesión y registro

  # HU-01: Como usuario nuevo, quiero poder registrarme en la plataforma.
  @HU01-Registro @register
  Scenario: Registro exitoso de nuevo usuario
    Given que estoy en la página de registro
    And acepto el modal de términos
    When ingreso el nombre "Usuario BDD Completado"
    And ingreso el correo "bdd.completed.success@example.com"
    And ingreso la contraseña "claveFinal123"
    And confirmo la contraseña "claveFinal123"
    And ingreso el RUT "3.333.333-3"
    And ingreso el RUT de carga "4.444.444-4"
    And hago clic en el botón de registrar
    Then debería redirigirme a la página principal

  # HU-02: Como usuario registrado, quiero poder iniciar sesión en la plataforma.
  @HU02-Login @smoke
  Scenario: Login exitoso con credenciales válidas
    Given que estoy en la página de inicio de sesión
    When ingreso el RUT "12.345.678-4" y la contraseña "claveSegura123"
    And hago clic en el botón de ingresar
    Then debería estar en la página principal
  
  # HU-02: Como usuario, quiero recibir un error si mis credenciales son incorrectas.
  @HU02-Login @negative
  Scenario: Login fallido con credenciales inválidas
    Given que estoy en la página de inicio de sesión
    When ingreso el RUT "11.111.111-1" y la contraseña "clave_incorrecta"
    And hago clic en el botón de ingresar
    Then debería quedar la misma url
  
  # HU-02: Como QA, quiero verificar múltiples combinaciones de login.
  @HU02-Login @outline
  Scenario Outline: Validación de login con múltiples credenciales
    Given que estoy en la página de inicio de sesión
    When ingreso el RUT "<rut>" y la contraseña "<clave>"
    And hago clic en el botón de ingresar
    Then debería <resultado>

    Examples:
      | rut          | clave          | resultado                    |
      | 12.345.678-4 | claveSegura123 | estar en la página principal |
      | 11.111.111-1 | clave_mala     | quedar la misma url          |
      |              |                | quedar la misma url          |
  
# HU-03: Como usuario conectado, quiero poder cerrar mi sesión de forma segura.
  @HU03-Logout @crud
  Scenario: El usuario puede cerrar sesión exitosamente
    Given que he iniciado sesión con el RUT "12.345.678-4" y la contraseña "claveSegura123"
    When hago clic en el botón de "Cerrar Sesión"
    Then debería ser redirigido a la página de login
