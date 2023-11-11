package com.homework2springboot.carrestapi.model;

import lombok.Builder;

@Builder
public record Car(Long id,

        String mark,

        String model,

        Color color) {
}
