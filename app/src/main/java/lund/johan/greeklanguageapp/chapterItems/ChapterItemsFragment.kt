package lund.johan.greeklanguageapp.chapterItems

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import lund.johan.greeklanguageapp.databinding.FragmentChapterItemsBinding
import lund.johan.greeklanguageapp.repository.Repository

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
        val idsArr = Repository.getAllIds()

        val linearLayoutManager = LinearLayoutManager(context)
        binding.chapterItems.layoutManager = linearLayoutManager
        val adapter: ChapterItemsAdapter = ChapterItemsAdapter(this, idsArr)
        binding.chapterItems.adapter = adapter
        return binding.root
    }
}