package com.office.test.contracttests;


import com.intuit.karate.junit4.Karate;
import com.office.Application;
import cucumber.api.CucumberOptions;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;


@RunWith(Karate.class)
@CucumberOptions(features = {"classpath:features/."})
public class KarateTest {

    @BeforeClass
    public static void setUp(){
        Application.main();


    }

}


