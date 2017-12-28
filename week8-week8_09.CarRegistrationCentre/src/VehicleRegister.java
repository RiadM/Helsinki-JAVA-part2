import java.util.ArrayList;
import java.util.HashMap;

public class VehicleRegister {
    private HashMap<RegistrationPlate, String> owners;

    public VehicleRegister() {
        this.owners =new HashMap<RegistrationPlate, String>();
    }

    public boolean add(RegistrationPlate plate, String owner){
        if(this.owners.get(owner) == null && this.owners.get(plate) == null){
            this.owners.put(plate,owner);
            return true;
        }else {
            return false;
        }
    }

    public String get(RegistrationPlate plate){
        if(this.owners.get(plate) == null){
            return null;
        }else {
            return "" + this.owners.get(plate);
        }
    }

    public boolean delete(RegistrationPlate plate){
        if(this.owners.get(plate) != null){
            this.owners.remove(plate);
            return true;
        } else {
            return false;
        }
    }

    public void printRegistrationPlates(){
        for(RegistrationPlate plate: this.owners.keySet()){
            System.out.println(plate.toString());
        }
    }

    public void printOwners(){
        ArrayList<String> carOwner = new ArrayList();
        for(RegistrationPlate plate: this.owners.keySet()){
            String name = this.owners.get(plate).toString();
            if(!carOwner.contains(name)){
            carOwner.add(name);
                System.out.println(name);
            }
        }
    }
}
