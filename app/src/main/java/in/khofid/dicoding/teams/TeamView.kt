package `in`.khofid.dicoding.teams

import `in`.khofid.dicoding.model.Team

interface TeamView {
    fun showLoading()
    fun hideLoading()
    fun showTeamList(data: List<Team>)
}