package cl.dasacademy.reservas.infrastructure.persistence;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "reservas")
public class ReservaJpaEntity {

    @Id
    @Column(name = "id", length = 36)
    private String id;

    @Column(name = "sala_id", nullable = false, length = 36)
    private String salaId;

    @Column(name = "inicio", nullable = false, length = 19)
    private String inicio;

    @Column(name = "fin", nullable = false, length = 19)
    private String fin;

    protected ReservaJpaEntity(){

    }

    ReservaJpaEntity(String id, String salaId, String inicio, String fin) {
        this.id = id;
        this.salaId = salaId;
        this.inicio = inicio;
        this.fin = fin;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSalaId() {
        return salaId;
    }

    public void setSalaId(String salaId) {
        this.salaId = salaId;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }
}
