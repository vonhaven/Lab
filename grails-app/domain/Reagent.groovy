class Reagent {

    int code
    String name
    List<String> details
    Effect e1
    Effect e2
    Effect e3
    Effect e4
    BiasLevel bEarth
    BiasLevel bWater
    BiasLevel bWind
    BiasLevel bStorm
    BiasLevel bFire
    BiasLevel bFrost
    BiasLevel bLight
    BiasLevel bShadow

    public enum BiasLevel {
        NONE,
        LOW,
        MEDIUM,
        HIGH
    }

    static constraints = {
        code min: 0, unique: true
        name blank: false, unique: true
        details size: 4..4
    }
}
