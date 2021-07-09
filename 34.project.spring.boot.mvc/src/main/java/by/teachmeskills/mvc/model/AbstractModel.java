package by.teachmeskills.mvc.model;

public class AbstractModel implements IModel {

    protected Long id;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
