package `in`.khofid.dicoding.teams

import `in`.khofid.dicoding.api.ApiRepository
import `in`.khofid.dicoding.api.TheSportDBApi
import `in`.khofid.dicoding.model.TeamResponse
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class TeamsPresenter(private val view: TeamView,
                     private val apiRepository: ApiRepository,
                     private val gson: Gson) {

    fun getTeamList(league: String?){
        view.showLoading()
        doAsync {
            val data = gson.fromJson(
                    apiRepository.doRequest(TheSportDBApi.getTeams(league)),
                    TeamResponse::class.java
            )
            uiThread {
                view.hideLoading()
                view.showTeamList(data.teams)
            }
        }
    }
}