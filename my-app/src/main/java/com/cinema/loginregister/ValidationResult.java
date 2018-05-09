package com.cinema.loginregister;

import java.util.HashMap;
import java.util.Map;

public class ValidationResult {

    private Map<String, String> results = new HashMap<>();

    public Map<String, String> getResults() {
        return results;
    }

    public void setResults(Map<String,String> results){
        this.results = results;
    }
}
