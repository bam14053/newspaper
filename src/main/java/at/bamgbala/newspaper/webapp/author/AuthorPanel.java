package at.bamgbala.newspaper.webapp.author;

import at.bamgbala.newspaper.webapp.ContentPanel;

public class AuthorPanel extends ContentPanel {
	public AuthorPanel(String id) {
        super(id);
        add(new AuthorForm("authorForm"));
    }
}
