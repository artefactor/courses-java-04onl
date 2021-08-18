package by.tms.springmvctutorial;

import javax.persistence.*;

@MappedSuperclass
public abstract class AbstractEntity implements IEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    protected Long id;

    public AbstractEntity(Long id) {
        this.id = id;
    }

    public AbstractEntity(Long id, Long timestamp) {
        this.id = id;
    }

    public AbstractEntity() {
    }

    @PrePersist
    public void init() {
        this.id = null;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
