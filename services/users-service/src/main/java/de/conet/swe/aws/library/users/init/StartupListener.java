package de.conet.swe.aws.library.users.init;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import de.conet.swe.aws.library.users.model.jpa.User;
import de.conet.swe.aws.library.users.service.UsersService;

@Singleton
@Startup
public class StartupListener {

	@Inject
	private UsersService libraryService;

	@PostConstruct
	private void startup() {
		User user = new User();
		user.setName("Philipp");
		libraryService.addUser(user);

		user = new User();
		user.setName("Shirley");
		libraryService.addUser(user);
	}
}
