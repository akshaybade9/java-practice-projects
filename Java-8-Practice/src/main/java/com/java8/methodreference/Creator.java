package com.java8.methodreference;

@FunctionalInterface
public interface Creator<T> {
	T create(String name); 
}
