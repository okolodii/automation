public class MyStringClass {
    String str1;
    String str2;
    String str3;

    public MyStringClass(String str1, String str2, String str3) {
        this.str1 = str1;
        this.str2 = str2;
        this.str3 = str3;
    }

    public String s1() {return str1;}
    public String s2() {return str1 + " " + str2;}
    public String s3() {return str3.replace("three", "three+");}
}