package cl.dasacademy.reservas.application.query;

import java.time.LocalDate;
import java.util.UUID;

public record ReservasDelDiaQuery(UUID salaId, LocalDate dia) {
}
