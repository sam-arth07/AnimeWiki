package com.example.animewiki.data.remote

import com.example.animewiki.domain.model.ApiResponse
import com.example.animewiki.domain.model.Hero
import okio.IOException

class FakeAnimeApi2 : AnimeApi {

    private var page1: List<Hero> = listOf(
        Hero(
            id = 1,
            name = "Boruto Uzumaki (うずまきボルト)",
            image = "/images/boruto.png",
            about = "Boruto Uzumaki (うずまきボルト, Uzumaki Boruto) is a shinobi from Konohagakure's Uzumaki Clan and a direct descendant of the Hyūga clan through his mother. Initially nonchalant in his duties as a member of Team 7 and resentful of his father and the office of Hokage because it left him with no time for his family; Boruto eventually comes to respect and reconcile with his father and his role as Hokage, yet vows to become like his mentor Sasuke Uchiha — a support system for the Hokage and the village.  He was later forced to defect from the village after his adoptive brother Kawaki frames him for killing his parents by altering everyone's memories of him. However, despite losing everything, he remains determined to prove his innocence and regain everything taken from him. \n",
            month = "Mar",
            day = "27th",
            rating = 3.5,
            power = 374000,
            abilities = listOf(
                "Big Ball Rasengan (Manga only)\n" +
                        "Boruto Stream\n" +
                        "Chakra Suppression Technique (Manga only)\n" +
                        "Compression Rasengan (Anime only)\n" +
                        "Flying Thunder God Technique (Manga only)\n" +
                        "Gentle Fist\n" +
                        "Harem Technique\n" +
                        "Iaidō (Manga only)\n" +
                        "Improvised Secret Technique: Lightning Ball Shuriken Technique (Anime only)\n" +
                        "Kāma\n" +
                        "Lightning Release Bullet: Powerful Breath (Anime only)\n" +
                        "Lightning Release: Purple Electricity (Manga only)\n" +
                        "Lightning Release: Thunderclap Arrow\n" +
                        "Lightning Release: Thunderclap Wave\n" +
                        "Multiple Shadow Clone Technique (Anime only)\n" +
                        "Multiple String Light Formation (Anime only)\n" +
                        "Parent and Child Rasengan\n" +
                        "Rasengan\n" +
                        "Rasengan: \"Unison\"\n" +
                        "Rasengan: \"Uzuhiko\" (Manga only)\n" +
                        "Scientific Ninja Tool: Orca and Powerful Breath\n" +
                        "Sexy Technique\n" +
                        "Shadow Clone Technique\n" +
                        "String Light Formation (Anime only)\n" +
                        "Student and Teacher: Rasengan\n" +
                        "Summoning Technique (Snake)\n" +
                        "Super Compression Rasengan (Anime only)\n" +
                        "Surging Fire Wild Dance (Anime only)\n" +
                        "Uchiha Style Kenjutsu (Manga only)\n" +
                        "Uchiha Style Shurikenjutsu: \"Lightning\": Triple\n" +
                        "Ultra-Big Ball Rasengan (Manga only)\n" +
                        "Vanishing Rasengan\n" +
                        "Water Release: Surging Sea\n" +
                        "Water Release: Water Formation Wall (Novel only)\n" +
                        "Wind Release: Breakthrough (Manga only)\n" +
                        "Wind Release: Gale Palm\n" +
                        "Wind Release: Rasengan (Anime only)\n" +
                        "Ōtsutsuki Teleportation"
            ),
            family = listOf(
                "Minato Namikaze (Grandfather)\n" +
                        "Kushina Uzumaki (Grandmother)\n" +
                        "Naruto Uzumaki (Father)\n" +
                        "Hyūga Elder (Great-Grandfather)\n" +
                        "Hiashi Hyūga (Grandfather)\n" +
                        "Hizashi Hyūga (Granduncle)\n" +
                        "Hinata and Hanabi's Mother (Grandmother) (Anime only)\n" +
                        "Hinata Hyūga (Mother)\n" +
                        "Hanabi Hyūga (Aunt)\n" +
                        "Himawari Uzumaki (Sister)\n" +
                        "Neji Hyūga (First cousin once removed)\n" +
                        "Kawaki (Adoptive Brother)\n" +
                        "Momoshiki Ōtsutsuki (Host)"
            ),
            natureTypes = listOf(
                "Lightning Release (Affinity)\n" + " Wind Release\n" + " Water Release"
            )
        ),
        Hero(
            id = 2,
            name = "Kawaki Uzumaki (うずまきカワキ)",
            image = "/images/kawaki.jpg",
            about = "Kawaki (カワキ) is a genin. He was originally raised by Kara, who experimented on him for years with plans of making him the vessel of Isshiki Ōtsutsuki. He is eventually rescued by Konohagakure and adopted into the family of Naruto Uzumaki. His love for Naruto and his hatred for the Ōtsutsuki Clan ultimately leads him to switch lives with his adoptive brother, Boruto, causing most of the world to think of him as Kawaki Uzumaki (うずまきカワキ, Uzumaki Kawaki).",
            month = "May",
            day = "13th",
            rating = 4.5,
            power = 365000,
            abilities = listOf(
                "Chakra Suppression Technique\n" + "Daihakoten\n" + "Daikokuten\n" + "Daikokuten: Collapse\n" + "Daikokuten: Divine Descent\n" + "Daikokuten: Falling Star\n" + "Fire Release: Soaring Flame Bullet Technique\n" + "Kāma\n" + "Kāma: Discharge\n" + "Kāma: Great Burial Wave\n" + "Rasengan: \"Unison\"\n" + "Reverse Scale\n" + "Revolving Blade Dance\n" + "Scale Fragment\n" + "Shadow Clone Technique\n" + "Shape Transformation: Strike\n" + "Sukunahikona\n" + "Sukunahikona: Instant Appearance\n" + "Sukunahikona: Rapid Succession\n" + "Sukunahikona: Scale Fragment\n" + "Thorn Explosion\n" + "Tracking Crimson Bullet\n" + "Violent Arm (Anime only)\n" + "Ōtsutsuki Teleportation"
            ),
            family = listOf(
                "Kokatsu (Father)\n" +
                        "Minato Namikaze (Adoptive Grandfather)\n" +
                        "Kushina Uzumaki (Adoptive Grandmother)\n" +
                        "Naruto Uzumaki (Adoptive Father)\n" +
                        "Hyūga Elder (Adoptive Great-Grandfather)\n" +
                        "Hiashi Hyūga (Adoptive Grandfather)\n" +
                        "Hizashi Hyūga (Adoptive Granduncle)\n" +
                        "Hinata and Hanabi's Mother (Adoptive Grandmother) (Anime only)\n" +
                        "Hinata Uzumaki (Adoptive Mother)\n" +
                        "Hanabi Hyūga (Adoptive Aunt)\n" +
                        "Boruto Uzumaki (Adoptive Brother)\n" +
                        "Himawari Uzumaki (Adoptive Sister)\n" +
                        "Neji Hyūga (Adoptive first cousin once removed)\n" +
                        "Isshiki Ōtsutsuki (Temporally Host)"
            ),
            natureTypes = listOf("Fire Release")
        ),
        Hero(
            id = 3,
            name = "Uchiha Sarada (うちはサラダ)",
            image = "/images/sarada.jpg",
            about = "Sarada Uchiha (うちはサラダ, Uchiha Sarada) is a kunoichi from Konohagakure's Uchiha Clan. Because she was raised only by her mother without having her father around, Sarada initially struggled to understand who she is or what she's supposed to be. After meeting her father with the help of Naruto Uzumaki, Sarada comes to believe that she is defined by the connections she has with others, and as a member of Team Konohamaru, she seeks to someday become Hokage so that she can connect with as many people as possible.",
            month = "Mar",
            day = "31st",
            rating = 4.8,
            power = 300500,
            abilities = listOf(
                "Chakra Enhanced Strength\n" +
                        "Chakra Transfer Technique (Anime only)\n" +
                        "Cherry Blossom Impact\n" +
                        "Chidori\n" +
                        "Chidori Current (Manga only)\n" +
                        "Fire Release: Great Fireball Technique\n" +
                        "Fire Release: Phoenix Sage Fire Technique\n" +
                        "Genjutsu: Sharingan\n" +
                        "Improvised Secret Technique: Lightning Ball Shuriken Technique (Anime only)\n" +
                        "Lightning Ball\n" +
                        "Lightning Burial: Banquet of Lightning (Anime only)\n" +
                        "Lightning Flash\n" +
                        "Lightning Strike Armour (Anime only)\n" +
                        "Lorentz Gun (Novel only)\n" +
                        "Multiple String Light Formation (Anime only)\n" +
                        "Mystical Palm Technique (Anime only)\n" +
                        "Shadow Clone Technique (Anime only)\n" +
                        "String Light Formation (Anime only)\n" +
                        "Super Compression Rasengan (Anime only)\n" +
                        "Wind Release: Gale Palm (Anime only)\n" +
                        "Ōhirume (Manga only)"
            ),
            family = listOf(
                "Fugaku Uchiha (Grandfather)\n" +
                        "Mikoto Uchiha (Grandmother)\n" +
                        "Sasuke Uchiha (Father)\n" +
                        "Itachi Uchiha (Uncle)\n" +
                        "Kizashi Haruno (Grandfather)\n" +
                        "Mebuki Haruno (Grandmother)\n" +
                        "Sakura Haruno (Mother)"
            ),
            natureTypes = listOf(
                " Lightning Release\n" +
                        " Fire Release\n" +
                        " Wind Release (Anime only)\n" +
                        " Yin Release"
            )
        ),
    )
    private var page2: List<Hero> = listOf(
        Hero(
            id = 4,
            name = "Sasuke",
            image = "/images/sasuke.jpg",
            about = "Sasuke Uchiha (うちはサスケ, Uchiha Sasuke) is one of the last surviving members of Konohagakure's Uchiha clan. After his older brother, Itachi, slaughtered their clan, Sasuke made it his mission in life to avenge them by killing Itachi. He is added to Team 7 upon becoming a ninja and, through competition with his rival and best friend, Naruto Uzumaki.",
            rating = 5.0,
            power = 98,
            month = "July",
            day = "23rd",
            family = listOf(
                "Fugaku",
                "Mikoto",
                "Itachi",
                "Sarada",
                "Sakura"
            ),
            abilities = listOf(
                "Sharingan",
                "Rinnegan",
                "Sussano",
                "Amateratsu",
                "Intelligence"
            ),
            natureTypes = listOf(
                "Lightning",
                "Fire",
                "Wind",
                "Earth",
                "Water"
            )
        ),
        Hero(
            id = 5,
            name = "Naruto",
            image = "/images/naruto.jpg",
            about = "Naruto Uzumaki (うずまきナルト, Uzumaki Naruto) is a shinobi of Konohagakure's Uzumaki clan. He became the jinchūriki of the Nine-Tails on the day of his birth — a fate that caused him to be shunned by most of Konoha throughout his childhood. After joining Team Kakashi, Naruto worked hard to gain the village's acknowledgement all the while chasing his dream to become Hokage.",
            rating = 5.0,
            power = 98,
            month = "Oct",
            day = "10th",
            family = listOf(
                "Minato",
                "Kushina",
                "Boruto",
                "Himawari",
                "Hinata"
            ),
            abilities = listOf(
                "Rasengan",
                "Rasen-Shuriken",
                "Shadow Clone",
                "Senin Mode"
            ),
            natureTypes = listOf(
                "Wind",
                "Earth",
                "Lava",
                "Fire"
            )
        ),
        Hero(
            id = 6,
            name = "Sakura",
            image = "/images/sakura.jpg",
            about = "Sakura Uchiha (うちはサクラ, Uchiha Sakura, née Haruno (春野)) is a kunoichi of Konohagakure. When assigned to Team 7, Sakura quickly finds herself ill-prepared for the duties of a shinobi. However, after training under the Sannin Tsunade, she overcomes this, and becomes recognised as one of the greatest medical-nin in the world.",
            rating = 4.5,
            power = 92,
            month = "Mar",
            day = "28th",
            family = listOf(
                "Kizashi",
                "Mebuki",
                "Sarada",
                "Sasuke"
            ),
            abilities = listOf(
                "Chakra Control",
                "Medical Ninjutsu",
                "Strength",
                "Intelligence"
            ),
            natureTypes = listOf(
                "Earth",
                "Water",
                "Fire"
            )
        )
    )
    private var page3: List<Hero> = listOf(
        Hero(
            id = 7,
            name = "Mitsuki",
            image = "/images/mitsuki.jpg",
            about = "Mitsuki (ミツキ, Mitsuki) is a synthetic human that was created as a partial clone of Orochimaru. Immigrating to Konohagakure to confirm whether or not Boruto Uzumaki was his \"sun\", he became a shinobi and was placed on Team Konohamaru. Mitsuki was created as a clone of Orochimaru, being cultivated from the same embryo as at least one older \"Mitsuki\", and raised in a test tube.",
            rating = 4.9,
            power = 95,
            month = "Jul",
            day = "25th",
            family = listOf(
                "Orochimaru",
                "Log"
            ),
            abilities = listOf(
                "Senin Mode",
                "Transformation",
                "Intelligence"
            ),
            natureTypes = listOf(
                "Lightning",
                "Wind"
            )
        ),
        Hero(
            id = 8,
            name = "Orochimaru",
            image = "/images/orochimaru.jpg",
            about = "Orochimaru (大蛇丸, Orochimaru) is one of Konohagakure's legendary Sannin. With a life-ambition to learn all of the world's secrets, Orochimaru seeks immortality so that he might live all of the lives necessary to accomplish his task. After being caught red-handed performing unethical experiments on his fellow citizens for the sake of this immortality, Orochimaru defected from Konoha.",
            rating = 4.5,
            power = 97,
            month = "Oct",
            day = "27th",
            family = listOf(
                "Mitsuki",
                "Log"
            ),
            abilities = listOf(
                "Senin Mode",
                "Transformation",
                "Science"
            ),
            natureTypes = listOf(
                "Lightning",
                "Wind",
                "Fire",
                "Earth",
                "Water"
            )
        ),
        Hero(
            id = 9,
            name = "Kakashi",
            image = "/images/kakashi.png",
            about = "Kakashi Hatake (はたけカカシ, Hatake Kakashi) is a shinobi of Konohagakure's Hatake clan. Famed as Kakashi of the Sharingan (写輪眼のカカシ, Sharingan no Kakashi), he is one of Konoha's most talented ninja, regularly looked to for advice and leadership despite his personal dislike of responsibility. To his students on Team 7, Kakashi emphasises the importance of teamwork; he himself received this lesson, along with the Sharingan, from his childhood friend, Obito Uchiha.",
            rating = 4.5,
            power = 96,
            month = "Sep",
            day = "15th",
            family = listOf(
                "Sakumo"
            ),
            abilities = listOf(
                "Intelligence",
                "Strength"
            ),
            natureTypes = listOf(
                "Lightning",
                "Wind",
                "Fire",
                "Earth",
                "Water"
            )
        )
    )
    private var page4: List<Hero> = listOf(
        Hero(
            id = 10,
            name = "Isshiki",
            image = "/images/ishiki.jpg",
            about = "A thousand years ago, Isshiki came to Earth alongside Kaguya with the objective to plant a Tree to harvest its Chakra Fruit. While Kaguya, being lower-ranked, was planned to be sacrificed to create the Chakra Fruit, she instead turned on Isshiki, leaving him on the verge of death after destroying Isshiki's lower half. Encountering Jigen and not having the strength to implant a Kāma on him, Isshiki devised a desperate plan and shrunk himself to enter the monk's ear in order to survive his injury by absorbing Jigen's nutrients.",
            rating = 5.0,
            power = 100,
            month = "Jan",
            day = "1st",
            family = listOf(
                "Otsutsuki Clan"
            ),
            abilities = listOf(
                "Sukunahikona",
                "Daikokuten",
                "Byakugan",
                "Space–Time",
                "Intelligence"
            ),
            natureTypes = listOf(
                "Fire"
            )
        ),
        Hero(
            id = 11,
            name = "Momoshiki",
            image = "/images/momoshiki.jpg",
            about = "Momoshiki Ōtsutsuki (大筒木モモシキ, Ōtsutsuki Momoshiki) was a member of the Ōtsutsuki clan's main family, sent to investigate the whereabouts of Kaguya and her God Tree and then attempting to cultivate a new one out of the chakra of the Seventh Hokage. In the process of being killed by Boruto Uzumaki, Momoshiki placed a Kāma on him, allowing his spirit to remain intact through the mark.",
            rating = 3.9,
            power = 98,
            month = "Jan",
            day = "1st",
            family = listOf(
                "Otsutsuki Clan"
            ),
            abilities = listOf(
                "Rinnegan",
                "Byakugan",
                "Strength"
            ),
            natureTypes = listOf(
                "Fire",
                "Lightning",
                "Wind",
                "Water",
                "Earth"
            )
        ),
        Hero(
            id = 12,
            name = "Urashiki",
            image = "/images/urashiki.jpg",
            about = "Urashiki Ōtsutsuki (大筒木ウラシキ, Ōtsutsuki Urashiki) was a low-ranking member of the Ōtsutsuki clan's main family, sent to assist Momoshiki and Kinshiki on their mission to investigate Kaguya's whereabouts and gather the chakra of the God Tree on Earth. Compared to his comrades, Urashiki had been shown to have a rather laid-back and jovial personality. He was quite willing to joke along with Momoshiki and Kinshiki, and disparaged on how serious they are.",
            rating = 3.4,
            power = 95,
            month = "Jan",
            day = "1st",
            family = listOf(
                "Otsutsuki Clan"
            ),
            abilities = listOf(
                "Space–Time",
                "Rinnegan",
                "Byakugan"
            ),
            natureTypes = listOf(
                "Fire",
                "Lightning",
                "Wind",
                "Earth"
            )
        )
    )
    private var page5: List<Hero> = listOf(
        Hero(
            id = 13,
            name = "Code",
            image = "/images/code.jpg",
            about = "Code (コード, Kōdo) is the last active Inner from Kara. Carrying Isshiki Ōtsutsuki's legacy within him, he inherits the Ōtsutsuki Clan's will to become a Celestial Being and continually evolve. At the time Kawaki was brought to Kara, Code was one of fifteen candidates in Jigen and Amado's Ōtsutsuki ritual to screen for a Kāma vessel for Isshiki. Only Kawaki survived to become an actual vessel.",
            rating = 4.8,
            power = 99,
            month = "Jan",
            day = "1st",
            family = listOf(
                "Unknown"
            ),
            abilities = listOf(
                "White Karma",
                "Transformation",
                "Genjutsu"
            ),
            natureTypes = listOf(
                "Unknown"
            )
        ),
        Hero(
            id = 14,
            name = "Amado",
            image = "/images/amado.jpg",
            about = "Amado (アマド, Amado) is a former Inner from the organisation Kara and the head of its research and development division. He has since defected to Konohagakure, where he used a mix of bluffs and gifts to gain official citizenship for the Hokage's protection. Amado had a daughter who died twelve years prior to the reign of the Seventh Hokage. In his quest to kill Isshiki Ōtsutsuki, Amado joined Kara and was granted the rank of Inner, serving as the head of its research and development division.",
            rating = 5.0,
            power = 90,
            month = "Jan",
            day = "1st",
            family = listOf(
                "Unknown"
            ),
            abilities = listOf(
                "Science",
                "Intelligence",
                "Trickery"
            ),
            natureTypes = listOf(
                "Unknown"
            )
        ),
        Hero(
            id = 15,
            name = "Koji",
            image = "/images/koji.jpg",
            about = "Koji Kashin (果心居士, Kashin Koji) is a clone of Jiraiya that was created by Amado for the purpose of killing Isshiki Ōtsutsuki. A former Inner of Kara, he was in charge of the sector on the outskirts of the Land of Fire. An enigmatic man, Koji has a very stoic and straightforward nature that follows a no-nonsense view. Arrogant as he may appear, he has consistently shown himself to be a very rational and perceptive man.",
            rating = 4.5,
            power = 90,
            month = "Jan",
            day = "1st",
            family = listOf(
                "Jiraiya"
            ),
            abilities = listOf(
                "Senin Mode",
                "Rasengan",
                "Shadow Clone"
            ),
            natureTypes = listOf(
                "Fire",
                "Earth"
            )
        )
    )

    private val heroes: Map<Int, List<Hero>> = mapOf(
        1 to page1,
        2 to page2,
        3 to page3,
        4 to page4,
        5 to page5,
    )

    fun clearData() {
        page1 = emptyList()
    }

    private var exception = false

    fun addException() {
        exception = true
    }

    override suspend fun getAllHeroes(page: Int): ApiResponse {
        if (exception) {
            throw IOException()
        }
        require(page in 1..heroes.size)
        return ApiResponse(
            success = true,
            message = "Ok",
            prevPage = calculatePage(page)["prevPage"],
            nextPage = calculatePage(page)["nextPage"],
            heroes = heroes[page]!!
        )
    }

    private fun calculatePage(page: Int): Map<String, Int?> {
        if (page1.isEmpty()) {
            return mapOf("prevPage" to null, "nextPage" to null)
        }
        var prevPage: Int? = null
        var nextPage: Int? = null

        if (page in 1..heroes.size - 1) {
            nextPage = page.plus(1)
        }
        if (page in 2..heroes.size) {
            prevPage = page.minus(1)
        }
        return mapOf("prevPage" to prevPage, "nextPage" to nextPage)
    }

    override suspend fun searchHeroes(name: String): ApiResponse {
        return ApiResponse(success = false)
    }
}