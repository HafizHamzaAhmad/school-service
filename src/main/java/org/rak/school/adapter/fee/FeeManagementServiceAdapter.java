package org.rak.school.adapter.fee;

import org.rak.school.adapter.transaction.FeeResponseDto;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class FeeManagementServiceAdapter {
    private final WebClient webClient;

    public FeeManagementServiceAdapter(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8082/fee-service").build();
    }

    public FeeDto getFee(String type, String category, String subCategory, String frequency) {
        Mono<FeeResponseDto> feeResponseDtoMono = webClient.get()
                .uri("/fee/type/{type}/category/{category}/sub-category/{subCategory}/frequency/{frequency}",
                        type, category, subCategory, frequency)
                .retrieve()
                .bodyToMono(FeeResponseDto.class);
        FeeResponseDto feeResponseDto = feeResponseDtoMono.block();
        return feeResponseDto != null ? feeResponseDto.getData() : new FeeDto();
    }
}
