package com.hamidou.ecommerce.product;

import com.hamidou.ecommerce.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.HttpMethod.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Service
@RequiredArgsConstructor
public class ProductClient {

    @Value("${application.config.product-url}")
    private String productUrl;

    //Client HTTP utilisé pour envoyer des requêtes HTTP (comme Feign, mais plus manuel)
    private final RestTemplate restTemplate;

    public List<PurchaseResponse> purchaseProducts(
            List<PurchaseRequest> requestBody
    ){

        //Définir les headers de la requête
        HttpHeaders headers = new HttpHeaders();
        headers.set(CONTENT_TYPE, APPLICATION_JSON_VALUE);

        //Combiner le body + headers pour envoyer la requête HTTP
        HttpEntity<List<PurchaseRequest>> requestEntity = new HttpEntity<>(requestBody, headers);

        //Utilisé pour spécifier le type générique de la réponse (liste de PurchaseResponse). RestTemplate ne peut pas le deviner sans ça
        ParameterizedTypeReference<List<PurchaseResponse>> responseType = new ParameterizedTypeReference<>() {};

        //Faire un appel POST à l’URL /purchase du service produit avec le body et les headers
        ResponseEntity<List<PurchaseResponse>> responseEntity = restTemplate.exchange(
                productUrl + "/purchase",
                POST,
                requestEntity,
                responseType
        );

        if(responseEntity.getStatusCode().isError()){
            throw new BusinessException("An error occured while processing the products purchase: " + responseEntity.getStatusCode());
        }
        return responseEntity.getBody();

    }

}
