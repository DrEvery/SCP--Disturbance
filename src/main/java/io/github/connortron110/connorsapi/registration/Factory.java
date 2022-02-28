package io.github.connortron110.connorsapi.registration;

@FunctionalInterface
public interface Factory<I, O> {
    O build(I input);
}
