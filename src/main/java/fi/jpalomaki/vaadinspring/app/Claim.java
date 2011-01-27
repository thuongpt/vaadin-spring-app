package fi.jpalomaki.vaadinspring.app;

import java.util.List;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import fi.jpalomaki.vaadinspring.app.persistence.DomainObject;

/**
 * Abstraction for a generic claim.
 *
 * @author jpalomak
 */
@Entity
public final class Claim extends DomainObject {

    @Enumerated
    private Type type;
    private String summary;
    private String description;
    private BigDecimal amount;

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
    
    public static Claim of(Type type, String summary, String description, BigDecimal amount) {
        Claim claim = new Claim();
        claim.type = type;
        claim.summary = summary;
        claim.description = description;
        claim.amount = amount;
        return claim;
    }
    
    public static List<Claim> findAll() {
        return entityManager().createQuery("FROM Claim", Claim.class).getResultList();
    }
    
    /**
     * Abstraction for claim type.
     */
    public static enum Type {
        FRAUD, LEGITIMATE;
    }
}