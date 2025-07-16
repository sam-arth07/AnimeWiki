package com.example.animewiki.domain.use_cases.get_selected_hero

import com.example.animewiki.data.repository.Repository
import com.example.animewiki.domain.model.Hero

class GetSelectedHeroUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke(heroId: Int): Hero {
        return repository.getSelectedHero(heroId = heroId)
    }
}