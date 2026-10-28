package cl.dasacademy.reservas.application.query;

import java.time.LocalDateTime;
import java.util.UUID;

public record ReservaVista(UUID id, LocalDateTime inicio,LocalDateTime fin) {
}
