class PeekingIterator implements Iterator<Integer> {
  boolean hasNext;
  Iterator<Integer> it;
  Integer next;


  public PeekingIterator(Iterator<Integer> iterator) {
    // initialize any member here.
    this.it = iterator;
    advanceIter();
  }

  public void advanceIter() {
    if (it.hasNext()) {
      next = it.next();
      hasNext = true;
    } else {
      hasNext = false;
    }
  }

  // Returns the next element in the iteration without advancing the iterator.
  public Integer peek() {
    return next;

  }

  // hasNext() and next() should behave the same as in the Iterator interface.
  // Override them if needed.
  @Override
    public Integer next() {
       Integer res = next;
        if (hasNext()) {
            return res;
        }
        advanceIter()
    }

  @Override
  public boolean hasNext() {
    return hasNext;
  }
}
