package com.office.test.contracttests;


import com.intuit.karate.KarateOptions;
import com.intuit.karate.junit4.Karate;
import com.office.Application;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;


@RunWith(Karate.class)
@KarateOptions(features = {"classpath:features/."},
    tags = {"~@wip","@functional","@contract"})
public class KarateTest {

    @BeforeClass
    public static void setUp(){
        System.setProperty("karate.env","qa");
        Application.main();


    }

}


