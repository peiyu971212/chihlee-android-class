package com.example.shopdemoapp.ui.product

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shopdemoapp.R
import com.example.shopdemoapp.api.ProductApi
import com.example.shopdemoapp.api.AppClientManager
import com.example.shopdemoapp.data.Product
import com.example.shopdemoapp.data.ProductsResponse
import com.example.shopdemoapp.databinding.FragmentProductsBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductsFragment : Fragment() {

    private var _binding: FragmentProductsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val productList: ArrayList<Product> = arrayListOf()
    private lateinit var productAdapter: ProductAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val productsViewModel =
            ViewModelProvider(this).get(ProductsViewModel::class.java)

        _binding = FragmentProductsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rvProduct = view.findViewById<RecyclerView>(R.id.rv_product)

        // 一筆資料效果
//        val detail = ProductDetail(
//            productId = 1,
//            productName = "商品1",
//            productPrice = 400,
//            productImageUrl = "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg",
//            productDescription = "商品1The Nike Air Max 270 React ENG combines a full-length React foam midsole with a 270 Max Air unit for unrivaled comfort and a striking visual experience."
//        )
//        productList.add(detail)
//        productAdapter = ProductAdapter(productList)
//        rvCart?.layoutManager =
//            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
//        rvCart?.adapter = productAdapter

        val apiServer = AppClientManager.client.create(ProductApi::class.java)
        apiServer.getProductListResponse().enqueue(object :
            Callback<ProductsResponse> {
            override fun onResponse(
                call: Call<ProductsResponse>,
                response: Response<ProductsResponse>
            ) {

                response.body()?.data?.let {
                    productList.addAll(it)
                }
                productAdapter = ProductAdapter(productList,requireContext())
                rvProduct?.layoutManager =
                    LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
                rvProduct?.adapter = productAdapter

            }

            override fun onFailure(call: Call<ProductsResponse>, t: Throwable) {
                Log.d("TAG", "onFailure: fail${t.message}")
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}