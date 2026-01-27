package com.example.guildgame.util;
import java.util.*;

import com.example.guildgame.domain.Adventurer;
import com.example.guildgame.domain.enums.AdventurerTrait;
import com.example.guildgame.domain.enums.Rank;

public class AdventurerFactory {

	
	
	public static List<Adventurer> generateAllAdventurers() {
	    List<Adventurer> allAdventurers = new ArrayList<>();

	    allAdventurers.addAll(generateAdventurersBatch1());
	    allAdventurers.addAll(generateAdventurersBatch2());
	    allAdventurers.addAll(generateAdventurersBatch3());
	    allAdventurers.addAll(generateAdventurersBatch4());
	    allAdventurers.addAll(generateAdventurersBatch5());

	    return allAdventurers;
	}

	
	
	
	
    public static List<Adventurer> generateAdventurersBatch1() {
        List<Adventurer> adventurers = new ArrayList<>();

        adventurers.add(create(
                "Aric Stonewatch",
                Rank.F,
                Set.of(AdventurerTrait.CAUTIOUS, AdventurerTrait.LOYAL),
                "A former town guard who survived a monster raid by holding the rear while others fled. " +
                "Aric learned that reckless bravery gets people killed, and he now prioritizes careful planning " +
                "and protecting his companions above all else."
        ));

        adventurers.add(create(
                "Lysa Goldleaf",
                Rank.F,
                Set.of(AdventurerTrait.GREEDY, AdventurerTrait.AMBITIOUS),
                "Raised in debt after her family lost their farm, Lysa sees adventuring as a ladder out of poverty. " +
                "She takes dangerous work willingly, believing wealth and status are the only true safety nets."
        ));

        adventurers.add(create(
                "Thorin Blackroot",
                Rank.E,
                Set.of(AdventurerTrait.LOYAL),
                "After losing his clan to a cave collapse, Thorin now attaches himself fiercely to any group he joins. " +
                "He believes survival comes from unity, not skill, and will never abandon a party member."
        ));

        adventurers.add(create(
                "Mirelle Dawnwhisper",
                Rank.F,
                Set.of(AdventurerTrait.FAME_SEEKER, AdventurerTrait.AMBITIOUS),
                "Once a tavern performer, Mirelle grew tired of singing about heroes instead of becoming one. " +
                "She seeks visible, dramatic quests where her deeds are sure to be noticed and remembered."
        ));

        adventurers.add(create(
                "Garruk Ironjaw",
                Rank.E,
                Set.of(AdventurerTrait.GREEDY),
                "A former dock enforcer, Garruk learned that strength without pay is meaningless. " +
                "He judges quests solely by reward and has little interest in honor or legacy."
        ));

        adventurers.add(create(
                "Elowen Brightwill",
                Rank.F,
                Set.of(AdventurerTrait.CAUTIOUS),
                "A failed academy mage, Elowen witnessed a spell go catastrophically wrong during training. " +
                "Since then, she avoids unnecessary risks and double-checks every plan before acting."
        ));

        adventurers.add(create(
                "Raven Hollowstep",
                Rank.E,
                Set.of(AdventurerTrait.AMBITIOUS, AdventurerTrait.CAUTIOUS),
                "Once a hired blade, Raven now seeks influence rather than bloodshed. " +
                "She advances carefully, choosing contracts that increase her reputation without needless danger."
        ));

        adventurers.add(create(
                "Borin Clayfist",
                Rank.F,
                Set.of(AdventurerTrait.LOYAL, AdventurerTrait.GREEDY),
                "A laborer who lost his job to war, Borin values coin but values comrades even more. " +
                "He believes shared hardship forges bonds stronger than gold."
        ));

        adventurers.add(create(
                "Selene Ashfall",
                Rank.E,
                Set.of(AdventurerTrait.FAME_SEEKER),
                "Selene joined the guild after her village ignored her warnings of an impending attack. " +
                "She now seeks recognition, determined that her voice will never be dismissed again."
        ));

        adventurers.add(create(
                "Kett Quickhands",
                Rank.F,
                Set.of(AdventurerTrait.GREEDY, AdventurerTrait.CAUTIOUS),
                "A former pickpocket trying to go legitimate, Kett prefers low-risk jobs with steady pay. " +
                "He avoids heroics and always plans an escape route."
        ));

        
        
        return adventurers;
    }

    
    public static List<Adventurer> generateAdventurersBatch2() {
        List<Adventurer> adventurers = new ArrayList<>();

        adventurers.add(create(
                "Joren Fieldward",
                Rank.F,
                Set.of(AdventurerTrait.CAUTIOUS, AdventurerTrait.LOYAL),
                "A former farmer who lost his village to wandering beasts, Joren learned that survival depends on trust. " +
                "He advances slowly and refuses to leave allies behind, even when retreat would be safer."
        ));

        adventurers.add(create(
                "Vexa Nightcoil",
                Rank.E,
                Set.of(AdventurerTrait.AMBITIOUS),
                "Vexa grew up among smugglers and learned to climb by stepping over others. " +
                "She sees adventuring as a path to power and carefully positions herself for promotion and influence."
        ));

        adventurers.add(create(
                "Orrin Palehand",
                Rank.F,
                Set.of(AdventurerTrait.CAUTIOUS),
                "After barely surviving his first dungeon expedition, Orrin became known for excessive preparation. " +
                "He studies maps, monster habits, and escape routes before ever drawing his weapon."
        ));

        adventurers.add(create(
                "Kaela Stormborn",
                Rank.E,
                Set.of(AdventurerTrait.FAME_SEEKER, AdventurerTrait.AMBITIOUS),
                "Kaela believes greatness is seized, not granted. " +
                "She favors bold, highly visible quests and thrives when others are watching her succeed."
        ));

        adventurers.add(create(
                "Brunn Deepdelver",
                Rank.E,
                Set.of(AdventurerTrait.GREEDY, AdventurerTrait.CAUTIOUS),
                "A tunnel scout by trade, Brunn understands the value of patience and profit. " +
                "He avoids unnecessary fights but expects generous payment for any risk he takes."
        ));

        adventurers.add(create(
                "Ilyra Sunreach",
                Rank.F,
                Set.of(AdventurerTrait.FAME_SEEKER),
                "Once ignored as a shrine assistant, Ilyra turned to adventuring to prove her worth. " +
                "She eagerly volunteers for public missions where success brings recognition."
        ));

        adventurers.add(create(
                "Dren Wolfscar",
                Rank.E,
                Set.of(AdventurerTrait.LOYAL),
                "Marked by scars from defending a caravan to the last man, Dren believes loyalty is repaid in survival. " +
                "He bonds quickly with parties and considers desertion an unforgivable crime."
        ));

        adventurers.add(create(
                "Perrin Coinstep",
                Rank.F,
                Set.of(AdventurerTrait.GREEDY),
                "A failed merchant, Perrin turned to adventuring to recover his losses. " +
                "He avoids emotional attachments and measures every quest by its payout."
        ));

        adventurers.add(create(
                "Seris Moonveil",
                Rank.E,
                Set.of(AdventurerTrait.CAUTIOUS, AdventurerTrait.AMBITIOUS),
                "Seris believes patience is the sharpest weapon. " +
                "She advances methodically through the guild, choosing missions that build influence without unnecessary exposure."
        ));

        adventurers.add(create(
                "Toma Reedfoot",
                Rank.F,
                Set.of(AdventurerTrait.LOYAL, AdventurerTrait.FAME_SEEKER),
                "A former courier, Toma dreams of becoming a hero people recognize by name. " +
                "He sticks close to his companions, hoping shared victories will earn lasting renown."
        ));

        return adventurers;
    }

    
    public static List<Adventurer> generateAdventurersBatch3() {
        List<Adventurer> adventurers = new ArrayList<>();

        adventurers.add(create(
                "Harlan Oakshield",
                Rank.E,
                Set.of(AdventurerTrait.LOYAL, AdventurerTrait.CAUTIOUS),
                "Harlan served as a shield bearer in a failed militia. Watching reckless leaders waste lives taught him " +
                "to value careful tactics and unwavering loyalty to those beside him."
        ));

        adventurers.add(create(
                "Nyssa Flint",
                Rank.F,
                Set.of(AdventurerTrait.AMBITIOUS),
                "Nyssa left her quiet hometown convinced she was meant for more. " +
                "She takes any opportunity that promises advancement, even if it means leaving others behind."
        ));

        adventurers.add(create(
                "Korvin Ashmark",
                Rank.E,
                Set.of(AdventurerTrait.GREEDY),
                "Korvin survived years as a battlefield scavenger, learning that coin outlasts honor. " +
                "He joins expeditions purely for profit and abandons causes that stop paying."
        ));

        adventurers.add(create(
                "Liora Windmere",
                Rank.F,
                Set.of(AdventurerTrait.CAUTIOUS, AdventurerTrait.FAME_SEEKER),
                "Once mocked for her fears, Liora now seeks recognition without recklessness. " +
                "She carefully chooses public missions where success feels both safe and validating."
        ));

        adventurers.add(create(
                "Durgan Flintbeard",
                Rank.E,
                Set.of(AdventurerTrait.LOYAL),
                "A veteran miner, Durgan survived multiple cave-ins thanks to teamwork. " +
                "He trusts in comrades over courage and will never abandon a fellow adventurer."
        ));

        adventurers.add(create(
                "Sable Thorn",
                Rank.F,
                Set.of(AdventurerTrait.GREEDY, AdventurerTrait.CAUTIOUS),
                "Raised among thieves, Sable learned that survival means knowing when to retreat. " +
                "She takes only low-risk jobs with guaranteed reward."
        ));

        adventurers.add(create(
                "Edrin Valefire",
                Rank.E,
                Set.of(AdventurerTrait.AMBITIOUS, AdventurerTrait.FAME_SEEKER),
                "Edrin believes legends are built through decisive action. " +
                "He seeks dangerous but visible quests, convinced recognition will accelerate his rise."
        ));

        adventurers.add(create(
                "Mara Quietbrook",
                Rank.F,
                Set.of(AdventurerTrait.CAUTIOUS),
                "A healer’s apprentice who saw too many bold warriors die, Mara favors retreat over heroics. " +
                "She believes living to fight another day is the truest victory."
        ));

        adventurers.add(create(
                "Kell Ironridge",
                Rank.E,
                Set.of(AdventurerTrait.GREEDY, AdventurerTrait.LOYAL),
                "Kell sells his strength for coin, but once paid, his loyalty is absolute. " +
                "Breaking a contract is, to him, worse than death."
        ));

        adventurers.add(create(
                "Fenn Quickwhistle",
                Rank.F,
                Set.of(AdventurerTrait.FAME_SEEKER),
                "A former street performer, Fenn longs to be remembered for more than fleeting applause. " +
                "He joins high-visibility missions hoping to earn lasting renown."
        ));

        return adventurers;
    }

    
    public static List<Adventurer> generateAdventurersBatch4() {
        List<Adventurer> adventurers = new ArrayList<>();

        adventurers.add(create(
                "Rothan Greyfield",
                Rank.E,
                Set.of(AdventurerTrait.CAUTIOUS),
                "Rothan once watched an entire party die due to poor scouting. " +
                "He now insists on patience, preparation, and fallback plans before every engagement."
        ));

        adventurers.add(create(
                "Isla Brightfen",
                Rank.F,
                Set.of(AdventurerTrait.FAME_SEEKER, AdventurerTrait.LOYAL),
                "Isla believes heroes inspire others to be better. " +
                "She seeks recognition but refuses to gain it at the expense of her companions."
        ));

        adventurers.add(create(
                "Vorn Ashhammer",
                Rank.E,
                Set.of(AdventurerTrait.GREEDY),
                "Vorn abandoned his trade when it stopped paying. " +
                "To him, loyalty lasts only as long as the coin keeps flowing."
        ));

        adventurers.add(create(
                "Nella Brookshade",
                Rank.F,
                Set.of(AdventurerTrait.CAUTIOUS, AdventurerTrait.LOYAL),
                "A former escort guide, Nella learned that vigilance keeps people alive. " +
                "She watches over her allies constantly and avoids unnecessary risks."
        ));

        adventurers.add(create(
                "Cassian Flamecrest",
                Rank.E,
                Set.of(AdventurerTrait.AMBITIOUS, AdventurerTrait.FAME_SEEKER),
                "Cassian believes obscurity is a failure. " +
                "He chooses bold quests that place him at the center of attention and promise advancement."
        ));

        adventurers.add(create(
                "Bera Stonefoot",
                Rank.F,
                Set.of(AdventurerTrait.LOYAL),
                "Bera joined the guild after her caravan companions saved her life. " +
                "She now repays that kindness by standing firm beside any party she joins."
        ));

        adventurers.add(create(
                "Jax Needlegrin",
                Rank.E,
                Set.of(AdventurerTrait.GREEDY, AdventurerTrait.CAUTIOUS),
                "A professional gambler, Jax only plays when the odds favor him. " +
                "He applies the same logic to adventuring, balancing risk against reward."
        ));

        adventurers.add(create(
                "Elric Thornvale",
                Rank.F,
                Set.of(AdventurerTrait.AMBITIOUS),
                "Elric left his apprenticeship early, convinced slow paths lead nowhere. " +
                "He takes on work beyond his experience, hoping rapid success will follow."
        ));

        adventurers.add(create(
                "Maelin Frostveil",
                Rank.E,
                Set.of(AdventurerTrait.CAUTIOUS, AdventurerTrait.LOYAL),
                "After surviving a frozen expedition through mutual support, Maelin trusts preparation " +
                "and teamwork more than raw power."
        ));

        adventurers.add(create(
                "Tess Hollowmere",
                Rank.F,
                Set.of(AdventurerTrait.FAME_SEEKER),
                "Tess grew tired of being overlooked in every village she passed through. " +
                "She now chases visible victories so her name will finally be remembered."
        ));

        return adventurers;
    }

    
    public static List<Adventurer> generateAdventurersBatch5() {
        List<Adventurer> adventurers = new ArrayList<>();

        adventurers.add(create(
                "Orin Blacktide",
                Rank.E,
                Set.of(AdventurerTrait.AMBITIOUS),
                "Orin believes leadership is taken, not granted. " +
                "He constantly seeks chances to prove himself capable of greater authority."
        ));

        adventurers.add(create(
                "Lyra Softstep",
                Rank.F,
                Set.of(AdventurerTrait.CAUTIOUS),
                "Lyra survived a deadly ambush by hiding rather than fighting. " +
                "She values discretion and survival over pride."
        ));

        adventurers.add(create(
                "Grent Coalbeard",
                Rank.E,
                Set.of(AdventurerTrait.LOYAL),
                "A retired forge guard, Grent treats every party like a sworn unit. " +
                "Once committed, he will not retreat unless everyone does."
        ));

        adventurers.add(create(
                "Sera Vale",
                Rank.F,
                Set.of(AdventurerTrait.AMBITIOUS, AdventurerTrait.FAME_SEEKER),
                "Sera dreams of rising from obscurity to legend. " +
                "She seeks both advancement and recognition through daring exploits."
        ));

        adventurers.add(create(
                "Drogan Splithelm",
                Rank.E,
                Set.of(AdventurerTrait.GREEDY),
                "Drogan measures success by weight of coin, not tales told. " +
                "He prefers brutal efficiency and well-paid outcomes."
        ));

        adventurers.add(create(
                "Mina Riversong",
                Rank.F,
                Set.of(AdventurerTrait.LOYAL, AdventurerTrait.CAUTIOUS),
                "A former river scout, Mina believes awareness saves lives. " +
                "She watches for danger and keeps her companions close."
        ));

        adventurers.add(create(
                "Karn Redmark",
                Rank.E,
                Set.of(AdventurerTrait.AMBITIOUS, AdventurerTrait.GREEDY),
                "Karn seeks both wealth and rank, seeing each as proof of superiority. " +
                "He chooses missions that promise tangible advancement."
        ));

        adventurers.add(create(
                "Elli Thornstep",
                Rank.F,
                Set.of(AdventurerTrait.FAME_SEEKER),
                "Elli joined the guild after seeing heroes celebrated in her hometown. " +
                "She longs to stand in the same spotlight."
        ));

        adventurers.add(create(
                "Brom Talonreach",
                Rank.E,
                Set.of(AdventurerTrait.CAUTIOUS),
                "Brom learned restraint after losing friends to reckless charges. " +
                "He prefers slow, controlled engagements."
        ));

        adventurers.add(create(
                "Nira Goldwind",
                Rank.F,
                Set.of(AdventurerTrait.GREEDY, AdventurerTrait.AMBITIOUS),
                "Nira believes wealth opens every door. " +
                "She treats adventuring as an investment toward future power."
        ));

        return adventurers;
    }

    
    
    
    private static Adventurer create(String name, Rank rank, Set<AdventurerTrait> traits, String background) {
        Adventurer a = new Adventurer();
        a.id = UUID.randomUUID();
        a.name = name;
        a.rank = rank;
        a.traits.addAll(traits);
        a.background = background;
        return a;
    }
}
