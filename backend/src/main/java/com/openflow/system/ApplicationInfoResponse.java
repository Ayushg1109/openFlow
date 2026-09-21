package com.openflow.system;

/**
 * Public information describing the OpenFlow application.
 *
 * @param name        application name
 * @param version     current application version
 * @param description short application description
 */
public record ApplicationInfoResponse(
        String name,
        String version,
        String description
) {
}