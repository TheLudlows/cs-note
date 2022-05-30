package nc;

import java.util.Scanner;

public class hj87 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int total = 0;
            String line = scanner.nextLine();
            if(line.length()<=4) {
                total+=5;
            } else if(line.length() <= 7) {
                total+=10;
            } else {
                total +=25;
            }
            int little = 0;
            int bigger = 0;
            int num = 0;
            int other = 0;
            for(int i=0;i<line.length();i++) {
                char c= line.charAt(i);
                if(c >='a' && c <= 'z') {
                    little ++;
                } else if(c >='A' && c <= 'Z') {
                    bigger++;
                } else if(c >='0' && c<= '9') {
                    num++;
                } else {
                    other++;
                }

            }

            if(little > 0) {
                total +=10;
            }

            if(bigger > 0) {
                total +=10;
            }

            if(num == 1) {
                total +=10;
            } else if(num > 1) {
                total +=20;
            }
            if(other == 1) {
                total +=10;
            } else if(other > 1) {
                total +=25;
            }
            if((little > 0 && bigger == 0) ||(little ==0 && bigger > 0)) {
                if(num > 0 && other == 0) {
                    total +=2;
                }
                if(num > 0 && other > 0) {
                    total +=3;
                }
            } else if(little > 0 && bigger > 0) {
                if(num > 0 && other > 0) {
                    total+=5;
                }
            }

            if(total >=90){
                System.out.println("VERY_SECURE");
            } else if(total >=80) {
                System.out.println("SECURE");
            }else if(total >=70) {
                System.out.println("VERY_STRONG");
            }else if(total >=60) {
                System.out.println("STRONG");
            }else if(total >=50) {
                System.out.println("AVERAGE");
            }else if(total >=25) {
                System.out.println("WEAK");
            }else if(total >=0) {
                System.out.println("VERY_WEAK");
            }
        }
    }
}
