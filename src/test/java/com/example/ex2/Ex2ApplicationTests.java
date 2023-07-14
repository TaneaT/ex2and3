package com.example.ex2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class Ex2ApplicationTests {

	@Autowired
	TaskManagerService taskManagerService;

	@Test
	void addUser() {

		User user = new User();
		user.firstName = "Mihai";

		taskManagerService.addUser(user);
		Assertions.assertEquals(taskManagerService.showAllUser().size(),1);
		Assertions.assertEquals(taskManagerService.showAllUser().get(0).getFirstName(),"Mihai");

	}

	@Test
	List<User> showAllUsers(){
		List<User> user = new ArrayList<>();
		User user1 = new User();
		user.add(user1);

		Assertions.assertEquals(taskManagerService.showAllUser().get(0),user);

		return user;
	}

}
