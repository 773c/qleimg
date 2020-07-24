package com.eiqle.qleimg.portal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

@RunWith(JUnit4.class)
@SpringBootTest(classes = QleimgPortalApplication.class)
public class Test1 {
    @Test
    public void t1() throws FileNotFoundException {
        File file = new File("F:/result.png");
        InputStream input = new FileInputStream("F:/123.png");
        System.out.println(input);
    }
}
