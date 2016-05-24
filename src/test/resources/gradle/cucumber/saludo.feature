Feature: LanzaDados
  Compruebo la funcionalidad minima de mi aplicacion

  Scenario: basico
    Given Estoy en la pantalla principal
    When pulso botón de dado
    Then Aparece el resultado de la tirada

  Scenario: basico -> lista de tiradas
    Given Estoy en la pantalla principal
    When pulso el botón de lista
    Then Se va a la pantalla de lista de tiradas

  Scenario: lista de tiradas
    Given Estoy en la pantalla de lista de tiradas
    When pulso un botón de la lista de tiradas
    Then Aparece el resultado de la tirada de la lista

  Scenario: lista de tiradas -> añadir tirada
    Given Estoy en la pantalla de lista de tiradas
    When pulso el boton de añadir elemento
    Then Se va a la pantalla de añadir tirada

  Scenario: lista de tiradas -> modificar tirada
    Given Estoy en la pantalla de lista de tiradas
    When pulso el boton de editar elemento
    Then Se va a la pantalla de modificar tirada
