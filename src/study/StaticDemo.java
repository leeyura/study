package study;

/*public class StaticDemo {
    static int staticint;        //static 변수
    int memberint;            //member 변수
    String memberstr;        //member 변수

    public static void main(String[] args) {
        StaticDemo sd1 = new StaticDemo();
        sd1.memberint++; 
        sd1.memberstr="SD1";
        StaticDemo.staticint++;
        System.out.println("멤버이름 :" + sd1.memberstr
        							+ ", 멤버정수 :" + sd1.memberint
    								+ ", static 정수 :" + StaticDemo.staticint);
        
        
        StaticDemo sd2 = new StaticDemo();
        sd2.memberint++; 
        sd2.memberstr="SD2";
        StaticDemo.staticint++;
        System.out.println("멤버이름 :" + sd2.memberstr
                					+ ",멤버정수 : " + sd2.memberint
                					+ ", static 정수:" + StaticDemo.staticint);
    }
}*/

public class StaticDemo {
    static int staticint;        //static 변수
    int memberint;            //member 변수
    String memberstr;        //member 변수
    static void view(){
        System.out.println("static view 호출: " + staticint );
    }
    public static void main(String[] args) {
        StaticDemo.staticint++; 
        StaticDemo.view();                       //  static view 변수 : 1
        StaticDemo sd1 = new StaticDemo();
        sd1.memberint++; 
        sd1.memberstr="SD1";
        StaticDemo.staticint++; 
        StaticDemo.view();                       //  static view 변수 : 2
        System.out.println("멤버이름 :" + sd1.memberstr
        							+ ",멤버정수 :" + sd1.memberint
        							+ ", static 정수 :" + StaticDemo.staticint);
        
        StaticDemo.staticint++; 
        StaticDemo.view();                      //  static view 변수 : 3
    }
}


