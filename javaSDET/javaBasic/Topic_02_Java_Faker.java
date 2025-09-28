package javaBasic;

import com.github.javafaker.Faker;

import java.util.Locale;

public class Topic_02_Java_Faker {
    public static void main(String[] args) {
        Faker faker = new Faker(new Locale("vi"));
        System.out.println(faker.address().firstName());
        System.out.println(faker.address().lastName());
        System.out.println(faker.address().city());

        System.out.println(faker.internet().emailAddress());
        System.out.println(faker.internet().password(6,12));
        System.out.println(faker.internet().password(6,12,true));
        System.out.println(faker.internet().password(6,12,true,true));
        System.out.println(faker.internet().password(6,12,true,true,true));
    }
}
