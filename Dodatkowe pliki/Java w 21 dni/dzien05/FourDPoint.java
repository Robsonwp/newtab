/* Rozwiązanie dla rozdział 5., ćwiczenie 2. */

package com.java21days;

import java.awt.Point;
 
class FourDPoint extends Point {
    int z;
    int t;

    FourDPoint(int x, int y, int inZ, int inT) {
        super(x,y);
        this.z = inZ;
        this.t = inT;
    }

    public static void main(String[] arguments) {
        FourDPoint np = new FourDPoint(5, 5, 4, 100);
        System.out.println("x wynosi " + np.x);
        System.out.println("y wynosi " + np.y);
        System.out.println("z wynosi " + np.z);
        System.out.println("t wynosi " + np.t);
    }
}
