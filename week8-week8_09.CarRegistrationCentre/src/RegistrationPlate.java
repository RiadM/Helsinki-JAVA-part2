
public class RegistrationPlate {
    // don't change the code which is already given to you

    // ATTENTION: the object variable types are final, meaning that their value cannot be changed!
    private final String regCode;
    private final String country;

    public RegistrationPlate(String country, String regCode) {
        this.regCode = regCode;
        this.country = country;
    }

    @Override
    public String toString() {
        return country + " " + regCode;
    }

    @Override
    public boolean equals(Object object){

        //Return false if not same object or object is null
        if(object == null || getClass() != object.getClass()){
            return false;
        }

        RegistrationPlate compared = (RegistrationPlate) object;

        //Return false if country is not same, null or not equals.
        if(compared.country != this.country || this.country == null || !this.country.equals(compared.country) || !this.regCode.equals(compared.regCode)){
            return false;
        }
        return true;
    }

    @Override
    public int hashCode(){
        //Arbitrary return 2 if the country is null
        if(this.country == null){
            return 2;
        }
        return this.country.hashCode();
    }

}
