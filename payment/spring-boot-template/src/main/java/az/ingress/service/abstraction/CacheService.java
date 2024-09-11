package az.ingress.service.abstraction;

public interface CacheService {
    void save(Long id);
    void get(String cacheKey);
}
