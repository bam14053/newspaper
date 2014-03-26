package at.bamgbala.newspaper.webapp;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;

public class NewspaperApplication extends WebApplication {

	@Override
	public Class<? extends Page> getHomePage() {
		return HelloWorldPage.class;
	}

}
