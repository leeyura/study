package study;

/*public class StaticDemo {
    static int staticint;        //static ����
    int memberint;            //member ����
    String memberstr;        //member ����

    public static void main(String[] args) {
        StaticDemo sd1 = new StaticDemo();
        sd1.memberint++; 
        sd1.memberstr="SD1";
        StaticDemo.staticint++;
        System.out.println("����̸�:" + sd1.memberstr
        							+ ", �������:" + sd1.memberint
    								+ ", ����ƽ����:" + StaticDemo.staticint);
        
        
        StaticDemo sd2 = new StaticDemo();
        sd2.memberint++; 
        sd2.memberstr="SD2";
        StaticDemo.staticint++;
        System.out.println("����̸�:" + sd2.memberstr
                					+ ", �������:" + sd2.memberint
                					+ ", ����ƽ����:" + StaticDemo.staticint);
    }
}*/

public class StaticDemo {
    static int staticint;        //static ����
    int memberint;            //member ����
    String memberstr;        //member ����
    static void view(){
        System.out.println("static view ȣ��: " + staticint );
    }
    public static void main(String[] args) {
        StaticDemo.staticint++; 
        StaticDemo.view();                       //  static view ȣ��: 1
        StaticDemo sd1 = new StaticDemo();
        sd1.memberint++; 
        sd1.memberstr="SD1";
        StaticDemo.staticint++; 
        StaticDemo.view();                       //  static view ȣ��: 2
        System.out.println("����̸�:" + sd1.memberstr
        							+ ", �������:" + sd1.memberint
        							+ ", ����ƽ����:" + StaticDemo.staticint);
        
        StaticDemo.staticint++; 
        StaticDemo.view();                      //  static view ȣ��: 3
    }
}


