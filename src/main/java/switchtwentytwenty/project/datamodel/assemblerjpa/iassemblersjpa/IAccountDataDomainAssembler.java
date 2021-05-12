package switchtwentytwenty.project.datamodel.assemblerjpa.iassemblersjpa;

import switchtwentytwenty.project.domain.aggregates.account.IAccount;
import switchtwentytwenty.project.datamodel.domainjpa.AccountJPA;
import switchtwentytwenty.project.domain.valueobject.*;

public interface IAccountDataDomainAssembler extends AssemblerDataDomain<AccountJPA, IAccount>{

    AccountID createAccountID(AccountJPA accountJPA);

    PersonID createOwnerID(AccountJPA accountJPA);

    Designation createDesignation(AccountJPA accountJPA);

    AccountType createAccountType(AccountJPA accountJPA);

}