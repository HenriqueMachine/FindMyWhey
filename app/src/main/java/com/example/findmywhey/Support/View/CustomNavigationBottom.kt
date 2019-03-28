package com.example.findmywhey.Support.View

import android.animation.Animator
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.animation.DecelerateInterpolator
import android.widget.*
import com.example.findmywhey.R

/**
 * Created by Henrique Menezes da Paixão on 27/03/19.
 */
class CustomNavigationBottom: RelativeLayout {

    private var bt_home: LinearLayout? = null
    private var bt_desconto: LinearLayout? = null
    private var bt_abastecer: ImageButton? = null
    private var bt_pesquisa: LinearLayout? = null
    private var bt_menu: LinearLayout? = null

    private var imageview_bt_home: ImageView? = null
    private var imageview_bt_desconto: ImageView? = null
    private var imageview_bt_pesquisa: ImageView? = null
    private var imageview_bt_menu: ImageView? = null

    private var textview_bt_home: TextView? = null
    private var textview_bt_desconto: TextView? = null
    private var textview_bt_pesquisa: TextView? = null
    private var textview_bt_menu: TextView? = null
    private var selectedItemPosition : ((Int) -> Unit)? = null
    private var positioSelected = -1

    companion object {
        val ITEM_HOME = 0
        val ITEM_HISTORICO = 1
        val ITEM_CARRINHO = -1
        val ITEM_PESQUISA = 2
        val ITEM_MENU = 3
    }

    constructor(context: Context) : super(context) {
        initControl(context)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        initControl(context,attrs)
    }

    constructor(context: Context, attrs: AttributeSet,
                defStyle: Int) : super(context, attrs, defStyle) {
        initControl(context,attrs)
    }

    private fun initControl(context: Context, attrs: AttributeSet? = null) {

        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(R.layout.action_bar_bottom_home, this)

        confViews()

    }

    private fun confViews() {

        bt_home = findViewById(R.id.bt_home)
        bt_desconto = findViewById(R.id.bt_historico)
        bt_abastecer = findViewById(R.id.bt_carrinho)
        bt_pesquisa = findViewById(R.id.bt_pesquisa)
        bt_menu = findViewById(R.id.bt_menu)

        imageview_bt_home = findViewById(R.id.imageview_bt_home)
        imageview_bt_desconto = findViewById(R.id.imageview_bt_historico)
        imageview_bt_pesquisa = findViewById(R.id.imageview_bt_pesquisa)
        imageview_bt_menu = findViewById(R.id.imageview_bt_menu)

        textview_bt_home = findViewById(R.id.textview_bt_home)
        textview_bt_desconto = findViewById(R.id.textview_bt_historico)
        textview_bt_pesquisa = findViewById(R.id.textview_bt_pesquisa)
        textview_bt_menu = findViewById(R.id.textview_bt_menu)

        bt_home?.setOnClickListener {
            if (bt_home?.isSelected != true) {

                positioSelected = ITEM_HOME
                setItemSelected(ITEM_HOME)
                selectedItemPosition?.invoke(ITEM_HOME)

            }

        }

        bt_desconto?.setOnClickListener {
            if (bt_desconto?.isSelected != true) {

                positioSelected = ITEM_HISTORICO
                setItemSelected(ITEM_HISTORICO)
                selectedItemPosition?.invoke(ITEM_HISTORICO)

            }

        }

        bt_pesquisa?.setOnClickListener {
            if (bt_pesquisa?.isSelected != true) {

                positioSelected = ITEM_PESQUISA
                setItemSelected(ITEM_PESQUISA)
                selectedItemPosition?.invoke(ITEM_PESQUISA)

            }

        }

        bt_menu?.setOnClickListener {
            if (bt_menu?.isSelected != true) {

                positioSelected = ITEM_MENU
                setItemSelected(ITEM_MENU)
                selectedItemPosition?.invoke(ITEM_MENU)

            }

        }

        bt_abastecer?.setOnClickListener {
            selectedItemPosition?.invoke(ITEM_CARRINHO)
        }

    }

    fun setstelectedListern(selectedItemPosition : ((Int) -> Unit)?){
        this.selectedItemPosition = selectedItemPosition
    }

    fun getPositionSelected():Int{
        return positioSelected
    }

    fun performClickProsition(position:Int){
        when(position){
            ITEM_HOME -> bt_home?.performClick()
            ITEM_HISTORICO -> bt_desconto?.performClick()
            ITEM_PESQUISA -> bt_pesquisa?.performClick()
            ITEM_MENU -> bt_menu?.performClick()
        }
    }

