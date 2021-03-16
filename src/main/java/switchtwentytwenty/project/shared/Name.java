package switchtwentytwenty.project.shared;

import switchtwentytwenty.project.ValueObject;
import switchtwentytwenty.project.exceptions.InvalidNameException;

public class Name implements ValueObject {
    
    private String name;
    private final static String INVALIDNAME = "Name is not valid";

    public Name(String name) {
        this.name = name;
        validateData();
    }

    private void validateData() {
        checkName();
    }

    private void checkName() {
        if(!isValidName())
            throw new InvalidNameException(INVALIDNAME);
    }

    // Falta Verificação com regras de negócio
    private boolean isValidName() {
        return true;
    }

}
