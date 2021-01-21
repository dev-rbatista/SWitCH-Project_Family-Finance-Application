package switch2020.project.domain.model;

import switch2020.project.domain.services.AccountService;
import switch2020.project.domain.services.CategoryService;
import switch2020.project.domain.services.EmailService;
import switch2020.project.domain.services.FamilyService;

import java.util.ArrayList;

public class Application {

    // Attributes
    private ArrayList<StandardCategory> categories = new ArrayList<>();
    private EmailService emailService = new EmailService();
    private CategoryService categoryService = new CategoryService();
    private FamilyService familyService = new FamilyService();
    private AccountService accountService = new AccountService();

    // Constructors
    public Application() {
    }

    public Application(Family family) {
        this.familyService.addFamily(family);
    }

    public AccountService getAccountService() {
        return this.accountService;
    }

    /********************** GETTERS AND SETTERS **********************/
    // Business methods
    public CategoryService getCategoryService() {
        return this.categoryService;
    }

    public FamilyService getFamilyService() {
        return this.familyService;
    }

    public EmailService getEmailService() {
        return this.emailService;
    }
}
