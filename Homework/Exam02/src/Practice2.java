import java.util.function.Function;

interface IList<T> {
  int length();
  <U> IList<U> map(Function<T, U> func);
}


class Snoc<T> implements IList<T>{
  IList<T> list;
  T item;
  @Override
  public int length() {
    // TODO Auto-generated method stub
    return list.length();
  }
  @Override
  public <U> IList<U> map(Function<T, U> func) {
    // TODO Auto-generated method stub
    return null;
  }
}

class Append<T> implements IList<T>{

  @Override
  public int length() {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public <U> IList<U> map(Function<T, U> func) {
    // TODO Auto-generated method stub
    return null;
  }
  
}