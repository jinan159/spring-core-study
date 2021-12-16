package hello.core.common;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.UUID;

@Scope(value = "request")
@Component
public class MyLogger {
    private String uuid;
    private String requestURL;

    public void setRequestURL(String requestURL) {
        this.requestURL = requestURL;
    }

    public void log(String message) {
        System.out.println("["+uuid+"]["+requestURL+"] " + message);
    }

    @PostConstruct
    public void init() {
        System.out.println("["+uuid+"] request scope bean created: " + this);
        uuid = UUID.randomUUID().toString();
    }

    @PreDestroy
    public void close() {
        System.out.println("["+uuid+"] request scope bean close: " + this);
    }
}
