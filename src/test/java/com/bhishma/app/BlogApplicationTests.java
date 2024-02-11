package com.bhishma.app;

import com.bhishma.app.repositories.UserRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BlogApplicationTests {
	@Autowired
private UserRepo userRepo;
	@Test
	void contextLoads() {
	}

	@Test
	public void repoTest(){
		String className=this.userRepo.getClass().getName();
		String packageNamge=this.userRepo.getClass().getPackageName();
		System.out.println(className+" "+packageNamge);
	}

}
