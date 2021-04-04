public class Address {
    private String street;
    private int zip_code;
    private String apartament;

    public Address(String street, int zip_code, String apartament){
        this.street = street;
        this.zip_code = zip_code;
        this.apartament = apartament;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String newStreet) {
        this.street = newStreet;
    }

    public int getZip_code() {
        return zip_code;
    }

    public void setZip_code(int newZip_code) {
        this.zip_code = newZip_code;
    }

    public String getApartament() {
        return apartament;
    }

    public void setApartament(String newApartment) {
        this.apartament = newApartment;
    }
}
