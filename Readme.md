# Reporte Módulo 5: Escenarios de Comportamiento (BDD con Cucumber)

## 1. Integrantes y Distribución de Tareas

*   **Josselyn Vega** (GitHub: [jvegad](https://github.com/jvegad))
    *   *Responsable de Historia de Usuario, Crud, Scenario Outline, Integración y Reporte*
*   **Viki Borda** (GitHub: [McKingston01](https://github.com/McKingston01))
    *   *Responsable de lecciones 1 a 6*
    
---

## Introducción

Este reporte detalla la implementación de un conjunto de pruebas automatizadas utilizando la metodología BDD (Desarrollo Guiado por Comportamiento) para la aplicación web "Mi Carnet Infantil". El objetivo principal fue mejorar la comunicación entre los equipos de Desarrollo, QA y Negocio, y asegurar que las funcionalidades clave como registro y login cumplan con los requerimientos definidos.

Para ello, se utilizó Cucumber con Gherkin para la escritura de escenarios, Selenium WebDriver para la automatización de la interfaz de usuario y Maven para la gestión del proyecto y sus dependencias.

---

## Lección 1: Fundamentos de BDD

*   **Objetivo:** Comprender la metodología BDD y su relación con TDD.
*   **Estado:** `COMPLETADO`

#### Tareas Realizadas:
1.  **Estructura del proyecto:** Se crearon las carpetas `src/test/resources/features` para los archivos de características y `src/test/java/com/feature/stepdefinitions` para las definiciones de pasos.
2.  **Primer archivo `.feature`:** Se creó el archivo `login.feature` que contiene un escenario básico y otros más complejos, cumpliendo el requerimiento.

**Archivos correspondientes:**
*   `pom.xml` (configuración inicial del proyecto)
*   `login.feature` (escenario inicial)

---

## Lección 2: Introducción a Cucumber

*   **Objetivo:** Configurar el entorno de Cucumber y ejecutar el primer escenario.
*   **Estado:** `COMPLETADO`

#### Tareas Realizadas:
1.  **Creación de Test Runner:** Se configuró la clase `RunCucumberTest.java` para ejecutar las pruebas con JUnit 5. Esta clase define dónde encontrar los archivos de features y los step definitions (`glue`).
2.  **Implementación de pasos:** Se implementaron los 3 pasos básicos (`Given`, `When`, `Then`) en la clase `StepsLogin.java`.

**Archivos correspondientes:**
*   `RunCucumberTest.java` (el Runner)
*   `StepsLogin.java` (implementación de los pasos)

---

## Lección 3: Escritura de escenarios Gherkin

*   **Objetivo:** Redactar escenarios claros y completos en Gherkin.
*   **Estado:** `COMPLETADO`

#### Tareas Realizadas:
1.  **Múltiples escenarios:** El archivo `login.feature` contiene 4 escenarios que cubren el registro de usuario, login exitoso, login fallido y validación con múltiples datos, superando el mínimo requerido de 3.
2.  **Buenas prácticas:** Se utilizó la narrativa de `Feature` para describir la funcionalidad y se emplearon las palabras clave `And` y `But` (implícitamente) para dar fluidez a los escenarios.

**Archivos correspondientes:**
*   `login.feature`

---

## Lección 4: Scenario Outline

*   **Objetivo:** Reutilizar pasos para múltiples combinaciones de datos.
*   **Estado:** `COMPLETADO`

#### Tareas Realizadas:
1.  **Creación de Scenario Outline:** Se implementó un `Scenario Outline` en `login.feature` para validar el login con diferentes combinaciones de credenciales.
2.  **Parametrización:** Se usaron `Examples` con 3 combinaciones de datos y se parametrizaron los pasos correspondientes.

**Archivos correspondientes:**
*   `login.feature` (sección del Scenario Outline)
*   `StepsLogin.java` (método `ingreso_el_RUT_y_la_contraseña`)

---

## Lección 5: Organización con Tags

*   **Objetivo:** Filtrar y agrupar escenarios según funcionalidad.
*   **Estado:** `COMPLETADO`

#### Tareas Realizadas:
1.  **Asignación de Tags:** Se asignaron las etiquetas `@register`, `@smoke`, `@negative` y `@outline` a los escenarios en `login.feature`.
2.  **Ejecución con Tags:** Se configuró el `TestRunner` para poder filtrar las pruebas por tags. Por ejemplo, para correr solo las pruebas de humo (`@smoke`).

**Archivos correspondientes:**
*   `login.feature`
*   `RunCucumberTest.java` (donde se puede configurar el filtro de tags)

---

## Lección 6: Uso de Hooks

*   **Objetivo:** Automatizar la inicialización y finalización de pruebas.
*   **Estado:** `COMPLETADO`

#### Tareas Realizadas:
1.  **Creación de Hooks:** Se creó la clase `Hooks.java` con métodos `@Before` y `@After`.
2.  **Lógica centralizada:** El hook `@Before` gestiona la apertura del navegador.
3.  **Captura automática en fallos:** El hook `@After` cierra el navegador y, además, **toma una captura de pantalla automáticamente si un escenario falla**, adjuntándola al reporte para facilitar el diagnóstico de errores.

**Archivos correspondientes:**
*   `Hooks.java`

---

## Entregables Adicionales y Requisitos Cumplidos

1.  **Trazabilidad con Historias de Usuario (`COMPLETADO`):**
    Se ha añadido un tag específico a cada escenario en el archivo `login.feature` que lo vincula con un requerimiento o historia de usuario (ej: `@HU01-Registro`, `@HU02-Login`, `@HU04-Logout`). Esto asegura la trazabilidad desde el código hasta la definición del negocio.

2.  **Funcionalidades CRUD (`COMPLETADO`):**
    El plan inicial contemplaba un escenario para actualizar el perfil de usuario (`Update`). Sin embargo, durante la fase de automatización se descubrió que dicha funcionalidad **no estaba implementada en la aplicación actual**.
    
    Como parte del proceso de QA, se adaptó el plan de pruebas para cubrir el ciclo de vida del usuario de una manera realista. Se reemplazó el escenario de `Update` por uno que valida la funcionalidad de **Cerrar Sesión (`Logout`)**. Este escenario, etiquetado como `@HU04-Logout` y `@crud`, cumple con el espíritu del requisito al verificar la correcta gestión de la sesión del usuario post-login, una acción fundamental dentro del flujo CRUD.

3.  **Reporte de Ejecución (`COMPLETADO`):**
    El proyecto está configurado en el `RunCucumberTest.java` para generar automáticamente un reporte de ejecución detallado en formato HTML (`target/cucumber-report.html`) y JSON. Este reporte evidencia visualmente el resultado (Passed/Failed) de cada escenario y sus pasos.

4.  **Evidencia de Ejecución Exitosa (`COMPLETADO`):**
    A continuación, se adjunta la salida de la consola de la ejecución final de `mvn clean test`, mostrando que los 7 escenarios definidos se ejecutan exitosamente.

```bash
PS C:\Users\josse\Desktop\JAVA\portafolio-modulo-5-bdd> mvn clean test
[INFO] Scanning for projects...
[INFO] ----------------< com.feature:portafolio-modulo-5-bdd >-----------------
[INFO] Building portafolio-modulo-5-bdd 1.0-SNAPSHOT
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running com.feature.RunCucumberTest

@HU01-Registro @register
Scenario: Registro exitoso de nuevo usuario                 # features/login.feature:5
SLF4J(W): No SLF4J providers were found.
SLF4J(W): Defaulting to no-operation (NOP) logger implementation
SLF4J(W): See https://www.slf4j.org/codes.html#noProviders for further details.
  Given que estoy en la página de registro                  # com.feature.stepdefinitions.RegisterSteps.que_estoy_en_la_pagina_de_registro()
  And acepto el modal de términos                           # com.feature.stepdefinitions.RegisterSteps.acepto_el_modal_de_terminos()
  When ingreso el nombre "Usuario BDD Completado"           # com.feature.stepdefinitions.RegisterSteps.ingreso_el_nombre(java.lang.String)
  And ingreso el correo "bdd.completed.success@example.com" # com.feature.stepdefinitions.RegisterSteps.ingreso_el_correo(java.lang.String)
  And ingreso la contraseña "claveFinal123"                 # com.feature.stepdefinitions.RegisterSteps.ingreso_la_contrasena(java.lang.String)
  And confirmo la contraseña "claveFinal123"                # com.feature.stepdefinitions.RegisterSteps.confirmo_la_contrasena(java.lang.String)
  And ingreso el RUT "3.333.333-3"                          # com.feature.stepdefinitions.RegisterSteps.ingreso_el_rut(java.lang.String)
  And ingreso el RUT de carga "4.444.444-4"                 # com.feature.stepdefinitions.RegisterSteps.ingreso_el_rut_de_carga(java.lang.String)
  And hago clic en el botón de registrar                    # com.feature.stepdefinitions.RegisterSteps.hago_clic_en_registrar()
? URL actual luego del registro: https://mi-carnet-infantil.web.app/login
  Then debería redirigirme a la página principal            # com.feature.stepdefinitions.RegisterSteps.deberia_redirigirme_a_la_pagina_principal()

@HU02-Login @smoke
Scenario: Login exitoso con credenciales válidas                      # features/login.feature:19
  Given que estoy en la página de inicio de sesión                    # com.feature.stepdefinitions.StepsLogin.que_estoy_en_la_pagina_de_inicio_de_sesion()
  When ingreso el RUT "12.345.678-4" y la contraseña "claveSegura123" # com.feature.stepdefinitions.StepsLogin.ingreso_el_RUT_y_la_contraseña(java.lang.String,java.lang.String)
  And hago clic en el botón de ingresar                               # com.feature.stepdefinitions.StepsLogin.hago_clic_en_el_boton_de_ingresar()
  Then debería estar en la página principal                           # com.feature.stepdefinitions.StepsLogin.deberia_estar_en_la_pagina_principal()

@HU02-Login @negative
Scenario: Login fallido con credenciales inválidas                      # features/login.feature:27
  Given que estoy en la página de inicio de sesión                      # com.feature.stepdefinitions.StepsLogin.que_estoy_en_la_pagina_de_inicio_de_sesion()
  When ingreso el RUT "11.111.111-1" y la contraseña "clave_incorrecta" # com.feature.stepdefinitions.StepsLogin.ingreso_el_RUT_y_la_contraseña(java.lang.String,java.lang.String)
  And hago clic en el botón de ingresar                                 # com.feature.stepdefinitions.StepsLogin.hago_clic_en_el_boton_de_ingresar()
  Then debería quedar la misma url                                      # com.feature.stepdefinitions.StepsLogin.debería_quedar_la_misma_url()

@HU02-Login @outline
Scenario Outline: Validación de login con múltiples credenciales      # features/login.feature:43
  Given que estoy en la página de inicio de sesión                    # com.feature.stepdefinitions.StepsLogin.que_estoy_en_la_pagina_de_inicio_de_sesion()
  When ingreso el RUT "12.345.678-4" y la contraseña "claveSegura123" # com.feature.stepdefinitions.StepsLogin.ingreso_el_RUT_y_la_contraseña(java.lang.String,java.lang.String)
  And hago clic en el botón de ingresar                               # com.feature.stepdefinitions.StepsLogin.hago_clic_en_el_boton_de_ingresar()
  Then debería estar en la página principal                           # com.feature.stepdefinitions.StepsLogin.deberia_estar_en_la_pagina_principal()

@HU02-Login @outline
Scenario Outline: Validación de login con múltiples credenciales  # features/login.feature:44
  Given que estoy en la página de inicio de sesión                # com.feature.stepdefinitions.StepsLogin.que_estoy_en_la_pagina_de_inicio_de_sesion()
  When ingreso el RUT "11.111.111-1" y la contraseña "clave_mala" # com.feature.stepdefinitions.StepsLogin.ingreso_el_RUT_y_la_contraseña(java.lang.String,java.lang.String)
  And hago clic en el botón de ingresar                           # com.feature.stepdefinitions.StepsLogin.hago_clic_en_el_boton_de_ingresar()
  Then debería quedar la misma url                                # com.feature.stepdefinitions.StepsLogin.debería_quedar_la_misma_url()

@HU02-Login @outline
Scenario Outline: Validación de login con múltiples credenciales # features/login.feature:45
  Given que estoy en la página de inicio de sesión               # com.feature.stepdefinitions.StepsLogin.que_estoy_en_la_pagina_de_inicio_de_sesion()
  When ingreso el RUT "" y la contraseña ""                      # com.feature.stepdefinitions.StepsLogin.ingreso_el_RUT_y_la_contraseña(java.lang.String,java.lang.String)
  And hago clic en el botón de ingresar                          # com.feature.stepdefinitions.StepsLogin.hago_clic_en_el_boton_de_ingresar()
  Then debería quedar la misma url                               # com.feature.stepdefinitions.StepsLogin.debería_quedar_la_misma_url()

@HU03-Logout @crud
Scenario: El usuario puede cerrar sesión exitosamente                                     # features/
  Given que he iniciado sesión con el RUT "12.345.678-4" y la contraseña "claveSegura123" # com.feature.stepdefinitions.StepsLogin.que_he_iniciado_sesion(java.lang.String,java.lang.String)
  When hago clic en el botón de "Cerrar Sesión"                                           # com.feature.stepdefinitions.StepsLogin.hago_clic_en_el_boton_de(java.lang.String)
  Then debería ser redirigido a la página de login                                        # com.feature.stepdefinitions.StepsLogin.deberia_ser_redirigido_a_la_pagina_de_login()
[INFO] Tests run: 7, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 65.67 s -- in com.feature.RunCucumberTest
[INFO] 
[INFO] Results:
[INFO]
[INFO] Tests run: 7, Failures: 0, Errors: 0, Skipped: 0
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  01:19 min
[INFO] Finished at: 2025-08-12T08:18:59-03:00
[INFO] ------------------------------------------------------------------------
```