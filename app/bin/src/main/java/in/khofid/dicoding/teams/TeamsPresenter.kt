package `in`.khofid.dicoding.teams

import `in`.khofid.dicoding.api.ApiRepository
import `in`.khofid.dicoding.api.TheSportDBApi
import `in`.khofid.dicoding.model.TeamResponse
import `in`.khofid.dicoding.utils.CoroutineContextProvider
import com.google.gson.Gson
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.coroutines.experimental.bg

class TeamsPresenter(private val view: TeamView,
                     private val apiRepository: ApiRepository,
                     private val gson: Gson,
                     private val context: CoroutineContextProvider = CoroutineContextProvider()) {

    fun getTeamList(league: String?){
        view.showLoading()
        async(context.main) {
            val data = bg {
                gson.fromJson(
                        apiRepository.doRequest(TheSportDBApi.getTeams(league)),
                        TeamResponse::class.java
                )
            }
                view.showTeamList(data.await().teams)
                view.hideLoading()
        }
    }
}