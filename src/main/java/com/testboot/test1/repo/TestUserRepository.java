package com.testboot.test1.repo;

import com.testboot.test1.models.TestUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;

@Controller
public interface TestUserRepository extends CrudRepository<TestUser,String> {


}
