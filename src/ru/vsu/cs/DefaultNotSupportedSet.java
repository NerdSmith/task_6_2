package ru.vsu.cs;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public interface DefaultNotSupportedSet<T> extends Set<T> {

    @Override
    default int size() {
        throw new UnsupportedOperationException("This method is not yet supported");
    }

    @Override
    default boolean isEmpty() {
        throw new UnsupportedOperationException("This method is not yet supported");
    }

    @Override
    default boolean contains(Object o) {
        throw new UnsupportedOperationException("This method is not yet supported");
    }

    @Override
    default Iterator<T> iterator() {
        throw new UnsupportedOperationException("This method is not yet supported");
    }

    @Override
    default Object[] toArray() {
        throw new UnsupportedOperationException("This method is not yet supported");
    }

    @Override
    default <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException("This method is not yet supported");
    }

    @Override
    default boolean add(T e) {
        throw new UnsupportedOperationException("This method is not yet supported");
    }

    @Override
    default boolean remove(Object o) {
        throw new UnsupportedOperationException("This method is not yet supported");
    }

    @Override
    default boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException("This method is not yet supported");
    }

    @Override
    default boolean addAll(Collection<? extends T> c) {
        throw new UnsupportedOperationException("This method is not yet supported");
    }

    @Override
    default boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("This method is not yet supported");
    }

    @Override
    default boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("This method is not yet supported");
    }

    @Override
    default void clear() {
        throw new UnsupportedOperationException("This method is not yet supported");
    }
}
