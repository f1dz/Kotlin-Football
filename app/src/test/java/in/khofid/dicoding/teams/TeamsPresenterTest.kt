package `in`.khofid.dicoding.teams

import `in`.khofid.dicoding.TestContextProvider
import `in`.khofid.dicoding.api.ApiRepository
import `in`.khofid.dicoding.api.TheSportDBApi
import `in`.khofid.dicoding.model.Team
import `in`.khofid.dicoding.model.TeamResponse
import com.google.gson.Gson
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

class TeamsPresenterTest {

    @Mock private lateinit var view: TeamView
    @Mock private lateinit var gson: Gson
    @Mock private lateinit var apiRepository: ApiRepository

    private lateinit var presenter: TeamsPresenter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = TeamsPresenter(view, apiRepository, gson, TestContextProvider())
    }

    @Test
    fun getTeamList(){
        val teams: MutableList<Team> = mutableListOf()
        val response =TeamResponse(teams)

        val league = "English Premiere League"

        `when`(
                gson.fromJson(apiRepository.doRequest(TheSportDBApi.getTeams(league)), TeamResponse::class.java)
        ).thenReturn(response)

        presenter.getTeamList(league)

        verify(view).showLoading()
        verify(view).showTeamList(teams)
        verify(view).hideLoading()
    }
}