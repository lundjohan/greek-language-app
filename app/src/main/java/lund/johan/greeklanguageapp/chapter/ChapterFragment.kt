package lund.johan.greeklanguageapp.chapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.CollapsingToolbarLayout
import lund.johan.greeklanguageapp.databinding.FragmentChapterBinding
import lund.johan.greeklanguageapp.repository.DaggerRepositoryFactory

/**
 * This Fragment contains a list of the Chapter's various material, such as films, wordgames etc
 */
class ChapterFragment : Fragment() {
    var idChapter:Int = -1
    lateinit var appBarLayout: AppBarLayout
    lateinit var collapsingToolbar: CollapsingToolbarLayout
    private val repo = DaggerRepositoryFactory.create().repo()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        idChapter = ChapterFragmentArgs.fromBundle(requireArguments()).idChapter

        // Inflate the layout for this fragment
        val binding =
            FragmentChapterBinding.inflate(inflater, container, false)
        appBarLayout = binding.appBarLayout
        collapsingToolbar = binding.collapsingToolbar

        onlyShowTitleWhenAppBarIsCollapsed()
        repo.loadImageInto(idChapter,binding.topImage)

        //initiate RecyclerView
        val idsArr = repo.getAllChapterPartsIds(idChapter)

        val linearLayoutManager = LinearLayoutManager(context)
        binding.lessons.layoutManager = linearLayoutManager
        val adapter = ChapterAdapter(this, idsArr)
        binding.lessons.adapter = adapter
        return binding.root
    }

    //method copied from https://stackoverflow.com/questions/31662416/show-collapsingtoolbarlayout-title-only-when-collapsed
    private fun onlyShowTitleWhenAppBarIsCollapsed() {
        var isShow = true
        var scrollRange = -1
        appBarLayout.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { barLayout, verticalOffset ->
            if (scrollRange == -1){
                scrollRange = barLayout?.totalScrollRange!!
            }
            if (scrollRange + verticalOffset <= 0){
                collapsingToolbar.title = repo.getImgTxt(idChapter)
                isShow = true
            } else if (isShow){
                collapsingToolbar.title = " " //careful there should a space between double quote otherwise it wont work
                isShow = false
            }
        })
    }
}