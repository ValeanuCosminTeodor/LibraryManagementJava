abstract class Person {
    protected String name;
    protected int age;
    protected Address address;

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int newAge) {
        this.age = newAge;
    }

    public Address getAddress() { return address;}

    public abstract void details();
}
