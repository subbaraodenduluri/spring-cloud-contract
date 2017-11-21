package com.ebsco.cdc.consumer.model;

public class Greeting {
    private String name;
    private String prefix;
    private String suffix;
    
    public Greeting(String name) {
        super();
        this.name = name;
    }
    
    public Greeting(String prefix, String name) {
        super();
        this.prefix = prefix;
        this.name = name;
    }
    
    public Greeting(String prefix, String name, String suffix) {
        super();
        this.prefix = prefix;
        this.name = name;
        this.suffix = suffix;
    }
    
    public String getPrefix() {
        return prefix;
    }
    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSuffix() {
        return suffix;
    }
    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

}
