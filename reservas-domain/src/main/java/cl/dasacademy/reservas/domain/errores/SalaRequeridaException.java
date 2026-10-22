package cl.dasacademy.reservas.domain.errores;

public final class SalaRequeridaException extends ReservaInvalidaException {

    public SalaRequeridaException() {
        super("reserva.sala_requerida", "La reserva debe indicar una sala.");
    }
}
