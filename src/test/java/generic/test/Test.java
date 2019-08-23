package generic.test;


public class Test {

    public static void main(String[] args) {
        /*Child child = new Child();
        System.out.println("---------------------------------------");
        Child child2 = new Child();*/

//        Test.stringTest();
        //StringAppend Time is: 3531
//        Test.stringAppend();
        //StringBuilderAppend Time is: 13
        Test.stringBuilderAppend();
        //StringBufferAppend Time is: 9
        Test.stringBufferAppend();

    }

    public static void stringTest() {
        String str1 = new String("abc");
        String str2 = new String("abc");
        String str3 = "abc";
        String str4 = new String("ab") + new String("c");
        String str5 = new String("ab");
        String str6 = new String("c");
        String str7 = str5 + str6;
        /*System.out.println(str1 == str2);
        System.out.println(str1.intern() == str3);
        System.out.println(str1 == str4);*/
        System.out.println(str1 == str7);
    }

    public static void stringAppend() {
        long start = System.currentTimeMillis();
        String str = "";
        int sum = 50000;
        for (int i = 0; i < sum; i++) {
             str += "abc";
        }
        long end = System.currentTimeMillis();
        System.out.println("StringAppend Time is: " + (end - start));
    }

    public static void stringBuilderAppend() {
        long start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        int sum = 50000;
        for (int i = 0; i < sum; i++) {
            sb.append("abc");

        }
        long end = System.currentTimeMillis();
        System.out.println("StringBuilderAppend Time is: " + (end - start));
    }

    public static void stringBufferAppend() {
        long start = System.currentTimeMillis();
        StringBuffer sb = new StringBuffer();
        int sum = 50000;
        for (int i = 0; i < sum; i++) {
            sb.append("abc");
        }
        long end = System.currentTimeMillis();
        System.out.println("StringBufferAppend Time is: " + (end - start));
    }
}
