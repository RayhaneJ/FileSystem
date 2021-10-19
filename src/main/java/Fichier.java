public final class Fichier extends Composant {
    private StringBuilder content = new StringBuilder();

    public Fichier(String name, Owner owner) {
        super(name, owner);
    }

    @Override
    public Integer getSize() {
        return 1;
    }

    @Override
    public String getContent() {
        return content.toString();
    }

    @Override
    public void appendContent(String name) {
        this.content.append(name);
    }

    @Override
    public boolean isComposite() {
        return false;
    }

    @Override
    public String toString() {
        return getContent();
    }
}
