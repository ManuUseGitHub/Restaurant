/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.models.writers.exceptions;

/**
 *
 * @author MAZE2
 */
public class ConfigurationMissingException extends RuntimeException {

    public ConfigurationMissingException() {
        super();
    }

    public ConfigurationMissingException(String message) {
        super(message);
    }

    public ConfigurationMissingException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConfigurationMissingException(Throwable cause) {
        super(cause);
    }
}
