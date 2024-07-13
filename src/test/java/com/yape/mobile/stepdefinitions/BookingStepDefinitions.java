package com.yape.mobile.stepdefinitions;

import com.yape.mobile.step.BookingSteps;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

import java.util.List;
import java.util.Map;


public class BookingStepDefinitions {

    @Steps
    BookingSteps bookingSteps;

    @Given("^que el usuario ha abierto la aplicación de Booking$")
    public void queUsuarioAbreAplicacionBooking(){
    bookingSteps.inicio();
    }

    @When("^el usuario busca la Ciudad de (.*)$")
    public void elUsuarioBuscaLaCiudadDeCUSCO(String ciudad) {
    bookingSteps.ingresarCiudad(ciudad);
    bookingSteps.seleccionarCiudad();
    }

    @And("^selecciona las fechas de estadía desde el (.*) hasta el (.*)$")
    public void seleccionaLasFechasDeEstadíaDesdeElHastaEl(String fechainicio, String fechafinal) {
    bookingSteps.seleccionarFechas(fechainicio,fechafinal);
    }

    @And("^selecciona (.*) habitación, (.*) adultos y (.*) niño de (.*) años$")
    public void seleccionaHabitaciónAdultosYNiñoDeAños(int habitacion, int cantadultos, int cantniños, int edadniños) {
    bookingSteps.selecionamosCuartoYPasajeros(habitacion,cantadultos,cantniños,edadniños);
    }

    @And("^selecciona el (.*) item del hotel disponible$")
    public void seleccionaUnHotelDisponible(int item) {
    bookingSteps.seleccionarItem(item);
    }

    @And("^elige el tipo de habitación deseada$")
    public void eligeElTipoDeHabitaciónDeseada() {
    bookingSteps.elegirPrimeraOpcionDeseada();
    }

    @And("^llena los datos de la persona que realizará la reserva:$")
    public void llenaLosDatosDeLaPersonaQueRealizaráLaReserva(DataTable dataTable) {
        List<Map<String, String>> datos = dataTable.asMaps(String.class, String.class);
        Map<String, String> reserva = datos.get(0);


        bookingSteps.completarFomrulario(reserva);
    }

    @Then("^la reserva debe ser confirmada con los detalles correctos$")
    public void laReservaDebeSerConfirmadaConLosDetallesCorrectos() {

    }
}
