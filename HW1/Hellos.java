package HW1;

public class Hellos {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        for(int i=1;i<=n;i++) {
            String suffix;

            if (i % 100 >= 11 && i % 100 <= 13) {
                suffix = "th";
            } else {
                switch (i % 10) {
                    case 1: suffix = "st"; break;
                    case 2: suffix = "nd"; break;
                    case 3: suffix = "rd"; break;
                    default: suffix = "th";
                }
            }

            System.out.println(i + suffix + " Hello");
        }
    }
}
