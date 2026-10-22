package cl.dasacademy.reservas.domain.errores;

import cl.dasacademy.reservas.domain.entidades.Formato;

import java.time.LocalDateTime;

public final class ReservaEnElPasadoException extends ReservaInvalidaException {

    private final LocalDateTime inicio;
    private final LocalDateTime ahora;

    public ReservaEnElPasadoException(LocalDateTime inicio, LocalDateTime ahora){
        super("reserva.en_el_pasado",
                "La reserva empieza " + Formato.fechaHora(inicio) + ", que ya pasó (ahora son las "
                        + Formato.fechaHora(ahora) + ").",
                datos("inicio", inicio, "ahora", ahora));
        this.inicio = inicio;
        this.ahora =  ahora;
    }

    public LocalDateTime inicio() {
        return inicio;
    }

    public LocalDateTime ahora() {
        return ahora;
    }
}
