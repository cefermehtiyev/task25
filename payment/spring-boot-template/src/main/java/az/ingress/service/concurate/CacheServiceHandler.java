package az.ingress.service.concurate;

import az.ingress.model.dto.CacheData;
import az.ingress.service.abstraction.CacheService;
import az.ingress.util.CacheUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;

@Slf4j
@RequiredArgsConstructor
@Service
public class CacheServiceHandler implements CacheService {
    private final CacheUtil cacheUtil;
    @Override
    public void save(Long id) {
        var cacheKey = "az-ingress-payment:payment-id:"+id;
        var data = new CacheData("Telephone");
        cacheUtil.saveToCache(cacheKey,data,1L, ChronoUnit.MINUTES);

    }

    @Override
    public void get(String cacheKey) {
        var data = cacheUtil.getBucket(cacheKey);
        log.info("ActionLog.cacheData:{}",data);


    }
}
