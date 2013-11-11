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
        effects << [002, "Windburn", "Deals %m wind damage after %d moments.", G]
        effects << [100, "Sunfire", "Immediately deals %m solar damage.", G]
        effects << [101, "Wrinkling", "Immediately deals %m solar damage.", G]
        effects << [102, "Sunburn", "Deals %m solar damage after %d moments.", G]
        effects << [200, "Sparks", "Immediately deals %m fire damage.", G]
        effects << [201, "Immolation", "Deals %m fire damage over %d moments.", G]
        effects << [202, "Burning", "Deals %m fire damage after %d moments.", G]
        effects << [300, "Splitting", "Immediately deals %m earth damage.", G]
        effects << [301, "Crumbling", "Deals %m earth damage over %d moments.", G]
        effects << [302, "Erosion", "Deals %m earth damage after %d moments.", G]
        effects << [400, "Shock", "Immediately deals %m storm damage.", G]
        effects << [401, "Jolting", "Deals %m storm damage over %d moments.", G]
        effects << [402, "Aftershock", "Deals %m storm damage after %d moments.", G]
        effects << [500, "Death", "Immediately deals %m shadow damage.", G]
        effects << [501, "Putrefaction", "Deals %m shadow damage over %d moments.", G]
        effects << [502, "Doom", "Deals %m shadow damage after %d moments.", G]
        effects << [600, "Piercing", "Immediately deals %m frost damage.", G]
        effects << [601, "Freezing", "Deals %m frost damage over %d moments.", G]
        effects << [602, "Frostbite", "Deals %m frost damage after %d moments.", G]
        effects << [700, "Inundation", "Immediately deals %m water damage.", G]
        effects << [701, "Gagging", "Deals %m water damage over %d moments.", G]
        effects << [702, "Drowning", "Deals %m water damage after %d moments.", G]
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
        reagents << [0, "Lifeseed", 
            ["a", "d", "c", "d"],
            Effect.findByCode(300),
            Effect.findByCode(301),
            Effect.findByCode(302),
            Effect.findByCode(700),
            N, N, N, H, N, N, N, L]
        reagents << [1, "Emberthorn", 
            ["a", "b", "c", "d"],
            Effect.findByCode(200),
            Effect.findByCode(201),
            Effect.findByCode(400),
            Effect.findByCode(600),
            N, N, M, N, L, N, L, N]
        reagents << [2, "Aeynite", 
            ["a", "b", "c", "d"],
            Effect.findByCode(000),
            Effect.findByCode(300),
            Effect.findByCode(500),
            Effect.findByCode(600),
            L, N, N, L, N, L, L, N]
        reagents << [3, "Dragonleaf", 
            ["a", "b", "c", "d"],
            Effect.findByCode(000),
            Effect.findByCode(100),
            Effect.findByCode(200),
            Effect.findByCode(201),
            L, L, M, N, N, N, N, N]
        reagents << [4, "Glimmerscale",
            ["a", "b", "c", "d"],
            Effect.findByCode(700),
            Effect.findByCode(701),
            Effect.findByCode(702),
            Effect.findByCode(100),
            N, L, N, N, N, N, N, H]
        reagents << [5, "Deathblossom",
            ["a", "b", "c", "d"],
            Effect.findByCode(500),
            Effect.findByCode(501),
            Effect.findByCode(502),
            Effect.findByCode(300),
            N, N, N, L, N, H, N, N]
        reagents << [6, "Topazine",
            ["a", "b", "c", "d"],
            Effect.findByCode(400),
            Effect.findByCode(401),
            Effect.findByCode(100),
            Effect.findByCode(101),
            N, M, N, N, M, N, N, N]
        reagents << [7, "Everbloom",
            ["a", "b", "c", "d"],
            Effect.findByCode(300),
            Effect.findByCode(301),
            Effect.findByCode(600),
            Effect.findByCode(601),
            N, N, N, M, N, N, M, N]
        reagents << [8, "Silverdust",
            ["a", "b", "c", "d"],
            Effect.findByCode(100),
            Effect.findByCode(400),
            Effect.findByCode(401),
            Effect.findByCode(500),
            N, L, N, N, M, L, N, N]
        reagents << [9, "Hawkeye",
            ["a", "b", "c", "d"],
            Effect.findByCode(000),
            Effect.findByCode(001),
            Effect.findByCode(002),
            Effect.findByCode(100),
            H, L, N, N, N, N, N, N]
        reagents << [10, "Sapphire",
            ["a", "b", "c", "d"],
            Effect.findByCode(600),
            Effect.findByCode(601),
            Effect.findByCode(700),
            Effect.findByCode(701),
            N, N, N, N, N, N, M, M]
        reagents << [11, "Emerald",
            ["a", "b", "c", "d"],
            Effect.findByCode(300),
            Effect.findByCode(301),
            Effect.findByCode(700),
            Effect.findByCode(701),
            N, N, N, M, N, N, N, M]
        reagents << [12, "Ruby",
            ["a", "b", "c", "d"],
            Effect.findByCode(100),
            Effect.findByCode(101),
            Effect.findByCode(200),
            Effect.findByCode(201),
            N, M, M, N, N, N, N, N]
        reagents << [13, "Saturnite",
            ["a", "b", "c", "d"],
            Effect.findByCode(000),
            Effect.findByCode(300),
            Effect.findByCode(400),
            Effect.findByCode(700),
            L, N, N, L, L, N, N, L]
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
