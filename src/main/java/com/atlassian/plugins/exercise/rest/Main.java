package com.atlassian.plugins.exercise.rest;

public class Main {

    public static void main(String[] args) {
        searchResource searchResource = new searchResource();
        System.out.println(searchResource.getMessageFromKey("queen"));
    }
}
