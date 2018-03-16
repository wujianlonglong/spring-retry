package wjl.spring.retry.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import wjl.spring.retry.service.TestService;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("retry")
public class RetryController {
    @Autowired
    public TestService testService;
    @RequestMapping(value = "testRetry",method = {RequestMethod.POST,RequestMethod.GET},produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Map testRetry(){
        Map map=new HashMap();
        try {
            map= testService.testRetry();
            return map;
        }catch (Exception e){
            e.printStackTrace();
            return map;
        }
    }

}
