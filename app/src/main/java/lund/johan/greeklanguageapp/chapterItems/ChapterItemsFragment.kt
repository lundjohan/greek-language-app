package lund.johan.greeklanguageapp.chapterItems

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import lund.johan.greeklanguageapp.MainActivity
import lund.johan.greeklanguageapp.R
import lund.johan.greeklanguageapp.databinding.FragmentChapterItemsBinding

class ChapterItemsFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //(requireActivity() as MainActivity).supportActionBar!!.hide()


    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentChapterItemsBinding =
            FragmentChapterItemsBinding.inflate(inflater, container, false)



        //initiate RecyclerView
        //line below will be replaced by repository
        val dataset: Array<ChapterTeaser> = arrayOf(
            ChapterTeaser(R.drawable.acropolis_5_3, "The Acropolis"),
            ChapterTeaser(R.drawable.greek_food_5_3, "Greek Food"),
            ChapterTeaser(R.drawable.mycenae_5_3, "Mycenae")
        )

        val linearLayoutManager = LinearLayoutManager(context)
        binding.chapterItems.layoutManager = linearLayoutManager
        val adapter: ChapterItemsAdapter = ChapterItemsAdapter(this, dataset)
        binding.chapterItems.adapter = adapter
        return binding.root
    }
}