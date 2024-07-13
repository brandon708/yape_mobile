package com.yape.mobile.step;

import com.yape.mobile.screens.*;
import net.thucydides.core.annotations.Step;

import java.text.ParseException;
import java.util.Map;


public class BookingSteps {
    HomeScreenBookings homeScreenBookings;
    SearchCityScreenBookings searchCityScreenBookings;

    SearchDateScreenBookings searchDateScreenBookings;
    SelectPassengersScreenBookings selectPassengersScreenBookings;
    SelectItemScreenBookings selectItemScreenBookings;
    SelectDesiredRoomsScreenBookings selectDesiredRoomsScreenBookings;
    CompleteInfoScreenBookings completeInfoScreenBookings;
    @Step("Iniciar")
    public void inicio(){
        homeScreenBookings.iniciar();
    }
    @Step("Ingresar Ciudad {0}")
    public void ingresarCiudad(String ciudad){
        searchCityScreenBookings.enterSearchCity(ciudad);
    }
    @Step("Seleccionamos Ciudad")
    public void seleccionarCiudad(){
        searchCityScreenBookings.clickFirstOption();
    }

    @Step("Seleccionamos Fecha Inicio y Final {0}, {1}")
    public void seleccionarFechas(String fechaInicio, String fechaFinal) {
        try {
            searchDateScreenBookings.selectDate(fechaInicio, fechaFinal);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Step("Seleccionamos Cuartos y Pasajeros {0}, {1}, {2}, {3}")
    public void selecionamosCuartoYPasajeros(int habitacion, int cantadultos, int cantninos, int edadninos){
        selectPassengersScreenBookings.selectPassenger();
        selectPassengersScreenBookings.selectRooms(habitacion);
        selectPassengersScreenBookings.selectAdults(cantadultos);
        selectPassengersScreenBookings.selectChildren(cantninos,edadninos);
        selectPassengersScreenBookings.selectApply();
        selectPassengersScreenBookings.selectSearch();
    }

    @Step("Seleccionamos el segundo item {0}")
    public void seleccionarItem(int item) {
      selectItemScreenBookings.selectSecondItem(item);
    }

    @Step("Seleccionamos la primera habitacion")
    public void elegirPrimeraOpcionDeseada() {
        selectDesiredRoomsScreenBookings.clickNext();
        selectDesiredRoomsScreenBookings.selectFirstOption();
        selectDesiredRoomsScreenBookings.clickReserva();
    }
    @Step("Llenamos el formulario de Informacion personal {0}")
    public void completarFomrulario(Map<String, String> reserva) {
        completeInfoScreenBookings.fillReservationForm(
                reserva.get("firstname"),
                reserva.get("lastname"),
                reserva.get("email"),
                reserva.get("country"),
                reserva.get("mobile"),
                reserva.get("purpose"));
    }

}
