package pages;

public class PageObjectManager {

    private DashboardPage dashboardPage;
    private LoginPage loginPage;
    private AddPatientPage newPatientPage;
	//private MyPatientPage myPatientPage;

	
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
	
//	public MyPatientPage getMyPatientPage() {
//		if (myPatientPage == null) {
//			myPatientPage = new MyPatientPage();
//		}
//		return myPatientPage;
//	}


    public AddPatientPage getNewPatientPage() {
    if (newPatientPage == null) {
      newPatientPage = new AddPatientPage();
    }
      return newPatientPage;
    }
}