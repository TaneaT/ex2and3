package com.example.ex2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BooleanSupplier;


class Ex2ApplicationTests {


	@Mock
	TaskManagerService taskManagerService;

	ServiceImplementation serviceImplementation;



	@BeforeEach
	void setUp() {
//		autoCloseable = MockitoAnnotations.openMocks(this);
//		serviceImplementation = new ServiceImplementation(taskManagerService);

		taskManagerService = mock(TaskManagerService.class);
//
	}

	@AfterEach
	void tearDown() throws Exception {
//		autoCloseable.close();
	}

	@Test
	void addUserinDB() {

		User user = new User("Mihai","Jalba","MihaiJ");
		user.setFirstName("Mihai");


		taskManagerService.addUser(user);
//		assertEquals(1,taskManagerService.showAllUser().size());
		verify(taskManagerService).addUser(user);
//		verify(taskManagerService).showAllUser().get(0).getFirstName("Mihai");
	//		assertEquals("Mihai",taskManagerService.showAllUser().get(0).getFirstName());

	}

	@Test
	void showAllUsers(){
		List<User> user = new ArrayList<>();
		user.add(new User("Mihai","Jalba","MihaiJ"));

		when(taskManagerService.showAllUser()).thenReturn(user);
//
//		taskManagerService.showAllUser() ;
//		assertTrue((BooleanSupplier) serviceImplementation.showAllUser());
//		verify(taskManagerService).showAllUser();

	}

	@Test
	void addTask(){
		User user = new User("Mihai","Jalba","MihaiJ");

		taskManagerService.addTask();

		verify(taskManagerService).addTask();
	}

	@Test
	void showUsersTasks(){
		 taskManagerService.showUsersTasks();

		 verify(taskManagerService).showUsersTasks();
	}

}
