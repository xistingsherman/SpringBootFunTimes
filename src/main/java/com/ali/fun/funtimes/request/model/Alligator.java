package com.ali.fun.funtimes.request.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.Instant;

public record Alligator(String name,
                        int age,
                        @JsonFormat(shape =JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC") Instant dob) {
}
