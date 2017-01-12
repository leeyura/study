package study;

public class study3 {

}
/** ArrayList 그외.
 * TreeSet
 * 원소들을 정렬된 상태로 유지하며 원소가 중복되어 들어가지 않게함.  
 * LinkedList
 * 컬렉션 중간에서 원소를 추가하거나 삭제하는 작업을 더 빠르게 처리할 수 있게 해주는 컬렉션
 * HashSet
 * 컬렉션에 중복된 원소가 들어가지 않도록 해주고 컬렉션 내에서 어떤 원소를 빠르게 찾을수 있게 함.
 * LinkedHashMap
 * 일반 HashMap과 거의 같지만 원소(이름/값)가 삽입된 순서를 그대로 유지시켜줄수도 있고, 원소에 마지막으로 접근했던 순서를 기억하도록 설명할 수도 있다는점이 다름.
 * HashMap
 * 원소들을 이름/값 쌍 형식으로 저장하고 접근할수 있게 해줌	
 */

/** 제네릭
 * 제네릭을 사용하면 형 안정성이 확보된 컬렉션을 만들 수 있음.
 * 제네릭을 쓰는 클래스(ArrayList 등)의 인스턴스를 만드는 방법 - 
    new ArrayList<String>();
 * 제네릭 유형의 변수를 선언하고 변수에 값을 대입하는 방법
    List<String> nameList =  new ArrayList<String>();
 * 제네릭 유형을 인자로 받아들이는 메소드 선언(호출) 방법
    void foo(List<String> list)    x.foo(nameList)
    
 * 제너릭 메소드 사용법
   1. 클래스 선언부에서 정의된 유형 매개변수를 사용하는 방법
      - 클래스를 정의할 때 유형 매개변수를 선언 했다면, 그 유형을 특정 클래스 또는 
        인터페이스 유형을 사용하는 것과 똑같은 방식으로 사용 가능.
   public class ArrayList<E> extends AbstractList<E>... { public boolean add(E o)
   
   2. 클래스 선언부에서 쓰이지 않은 유형 매개변수를 사용하는 방법 
      - 클래스 자체에서는 유형 매개변수를 사용하지 않더라도 특별한 위치(리턴유형을 선언하는곳 바로앞)에서
        선언해주기만 하면 메소드 내에서 유형 매개변수를 별도로 지정해서 쓸수 있다.
        public <T extends Animal> void takeThing(ArrayList<T> list)
 */

/** Comparable와 Comparator 
 * Comparable 
 * - 기본 정렬기준을 구현하는데 사용.   java.lang패키지 ( compareto() 메소드)
public interface Comparable{
  public int compareTo(Object o);
}
 * Comparator 
 * - 기본 정렬기준 외에 다른 기준으로 정렬하고자할 때 사용   java.util패키지 (compare() 메소드)
public interface Comparator{
  int compare(Object o1, Object o2);
  boolean equals(Object obj);
}
 * 
 * 인자가 한 개인 sort(List o) 메소드를 호출하면 목록에 있는 원소의 comapareTo()메소드에 의해 순서가 결정.
   따라서 목록에 들어있는 원소가 반드시 comparable인터페이스를 구현한 클래스 유형이여야 함.
 * sort(List o , Comparator c)를 호출하였을 때, 목록에 있는 원소의 compareTo()메소드가 호출되지않고,
   대신 Comparator의 compare()메소드가 호출,
   즉, 목록에 들어있는 원소들이 Comparable 인터페이스를 구현하지 않은 클래스 유형이어도 상관없음.  
 */


/**  List  Set  Map
 * List - 순서가 중요할 때
 * 인덱스의 위치를 알고있는 컬렉션
 * list를 사용하면 어떤 원소가 그 목록의 어느 위치에 있는지 알 수 있으며, 같은 객체를 참조하는 원소가 두개이상 존재할 수 있음.
 */

/* 
 * Set - 유일성이 중요할 때
* 중복을 허용하지 않는 컬렉션
* 집합(set)에서 어떤 것이 이미 컬렉션에 들어있는지 알 수 있음. 똑같은 객체를 참조하는 원소가 두개이상 존재할 수 없음.
 */

 /* 
 * Map - 키를 가지고 뭔가 찾는것이 중요할 때
 * key - value 를 사용하는 컬렉션
 * 맵(map)에서는 주어진 키에 대응되는값을 알고 있음.
 * 서로 다른 키로 같은 값을 참조하는 것은 가능하지만 같은키가 여러개 들어갈 수는 없음. 
 * 보통 String을 키로 사용하지만 키로 사용할 수 있는 객체의 유형에는 제한이 없음.
 */


