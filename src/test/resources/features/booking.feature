
Feature: Flujo completo de reserva de alojamiento en Booking

  @booking
  Scenario: Realizar una reserva de alojamiento
    Given que el usuario ha abierto la aplicación de Booking
    When  el usuario busca la Ciudad de CUSCO
    And   selecciona las fechas de estadía desde el 23/07/2024 hasta el 31/07/2024
    And   selecciona 3 habitación, 3 adultos y 1 niño de 5 años
    And   selecciona el 2 item del hotel disponible
    And   elige el tipo de habitación deseada
    And   llena los datos de la persona que realizará la reserva:
      | firstname | lastname | email           | country | mobile    | purpose |
      | Brandon   | Soto     | sotom@gmail.com | Peru    | 924190881 | Leisure |
    Then  la reserva debe ser confirmada con los detalles correctos
