class Reagent {

    int id
    String name
    List<String> details
    List<Effect> effects

    static constraints = {
        id min: 0
        name blank: false
        details size: 4..4
        effects size: 4..4
    }
}
