package cl.dasacademy.reservas.domain.errores;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public abstract sealed class ReglaDeNegocioException extends RuntimeException
        permits ReservaInvalidaException, ConflictoDeEstadoException {

    private final String codigo;
    private final Map<String,Object> detalles;

    protected ReglaDeNegocioException(String codigo, String mensaje, Map<String,Object> detalles){
        super(mensaje);

        if(codigo == null || codigo.isBlank()){
            throw new IllegalArgumentException("Un error de negocio necesita un codigo estable");
        }
        this.codigo = codigo;
        this.detalles = detalles == null ? Map.of() : Collections.unmodifiableMap(new LinkedHashMap<>(detalles));
    }

    protected ReglaDeNegocioException(String codigo,String mensaje){
        this(codigo,mensaje,null);
    }

    public String codigo() {
        return this.codigo;
    }

    public Map<String,Object> detalles(){
        return this.detalles;
    }


    /**
     * Ayuda para que las subclases armen sus detalles en orden sin repetir la
     * ceremonia de {@code new LinkedHashMap<>(); put; put; put}.
     */
    protected static Map<String, Object> datos(Object... claveValor){
        Objects.requireNonNull(claveValor);

        if(claveValor.length % 2 != 0){
            throw new IllegalArgumentException("Los detalles van en pares clave, valor.");
        }

        var mapa = new LinkedHashMap<String, Object>();

        for (int i = 0; i < claveValor.length; i += 2) {
            mapa.put((String) claveValor[i], claveValor[i + 1]);
        }

        return mapa;
    }

}
