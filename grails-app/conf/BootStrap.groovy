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
        Effect.Alignment G = Effect.Alignment.HELPFUL
        Effect.Alignment N = Effect.Alignment.NEUTRAL
        Effect.Alignment B = Effect.Alignment.HARMFUL
        effects << [300, "Healing", ["Restores %m health instantly", "2", "3", "4"], G]
        effects << [301, "Restoration", ["Restores %m health over %d", "2", "3", "4"], G]
        effects << [302, "Regeneration", ["Increases health regeneration by %m over %d", "2", "3", "4"], G]
        effects << [303, "Fortification", ["Increases both current and maximum health by %m for %d", "2", "3", "4"], G]
        effects << [304, "Stasis", ["Freezes current health for %d", "2", "3", "4"], N]
        effects << [305, "Lapsing", ["Returns current health to its value %d ago", "2", "3", "4"], N]
        effects << [306, "Fake 1", ["Returns current health to its value %d ago", "2", "3", "4"], B]
        effects << [307, "Fake 2", ["Returns current health to its value %d ago", "2", "3", "4"], B]
        effects << [308, "Fake 3", ["Returns current health to its value %d ago", "2", "3", "4"], B]
        effects << [309, "Fake 4", ["Returns current health to its value %d ago", "2", "3", "4"], B]
        effects << [310, "Fake 5", ["Returns current health to its value %d ago", "2", "3", "4"], B]
        effects << [311, "Fake 6", ["Returns current health to its value %d ago", "2", "3", "4"], B]
        effects.each() { effect ->
            new Effect (
                code: effect[0], 
                name: effect[1], 
                details: effect[2],
                alignment: effect[3]
            ).save(flush: true, failOnError: true)
        }
    }
    
    private void bootstrapReagents() {
        def reagents = []
        //TODO
        //randomly generate reagents for each new user
        //pros: nautral anti-cheat, dynamic gameplay/replay
        //cons: extra data to store, more logic
        Reagent.BiasLevel N = Reagent.BiasLevel.NONE
        Reagent.BiasLevel L = Reagent.BiasLevel.LOW
        Reagent.BiasLevel M = Reagent.BiasLevel.MEDIUM
        Reagent.BiasLevel H = Reagent.BiasLevel.HIGH
        reagents << [0, "Liferoot", 
            ["a", "d", "c", "d"],
            Effect.findByCode(300),
            Effect.findByCode(301),
            Effect.findByCode(302),
            Effect.findByCode(303),
            N, N, N, H, N, N, N, L 
        ]
        reagents << [1, "Emberthorn", 
            ["a", "b", "c", "d"],
            Effect.findByCode(302),
            Effect.findByCode(303),
            Effect.findByCode(304),
            Effect.findByCode(305),
            N, N, M, N, L, N, L, N 
        ]
        reagents << [2, "Bloodstone", 
            ["a", "b", "c", "d"],
            Effect.findByCode(306),
            Effect.findByCode(307),
            Effect.findByCode(308),
            Effect.findByCode(309),
            L, N, N, L, N, L, L, N 
        ]
        reagents << [3, "Dragonleaf", 
            ["a", "b", "c", "d"],
            Effect.findByCode(308),
            Effect.findByCode(309),
            Effect.findByCode(310),
            Effect.findByCode(311),
            L, L, M, N, N, N, N, N 
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
                bWind: reagent[7],
                bLight: reagent[8],
                bFire: reagent[9],
                bEarth: reagent[10],
                bStorm: reagent[11],
                bShadow: reagent[12],
                bFrost: reagent[13],
                bWater: reagent[14]
            ).save(flush: true, failOnError: true)
        }
    }
}
