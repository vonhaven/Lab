class Reagent {

    int code
    String name
    List<String> details
    static hasMany = [effects: Effect] 

    static constraints = {
        code min: 0, unique: true
        name blank: false, unique: true
        details size: 4..4
        effects size: 4..4
    }
}
