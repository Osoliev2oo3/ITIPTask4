import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        String[] a = isesse(10, 7, "hello my name is Bessie and this is my essay");
        for (int i = 0; i < 10; i++) {
            if (a[i] != "")
                System.out.println(a[i]);
        }
        System.out.println(split("(())()()(())"));
        System.out.println(toCamelCase("hello_edabit"));
        System.out.println(overTime(9, 17, 30, 1.5));
        System.out.println(BMI("55 kilos", "1.65 meters"));
        Vector b = (bugger(999));
        Enumeration vEnum = b.elements();
        System.out.println("\nЭлементы в векторе:");
        while (vEnum.hasMoreElements())
            System.out.print(vEnum.nextElement() + " ");
        System.out.println();
        System.out.println(doesRhyme("Sam I am!", "Green eggs and ham."));
        System.out.println(countUniqueBooks("AZYWABBCATTTA", 'A'));

    }

    public static String[] isesse(int n, int k, String str) {
        int z = 0;
        int x = 0;
        int index = 0;
        int startindex = 0;
        int endindex = 0;
        String[] str2 = new String[n];
        for (int i = 0; i < n; i++) {
            str2[i] = "";
        }
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == ' ' || (i + 1) == str.length()) {
                x++;
            }
            if (x == 1 && index == 0) {
                endindex = i;
                index = 1;
            }
            if (x == 2) {
                index = 0;
                if (i - startindex - 1 <= k) {
                    str2[z] += str.substring(startindex, i);
                    startindex = i + 1;
                    endindex = 0;
                    z++;
                    x = 0;
                } else {
                    str2[z] += str.substring(startindex, endindex);
                    startindex = endindex + 1;
                    endindex = 0;
                    z++;
                    x = 0;
                }
            } else if (x == 1 && (i + 1) == str.length()) {
                str2[z] += str.substring(startindex, endindex);
            }
        }
        return str2;
    }

    public static String split(String str) {
        StringBuffer strBuffer = new StringBuffer(str);
        int z = 0;
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == ')' && str.charAt(i + 1) == '(') {
                strBuffer.insert(i + 1 + z, ',');
                z++;
            }
        }
        return strBuffer.toString();
    }

    public static String toCamelCase(String str) {
        int z = 0;
        if (str.indexOf('_') != -1) {
            String[] str1 = str.split("_");
            String s = str1[0];
            for (int i = 1; i < str1.length; i++) {
                s += str1[i].substring(0, 1).toUpperCase() + str1[i].substring(1);
            }
            return s;
        } else if (str.indexOf('_') == -1) {
            StringBuffer strBuffer = new StringBuffer(str);
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) <= 90 && str.charAt(i) >= 65) {
                    strBuffer.insert(i + z, '_');
                    z++;
                    int b = str.charAt(i) + 32;
                    char a = (char) b;
                    strBuffer.setCharAt(i + z, a);
                }
            }
            return strBuffer.toString();
        }
        return "false";
    }

    public static double overTime(double a, double b, double c, double d) {
        return (17 - a) * c + (b - 17) * c * d;
    }

    public static String BMI(String str1, String str2) {
        String[] s1 = str1.split(" ");
        String[] s2 = str2.split(" ");
        double x = 0, y = 0;
        if (s1[1] == "pounds") {
            x = Double.parseDouble(s1[0]) / 2.2;
        } else {
            x = Double.parseDouble(s1[0]);
        }
        if (s2[1] == "inches") {
            y = Double.parseDouble(s2[0]) / 39.37;
        } else {
            y = Double.parseDouble(s2[0]);
        }
        double s = x / (y * y);
        String otvet = String.format("%.1f", s);
        if (s < 18.5) {
            return otvet + "  Underweight";
        } else if (s >= 18.5 && s <= 24.9) {
            return otvet + " Normal weight";
        } else {
            return otvet + " Overweight";
        }
    }

    public static Vector bugger(double a) {
        Vector mas = new Vector<>();
        double s, x = 0, otvet = 0;
        if (a < 10 && a >= 0) {
        } else if (a > 9) {
            do {
                s = a;
                x = 1;
                while (s > 0) {
                    x *= s % 10;
                    s = (int) (s / 10);
                }
                otvet++;
                mas.addElement(new Double(x));
                a = x;
            }
            while (x > 9);
        }
        mas.addElement(new Double(otvet));
        return mas;
    }

    public static boolean doesRhyme(String str1, String str2) {
        String s1 = "", s2 = "";
        for (int i = 0; i < str1.length(); i++) {
            if ((str1.charAt(i) >= 'A' && str1.charAt(i) <= 'Z') || (str1.charAt(i) >= 'a' && str1.charAt(i) <= 'z')) {
                s1 += str1.charAt(i);
            }
        }
        for (int i = 0; i < str2.length(); i++) {
            if ((str2.charAt(i) >= 'A' && str2.charAt(i) <= 'Z') || (str2.charAt(i) >= 'a' && str2.charAt(i) <= 'z')) {
                s2 += str2.charAt(i);
            }
        }
        s1 = s1.substring((s1.length() - 2)).toLowerCase();
        s2 = s2.substring((s2.length() - 2)).toLowerCase();
        return s1.equals(s2);
    }

    public static boolean trouble(int a, int b) {
        int i = 0, z = a % 10;
        while (i > 3) {
            if (a % 10 == z) {
                i++;
            } else {
                i = 0;
                z = a % 10;
            }
            a = (int) a / 10;
        }
        int i1 = 0, z1 = b % 10;
        while (i1 > 2) {
            if (b % 10 == z) {
                i1++;
            } else {
                i1 = 0;
                z1 = b % 10;
            }
            b = (int) b / 10;
        }
        if (a == b) {
            return true;
        } else {
            return false;
        }
    }
        private static int countUniqueBooks(String chars, char divider) {
            Set<Character> booksSet = new HashSet<>();
            boolean bookOpened = false;
            for (char c : chars.toCharArray()) {
                if (c == divider) {
                    bookOpened = !bookOpened;
                } else if (bookOpened) {
                    booksSet.add(c);
                }
            }
            return booksSet.size();
        }
    }
