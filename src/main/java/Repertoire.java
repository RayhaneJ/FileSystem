import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Repertoire extends Composant implements Composite<IComposant> {
    private List<IComposant> composants = new ArrayList<>();

    public Repertoire(String name, Owner owner) {
        super(name, owner);
    }

    @Override
    public Integer getSize() {
        return composants.size();
    }

    @Override
    public String getContent() {
        StringBuilder sb = new StringBuilder();
        composants.forEach(composant -> sb.append(composant.getName()).append("\n"));
        return sb.toString();
    }

    @Override
    public void appendContent(String name) {
        throw new UnsupportedOperationException("Cannot append content on repository.");
    }

    public IComposant appendContentToDir(String content){
        IComposant composant = FSFactory.getInstance().createComposant(ComposantType.FICHIER, String.valueOf(Objects.hash(content)+"-file"),owner);
        composants.add(composant);
        return composant;
    }

    @Override
    public boolean isComposite() {
        return true;
    }

    @Override
    public void setOwner(Owner owner, boolean recursive) {
        super.setOwner(owner, recursive);
        if(recursive)
            composants.forEach(composant -> composant.setOwner(owner, true));
    }

    @Override
    public List<IComposant> getChildren() {
        return new ArrayList<>(composants);
    }

    @Override
    public void addChild(IComposant t) {
        composants.add(t);
    }

    @Override
    public boolean removeChild(IComposant t) {
        composants.remove(t);
        return true;
    }

    @Override
    public boolean removeChildren(List<IComposant> t) {
        composants.removeAll(t);
        return true;
    }
}
