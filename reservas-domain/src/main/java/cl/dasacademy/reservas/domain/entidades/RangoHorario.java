package cl.dasacademy.reservas.domain.entidades;

import cl.dasacademy.reservas.domain.errores.DuracionFueraDeRangoException;
import cl.dasacademy.reservas.domain.errores.RangoInvertidoException;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public record RangoHorario(LocalDateTime inicio, LocalDateTime fin)
{
    public static final Duration MIN = Duration.ofMinutes(30);
    public static final Duration MAX = Duration.ofHours(4);

    private static final DateTimeFormatter LEGIBLE = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public RangoHorario {
        Objects.requireNonNull(inicio,"inicio");
        Objects.requireNonNull(fin,"fin");

        inicio = inicio.truncatedTo(ChronoUnit.MINUTES);
        fin = fin.truncatedTo(ChronoUnit.MINUTES);

        //vamos a validar que el fin no sea el pasado del inicio
        if(!fin.isAfter(inicio)){
            throw new RangoInvertidoException(inicio,fin);
        }

        var duracion = Duration.between(inicio, fin);

        //validamos que se cumpla tanto la duracion minima como maxima para la reserva
        if (duracion.compareTo(MIN) < 0 || duracion.compareTo(MAX) > 0) {
            throw new DuracionFueraDeRangoException(duracion, MIN, MAX);
        }

    }

    public Duration duracion() {
        return Duration.between(inicio, fin);
    }

    public boolean seTranslapaCon(RangoHorario otraReserva){
        Objects.requireNonNull(otraReserva,"otro");

        return inicio.isBefore(otraReserva.fin()) && otraReserva.inicio().isBefore(fin);
    }

    @Override
    public String toString() {
        return LEGIBLE.format(inicio) + "–" + DateTimeFormatter.ofPattern("HH:mm").format(fin);
    }
}
