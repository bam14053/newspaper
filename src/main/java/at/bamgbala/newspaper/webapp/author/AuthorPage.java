package at.bamgbala.newspaper.webapp.author;

import org.apache.wicket.Component;

import at.bamgbala.newspaper.webapp.NewspaperPage;

public class AuthorPage extends NewspaperPage {
	 protected Component contentPanel() {
	        return new AuthorPanel("authorPanel");
	    }
}
