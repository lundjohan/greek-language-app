package lund.johan.greeklanguageapp.chapterItems

import android.content.res.AssetManager
import android.graphics.BitmapFactory
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.RecyclerView
import lund.johan.greeklanguageapp.R
import java.io.InputStream


class ChapterItemsAdapter(
    private val usingFragment: Fragment,
    private val dataSet: Array<ChapterTeaser>
) : RecyclerView.Adapter<ChapterItemsAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val chapterImg: ImageView = view.findViewById(R.id.image)
        val chapterInfo: TextView = view.findViewById(R.id.info_text);

        init {
            chapterImg.setOnClickListener{ navigateToChapter(adapterPosition)}
            chapterInfo.setOnClickListener{ navigateToChapter(adapterPosition)}
        }


    }
    fun navigateToChapter(chapterId: Int) {
        val action: ChapterItemsFragmentDirections.ActionChaptersToChapter =
            ChapterItemsFragmentDirections.actionChaptersToChapter().setIdChapter(chapterId);

        NavHostFragment.findNavController(usingFragment).navigate(action);
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.chapter_item, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val teaser: ChapterTeaser = dataSet[position]
        viewHolder.chapterInfo.text = teaser.txt
        viewHolder.chapterImg.setImageResource(teaser.imgId)
    }

    override fun getItemCount() = dataSet.size

}
