package io.four;

import org.roaringbitmap.RoaringBitmap;

public class BitMapTest {

    public static void main(String[] args) {
        RoaringBitmap rb = RoaringBitmap.bitmapOf(1,2,3,1000);
        rb.getContainerPointer();

        rb.add(1);
        rb.add();
        rb.add(Short.MAX_VALUE);
        System.out.println(rb.contains(1));
        System.out.println(rb.select(3));

        System.out.println(rb.rank(3));

        System.out.println(rb.getSizeInBytes());
    }
}
