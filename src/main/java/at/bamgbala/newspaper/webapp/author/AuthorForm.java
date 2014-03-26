package at.bamgbala.newspaper.webapp.author;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import at.bamgbala.newspaper.domain.Author;
import at.bamgbala.newspaper.repository.AuthorRepository;

public class AuthorForm extends Form<Author> {
	protected final Logger logger = LoggerFactory.getLogger(getClass());

	@SpringBean
	private AuthorRepository authorRepository;
	
	public AuthorForm(String id) {
		super(id, new CompoundPropertyModel<Author>(new Author("abideen", "Bamgbala", "abi", "hello", "may@homtmail.com")));
		add(new TextField<>("firstname"));
		add(new TextField<>("lastname"));
		add(new TextField<>("username"));
		add(new TextField<>("password"));
		add(new TextField<>("e-mail"));
	}
	
	@Override
    public final void onSubmit() {
        Author author = getModelObject();
        authorRepository.save(author);
        logger.error("Teacher after save: " + author);
    }
}
