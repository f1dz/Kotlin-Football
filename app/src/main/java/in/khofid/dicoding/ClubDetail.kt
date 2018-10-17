package `in`.khofid.dicoding

import android.graphics.Typeface
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import org.jetbrains.anko.*

class ClubDetail : AppCompatActivity(){


    private lateinit var club: Item
    private lateinit var nameTextView: TextView
    private lateinit var imageView: ImageView
    private lateinit var detailView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initUI()

        val intent = intent
        club = intent.getParcelableExtra("club")
        club.image?.let { Picasso.get().load(it).into(imageView) }
        nameTextView.text = club.name
        detailView.text = club.detail

    }

    fun initUI() {
        verticalLayout {
            padding = dip(6)
            gravity = Gravity.CENTER_HORIZONTAL

            imageView = imageView{}.lparams(width = dip(150), height = dip(150))
            nameTextView = textView{
                textSize = 20f
                typeface = Typeface.DEFAULT_BOLD
            }.lparams(width = wrapContent)
            detailView = textView{ textAlignment = TextView.TEXT_ALIGNMENT_CENTER}

        }
    }
}