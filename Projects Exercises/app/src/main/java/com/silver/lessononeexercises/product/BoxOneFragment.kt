package com.silver.lessononeexercises.product


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.silver.lessononeexercises.R
import com.silver.lessononeexercises.adapters.ProductAdapter
import com.silver.lessononeexercises.model.ProductEntity
import kotlinx.android.synthetic.main.fragment_box_one.*
import java.lang.RuntimeException

/**
 * A simple [Fragment] subclass.
 */
class BoxOneFragment : Fragment() {

    private var listener : OnProductListener? = null

    private var products = mutableListOf<ProductEntity>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_box_one, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnProductListener){
            listener = context
        }else{
            throw RuntimeException("$context must implement OnProductListener")
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setData()
        context?.let {
            lv_product.adapter = ProductAdapter(it, products)
        }

        lv_product.setOnItemClickListener { _,_,i,_ ->
            listener?.let {
                it.selectedItemProduct(products[i])
            }
        }

        listener?.renderFirst(first())
    }

    private fun setData() {
        val product1 = ProductEntity(1, "product1", "S/ 20.0", R.mipmap.fruit_1, "The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested. Sections 1.10.32 and 1.10.33 from \"de Finibus Bonorum et Malorum\" by Cicero are also reproduced in their exact original form, accompanied by English versions from the 1914 translation by H. Rackham.")
        val product2 = ProductEntity(2, "product2", "S/ 21.0", R.mipmap.fruit_2, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In fringilla mi nulla, vitae faucibus purus tincidunt et. Aenean a finibus nisl, vitae gravida dolor. Pellentesque a lacus sapien. Nam odio leo, laoreet sit amet sodales at, vestibulum ac felis. In feugiat tortor justo, id consequat quam egestas quis. Pellentesque interdum justo et augue commodo, vel pharetra velit suscipit. Nunc in augue iaculis, auctor urna varius, efficitur tortor. ")
        val product3 = ProductEntity(3, "product3", "S/ 22.0", R.mipmap.fruit_3, "TAliquam sit amet iaculis mi. Donec lobortis, elit eget hendrerit blandit, felis enim maximus elit, at finibus diam ex vel lectus. Nulla facilisi. Donec ultrices nisl eget porta mollis. Nunc tortor tellus, sollicitudin quis elit vitae, sagittis pretium massa. Proin et sem sit amet diam tempus mattis sit amet at dolor.")
        val product4 = ProductEntity(4, "product4", "S/ 23.0", R.mipmap.fruit_4, " id interdum sem scelerisque vitae. Donec vulputate dapibus laoreet. Pellentesque imperdiet diam massa, non posuere nibh tristique ac. Suspendisse venenatis et ipsum in cursus. Donec massa nunc, semper sit amet ultricies vel, commodo in massa. Fusce eget dictum ipsum, et laoreet diam. Maecenas vestibulum ultrices ipsum in sodales.")
        val product5 = ProductEntity(5, "product5", "S/ 24.0", R.mipmap.fruit_5, "n hac habitasse platea dictumst. Quisque non nunc ac mauris viverra tempus lobortis at nulla. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis interdum ultricies facilisis. Sed sodales et felis ut lacinia. Mauris ac sagittis nulla. Nullam nec lobortis sem, ut imperdiet neque. Duis vitae interdum dolor, sit amet cursus neque.")
        val product6 = ProductEntity(6, "product6", "S/ 25.0", R.mipmap.fruit_6, "Donec vitae dapibus nisi. Mauris sapien magna, rhoncus et aliquet quis, convallis ut lorem. Pellentesque pulvinar justo magna, vel sagittis sem auctor eget. Aenean tristique risus eget vehicula dignissim. Nulla aliquam consequat ex eu fermentum.")

        products.add(product1)
        products.add(product2)
        products.add(product3)
        products.add(product4)
        products.add(product5)
        products.add(product6)
    }

    private fun first(): ProductEntity? {
        products?.let {
            return it[0]
        }
        return null
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }
}
