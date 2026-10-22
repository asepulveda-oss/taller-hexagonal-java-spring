package cl.dasacademy.reservas.domain.entidades;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class Formato {

    private static final DateTimeFormatter FECHA_HORA = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    private Formato(){
    }

    public static String fechaHora(LocalDateTime valor) {
        return valor == null ? "?" : FECHA_HORA.format(valor);
    }

    public static String minutos(Duration duracion) {
        return duracion.toMinutes() + " minutos";
    }

    public static String horas(Duration duracion) {
        // 4 h se escribe "4 horas", 90 min se escribe "1,5 horas".
        double horas = duracion.toMinutes() / 60.0;
        return (horas == Math.floor(horas)
                ? String.valueOf((long) horas)
                : String.valueOf(horas).replace('.', ',')) + " horas";
    }
}
