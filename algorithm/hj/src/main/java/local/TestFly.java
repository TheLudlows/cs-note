package local;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.sql.PreparedStatement;
import java.text.Normalizer;
import java.util.Collection;
import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Phaser;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.text.Normalizer.Form.NFD;

class Swan {

    public static void fly() {

        System.out.println("swan can fly ...");

    }

}

class UglyDuck extends Swan {

    public static void fly() {

        System.out.println("ugly duck can't fly ...");

    }

}
class Food{}

class Friut extends Food{}
class Apple extends Friut{}
public class TestFly {



    public static void main(String[] args) {
        List<String> string = new ArrayList<String>();

        string.add("hello");

        string.add(0, "ok");

        System.out.println(string.get(1));
    }

    public static double spart(double fst) {

        return 0;
    }

}

interface A {
    public static final int a = 10;
}