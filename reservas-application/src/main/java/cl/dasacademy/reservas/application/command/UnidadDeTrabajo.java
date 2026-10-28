package cl.dasacademy.reservas.application.command;

import java.util.function.Supplier;

public interface UnidadDeTrabajo {
    <T> T ejecutar(Supplier<T> trabajo);
}
