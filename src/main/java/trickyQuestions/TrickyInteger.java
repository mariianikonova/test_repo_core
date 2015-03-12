package trickyQuestions;

/**
 * Created by user on 05.03.15.
 */
public class TrickyInteger {

    public static void main(String[] args) {

        int int1 = 1;
        int int3 = 256;
        int int4 = 1024;


        Integer i1 = 1;
        Integer i2 = 1;
        Integer i3 = 256;
        Integer i4 = 256;
        Integer i5 = 1024;
        Integer i6 = 1024;


        Integer integer1 = new Integer(1);
        Integer integer3 = new Integer(256);
        Integer integer4 = new Integer(1024);


        if (i1 == i2) {
            System.out.println("i1 == i2");
        } else {
            System.out.println("i1 != i2");
        }
        if (int3 == i3) {
            System.out.println("int3 == i3");
        } else {
            System.out.println("int3 != i3");
        }
        if (int1 == i1) {
            System.out.println("int1 == i1");
        } else {
            System.out.println("int1 != i1");
        }
        if (integer3 == i3) {
            System.out.println("integer3 == i3");
        } else {
            System.out.println("integer3 != i3");
        }
        if (integer3 == int3) {
            System.out.println("integer3 == int3");
        } else {
            System.out.println("integer3 != int3");
        }
        if (integer1 == i1) {
            System.out.println("integer1 == i1");
        } else {
            System.out.println("integer1 != i1");
        }
        if (integer1 == int1) {
            System.out.println("integer1 == int1");
        } else {
            System.out.println("integer1 != int1");
        }
        if (i1 == i2) {
            System.out.println("i1 == i2");
        } else {
            System.out.println("i1 != i2");
        }
        if (i3 == i4) {
            System.out.println("i3 == i4");
        } else {
            System.out.println("i3 != i4");
        }
        if (i5 == i6) {
            System.out.println("i5 == i6");
        } else {
            System.out.println("i5 != i6");
        }
        if (int4 == i6) {  //RETURN TRUE/?WHY
            System.out.println("int4 == i6");
        } else {
            System.out.println("int4 != i6");
        }
        if (integer4 == i6) {  //RETURN TRUE/?WHY
            System.out.println("integer4 == i6");
        } else {
            System.out.println("integer4 != i6");
        }
    }
}