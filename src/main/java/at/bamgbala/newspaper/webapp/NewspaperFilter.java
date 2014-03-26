package at.bamgbala.newspaper.webapp;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

import org.apache.wicket.protocol.http.WicketFilter;
@WebFilter(value= "/newspaper/*", initParams = {
		@WebInitParam(name = "applicationClassName", value = "at.bamgbala.newspaper.webapp.NewspaperApplication"),
		@WebInitParam(name = "filterMappingurlPattern", value = "/newspaper/*")})
public class NewspaperFilter extends WicketFilter {

}
