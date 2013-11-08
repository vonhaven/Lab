/** A superclass for one of four playable heroes */
class Hero {

    //combat stats
    int maxHealth
    int health

    //generic stats
    int strength
    int dexterity
    int intuition
    int fortitude
    int swiftness
    int perception
    int disposition
    int luck

    //alchemical progression
    def knowledge = [:]

    public Hero() {
        /*
        if (health != null) health = maxHealth
        Reagent.findAll().each() { reagent ->
            knowledge[reagent.code] = false 
        }*/
    }

    static constraints = {
        maxHealth min: 1, max: 100
        health min: 1, max: 100
        strength min: 1, max: 5
        dexterity min: 1, max: 5
        intuition min: 1, max: 5
        fortitude min: 1, max: 5
        swiftness min: 1, max: 5
        perception min: 1, max: 5
        disposition min: 1, max: 5
        luck min: 1, max: 5
    }
}
