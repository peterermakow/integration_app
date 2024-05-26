package ru.ermakow.payment_core.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;
import ru.ermakow.dto.response.ErrorResponse;

import java.io.IOException;

@Component
public class RestTemplateErrorResponseHandler implements ResponseErrorHandler {

    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        HttpStatusCode statusCode = response.getStatusCode();
        return statusCode.is4xxClientError() || statusCode.is5xxServerError();
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        if (response.getStatusCode().is4xxClientError()) {
            ObjectMapper objectMapper = new ObjectMapper();
            ErrorResponse executorErrorDto = objectMapper.readValue(response.getBody(), ErrorResponse.class);
            throw new RuntimeException(executorErrorDto.message());
        }
    }
}
