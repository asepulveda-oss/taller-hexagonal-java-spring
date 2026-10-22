package cl.dasacademy.reservas.domain.entidades;

import cl.dasacademy.reservas.domain.errores.SalaRequeridaException;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public final class Reserva
{
    private final UUID id;
    private final UUID salaId;
    private final RangoHorario rango;

    private Reserva(UUID id, UUID salaId, RangoHorario rango){
        this.id = id;
        this.salaId = salaId;
        this.rango = rango;
    }

    public static Reserva crear(UUID salaId, LocalDateTime inicio, LocalDateTime fin, LocalDateTime ahora){
        Objects.requireNonNull(ahora,"ahora");

        if(salaId == null || salaId.equals(new UUID(0,0))){
            throw new SalaRequeridaException();
        }

        var rangoHorario = new RangoHorario(inicio,fin);

        return new Reserva(UUID.randomUUID(),salaId,rangoHorario);
    }

    public static Reserva rehidratar(UUID id, UUID salaId,LocalDateTime inicio, LocalDateTime fin){
        Objects.requireNonNull(id, "id");

        if(salaId == null || salaId.equals(new UUID(0,0))){
            throw new SalaRequeridaException();
        }

        var rangoHorario = new RangoHorario(inicio,fin);

        return new Reserva(id, salaId,rangoHorario);
    }

    /** Identidad de la reserva. Se asigna al nacer y no cambia nunca. */
    public UUID id() {
        return id;
    }

    /** Sala reservada. */
    public UUID salaId() {
        return salaId;
    }

    /** Tramo reservado. Es un value object, así que ya nació válido. */
    public RangoHorario rango() {
        return rango;
    }

    @Override
    public String toString() {
        return "Reserva " + id + " · sala " + salaId + " · " + rango;
    }
}
