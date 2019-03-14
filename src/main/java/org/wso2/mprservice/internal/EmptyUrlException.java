package org.wso2.mprservice.internal;

/**
 * This class is handle the exception of not defining a MPR dashboard backend service in deployment.yaml
 **/
public class EmptyUrlException extends Exception {

    public EmptyUrlException(String message) {
        super(message);
    }
}
