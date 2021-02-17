package lund.johan.greeklanguageapp.chapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import lund.johan.greeklanguageapp.chapterItems.ChapterItemsAdapter
import lund.johan.greeklanguageapp.databinding.FragmentChapterBinding
import lund.johan.greeklanguageapp.repository.Repository


class ChapterFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val idChapter = ChapterFragmentArgs.fromBundle(requireArguments()).idChapter
        // Inflate the layout for this fragment
        val binding =
            FragmentChapterBinding.inflate(inflater, container, false)
        binding.toolbar.title = Repository.getImgTxt(idChapter)
        Repository.loadImageInto(idChapter,binding.topImage)


        //initiate RecyclerView
        //line below will be replaced by repository
        val idsArr = Repository.getAllChapterPartsIds(idChapter)

        val linearLayoutManager = LinearLayoutManager(context)
        binding.lessons.layoutManager = linearLayoutManager
        val adapter = ChapterAdapter(this, idsArr)
        binding.lessons.adapter = adapter
        return binding.root
    }
}