package cl.dasacademy.reservas.application.query;

import java.util.Objects;
import java.util.Optional;

public final class ObtenerReservaUseCase {
    private final ReservaConsultas consultas;

    public ObtenerReservaUseCase(ReservaConsultas consultas){
        this.consultas = Objects.requireNonNull(consultas,"consultas");
    }

    public Optional<ReservaVista> ejecutar(ReservaPorIdQuery query){
        Objects.requireNonNull(query,"query");

        return consultas.porId(query.id());
    }
}
