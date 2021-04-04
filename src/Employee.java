class Employee extends Person{
    private int salary;
    private String position;

    public Employee(String name, int age, Address address, int salary, String position){
        this.name = name;
        this.age = age;
        this.address = address;
        this.salary = salary;
        this.position = position;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int newSalary) {
        this.salary = newSalary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String newPosition) {
        this.position = newPosition;
    }

    public void details(){
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Position: " + position);
        System.out.println("Current salary: " + salary);
    }
}
