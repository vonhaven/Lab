class Reagent {

    int code
    String name
    List<String> details
    Effect e1
    Effect e2
    Effect e3
    Effect e4

    static constraints = {
        code min: 0, unique: true
        name blank: false, unique: true
        details size: 4..4
    }
}
