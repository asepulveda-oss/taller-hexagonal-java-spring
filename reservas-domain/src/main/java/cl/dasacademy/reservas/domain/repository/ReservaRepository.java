package cl.dasacademy.reservas.domain.repository;

import cl.dasacademy.reservas.domain.entidades.Reserva;

import java.util.List;
import java.util.UUID;

public interface ReservaRepository
{
    List<Reserva> deSala(UUID salaId);
    void guardar(Reserva reserva);
}