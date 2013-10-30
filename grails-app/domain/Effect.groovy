class Effect {

    int code
    String name
    List<String> details

    static constraints = {
        code min: 0, unique: true
        name blank: false, unique: true
        details size: 4..4
    }
}
