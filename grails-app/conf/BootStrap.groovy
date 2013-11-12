class BootStrap {

    /** Setup */
    def init = { servletContext ->
        bootstrapEffects()
        bootstrapReagents()
        mix()
    }
    
    /** Teardown Y*/
    def destroy = {
        //cleanup
    }

    private void bootstrapEffects() {
        def effects = []
        Effect.Alignment G = Effect.Alignment.HELPFUL
        Effect.Alignment N = Effect.Alignment.NEUTRAL
        Effect.Alignment B = Effect.Alignment.HARMFUL
        effects << [000, "Galeforce", "Immediately deals %m wind damage.", B]
        effects << [001, "Suffocation", "Deals %m wind damage over %d moments.", B]
        effects << [002, "Windburn", "Deals %m wind damage after %d moments.", B]
        effects << [004, "Gusts", "Amplifies wind damage taken by %m%.", B]
        effects << [100, "Sunfire", "Immediately deals %m solar damage.", B]
        effects << [101, "Wrinkling", "Immediately deals %m solar damage.", B]
        effects << [102, "Sunburn", "Deals %m solar damage after %d moments.", B]
        effects << [200, "Sparks", "Immediately deals %m fire damage.", B]
        effects << [201, "Immolation", "Deals %m fire damage over %d moments.", B]
        effects << [202, "Burning", "Deals %m fire damage after %d moments.", B]
        effects << [300, "Splitting", "Immediately deals %m earth damage.", B]
        effects << [301, "Crumbling", "Deals %m earth damage over %d moments.", B]
        effects << [302, "Erosion", "Deals %m earth damage after %d moments.", B]
        effects << [400, "Shock", "Immediately deals %m storm damage.", B]
        effects << [401, "Jolting", "Deals %m storm damage over %d moments.", B]
        effects << [402, "Aftershock", "Deals %m storm damage after %d moments.", B]
        effects << [500, "Death", "Immediately deals %m shadow damage.", B]
        effects << [501, "Putrefaction", "Deals %m shadow damage over %d moments.", B]
        effects << [502, "Doom", "Deals %m shadow damage after %d moments.", B]
        effects << [600, "Piercing", "Immediately deals %m frost damage.", B]
        effects << [601, "Freezing", "Deals %m frost damage over %d moments.", B]
        effects << [602, "Frostbite", "Deals %m frost damage after %d moments.", B]
        effects << [700, "Inundation", "Immediately deals %m water damage.", B]
        effects << [701, "Gagging", "Deals %m water damage over %d moments.", B]
        effects << [702, "Drowning", "Deals %m water damage after %d moments.", B]
        effects.each() { effect ->
            new Effect (
                code: effect[0], 
                name: effect[1], 
                desc: effect[2],
                alignment: effect[3],
                element: effect[0] / 100
            ).save(flush: true, failOnError: true)
        }
    }
    
    private void bootstrapReagents() {
        def reagents = []
        reagents << [0, "Lifeseed", "a", 0.14, 5,
            [0, 0, 0, 3, 0, 0, 0, 1]]
        reagents << [1, "Emberthorn", "b", 0.45, 6,
            [0, 0, 2, 0, 1, 0, 1, 0]]
        reagents << [2, "Aeynite", "c", 0.81, 42,
            [1, 0, 0, 1, 0, 1, 1, 0]]
        reagents << [3, "Dragonleaf", "d", 0.05, 14,
            [1, 1, 2, 0, 0, 0, 0, 0]]
        reagents << [4, "Glimmerscale", "e", 0.09, 7,
            [0, 1, 0, 0, 0, 0, 0, 3]]
        reagents << [5, "Deathblossom", "f", 0.06, 22,
            [0, 0, 0, 1, 0, 3, 0, 0]]
        reagents << [6, "Topazine", "g", 0.82, 100,
            [0, 2, 0, 0, 2, 0, 0, 0]]
        reagents << [7, "Everbloom", "h", 0.06, 3,
            [0, 0, 0, 2, 0, 0, 2, 0]]
        reagents << [8, "Silverdust", "i", 0.22, 135,
            [0, 1, 0, 0, 2, 1, 0, 0]]
        reagents << [9, "Hawkeye", "j", 0.27, 75,
            [3, 1, 0, 0, 0, 0, 0, 0]]
        reagents << [10, "Sapphire", "k", 0.80, 100,
            [0, 0, 0, 0, 0, 0, 2, 2]]
        reagents << [11, "Emerald", "l", 0.83, 100,
            [0, 0, 0, 2, 0, 0, 0, 2]]
        reagents << [12, "Ruby", "m", 0.84, 100,
            [0, 2, 2, 0, 0, 0, 0, 0]]
        reagents << [13, "Saturnite", "n", 0.85, 100,
            [1, 0, 0, 1, 1, 0, 0, 1]]
        reagents.each() { reagent ->
            new Reagent (
                code: reagent[0],
                name: reagent[1],
                desc: reagent[2],
                weight: reagent[3],
                value: reagent[4],
                bias: Reagent.calculateBias(reagent[5]) 
            ).save(flush: true, failOnError: true)
        }
    }

    /** A programmer's finest alchemy */
    private void mix() {
        def reagents = Reagent.findAll()
        reagents.each() { reagent ->
            def effects = []
            for (int i=0; i<Element.values().size(); i++) {
                for (int j=0; j<reagent.getBiasOfType(i); j++) {
                    effects += Effect.findAllByElement(i).getAt(j)
                }
            }
            reagent.e1 = effects[0]
            reagent.e2 = effects[1]
            reagent.e3 = effects[2]
            reagent.e4 = effects[3]
        }
    }
}
