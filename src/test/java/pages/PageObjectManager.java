package pages;

public class PageObjectManager {

    private DashboardPage dashboardPage;
    private LoginPage loginPage;
    private AddPatientPage newPatientPage;
    private EditPatientPage editPatientPage;
    private MyPatientPage myPatientPage;

	
	public LoginPage getLoginPage() {
		if (loginPage == null) {
			loginPage = new LoginPage();
		}
		return loginPage;
	}
	
	public DashboardPage getDashboardPage() {
		if (dashboardPage == null) {
			dashboardPage = new DashboardPage();
		}
		return dashboardPage;
	}
	
public MyPatientPage getMyPatientPage() {
		if (myPatientPage == null) {
			myPatientPage = new MyPatientPage();
		}
		return myPatientPage;
	}
	public EditPatientPage getEditPatientPage() {
		if (editPatientPage == null) {
			editPatientPage = new EditPatientPage();
		}
		return editPatientPage;
	}

    public AddPatientPage getNewPatientPage() {
    if (newPatientPage == null) {
      newPatientPage = new AddPatientPage();
    }
      return newPatientPage;
    }
}