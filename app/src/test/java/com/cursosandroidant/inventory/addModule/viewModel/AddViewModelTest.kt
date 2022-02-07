package com.cursosandroidant.inventory.addModule.viewModel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.cursosandroidant.inventory.entities.Product
import junit.framework.TestCase
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AddViewModelTest : TestCase() {
    @get:Rule//Arquitectura de componentes para las pruebas unitarias
    var instantExcecutorRule = InstantTaskExecutorRule()

    @Test//queremos ver si el valor cambia
    fun addProductTest() {
        val addViewModel = AddViewModel()
        val product = Product(
            117, "Play 5", 30, "https://larepublica.pe/resizer/" +
                    "VFAbZhNU9NpJqLL6YhWZhb5SZEk=/1250x735/top/smart/" +
                    "cloudfront-us-east-1.images.arcpublishing." +
                    "com/gruporepublica/FFAVLEGGXFEMZARKYLCZ7DZQ7Y.png", 4.8, 56
        )
        //creamos el observador para simular
        val observer = Observer<Boolean> {}

        try {
            addViewModel.getResult().observeForever(observer)//Inicilizamos el observer
            addViewModel.addProduct(product)
            val result = addViewModel.getResult().value
            assertThat(result, `is`(true))
            //assertThat(result, not(nullValue())) opcional
        } finally {
            addViewModel.getResult().removeObserver(observer)//removemos el observador
        }

    }


}


