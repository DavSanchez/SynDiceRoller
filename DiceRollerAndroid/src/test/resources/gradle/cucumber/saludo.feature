Feature: Saludo
  Compruebo la funcionalidad minima de mi aplicacion

  Scenario: basico
    Given Una pantalla de entrada
    When le pido que salude
    Then me contesta con "Buenos dias"

  Scenario: personalizado
    Given Una pantalla de entrada
    When le digo mi nombre "Javier"
    And  le pido que salude
    Then me contesta con "Buenos dias Javier"

  Scenario Outline: personalizado
    Given Una pantalla de entrada
    When le digo mi nombre "<nombre>"
    And  le pido que salude
    Then me contesta con "<resultado>"
    Examples:
      | nombre       | resultado                |
      | Javier       | Buenos dias Javier       |
      | Miguel Angel | Buenos dias Miguel Angel |
      | Luis         | Buenos dias Luis         |
