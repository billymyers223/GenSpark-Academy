public class Puppy extends Dog{
    public String puppyName;
    public Puppy(String name, String puppyName) {
        super(name);
        this.puppyName = puppyName;
    }

    @Override
    public String toString(){

        System.out.println(puppyName + " had a puppy named " + super.getName());
        return puppyName + " is the child of " + super.getName();
    }

}
