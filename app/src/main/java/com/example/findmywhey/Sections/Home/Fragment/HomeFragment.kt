package com.example.findmywhey.Sections.Home.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.findmywhey.Adapter.ProdutosAdapter
import com.example.findmywhey.Model.ProdutoContentful
import com.example.findmywhey.R
import com.example.findmywhey.Sections.Home.dataProviders.HomeDataProvider
import com.example.findmywhey.Support.Base.BaseFragment
import kotlinx.android.synthetic.main.fragment_home.*


/**
 * Created by Henrique Menezes da Paixão on 27/03/19.
 */
class HomeFragment : BaseFragment(), HomeFragmentContract.UserView, ProdutosAdapter.ProdutoClicadoListern{

    private var adapter : ProdutosAdapter? = null

    private val presenter : HomeFragmentContract.UserActionListener<HomeFragmentContract.UserView> by lazy {
        HomeFragmentPresenter(context = activity, view = this, dataProvider = HomeDataProvider())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        try {
            container?.clearDisappearingChildren()
        }catch (e: Exception){

        }

        container?.removeAllViews()

        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()

    }

    private fun initViews(){

        presenter.loadProdutos()

    }

    override fun showProdutos(list: ArrayList<ProdutoContentful>?) {

        adapter = ProdutosAdapter(list!!, this.context!!,this)
        recycler_view_produtos_topo.adapter = adapter
        adapter?.notifyDataSetChanged()

    }

    override fun produtoClicked(position: Int) {

        Toast.makeText(context, "A", Toast.LENGTH_SHORT).show()

    }


}
