class BootStrap {

    /** Setup */
    def init = { servletContext ->
        bootstrapEffects()
        bootstrapReagents()
    }
    
    /** Teardown Y*/
    def destroy = {
        //cleanup
    }

    private void bootstrapEffects() {
        def effects = []
        effects << [0, "Healing", ["Restores %m health instantly", "2", "3", "4"]]
        effects << [1, "Restoration", ["Restores %m health over %d", "2", "3", "4"]]
        effects << [2, "Regeneration", ["Increases health regeneration by %m over %d", "2", "3", "4"]]
        effects << [3, "Fortification", ["Increases both current and maximum health by %m for %d", "2", "3", "4"]]
        effects << [4, "Stasis", ["Freezes current health for %d", "2", "3", "4"]]
        effects << [5, "Lapsing", ["Returns current health to its value %d ago", "2", "3", "4"]]
        effects << [10, "Rupturing", ["Inflicts %m physical damage", "2", "3", "4"]]
        effects << [11, "Immolation", ["Inflicts %m fire damage", "2", "3", "4"]]
        effects << [12, "Freezing", ["Inflicts %m cold damage", "2", "3", "4"]]
        effects << [13, "Mutation", ["Inflicts %m natural damage", "2", "3", "4"]]
        effects << [14, "Drowning", ["Inflicts %m water damage", "2", "3", "4"]]
        effects << [15, "Suffocation", ["Inflicts %m wind damage", "2", "3", "4"]]
        effects << [16, "Shock", ["Inflicts %m shock damage", "2", "3", "4"]]
        effects << [17, "Burning", ["Inflicts %m solar damage", "2", "3", "4"]]
        effects << [18, "Consumption", ["Inflicts %m shadow damage", "2", "3", "4"]]
        effects << [19, "Death", ["Removes %m health instantly", "2", "3", "4"]]
        effects.each() { effect ->
            new Effect (
                code: effect[0], 
                name: effect[1], 
                details: effect[2]
            ).save(flush: true, failOnError: true)
        }
    }
    
    private void bootstrapReagents() {
        def reagents = []

        //TODO
        //Randomly generate reagents for each
        //user-- no cheating! :D
        reagents << [0, "Liferoot", 
            ["1", "2", "3", "4"],
            Effect.findByCode(0),
            Effect.findByCode(1),
            Effect.findByCode(2),
            Effect.findByCode(3)
        ]
        reagents << [1, "Emberthorn", 
            ["1", "2", "3", "4"],
            Effect.findByCode(2),
            Effect.findByCode(3),
            Effect.findByCode(4),
            Effect.findByCode(5)
        ]
        reagents << [2, "Gromsblood", 
            ["1", "2", "3", "4"],
            Effect.findByCode(10),
            Effect.findByCode(11),
            Effect.findByCode(12),
            Effect.findByCode(13)
        ]
        reagents << [3, "Dragonleaf", 
            ["1", "2", "3", "4"],
            Effect.findByCode(11),
            Effect.findByCode(12),
            Effect.findByCode(13),
            Effect.findByCode(14)
        ]
        reagents.each() { reagent ->
            new Reagent (
                code: reagent[0],
                name: reagent[1],
                details: reagent[2],
                e1: reagent[3],
                e2: reagent[4],
                e3: reagent[5],
                e4: reagent[6],
            ).save(flush: true, failOnError: true)
        }
    }
}
