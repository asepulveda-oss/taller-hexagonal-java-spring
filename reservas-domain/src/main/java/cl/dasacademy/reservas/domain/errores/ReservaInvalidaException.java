package cl.dasacademy.reservas.domain.errores;

import java.util.Map;

public abstract non-sealed class ReservaInvalidaException
extends  ReglaDeNegocioException {

    protected ReservaInvalidaException(String codigo, String mensaje, Map<String, Object> detalles){
        super(codigo,mensaje,detalles);
    }

    protected ReservaInvalidaException(String codigo, String mensaje){
        super(codigo,mensaje);
    }
}
