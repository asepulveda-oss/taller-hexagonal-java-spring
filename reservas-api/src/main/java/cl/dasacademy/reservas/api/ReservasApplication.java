package cl.dasacademy.reservas.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Punto de entrada. Levanta Spring Boot y nada más.
 *
 * <p>Escanea solo {@code cl.dasacademy.reservas.api}: las clases de domain,
 * application e infrastructure entran al contexto únicamente vía {@code @Bean}.
 */
@SpringBootApplication
public class ReservasApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReservasApplication.class, args);
    }
}
