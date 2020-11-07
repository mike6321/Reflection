package me.whiteship;

import me.whiteship.di.Inject;

public class AccountService {

    @Inject
    AccountRepository accountRepository;

    public void join(){
        System.out.println("SERVICE.JOIN");
        accountRepository.save();
    }
}
