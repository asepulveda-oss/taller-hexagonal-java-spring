package cl.dasacademy.reservas.application.query;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ReservaConsultas {
    List<ReservaVista> delDia(UUID salaId, LocalDate dia);
    Optional<ReservaVista> porId(UUID id);
}
