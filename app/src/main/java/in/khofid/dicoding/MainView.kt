package `in`.khofid.dicoding

import `in`.khofid.dicoding.model.Team

interface MainView {
    fun showLoading()
    fun hideLoading()
    fun showTeamList(data: List<Team>)
}