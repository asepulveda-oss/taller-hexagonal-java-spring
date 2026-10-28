package cl.dasacademy.reservas.infrastructure.persistence;

import cl.dasacademy.reservas.domain.entidades.Reserva;
import cl.dasacademy.reservas.domain.errores.ReglaDeNegocioException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

final class ReservaMapper {
    static final DateTimeFormatter FORMATO_TABLA = DateTimeFormatter.ofPattern("uuuu-MM-dd'T'HH:mm:ss");

    private ReservaMapper() {
    }

    static Reserva aDominio(ReservaJpaEntity fila){
        try{
            return Reserva.rehidratar(
                    UUID.fromString(fila.getId()),
                    UUID.fromString(fila.getSalaId()),
                    deTexto(fila.getInicio()),
                    deTexto(fila.getFin())
            );
        }catch (ReglaDeNegocioException e){
            throw new IllegalStateException(
                    "La fila de reservas " + fila.getId() + " viola una invariante del dominio: " + e.getMessage(), e);
        }
    }

    static ReservaJpaEntity aTabla(Reserva reserva){
        return new ReservaJpaEntity(
                reserva.id().toString(),
                reserva.salaId().toString(),
                aTexto(reserva.rango().inicio()),
                aTexto(reserva.rango().fin()));
    }

    static String aTexto(LocalDateTime valor) {
        return FORMATO_TABLA.format(valor);
    }

    static LocalDateTime deTexto(String valor) {
        return LocalDateTime.parse(valor, FORMATO_TABLA);
    }
}
