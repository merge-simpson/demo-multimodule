package nettee.board.web.config;

import jakarta.annotation.PostConstruct;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
public class BoardMessageSourceConfiguration {

    private final MessageSource messageSource;

    public BoardMessageSourceConfiguration(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    /**
     * 각 모듈에서 관리할 수 있도록 구분 (속성을 통한 파일 스캔이 기본 제공이 아니므로 코드에서 우선은 개별로 주입 중)
     */
    @PostConstruct
    public void authMessageSource() {
        if (messageSource instanceof ReloadableResourceBundleMessageSource source) {
            source.addBasenames("classpath:i18n/validation/board.validation-message");
        }
    }
}