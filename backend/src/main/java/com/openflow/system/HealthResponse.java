package com.openflow.system;

public record HealthResponse(
        String status,
        String service
) {
}
