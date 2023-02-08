package com.keduit.helloworld.serviceImpl;

import com.keduit.helloworld.service.CensorshipService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class CensorshipServiceImpl implements CensorshipService {
    @Override
    public boolean abuseCheck(String message) {

        String[] check = message.split("시발|fcuk");
        if(check.length > 1){
            return true;
        }
        return false;
    }
}
