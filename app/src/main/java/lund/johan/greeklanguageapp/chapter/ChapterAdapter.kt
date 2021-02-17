package lund.johan.greeklanguageapp.chapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
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
            //chapterImg.setOnClickListener{ navigateToScreen(smallIds[adapterPosition])}
            //chapterInfo.setOnClickListener{ navigateToScreen(smallIds[adapterPosition])}
        }
    }

    //this has to change
    fun navigateToScreen(chapterId: Int) {
        //val action = ChapterItemsFragmentDirections.actionChaptersToChapter(chapterId);
        //NavHostFragment.findNavController(usingFragment).navigate(action);
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
        viewHolder.chapterInfo.text = Repository.getSmallImgTxt((smallIds[position]))
        Repository.loadSmallImageInto(smallIds[position], viewHolder.chapterImg)
    }

    override fun getItemCount() = smallIds.size

}