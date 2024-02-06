package org.rak.school.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
@Setter
public class BaseUrlConfig {

    @Value("${base.url.fee}")
    private String feeBaseUrl;

    @Value("${base.url.transaction}")
    private String transactionBaseUrl;
}
