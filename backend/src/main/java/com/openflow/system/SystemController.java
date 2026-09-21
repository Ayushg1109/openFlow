package com.openflow.system;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Exposes endpoin,ts describing the current OpenFlow application.
 */
@RestController
public class SystemController {

    private final String applicationName;
    private final String applicationVersion;
    private final String applicationDescription;

    public SystemController(
            @Value("${spring.application.name}") String applicationName,
            @Value("${app.version}") String applicationVersion,
            @Value("${app.description}") String applicationDescription
    ) {
        this.applicationName = applicationName;
        this.applicationVersion = applicationVersion;
        this.applicationDescription = applicationDescription;
    }

    /**
     * Confirms that the OpenFlow application is running.
     */
    @GetMapping("/health")
    public HealthResponse health() {
        return new HealthResponse(
                "UP",
                applicationName
        );
    }

    /**
     * Returns public information about the OpenFlow application.
     */
    @GetMapping("/api/info")
    public ApplicationInfoResponse applicationInfo() {
        return new ApplicationInfoResponse(
                applicationName,
                applicationVersion,
                applicationDescription
        );
    }
}