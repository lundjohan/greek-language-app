package lund.johan.greeklanguageapp.chapterItems

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import lund.johan.greeklanguageapp.databinding.FragmentChapterItemsBinding

class ChapterItemsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentChapterItemsBinding =
            FragmentChapterItemsBinding.inflate(inflater, container, false)

        //initiate RecyclerView
          //line below will be replaced by repository
        val dataset: Array<ChapterTeaser> = arrayOf(
            ChapterTeaser(0,"The Acropolis"),
            ChapterTeaser(1, "Greek Food")
        )

        val linearLayoutManager: LinearLayoutManager = LinearLayoutManager(context)
        binding.chapterItems.layoutManager = linearLayoutManager
        val adapter: ChapterItemsAdapter = ChapterItemsAdapter(this, dataset)
        binding.chapterItems.adapter = adapter
        return binding.root
    }
}