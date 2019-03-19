package com.softserve.dto;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public interface Converter<I,O> extends Function<I,O> {

    default O convert(final I input) {
        O output = null;
        if (input != null) {
            output = this.apply(input);
        }
        return output;
    }

    default Set<O> convert(final Set<I> input) {
        Set<O> output = new HashSet<>();
        if (input != null) {
            output = input.stream().map(this::apply).collect(Collectors.toSet());
        }
        return output;
    }
}
