package login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WebUserService {
    private final WebUserRepository webUserRepository;

    @Autowired
    public WebUserService(WebUserRepository webUserRepository) {
        this.webUserRepository = webUserRepository;
    }

    public void register(WebUser webUser) {
        webUserRepository.save(webUser);
    }

    public Iterable<WebUser> findAll() {
        return webUserRepository.findAll();
    }
}
