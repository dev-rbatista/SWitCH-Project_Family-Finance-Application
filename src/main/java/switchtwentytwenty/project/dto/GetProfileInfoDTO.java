package switchtwentytwenty.project.dto;

public class GetProfileInfoDTO {

    private String personID;

    public GetProfileInfoDTO(String personID) {
        this.personID = personID;
    }

    public String getPersonID() {
        return personID;
    }

    public void setPersonID(String personID) {
        this.personID = personID;
    }
}
