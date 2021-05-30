package ru.vsu.cs;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public interface DefaultNotSupportedMap<K, V> extends Map<K, V> {
    @Override
    default public int size() {
        throw new UnsupportedOperationException("This method is not yet supported");
    }

    @Override
    default public boolean isEmpty() {
        throw new UnsupportedOperationException("This method is not yet supported");
    }

    @Override
    default public boolean containsKey(Object key) {
        throw new UnsupportedOperationException("This method is not yet supported");
    }

    @Override
    default public boolean containsValue(Object value) {
        throw new UnsupportedOperationException("This method is not yet supported");
    }

    @Override
    default public V get(Object key) {
        throw new UnsupportedOperationException("This method is not yet supported");
    }

    @Override
    default public V put(K key, V value) {
        throw new UnsupportedOperationException("This method is not yet supported");
    }

    @Override
    default public V remove(Object key) {
        throw new UnsupportedOperationException("This method is not yet supported");
    }

    @Override
    default public void putAll(Map<? extends K, ? extends V> m) {
        throw new UnsupportedOperationException("This method is not yet supported");
    }

    @Override
    default public void clear() {
        throw new UnsupportedOperationException("This method is not yet supported");
    }

    @Override
    default public Set<K> keySet() {
        throw new UnsupportedOperationException("This method is not yet supported");
    }

    @Override
    default public Collection<V> values() {
        throw new UnsupportedOperationException("This method is not yet supported");
    }

    @Override
    default public Set<Entry<K, V>> entrySet() {
        throw new UnsupportedOperationException("This method is not yet supported");
    }
}
