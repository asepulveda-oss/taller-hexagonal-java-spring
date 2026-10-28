package cl.dasacademy.reservas.application.command;

import java.time.LocalDateTime;
import java.util.UUID;

public record CrearReservaCommand(UUID salaId, LocalDateTime inicio,LocalDateTime fin) {
}
