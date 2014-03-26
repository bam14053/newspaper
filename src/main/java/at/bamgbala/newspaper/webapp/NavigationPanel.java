package at.bamgbala.newspaper.webapp;

import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;

import at.bamgbala.newspaper.webapp.author.AuthorPage;

public class NavigationPanel extends Panel {
	 public NavigationPanel(String id) {
	        super(id);
	        add(new Link("navigateHelloWorld") {
	            @Override
	            public void onClick() {
	                setResponsePage(HelloWorldPage.class);
	            }
	        });
	        add(new Link("navigateNewspaper") {
	            @Override
	            public void onClick() {
	                setResponsePage(AuthorPage.class);
	            }
	        });
	    }
}
