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
        effects << [000, "Galeforce", "Immediately deals %m wind damage.", G]
        effects << [001, "Suffocation", "Deals %m wind damage over %d moments.", G]
        effects << [100, "Blinding", "Immediately deals %m solar damage.", G]
        effects << [200, "Immolation", "Immediately deals %m fire damage.", G]
        effects << [201, "Burning", "Deals %m fire damage over %d moments.", G]
        effects << [300, "Spontaneity", "Immediately deals %m earth damage.", G]
        effects << [301, "Mutation", "Immediately deals %m earth damage.", G]
        effects << [302, "Toxification", "Deals %m earth damage after %d moments.", G]
        effects << [400, "Shock", "Immediately deals %m storm damage.", G]
        effects << [500, "Darkness", "Immediately deals %m shadow damage.", G]
        effects << [600, "Frostbite", "Immediately deals %m frost damage.", G]
        effects << [700, "Gagging", "Immediately deals %m water damage.", G]
        effects << [701, "Drowning", "Deals %m water damage over %d moments.", G]
        effects << [702, "Depths", "Deals %m water damage after %d moments.", G]
        effects.each() { effect ->
            new Effect (
                code: effect[0], 
                name: effect[1], 
                desc: effect[2],
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
            Effect.findByCode(700),
            N, N, N, H, N, N, N, L 
        ]
        reagents << [1, "Emberthorn", 
            ["a", "b", "c", "d"],
            Effect.findByCode(200),
            Effect.findByCode(201),
            Effect.findByCode(400),
            Effect.findByCode(600),
            N, N, M, N, L, N, L, N 
        ]
        reagents << [2, "Bloodstone", 
            ["a", "b", "c", "d"],
            Effect.findByCode(000),
            Effect.findByCode(300),
            Effect.findByCode(500),
            Effect.findByCode(600),
            L, N, N, L, N, L, L, N 
        ]
        reagents << [3, "Dragonleaf", 
            ["a", "b", "c", "d"],
            Effect.findByCode(000),
            Effect.findByCode(100),
            Effect.findByCode(200),
            Effect.findByCode(201),
            L, L, M, N, N, N, N, N 
        ]
        reagents << [4, "Glimmerscale",
            ["a", "b", "c", "d"],
            Effect.findByCode(700),
            Effect.findByCode(701),
            Effect.findByCode(702),
            Effect.findByCode(100),
            N, L, N, N, N, N, N, H 
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
