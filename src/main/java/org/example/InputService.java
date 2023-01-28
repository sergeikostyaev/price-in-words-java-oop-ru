package org.example;

public interface InputService<T, U> {
    T read(U validators);
}
