import java.util.HashMap;
import java.util.Map;

class LRUCache {

  Node head = new Node(0, 0), tail = new Node(0, 0);
  Map<Integer, Node> map = new HashMap();
  int capacity;

  public LRUCache(int _capacity) {
    capacity = _capacity;
    head.next = tail;
    tail.prev = head;
  }

  /*
   * Our cache
   * [..............................................]
   * Front:                                      Tail 
   * Most frequently used                        Not used
   * HashMap to store key -> node
   * 
   */
  /*
   * Get: 
   *   * if map containskey, return that node with key
   *   * remove the node inside the linked list
   *   * Insert at front again
   */
  public int get(int key) {
    if (map.containsKey(key)) {
      Node node = map.get(key);
      remove(node);
      insert(node);
      return node.value;
    } else {
      return -1;
    }
  }

  /*
   * To put:
   *   * If it contains in map, remove it because we recently accessed it
   *   * If capacity is overload, remove item at tail
   *   * Insert the new node at front
   */
  public void put(int key, int value) {
    if (map.containsKey(key)) {
      remove(map.get(key));
    }
    if (map.size() == capacity) {
      remove(tail.prev);
    }
    insert(new Node(key, value));
  }

  /*
   * remove connect node.prev with node.next and remove it in the map
   */
  private void remove(Node node) {
    map.remove(node.key);
    node.prev.next = node.next;
    node.next.prev = node.prev;
  }

  /*
   * Insert the node
   * We put in the map
   * Insert after head pointer (so insert in beginning)
   */
  private void insert(Node node) {
    map.put(node.key, node);
    Node headNext = head.next;
    head.next = node;
    node.prev = head;
    headNext.prev = node;
    node.next = headNext;
  }

  class Node {
    Node prev, next;
    int key, value;

    Node(int _key, int _value) {
      key = _key;
      value = _value;
    }
  }
}
