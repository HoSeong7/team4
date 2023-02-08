package com.keduit.helloworld.CensorshipTests;

import com.keduit.helloworld.service.CensorshipService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Log4j2
public class CensorshipTest {

    @Autowired
    private CensorshipService service;

    @Test
    public void abuseTest(){
        String str = "좆같네 시발 운영자 누구냐? 딱밤마렵다.";
        boolean temp = service.abuseCheck(str);

        log.info(temp);
    }
}
