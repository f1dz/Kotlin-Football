package `in`.khofid.dicoding.detail

import `in`.khofid.dicoding.model.Team

interface TeamDetailView {
    fun showLoading()
    fun hideLoading()
    fun showTeamDetail(data: List<Team>)
}