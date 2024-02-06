package org.rak.school.adapter.transaction;

import org.rak.school.config.BaseUrlConfig;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class TransactionServiceAdapter {
    private final WebClient webClient;

    public TransactionServiceAdapter(WebClient.Builder webClientBuilder, BaseUrlConfig baseUrlConfig) {
        this.webClient = webClientBuilder.baseUrl(baseUrlConfig.getTransactionBaseUrl()).build();
    }


    public Mono<TransactionDto> postTransaction(TransactionDto transaction) {
        return webClient.post()
                .uri("/transaction")
                .bodyValue(transaction)
                .retrieve()
                .bodyToMono(TransactionDto.class);
    }
}
