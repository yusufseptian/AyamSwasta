package com.tubes.ayamswasta

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.tubes.ayamswasta.data.model.Account
import com.tubes.ayamswasta.data.model.ResponseAction
import com.tubes.ayamswasta.data.repository.AccountRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AccountFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AccountFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val us_id = activity?.getSharedPreferences("account", Context.MODE_PRIVATE)?.getString("us_id","").toString()
        val view = inflater.inflate(R.layout.fragment_account, container, false)
        AccountRepository.getAccount().myAccount(
            "user/"+ us_id
        ).enqueue(object : Callback<Account>{
            override fun onResponse(call: Call<Account>, response: Response<Account>) {
                if(response.isSuccessful){
                    view.findViewById<TextView>(R.id.txtFullName).text = response.body()!!.us_fullname
                    view.findViewById<TextView>(R.id.txtPhone).text = response.body()!!.us_telepon
                    view.findViewById<TextView>(R.id.txtAddress).text = response.body()!!.us_alamat
                }
            }

            override fun onFailure(call: Call<Account>, t: Throwable) {
            }

        })
        view.findViewById<Button>(R.id.btnLogout).setOnClickListener { activity?.finish() }
        val ac = activity
        view.findViewById<Button>(R.id.btnDelete).setOnClickListener {
            AccountRepository.getAccount().deleteMe(
                us_id
            ).enqueue(object : Callback<ResponseAction>{
                override fun onResponse(
                    call: Call<ResponseAction>,
                    response: Response<ResponseAction>
                ) {
                    if(response.isSuccessful){
                        Toast.makeText(ac?.applicationContext,response.body()!!.messages,Toast.LENGTH_LONG).show()
                        ac?.finish()
                    }
                }

                override fun onFailure(call: Call<ResponseAction>, t: Throwable) {
                    Toast.makeText(ac?.applicationContext,t.toString(),Toast.LENGTH_LONG).show()
                }

            })
        }
        view.findViewById<Button>(R.id.btnEditAkun).setOnClickListener{
            AccountRepository.getAccount().updateMe(
                us_id,
                view.findViewById<EditText>(R.id.txtFullName).text.toString(),
                view.findViewById<EditText>(R.id.txtPhone).text.toString(),
                view.findViewById<EditText>(R.id.txtAddress).text.toString(),
            ).enqueue(object : Callback<ResponseAction>{
                override fun onResponse(
                    call: Call<ResponseAction>,
                    response: Response<ResponseAction>
                ) {
                    if(response.isSuccessful){
                        Toast.makeText(ac?.applicationContext, response.body()!!.messages, Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(ac?.applicationContext, "Error code " + response.code().toString(), Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<ResponseAction>, t: Throwable) {
                    Toast.makeText(ac?.applicationContext,t.toString(),Toast.LENGTH_LONG).show()
                }

            })
        }
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AccountFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AccountFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}