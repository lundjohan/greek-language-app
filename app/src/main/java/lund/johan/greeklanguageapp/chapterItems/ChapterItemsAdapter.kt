package lund.johan.greeklanguageapp.chapterItems

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.RecyclerView
import lund.johan.greeklanguageapp.R
import lund.johan.greeklanguageapp.repository.DaggerRepositoryFactory


class ChapterItemsAdapter(
    private val usingFragment: Fragment,
    private val ids: IntArray
) : RecyclerView.Adapter<ChapterItemsAdapter.ViewHolder>() {
    private val repo = DaggerRepositoryFactory.create().repo()

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val chapterImg: ImageView = view.findViewById(R.id.small_image)
        val chapterInfo: TextView = view.findViewById(R.id.info_long_text);

        init {
            chapterImg.setOnClickListener{ navigateToChapter(ids[adapterPosition])}
            chapterInfo.setOnClickListener{ navigateToChapter(ids[adapterPosition])}
        }
    }
    fun navigateToChapter(chapterId: Int) {
        val action = ChapterItemsFragmentDirections.actionChaptersToChapter(chapterId);
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
        viewHolder.chapterInfo.text = repo.getImgTxt(ids[position])
        repo.loadImageInto(ids[position], viewHolder.chapterImg)
    }

    override fun getItemCount() = ids.size

}
