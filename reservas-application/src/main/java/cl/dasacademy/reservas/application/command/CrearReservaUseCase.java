package cl.dasacademy.reservas.application.command;

import cl.dasacademy.reservas.application.exceptions.SalaOcupadaException;
import cl.dasacademy.reservas.domain.entidades.Reserva;
import cl.dasacademy.reservas.domain.repository.ReservaRepository;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Objects;
import java.util.UUID;

public final class CrearReservaUseCase {

    private final ReservaRepository reservaRepository;
    private final UnidadDeTrabajo unidadDeTrabajo;
    private final Clock reloj;

    public CrearReservaUseCase(ReservaRepository reservaRepository,
                               UnidadDeTrabajo unidadDeTrabajo,
                               Clock reloj)
    {
        this.reservaRepository = Objects.requireNonNull(reservaRepository,"ReservaRepository");
        this.unidadDeTrabajo = Objects.requireNonNull(unidadDeTrabajo,"UnidadDeTrabajo");
        this.reloj = Objects.requireNonNull(reloj,"reloj");
    }

    public UUID ejecutar(CrearReservaCommand cmd)
    {
        Objects.requireNonNull(cmd,"cmd");

        var reserva = Reserva.crear(cmd.salaId(),cmd.inicio(),cmd.fin(),ahora());

        return unidadDeTrabajo.ejecutar(() -> {

            var otrasReservas = reservaRepository.deSala(cmd.salaId());

            var choque = otrasReservas.stream().filter(otraReserva -> otraReserva.rango().seTranslapaCon(reserva.rango()))
                    .findFirst();

            if(choque.isPresent()){
                throw new SalaOcupadaException(cmd.salaId(),reserva.rango(),choque.get().rango());
            }

            reservaRepository.guardar(reserva);

            return reserva.id();
        });
    }

    //aca obtenemos la hora y fecha actual del sistema
    private LocalDateTime ahora(){
        return LocalDateTime.now(reloj).truncatedTo(ChronoUnit.SECONDS);
    }
}
