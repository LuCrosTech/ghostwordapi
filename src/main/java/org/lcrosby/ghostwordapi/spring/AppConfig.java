package org.lcrosby.ghostwordapi.spring;

import org.lcrosby.ghostwordapi.service.WordAnalyzer;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {
    @Bean("wordAnalyzer")
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public WordAnalyzer getWordAnalyzer() {
        return new WordAnalyzer();
    }

}
