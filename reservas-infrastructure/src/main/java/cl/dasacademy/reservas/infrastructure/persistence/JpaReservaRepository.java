package cl.dasacademy.reservas.infrastructure.persistence;

import cl.dasacademy.reservas.domain.entidades.Reserva;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

public final class JpaReservaRepository  extends ReservaRepositoryBase {
    private final SpringDataReservaJpa jpa;

    public JpaReservaRepository(SpringDataReservaJpa jpa){
        this.jpa = Objects.requireNonNull(jpa,"jpa");
    }

    @Override
    protected List<Reserva> buscarDeSala(UUID salaId){
        return jpa.findBySalaIdOrderByInicioAsc(salaId.toString()).stream()
                .map(ReservaMapper::aDominio)
                .toList();
    }

    @Override
    protected void persistir(Reserva reserva){
        jpa.save(ReservaMapper.aTabla(reserva));
    }
}