    private fun setItemSelected(position: Int){

        when(position){
            0 ->{
                if (bt_home?.isSelected != true) {
                    bt_home?.isSelected = true
                    imageview_bt_home?.isSelected = true
                    startAnimationFadeInUp(textview_bt_home, 200)
                }
            }
            1 ->{
                if (bt_desconto?.isSelected != true) {
                    bt_desconto?.isSelected = true
                    imageview_bt_desconto?.isSelected = true
                    startAnimationFadeInUp(textview_bt_desconto, 200)
                }
            }

            2 ->{
                if (bt_pesquisa?.isSelected != true) {
                    bt_pesquisa?.isSelected = true
                    imageview_bt_pesquisa?.isSelected = true
                    startAnimationFadeInUp(textview_bt_pesquisa, 200)
                }
            }

            3 ->{
                if (bt_menu?.isSelected != true) {
                    bt_menu?.isSelected = true
                    imageview_bt_menu?.isSelected = true
                    startAnimationFadeInUp(textview_bt_menu, 200)
                }
            }
        }

        if (bt_home?.isSelected!! && position != 0) {

            bt_home?.isSelected = false
            imageview_bt_home?.isSelected = false
            startAnimationFadeInUpReverse(textview_bt_home,0, object : Animator.AnimatorListener{
                override fun onAnimationRepeat(animation: Animator?) {

                }

                override fun onAnimationEnd(animation: Animator?) {
                    textview_bt_home?.visibility = View.GONE
                }

                override fun onAnimationCancel(animation: Animator?) {
                }

                override fun onAnimationStart(animation: Animator?) {
                }

            })

        }

        if (bt_desconto?.isSelected!! && position != 1) {

            bt_desconto?.isSelected = false
            imageview_bt_desconto?.isSelected = false
            startAnimationFadeInUpReverse(textview_bt_desconto,200, object : Animator.AnimatorListener{
                override fun onAnimationRepeat(animation: Animator?) {

                }

                override fun onAnimationEnd(animation: Animator?) {
                    textview_bt_desconto?.visibility = View.GONE
                }

                override fun onAnimationCancel(animation: Animator?) {
                }

                override fun onAnimationStart(animation: Animator?) {
                }

            })

        }

        if (bt_pesquisa?.isSelected!! && position != 2) {

            bt_pesquisa?.isSelected = false
            imageview_bt_pesquisa?.isSelected = false
            startAnimationFadeInUpReverse(textview_bt_pesquisa,200, object : Animator.AnimatorListener{
                override fun onAnimationRepeat(animation: Animator?) {

                }

                override fun onAnimationEnd(animation: Animator?) {
                    textview_bt_pesquisa?.visibility = View.GONE
                }

                override fun onAnimationCancel(animation: Animator?) {
                }

                override fun onAnimationStart(animation: Animator?) {
                }

            })

        }

        if (bt_menu?.isSelected!! && position != 3) {

            bt_menu?.isSelected = false
            imageview_bt_menu?.isSelected = false
            startAnimationFadeInUpReverse(textview_bt_menu,200, object : Animator.AnimatorListener{
                override fun onAnimationRepeat(animation: Animator?) {

                }

                override fun onAnimationEnd(animation: Animator?) {
                    textview_bt_menu?.visibility = View.GONE
                }

                override fun onAnimationCancel(animation: Animator?) {
                }

                override fun onAnimationStart(animation: Animator?) {
                }

            })

        }
    }

    fun startAnimationFadeInUpReverse(view: View?, delay: Long, listern: Animator.AnimatorListener? = null) {
        val animator2 = view?.animate()
        view?.alpha = 1f
        view?.translationY = 0f
        view?.visibility = View.VISIBLE
        val animationValue2 = if (view?.alpha == 0f) 1f else 0f
        animator2?.alpha(animationValue2)
        animator2?.translationY(50f)
        animator2?.interpolator = DecelerateInterpolator()
        animator2?.startDelay = delay
        animator2?.setListener(listern)
        animator2?.start()
    }

    fun startAnimationFadeInUp(view: View?, delay: Long, listern:Animator.AnimatorListener? = null) {
        val animator2 = view?.animate()
        view?.alpha = 0f
        view?.translationY = 50f
        view?.visibility = View.VISIBLE
        val animationValue2 = if (view?.alpha == 0f) 1f else 0f
        animator2?.alpha(animationValue2)
        animator2?.translationY(0f)
        animator2?.interpolator = DecelerateInterpolator()
        animator2?.startDelay = delay
        animator2?.setListener(listern)
        animator2?.start()
    }

}