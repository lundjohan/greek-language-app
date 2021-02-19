package lund.johan.greeklanguageapp.chapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.RecyclerView
import lund.johan.greeklanguageapp.R
import lund.johan.greeklanguageapp.repository.Repository

class ChapterAdapter (
    private val usingFragment: Fragment,
    private val smallIds: IntArray
) : RecyclerView.Adapter<ChapterAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val chapterImg: ImageView = view.findViewById(R.id.small_image)
        val chapterInfo: TextView = view.findViewById(R.id.info_long_text);

        init {
            view.setOnClickListener{navigateToScreen(smallIds[adapterPosition])}
            //chapterImg.setOnClickListener{ navigateToScreen(smallIds[adapterPosition])}
            //chapterInfo.setOnClickListener{ navigateToScreen(smallIds[adapterPosition])}
        }
    }

    //this has to change => now every item is going to same video.
    fun navigateToScreen(id: Int) {
        val action = ChapterFragmentDirections.actionChapterToVideoplayer(usingFragment.getString(R.string.video_url));
        NavHostFragment.findNavController(usingFragment).navigate(action);
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.chapter_part_item, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.chapterInfo.text = Repository.getSmallImgTxt((smallIds[position]))
        Repository.loadSmallImageInto(smallIds[position], viewHolder.chapterImg)
    }

    override fun getItemCount() = smallIds.size

}