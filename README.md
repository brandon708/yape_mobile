Claro, aquí tienes un README ajustado para el proyecto de automatización de pruebas en una aplicación móvil utilizando Appium, Serenity BDD y Cucumber.


# Automatización de Pruebas para Aplicación Móvil de Booking

Este proyecto contiene pruebas automatizadas para la aplicación móvil de Booking utilizando Appium, Cucumber y Serenity BDD.

## Descripción

Este repositorio está dedicado a las pruebas automatizadas de la aplicación móvil de Booking. Las pruebas están diseñadas para garantizar el correcto funcionamiento de los principales flujos de usuario en la aplicación, incluyendo la búsqueda de alojamientos, selección de fechas, selección de habitaciones y la realización de reservas.

## Funcionalidades

- **Búsqueda de Alojamiento**: Pruebas para verificar la búsqueda de alojamientos en diferentes ciudades.
- **Selección de Fechas y Habitaciones**: Incluye pruebas para seleccionar fechas de estadía y habitaciones.
- **Gestión de Reservas**: Pruebas para la creación de reservas y llenado de información del usuario.
- **Interacción con Elementos de la Interfaz**: Pruebas para la interacción con diversos elementos de la interfaz de usuario, incluyendo botones y formularios.

## Estructura del Proyecto

```markdown
src
├── test
│   └── java
│       └── com
│           └── yape
│               └── mobile
│                   ├── screens
│                   │   ├── SelectItemScreenBookings.java
│                   │   ├── CompleteInfoScreenBookings.java
│                   │   ├── HomeScreenBookings.java
│                   │   ├── SearchDateScreenBookings.java
│                   │   ├── SearchCityScreenBookings.java
│                   │   ├── SelectDesiredRoomsScreenBookings.java
│                   │   ├── SelectPassengersScreenBookings.java
│                   ├── steps
│                   │   ├── BookingSteps.java
│                   ├── stepdefinitions
│                   │   ├── BookingStepDefinitions.java
│                   ├── runners
│                   │   └── CucumberTestSuite.java
└── resources
        └── features
            └── booking.feature
```

## Prerrequisitos

Para ejecutar este proyecto, asegúrate de tener instalado:

- **Java JDK 8 o superior**
- **Maven**
- **Node.js y npm**
- **Appium Server**
- **Android SDK**
- **IDE de tu preferencia (IntelliJ IDEA, Eclipse, etc.)**

## Configuración

1. Clona este repositorio:

    ```bash
    git clone https://github.com/brandon708/yape_mobile_automation.git
    ```

2. Importa el proyecto en tu IDE.

3. Instala y configura Appium:

    ```bash
    npm install -g appium
    appium
    ```

4. Configura las variables de entorno necesarias en `serenity.properties`:

    ```properties
    appium.server.url=http://localhost:4723/wd/hub
    appium.device.name=emulator-5554
    appium.platform.name=Android
    appium.platform.version=11
    ```

5. Ejecuta las pruebas desde tu IDE o mediante Maven:

    ```bash
    mvn clean verify
    ```

## Tecnologías Utilizadas

- **Java**: Lenguaje de programación principal utilizado para desarrollar las pruebas automatizadas.
- **Cucumber**: Framework utilizado para escribir las pruebas en un formato legible por humanos usando Gherkin.
- **Serenity BDD**: Librería que se integra con Cucumber para generar informes detallados de las pruebas.
- **Appium**: Herramienta utilizada para la automatización de aplicaciones móviles.
- **Maven**: Herramienta de gestión de dependencias y automatización de la construcción del proyecto.

## Contribuciones

¡Las contribuciones son bienvenidas! Si encuentras algún problema o tienes alguna sugerencia, por favor crea un *issue* o envía un *pull request*.

## Autor

Brandon Soto Mallqui

## Licencia

Este proyecto está bajo la licencia MIT. Ver el archivo [LICENSE](./LICENSE) para más detalles.
