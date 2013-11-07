/** Controls actions for Lab pages */
class LabController {

    /** Default action */
    def index() {
        def ingredients = []
        ingredients << Reagent.findByCode(0)
        ingredients << Reagent.findByCode(1)
        ingredients << Reagent.findByCode(2)
        ingredients << Reagent.findByCode(3)
        ingredients.each() {
            println it.effects
        }
        [ingredients: ingredients]
    }
}
