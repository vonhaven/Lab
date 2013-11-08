class Effect {

    int code
    String name
    Alignment alignment
    List<String> details

    public enum Alignment {
        HELPFUL,
        NEUTRAL,
        HARMFUL
    }

    static constraints = {
        code min: 0, unique: true
        name blank: false, unique: true
        details size: 4..4
    }
}
