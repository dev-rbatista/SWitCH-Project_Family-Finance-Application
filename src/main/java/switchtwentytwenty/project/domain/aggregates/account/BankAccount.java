package switchtwentytwenty.project.domain.aggregates.account;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import switchtwentytwenty.project.domain.valueobject.AccountID;
import switchtwentytwenty.project.domain.valueobject.Designation;
import switchtwentytwenty.project.domain.valueobject.Movement;
import switchtwentytwenty.project.domain.valueobject.IOwnerID;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Component
public class BankAccount extends AbNonCashAccount {

    private AccountID accountID;

    private IOwnerID ownerID;

    private Designation designation;

    private List<Movement> movements = new ArrayList<>();

   public BankAccount(IOwnerID ownerID, Designation designation) {
        this.ownerID = ownerID;
        this.designation = designation;
    }

    @Override
    public AccountID id() {
        return this.accountID;
    }

    @Override
    public boolean hasID(AccountID id) {
        return this.accountID == id;
    }

    @Override
    public IOwnerID getOwnerId() {
        return this.ownerID;
    }

    @Override
    public Designation getDesignation() {
        return this.designation;
    }

    @Override
    public void setDesignation(Designation designation) {
        this.designation = designation;
    }

    @Override
    public String getAccountType() {
        return "bank";
    }

    @Override
    public List<Movement> getListOfMovements() {
        List<Movement> copyMovements = new ArrayList<>();
        if (!this.movements.isEmpty()) {
            copyMovements.addAll(this.movements);
        }
        return copyMovements;
    }

    @Override
    public AccountID getAccountId() {
        return this.accountID;
    }

    @Override
    public void setAccountID(AccountID accountID) {
        this.accountID = accountID;
    }

    @Override
    public void setOwner(IOwnerID ownerID) {
        this.ownerID = ownerID;
    }

    @Override
    public void setMovements(List<Movement> movements) {

        this.movements = Collections.unmodifiableList(movements);
    }

    @Override
    public void addMovement(Movement movement) {
        this.movements.add(movement);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BankAccount)) return false;
        BankAccount that = (BankAccount) o;
        return Objects.equals(accountID, that.accountID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountID, ownerID);
    }
}