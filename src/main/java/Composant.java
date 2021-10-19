import java.util.Objects;

public abstract class Composant implements IComposant {
    protected final String name;
    protected Owner owner;

    public Composant(String name, Owner owner){
        this.name = name;
        this.owner = owner;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Owner getOwner() {
        return owner;
    }

    @Override
    public void setOwner(Owner owner, boolean recursive) {
        this.owner = owner;
    }

    @Override
    public abstract Integer getSize();

    @Override
    public abstract String getContent();

    @Override
    public abstract void appendContent(String name);

    @Override
    public abstract boolean isComposite();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Composant composant = (Composant) o;
        return Objects.equals(name, composant.name) && Objects.equals(owner, composant.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, owner);
    }
}
