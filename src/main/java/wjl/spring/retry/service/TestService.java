package wjl.spring.retry.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class TestService {
    @Autowired
    RetryService retryService;

    public Map testRetry() {
        Map map = new HashMap();
        String s = retryService.retry();
        if (s.equals("3")) {
            log.info("成功啦啦啦啦啦啦啦啦");
        } else {
            log.info("失败了");
        }
        map.put("result", s);
        return map;
    }
}
