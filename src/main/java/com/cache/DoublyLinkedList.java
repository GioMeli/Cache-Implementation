package com.cache;

/**
 * A simple doubly linked list supporting fast insertions and deletions.
 *
 * @param <K> the key type
 * @param <V> the value type
 */
class DoublyLinkedList<K, V> {
    private DoublyLinkedListNode<K, V> head;
    private DoublyLinkedListNode<K, V> tail;

    public DoublyLinkedList() {
        head = new DoublyLinkedListNode<>(null, null);
        tail = new DoublyLinkedListNode<>(null, null);
        head.next = tail;
        tail.prev = head;
    }

    public void moveToHead(DoublyLinkedListNode<K, V> node) {
        remove(node);
        addToHead(node);
    }

    public void remove(DoublyLinkedListNode<K, V> node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void addToHead(DoublyLinkedListNode<K, V> node) {
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    public DoublyLinkedListNode<K, V> removeTail() {
        if (tail.prev == head) return null;
        DoublyLinkedListNode<K, V> node = tail.prev;
        remove(node);
        return node;
    }
}

