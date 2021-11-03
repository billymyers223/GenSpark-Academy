public class Dog {
    private String name;

    public Dog(String name) {
        this.name = name;
    }

    public String bark(){
        System.out.println("Woof");
        return "Fido barks";
    }
    public String getName(){
        return name;
    }

    @Override
    public String toString(){
        Puppy fluffy = new Puppy(name, "Fluffy");
        System.out.println(name + " had a puppy named " + fluffy.puppyName);
        return name + " had a puppy named " + fluffy.puppyName;
    }

}
