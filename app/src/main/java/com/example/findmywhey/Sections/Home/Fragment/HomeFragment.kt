package com.example.findmywhey.Sections.Home.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.findmywhey.Adapter.ProdutosAdapter
import com.example.findmywhey.Model.ProdutoContentful
import com.example.findmywhey.Sections.DetailsProduct.DetailsProductActivity
import com.example.findmywhey.Sections.Home.dataProviders.HomeDataProvider
import com.example.findmywhey.Support.Base.BaseFragment
import com.example.findmywhey.Support.Base.startWithDataFragment
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

        return inflater.inflate(com.example.findmywhey.R.layout.fragment_home, container, false)
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
        val horizontalLayoutManagaer = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        recycler_view_produtos_topo.layoutManager = horizontalLayoutManagaer
        recycler_view_produtos_topo.adapter = adapter
        adapter?.notifyDataSetChanged()

    }

    override fun produtoClicked(position: Int) {

        presenter.loadInformation(position)

    }

    override fun openProduto(produto: ProdutoContentful) {

        context?.let { startWithDataFragment<DetailsProductActivity>(PRODUCT_SERIALIZED, produto, false, it) }

    }

    companion object {

        var PRODUCT_SERIALIZED = "produtoSerializado"

    }

}
