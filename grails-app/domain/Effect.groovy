class Effect {

    int code
    String name
    Alignment alignment
    int element
    String desc

    public enum Alignment {
        HELPFUL,
        NEUTRAL,
        HARMFUL
    }

    static constraints = {
        code min: 0, unique: true
        name blank: false, unique: true
        desc blank: false
    }
}
