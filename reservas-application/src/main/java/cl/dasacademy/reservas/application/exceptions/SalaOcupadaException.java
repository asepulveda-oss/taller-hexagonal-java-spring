package cl.dasacademy.reservas.application.exceptions;

import cl.dasacademy.reservas.domain.entidades.RangoHorario;
import cl.dasacademy.reservas.domain.errores.ConflictoDeEstadoException;

import java.util.LinkedHashMap;
import java.util.UUID;

public final class SalaOcupadaException extends ConflictoDeEstadoException {
    private final UUID salaId;
    private final RangoHorario rangoPedido;
    private final RangoHorario rangoOcupado;

    public SalaOcupadaException(UUID salaId, RangoHorario rangoPedido, RangoHorario rangoOcupado) {
        super("sala.ocupada",
                "La sala " + salaId + " ya tiene una reserva de " + rangoOcupado
                        + " que se cruza con el tramo pedido (" + rangoPedido + ").",
                detalles(salaId, rangoPedido, rangoOcupado));
        this.salaId = salaId;
        this.rangoPedido = rangoPedido;
        this.rangoOcupado = rangoOcupado;
    }

    private static LinkedHashMap<String, Object> detalles(
            UUID salaId, RangoHorario pedido, RangoHorario ocupado) {
        var mapa = new LinkedHashMap<String, Object>();
        mapa.put("salaId", salaId);
        mapa.put("inicioPedido", pedido.inicio());
        mapa.put("finPedido", pedido.fin());
        // Devolver el tramo que estorba, y no solo decir "está ocupada", es lo que
        // permite que un frontend muestre "ocupada de 9 a 11, prueba después de
        // las 11" en vez de un error genérico. Sale gratis: el caso de uso ya tenía
        // el dato en la mano cuando detectó el choque.
        mapa.put("inicioOcupado", ocupado.inicio());
        mapa.put("finOcupado", ocupado.fin());
        return mapa;
    }

    /** Sala en conflicto. */
    public UUID salaId() {
        return salaId;
    }

    /** El tramo que se quiso reservar. */
    public RangoHorario rangoPedido() {
        return rangoPedido;
    }

    /** El tramo ya reservado que lo impide. */
    public RangoHorario rangoOcupado() {
        return rangoOcupado;
    }
}
