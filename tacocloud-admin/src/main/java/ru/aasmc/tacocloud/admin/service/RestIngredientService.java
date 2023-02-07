package ru.aasmc.tacocloud.admin.service;

import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;
import ru.aasmc.tacocloud.admin.model.Ingredient;
import ru.aasmc.tacocloud.admin.model.IngredientCollection;

public class RestIngredientService implements IngredientService {

    private RestTemplate restTemplate;


    public RestIngredientService(String accessToken) {
        this.restTemplate = new RestTemplate();
        if (accessToken != null) {
            this.restTemplate
                    .getInterceptors()
                    .add(getBearerTokenInterceptor(accessToken));
        }
    }

    private ClientHttpRequestInterceptor getBearerTokenInterceptor(String accessToken) {
        return (ClientHttpRequestInterceptor) (httpRequest, bytes, clientHttpRequestExecution) -> {
            httpRequest.getHeaders().add("Authorization", "Bearer " + accessToken);
            return clientHttpRequestExecution.execute(httpRequest, bytes);
        };
    }

    @Override
    public Iterable<Ingredient> findAll() {
        IngredientCollection collection = restTemplate.getForObject(
                "http://localhost:8080/api/ingredients",
                IngredientCollection.class
        );
        if (collection != null) {
            return collection.getIngredients();
        }
        return null;
    }

    @Override
    public Ingredient addIngredient(Ingredient ingredient) {
        return restTemplate.postForObject("http://localhost:8080/api/ingredients",
                ingredient,
                Ingredient.class);
    }
}
