package main.java;

public class Stats {
    private static int writes = 0;
    private static int loads = 0;

    public static int getWrites() {
        return writes;
    }

    public static void setWrites(int writes) {
        Stats.writes = writes;
    }

    public static int getLoads() {
        return loads;
    }

    public static void setLoads(int loads) {
        Stats.loads = loads;
    }

}
