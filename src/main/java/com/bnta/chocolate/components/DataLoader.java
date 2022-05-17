package com.bnta.chocolate.components;

import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.models.Estate;
import com.bnta.chocolate.repositories.ChocolateRepository;
import com.bnta.chocolate.repositories.EstateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    ChocolateRepository chocolateRepository;

    @Autowired
    EstateRepository estateRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception{

        Estate estate1 = new Estate("Bob", "Australia");
        estateRepository.save(estate1);

        Chocolate chocolate1 = new Chocolate("Bueno", 30, estate1);
        chocolateRepository.save(chocolate1);

        Chocolate chocolate2 = new Chocolate("Snickers", 40, estate1);
        chocolateRepository.save(chocolate2);

        Chocolate chocolate3 = new Chocolate("Ben", 30, estate1);
        chocolateRepository.save(chocolate3);

        Chocolate chocolate4 = new Chocolate("Sam", 50, estate1);
        chocolateRepository.save(chocolate4);

        Estate estate2 = new Estate("Rob", "Canada");
        estateRepository.save(estate2);

        Chocolate chocolate5 = new Chocolate("Tim", 60, estate2);
        chocolateRepository.save(chocolate5);

        Chocolate chocolate6 = new Chocolate("Pam", 70, estate2);
        chocolateRepository.save(chocolate6);




    }

}
