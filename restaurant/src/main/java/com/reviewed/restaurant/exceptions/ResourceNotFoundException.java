package com.reviewed.restaurant.exceptions;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String resourceName, String fieldName, Integer fieldValue) {
        super(String.format("%s not found with '%s' : '%s'", resourceName, fieldName, fieldValue));
    }
}
