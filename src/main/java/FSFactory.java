public class FSFactory {
    public static final FSFactory instance = new FSFactory();

    public static FSFactory getInstance() {
        return instance;
    }

    public IComposant createComposant(ComposantType composantType, String name, Owner owner){
        if(composantType == ComposantType.FICHIER)
            return new Fichier(name, owner);
        return new Repertoire(name, owner);
    }
}
