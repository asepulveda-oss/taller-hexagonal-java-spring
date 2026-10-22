package cl.dasacademy.reservas.domain.errores;

import cl.dasacademy.reservas.domain.entidades.Formato;

import java.time.Duration;

public final class DuracionFueraDeRangoException extends ReservaInvalidaException {

    private final Duration duracion;
    private final Duration minima;
    private final Duration maxima;

    public DuracionFueraDeRangoException(Duration duracion, Duration minima, Duration maxima) {
        super("reserva.duracion_fuera_de_rango",
                "La reserva dura " + Formato.minutos(duracion) + " y debe durar entre "
                        + Formato.minutos(minima) + " y " + Formato.horas(maxima) + ".",
                datos("duracionMinutos", duracion.toMinutes(),
                        "minimoMinutos", minima.toMinutes(),
                        "maximoMinutos", maxima.toMinutes()));

        this.duracion = duracion;
        this.maxima = maxima;
        this.minima = minima;
    }

    public Duration duracion() {
        return duracion;
    }

    public Duration minima() {
        return minima;
    }

    public Duration maxima() {
        return maxima;
    }

    public boolean esDemasiadoCorta() {
        return duracion.compareTo(minima) < 0;
    }
}
