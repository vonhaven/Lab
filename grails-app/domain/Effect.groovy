class Effect {

    int id
    String name
    List<String> details

    static constraints = {
        id min: 0
        name blank: false
        details size: 4..4
    }
}
