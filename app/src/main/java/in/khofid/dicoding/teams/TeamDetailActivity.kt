package `in`.khofid.dicoding.teams

import `in`.khofid.dicoding.Item
import `in`.khofid.dicoding.model.Team
import android.graphics.Typeface
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.abc_alert_dialog_material.view.*
import org.jetbrains.anko.*

class TeamDetailActivity : AppCompatActivity() {


    private lateinit var club: Team
    private lateinit var nameTextView: TextView
    private lateinit var imageView: ImageView
    private lateinit var detailView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initUI()

        val intent = intent
        club = intent.getParcelableExtra("club")
        club.teamBadge?.let { Picasso.get().load(it).into(imageView) }
        nameTextView.text = club.teamName
        detailView.text = club.teamDescription

    }

    fun initUI() {
        verticalLayout {
            padding = dip(6)

            scrollView {
                verticalLayout {
                    gravity = Gravity.CENTER_HORIZONTAL

                    imageView = imageView {}.lparams(width = dip(150), height = dip(150))
                    nameTextView = textView {
                        textSize = 20f
                        typeface = Typeface.DEFAULT_BOLD
                    }.lparams(width = wrapContent)
                    detailView = textView { textAlignment = TextView.TEXT_ALIGNMENT_CENTER }
                }
            }.lparams(width = matchParent, height = matchParent)

        }
    }
}