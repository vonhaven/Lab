class Reagent {

    int code
    String name
    String desc
    double weight
    int value
    int bias
    Effect e1
    Effect e2
    Effect e3
    Effect e4

    static constraints = {
        code min: 0, unique: true
        name blank: false, unique: true
        desc blank: false
        value min: 0, max: 25000
        bias unique: true
        e1 nullable: true
        e2 nullable: true
        e3 nullable: true
        e4 nullable: true
    }

    /** Returns a bias level based the given element
        for this reagent */
    public int getBiasOfType(int element) {
        return bias / Math.pow(4, element) % 4
    }

    /** Calculates an reagents's bias id given a list
        of bias levels for each element */
    public static int calculateBias (List biases) {
        int biasId = 0
        biasId += biases[0] * Math.pow(4, 0)
        biasId += biases[1] * Math.pow(4, 1)
        biasId += biases[2] * Math.pow(4, 2)
        biasId += biases[3] * Math.pow(4, 3)
        biasId += biases[4] * Math.pow(4, 4)
        biasId += biases[5] * Math.pow(4, 5)
        biasId += biases[6] * Math.pow(4, 6)
        biasId += biases[7] * Math.pow(4, 7)
    }
}
