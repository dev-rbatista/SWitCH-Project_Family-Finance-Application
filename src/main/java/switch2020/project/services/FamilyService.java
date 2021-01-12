package switch2020.project.services;

import switch2020.project.model.*;
import switch2020.project.utils.FamilyMemberRelationDTO;
import switch2020.project.utils.FamilyWithoutAdministratorDTO;
import switch2020.project.utils.MemberProfileDTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FamilyService {

    // Attributes
    private List<Family> families = new ArrayList<>();

    // Constructors
    public FamilyService() {

    }

    public FamilyService(Family family) {
        this.families.add(family);
    }

    // Business Methods

    /**
     * Method that generates an ID for a Family
     *
     * @return generated ID
     */

    private int generateFamilyID() {
        int maxID = 0;
        for (Family family : this.families) {
            if (maxID < family.getFamilyID()) maxID = family.getFamilyID();
        }
        return maxID + 1;
    }

    public List<CustomCategory> getCustomCategories(int familyID) {
        Family family = getFamily(familyID);
        return family.getFamilyCustomCategories();
    }

    /**
     * Method to add an EmailAddress object with the passed email address string to the FamilyMember with the passed ID
     *
     * @param emailToAdd     String of the email address to add
     * @param familyID       Integer representing the family's ID
     * @param ccNumber Integer representing the family member's ID
     * @return True if email successfully added to the Family Member with the passed ID
     */
    public boolean addEmail(String emailToAdd, int familyID, String ccNumber) {
        if (!checkIfEmailPresent(emailToAdd)) {
            Family targetFamily = this.families.get(findFamilyIndexByID(familyID));
            return targetFamily.addEmail(emailToAdd, ccNumber);
        }
        throw new IllegalArgumentException("This email is already present");
    }

    /**
     * Method to find the index of a family with a specific ID in the Families ArrayList
     *
     * @param familyID Integer representing the ID to find
     * @return Int corresponding to the index of the family  that has the passed ID
     * @throws IllegalArgumentException if there is no family with the passed ID
     */
    private int findFamilyIndexByID(int familyID) {
        int index = 0;
        for (Family family : this.families) {
            if (family.getFamilyID() == familyID) {
                return index;
            }
            index++;
        }
        throw new IllegalArgumentException("No family with that ID was found");
    }

    /**
     * Method to check if a given email address is already present in the ArrayList of EmailAddress objects
     *
     * @param emailToCheck String representing the email address to check if present
     * @return True if the passed email address is already present
     */
    private boolean checkIfEmailPresent(String emailToCheck) {
        List<FamilyMember> allFamilyMembers = new ArrayList();
        List<EmailAddress> allEmails = new ArrayList();
        for (Family family : this.families) {
            allFamilyMembers.addAll(family.getFamilyMembers());

        }
        for (FamilyMember familyMember : allFamilyMembers) {
            allEmails.addAll(familyMember.getEmails());

        }

        for (EmailAddress email : allEmails) {
            if (email.getEmail().equalsIgnoreCase(emailToCheck)) {
                return true;
            }
        }
        return false;

    }

    /**
     * Method to add a Family to Families List -> families
     *
     * @param family Family to add
     */

    public void addFamily(Family family) {
        this.families.add(family);
    }

    public boolean addFamily(String familyName) {
        try {
            int familyID = generateFamilyID();
            Family newFamily = new Family(familyName, familyID);
            families.add(newFamily);
            return true;
        } catch (IllegalArgumentException exception) {
            return false;
        }
    }

    /**
     * Method to create a Relation and assign it to a Family Member
     *
     * @param selfCCNumber        ID of the Family Member how wants to create a Relation
     * @param otherccNumber       ID of the Family Member to be added a Relation
     * @param relationDesignation Relation Designation
     * @param familyID            FamilyID of Family Member how wants to create a Relation
     * @return boolean
     */

    public boolean createRelation(String selfCCNumber, String otherccNumber, String relationDesignation, int familyID) {
        Relation relation;
        Family fam = getFamily(familyID);

        if (fam.isAdmin(selfCCNumber)) { // If is Administrator
            if (fam.hasDesignation(relationDesignation)) { // Verify if a given relation designation is already present in list of relations assigned
                relation = new Relation(relationDesignation);
                fam.addRelationToFamilyMember(otherccNumber, relation); // Create a Relation instance and assign to a Family Member

            } else { // If not, add to list of relations assigned
                relation = new Relation(relationDesignation);
                fam.addToRelationDesignationList(relationDesignation);
                fam.addRelationToFamilyMember(otherccNumber, relation); // Create a Relation instance and assign to a Family Member
            }
            return true; // Return true if is administrator and a Relation has been created and assigned to given Family Member
        }
        return false; // Return false if isn't administrator
    }

    /**
     * Method to get a family by ID in families
     *
     * @param familyID FamilyID of required family
     * @return Family instance
     */
    public Family getFamily(int familyID) {
        if (checkIfFamilyExists(familyID)) {
            for (Family family : families) {
                if (family.getFamilyID() == familyID)
                    return family;
            }
        } else {
            throw new IllegalArgumentException("No family with such ID");
        }
        return null;
    }

    private boolean checkIfFamilyExists(int familyID) {
        for (Family family : families) {
            if (familyID == family.getFamilyID()) {
                return true;
            }
        }
        return false;
    }

    public boolean addFamilyMember(String ccNumber, String cc, String name, Date birthDate, Integer phone, String email, Integer vat, String street, String codPostal, String local, String city, Relation relationship, int familyID) {
        if (checkIfFamilyExists(familyID)) {
            int posicaoFamilia = this.families.indexOf(getFamily(familyID));
            if (this.families.get(posicaoFamilia).isAdmin(ccNumber)) {
                if (!checkIfEmailPresent(email)) {
                    return this.families.get(posicaoFamilia).addFamilyMember(cc, name, birthDate, phone, email, vat, street, codPostal, local, city, relationship);
                }
                throw new IllegalArgumentException("This email already exists");
            }
            throw new IllegalArgumentException("This user is not Administrator");
        }
        throw new IllegalArgumentException("Family does not exist");
    }

    public boolean addFamilyAdministrator(String ccNumber, String name, Date birthDate, Integer phone, String email, Integer vat, String street, String codPostal, String local, String city, Relation relationship, int familyID) {
        if (checkIfFamilyExists(familyID)) {
            if (!checkIfEmailPresent(email)) {
                int posicaoFamilia = this.families.indexOf(getFamily(familyID));
                return this.families.get(posicaoFamilia).addFamilyAdministrator(ccNumber, name, birthDate, phone, email, vat, street, codPostal, local, city, relationship);
            }
            throw new IllegalArgumentException("This email already exists");
        }
        throw new IllegalArgumentException("Family does not exist");
    }

   /* //Temporariamente comentado para não ter conflito até se decidir se retorna null ou exception
    private Family getFamily(int familyID){
        for (Family familia : families ) {
            if(familyID == familia.getFamilyID())
                return familia;
        }
        return null;
    } */

    public boolean verifyAdministratorPermission(int familyID, String ccNumber) {
        Family family = getFamily(familyID);
        boolean isAdmin = family.isAdmin(ccNumber);
        return isAdmin;
    }


    /**
     * Method to convert the FamilyMembers of a determined family previously obtained by the familyID.
     * With the familyID the method get the familyMembers (getMembers()) and iterates through all the members
     * obtaining the name and the relationDesignation, using them to create a new instance of the FamilyMemberRelationDTO
     * object which is stored in the FMRList. Returns said List back to the GetFamilyMembersAndRelation Controller.
     *
     * @param familyID
     * @return DTOList
     */
    public List<FamilyMemberRelationDTO> getDTOList(int familyID, String adminCCNumber) {
        List<FamilyMemberRelationDTO> DTOList = new ArrayList<>();
        if (verifyAdministratorPermission(familyID, adminCCNumber)) {
            List<FamilyMember> members = getFamily(familyID).getFamilyMembers();
            for (FamilyMember member : members) {
                String name = member.getName();
                String relation = member.getRelation();
                FamilyMemberRelationDTO newMember = new FamilyMemberRelationDTO(name, relation);
                DTOList.add(newMember);
            }
        }
        return DTOList;
    }


    /**
     * Method to create a family cash account for a family object
     *
     * @param familyID identifier of the family object
     * @return returns true if an account was created and stored by the family object
     */
    public boolean createFamilyCashAccount(int familyID, double balance) {
        boolean success;
        Family aFamily = getFamily(familyID);
        success = aFamily.createFamilyCashAccount(balance);
        return success;
    }

    public MemberProfileDTO getFamilyMemberProfile(int familyId, String ccNumber) {

        Family family = getFamily(familyId);
        FamilyMember familyMember = family.getFamilyMember(ccNumber);
        MemberProfileDTO memberProfile = familyMember.createProfile();

        return memberProfile;
    }

    /**
     * Method to return a List of Families without Administrator
     *
     * @return List<FamilyWithoutAdministratorDTO>
     */

    public List<FamilyWithoutAdministratorDTO> familiesWithoutAdministrator() {
        List<FamilyWithoutAdministratorDTO> listOfFamiliesWithoutAdministrator = new ArrayList<>();

        for (Family family : families) {
            if (!family.hasAdministrator()) {
                FamilyWithoutAdministratorDTO familyWithoutAdministratorDTO = family.familyWithoutAdministratorDTO();
                listOfFamiliesWithoutAdministrator.add(familyWithoutAdministratorDTO);
            }
        }
        return listOfFamiliesWithoutAdministrator;
    }
}

