package cl.dasacademy.reservas.domain.errores;

import java.util.Map;

public abstract non-sealed class ConflictoDeEstadoException extends
   ReglaDeNegocioException {

    protected ConflictoDeEstadoException(String codigo,String mensaje, Map<String,Object> detalles){
        super(codigo,mensaje,detalles);

    }

    protected ConflictoDeEstadoException(String codigo,String mensaje){
        super(codigo,mensaje);
    }
}
