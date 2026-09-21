package com.openflow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main entry point for the OpenFlow backend application.
 */
@SpringBootApplication
public class OpenFlowApplication {

	public static void main(String[] args) {
		SpringApplication.run(OpenFlowApplication.class, args);
	}
}