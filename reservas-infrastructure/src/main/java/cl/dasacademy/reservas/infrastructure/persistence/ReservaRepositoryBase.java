package cl.dasacademy.reservas.infrastructure.persistence;

import cl.dasacademy.reservas.domain.entidades.Reserva;
import cl.dasacademy.reservas.domain.repository.ReservaRepository;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

public abstract class ReservaRepositoryBase implements ReservaRepository {

    @Override
    public final List<Reserva> deSala(UUID salaId){
        if(salaId == null){
            throw new IllegalArgumentException("Hay que indicar una sala para consultar sus reservas.");
        }

        return buscarDeSala(salaId);
    }

    @Override
    public final void guardar(Reserva reserva){
        Objects.requireNonNull(reserva,"reserva");

        persistir(reserva);
    }

    protected abstract List<Reserva> buscarDeSala(UUID salaId);

    protected  abstract void persistir(Reserva reserva);
}
