package de.conet.swe.aws.ec2library.init;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import de.conet.swe.aws.ec2library.model.jpa.UserEntity;
import de.conet.swe.aws.ec2library.service.LibraryService;

@Singleton
@Startup
public class StartupListener {

	@Inject
	private LibraryService libraryService;

	@PostConstruct
	private void startup() {
		UserEntity user = new UserEntity();
		user.setName("Philipp");
		libraryService.addUser(user);

		user = new UserEntity();
		user.setName("Shirley");
		libraryService.addUser(user);
	}
}
