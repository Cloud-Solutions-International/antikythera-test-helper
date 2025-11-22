package sa.com.cloudsolutions.antikythera.testhelper.service;

import sa.com.cloudsolutions.antikythera.testhelper.evaluator.Autowired;
import sa.com.cloudsolutions.antikythera.testhelper.repository.UserRepository;

public class UserService {
    @Autowired
    private UserRepository repository;

    public void getUser(String userName) {
        System.out.println("Getting user: " + userName);
        repository.findByUsername(userName);
    }
}
