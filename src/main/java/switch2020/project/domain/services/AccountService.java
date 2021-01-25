package switch2020.project.domain.services;

import switch2020.project.domain.model.*;

import java.util.List;

public class AccountService {
    public boolean createPersonalCashAccount(FamilyMember targetMember, String accountDesignation, double initialBalance) {
        int accountID = generateID(targetMember);
        try {
            Account cashAccount = new CashAccount(accountDesignation, initialBalance, accountID);
            return targetMember.addAccount(cashAccount);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private int generateID(FamilyMember targetMember) {
        int max = 0;
        List<Account> tempList = targetMember.getAccounts();
        for (Account account : tempList) {
            if (max < account.getAccountID()) {
                max = account.getAccountID();
            }
        }
        return max + 1;
    }

    public boolean createFamilyCashAccount(Family targetFamily, String accountDesignation, double initialbalance) {
        //if (accountDesignation==null||accountDesignation.isBlank()||accountDesignation.isEmpty()) accountDesignation = ("Conta da familia " + targetFamily.getFamilyName());
        Account newCashAccount = new CashAccount(accountDesignation, initialbalance, 0);
        if (!targetFamily.hasCashAccount()) {
            targetFamily.addCashAccount(newCashAccount);
            return true;
        } else {
            throw new IllegalArgumentException("This Family already has a Cash Account");
        }
    }

    public boolean createPersonalCreditCardAccount(FamilyMember targetMember, String accountName, double withdrawalLimit) {
        int accountID = generateID(targetMember);

        Account creditCardAccount = new CreditCardAccount(withdrawalLimit, accountName, accountID);
        return targetMember.addAccount(creditCardAccount);
    }
}
