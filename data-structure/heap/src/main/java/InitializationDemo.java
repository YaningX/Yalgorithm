class ObjectDemo {
    static {
        System.out.println("ObjectDemo static block!");
    }

    {
        System.out.println("ObjectDemo constructor block");
    }
    String f="field value";
    public ObjectDemo() {
        System.out.println("ObjectDemo constructor");
    }
}
class ObjectDemo2 {
    static {
        System.out.println("ObjectDemo static block!");
    }

    {
        System.out.println("ObjectDemo constructor block");
    }
    String f2="field value";
    public ObjectDemo2() {
        System.out.println("ObjectDemo constructor");
        f2="field value changed!";
    }
}
public class InitializationDemo {
    static {
        System.out.println("I am a static block!");
    }

    public static void main(String[] args) {
        System.out.println("I am the main method!");

        ObjectDemo od1 = new ObjectDemo();
        ObjectDemo od2 = new ObjectDemo();
        System.out.println(od1.f);
        ObjectDemo2 od3 = new ObjectDemo2();
        System.out.println(od3.f2);
    }
}