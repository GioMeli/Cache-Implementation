package com.cache;

/**
 * A node in a doubly linked list.
 *
 * @param <K> the key type
 * @param <V> the value type
 */
class DoublyLinkedListNode<K, V> {
    K key;
    V value;
    DoublyLinkedListNode<K, V> prev;
    DoublyLinkedListNode<K, V> next;

    DoublyLinkedListNode(K key, V value) {
        this.key = key;
        this.value = value;
    }
}

