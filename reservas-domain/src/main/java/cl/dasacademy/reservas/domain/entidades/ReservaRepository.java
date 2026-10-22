package cl.dasacademy.reservas.domain.entidades;

import java.util.List;
import java.util.UUID;

public interface ReservaRepository
{
    List<Reserva> deSala(UUID salaId);
    void Guardar(Reserva reserva);
}
