package cl.dasacademy.reservas.application.query;

import java.util.List;
import java.util.Objects;

public final class ListarReservasDelDiaUseCases {

    private final ReservaConsultas consultas;

    public ListarReservasDelDiaUseCases(ReservaConsultas consultas){
        this.consultas = Objects.requireNonNull(consultas,"consultas");
    }

    public List<ReservaVista> ejecutar(ReservasDelDiaQuery query){
        Objects.requireNonNull(query,"query");

        return consultas.delDia(query.salaId(),query.dia());
    }
}
