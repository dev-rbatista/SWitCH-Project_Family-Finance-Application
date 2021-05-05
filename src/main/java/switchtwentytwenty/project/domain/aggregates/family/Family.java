package switchtwentytwenty.project.domain.aggregates.family;

import lombok.Getter;
import switchtwentytwenty.project.domain.valueobject.*;
import switchtwentytwenty.project.domain.aggregates.AggregateRoot;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Family implements AggregateRoot<FamilyID> {

    private FamilyID id;
    @Getter
    private FamilyName name;
    @Getter
    private RegistrationDate registrationDate;
    @Getter
    private PersonID admin;
    private List<Relation> relations = new ArrayList<>();
    //private AccountID cashAccount;


    /*
    private Family() {
    }

    public static class Builder {
        private FamilyID id;
        private FamilyName name;
        private RegistrationDate registrationDate;
        private EmailAddress admin;

        public Builder(FamilyID id) {
            this.id = id;
        }

        public Builder withName(FamilyName familyName) {
            this.name = familyName;
            return this;
        }

        public Builder withAdmin(EmailAddress emailAddress) {
            this.admin = emailAddress;
            return this;
        }

        public Builder withRegistrationDate (RegistrationDate registrationDate) {
            this.registrationDate = registrationDate;
            return this;
        }

        public Family build(){
            Family family = new Family();
            family.id = this.id;
            family.name = this.name;
            family.registrationDate = this.registrationDate;
            family.admin = this.admin;

            family.checkMandatoryAttributes();

            return family;
        }

    }
    */

    public Family(FamilyID familyID, FamilyName familyName, RegistrationDate registrationDate, PersonID adminEmail) {
        this.id = familyID;
        this.name = familyName;
        this.registrationDate = registrationDate;
        this.admin = adminEmail;
    }

    @Override
    public boolean hasID(FamilyID familyID) { //Implementado do Agregate Root ?
        return this.id.equals(familyID);
    }

/*
    public boolean verifyAdministrator(String ccNumber) {
        CCNumber cc = new CCNumber(ccNumber);
        boolean result = false;
        for (FamilyMember familyMember : familyMembers) {
            if (familyMember.compareID(cc))
                result = familyMember.isAdministrator();
        }
        return result;
    }

    public boolean addFamilyAdministrator(AddFamilyMemberDTO familyMemberDTO) {
        boolean administrator = true;
        VatNumber vat = new VatNumber(familyMemberDTO.getVat());
        if (!checkIfVATisUniqueInApp(vat)) {
            FamilyMember newFamilyMember = new FamilyMember(familyMemberDTO.getCc(), familyMemberDTO.getName(), familyMemberDTO.getBirthDate(), familyMemberDTO.getPhone(), familyMemberDTO.getEmail(), familyMemberDTO.getVat(), familyMemberDTO.getStreet(), familyMemberDTO.getCodPostal(), familyMemberDTO.getLocal(), familyMemberDTO.getCity(), administrator);
            familyMembers.add(newFamilyMember);
            return true;
        } else {
            throw new IllegalArgumentException("Vat already exists in the Family");
        }
    }
*/
// FAMILY TO DTO?

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Family)) return false;
        Family family = (Family) o;
        return id.equals(family.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public boolean isPersonTheAdmin(PersonID loggedUserID) {
        return loggedUserID.equals(this.admin);
    }

    @Override
    public FamilyID id() {
        return this.id;
    }


}