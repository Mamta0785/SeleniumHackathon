package pages;

public class PageObjectManager {

	private DashboardPage dashboardPage;
	private LoginPage loginPage;

/*	public DashboardPage getLaunchPage() {
		if (dashb == null) {
			launchPage = new LaunchPage();
		}
		return launchPage;
	}
*/
	public LoginPage getLoginPage() {
		if (loginPage == null) {
			loginPage = new LoginPage();
		}
		return loginPage;
	}

}
