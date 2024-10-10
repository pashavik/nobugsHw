package utils;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomData {
    public static String randomString(){
        return "test"+RandomStringUtils.randomAlphabetic(10);
    }
}
