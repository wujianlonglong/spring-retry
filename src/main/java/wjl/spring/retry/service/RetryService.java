package wjl.spring.retry.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import wjl.spring.retry.RetryException;

@Service
@Slf4j
public class RetryService {
    int i = 1;


    @Retryable(value = {RuntimeException.class}, maxAttempts = 4, backoff = @Backoff(delay = 10000l, multiplier = 1))
    public String retry() {
        log.info("测试retry");
        i++;//生产环境此处应该为调用第三方接口，判断接口返回code
        if (i == 8) {
            return i + "";
        }
        RetryException retryException = new RetryException("9999", "连接超时");
        throw retryException;
    }


    @Recover
    public String recover(RetryException e) {
        log.info(e.getMessage());
        return "6";
    }
}
