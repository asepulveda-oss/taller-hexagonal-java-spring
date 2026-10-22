package cl.dasacademy.reservas.domain.errores;

import cl.dasacademy.reservas.domain.entidades.Formato;

import java.time.LocalDateTime;

public final class RangoInvertidoException extends ReservaInvalidaException {

    private final LocalDateTime inicio;
    private final LocalDateTime fin;

    public RangoInvertidoException(LocalDateTime inicio, LocalDateTime fin){
        super("reserva.rango_invertido",
                "El fin (" + Formato.fechaHora(fin) + ") debe ser posterior al inicio ("
                        + Formato.fechaHora(inicio) + ").",
                datos("inicio", inicio, "fin", fin));
        this.inicio = inicio;
        this.fin = fin;
    }

    public LocalDateTime inicio() {
        return inicio;
    }

    public LocalDateTime fin() {
        return fin;
    }
}
