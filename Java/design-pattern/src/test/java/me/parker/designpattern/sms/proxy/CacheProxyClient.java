package me.parker.designpattern.sms.proxy;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
class CacheProxyClient {

    @Test
    void use_proxy_pattern() {
        Subject realSubject = new RealSubject();
        Subject cacheProxy = new CacheProxySubject(realSubject);

        // 처음 프록시 호출로 RealSubject를 호출하여 실제 데이터를 가져온다.
        log.info("----- 클라이언트에서 첫 번째 호출 -----");
        cacheProxy.operation();

        // 두번째 호출부터는 RealSubject를 호출하지 않고, 캐시값을 사용한다.
        log.info("----- 클라이언트에서 두 번째 호출 -----");
        cacheProxy.operation();
    }
}