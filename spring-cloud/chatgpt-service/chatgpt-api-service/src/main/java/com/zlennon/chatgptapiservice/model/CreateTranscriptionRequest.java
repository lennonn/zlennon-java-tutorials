package com.zlennon.chatgptapiservice.model;

import lombok.Data;

@Data
public class CreateTranscriptionRequest {
    String file;

    String model;
    String prompt;
    String response_format;
    String temperature;

}
