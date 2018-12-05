package Business;

import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Role.Role;
import Business.Role.SystemAdminRole;
import Business.UserAccount.UserAccount;
import java.util.ArrayList;

/**
 *
 * @author hetashavi
 */
public class EcoSystem extends Organization {

    private static EcoSystem business;
    private DrugCatalog drugCatalog;
    private DiseaseCatalog diseasecatalog;
    private ArrayList<Network> networkList;

    public static EcoSystem getInstance() {
        if (business == null) {
            business = new EcoSystem();
        }
        return business;
    }
    //enhance ecosystem
    //multi threading
    //analysis using graphs
    //pharmacy based on areas in network
    //stimulation
    //alerts use extensively

    private EcoSystem() {
        super(null);
        networkList = new ArrayList<>();
        drugCatalog = new DrugCatalog();
        diseasecatalog = new DiseaseCatalog();
    }

    public ArrayList<Network> getNetworkList() {
        return networkList;
    }

    public DrugCatalog getDrugCatalog() {
        return drugCatalog;
    }

    public void setDrugCatalog(DrugCatalog drugCatalog) {
        this.drugCatalog = drugCatalog;
    }

    public DiseaseCatalog getDiseasecatalog() {
        return diseasecatalog;
    }

    public void setDiseasecatalog(DiseaseCatalog diseasecatalog) {
        this.diseasecatalog = diseasecatalog;
    }
    
    

    public Network createAndAddNetwork() {
        Network network = new Network();
        networkList.add(network);
        return network;
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roleList = new ArrayList<>();
        roleList.add(new SystemAdminRole());
        return roleList;
    }

    public boolean checkIfUsernameIsUnique(String username) {

        if (!this.getUserAccountDirectory().checkIfUsernameIsUnique(username)) {
            return false;
        }
        
        return true;
    }
    
    public boolean checkIfEmpNameIsUnique(String username) {

        if (!this.getEmployeeDirectory().checkIfEmployeeIsUnique(username)) {
            return false;
        }
        
        return true;
    }
    
//     public boolean checkIfUsernameIsUnique(String name){
//        for (Network net :business.networkList) {
//            for(Enterprise ent : net.getEnterpriseDirectory().getEnterpriseList()){
//                for( Organization org : ent.getOrganizationDirectory().getOrganizationList()){
//                    for (UserAccount ua : org.getUserAccountDirectory().getUserAccountList()){
//                        if(ua.getUsername().equals(name)){
//                            return false;
//                        }
//                    }
//                }
//            }
//        }
//        return true;
//    }
    
    public boolean checkIfNetworkIsUnique(String name){
        for (Network net : networkList){
            if (net.getName().equalsIgnoreCase(name))
                return false;
        }
        return true;
    }
    
}