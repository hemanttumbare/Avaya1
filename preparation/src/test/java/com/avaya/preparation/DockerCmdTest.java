package com.avaya.preparation;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.junit.jupiter.api.Test;

public class DockerCmdTest {
	
	@Test
	public void dockerCmd() {
	try {
        // Specify the Docker command and its arguments
        String[] command = {"update-ca-certificates"};
        
        // Create the ProcessBuilder with the command
        ProcessBuilder processBuilder = new ProcessBuilder(command);
        
        // Start the process
        Process process = processBuilder.start();
        
        // Read the output of the process
        InputStream inputStream = process.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
        
        // Wait for the process to finish
        int exitCode = process.waitFor();
        
        // Print the exit code (0 indicates success)
        System.out.println("Exit Code: " + exitCode);
    } catch (IOException | InterruptedException e) {
        e.printStackTrace();
    }
	}

}
