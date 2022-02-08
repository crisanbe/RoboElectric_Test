package com.cursosandroidant.inventory.mainModule.viewModel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import junit.framework.TestCase
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers
import org.hamcrest.Matchers.*
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

//Con que version de android va ejecutar las pruebas
//@Config(sdk = [21,22,30])
//todo- Otra forma
@Config(maxSdk = 30)
@RunWith(AndroidJUnit4::class)
class MainViewModelTest : TestCase() {
    @get:Rule//Arquitectura de componentes para las pruebas unitarias
    var instantExcecutorRule = InstantTaskExecutorRule()


    @Test
    fun checkWelcomeTest(){
        val mainViewModel = MainViewModel(ApplicationProvider.getApplicationContext())//class MainViewModel(application: Application) nesecita un contesto
        val observer = Observer<Boolean>{}//inicializa el observador


        try {
            mainViewModel.isWelcome().observeForever(observer)
            val result = mainViewModel.isWelcome().value
            assertThat(result, not(nullValue()))
            assertThat(result, `is`(true))
        } finally {
            mainViewModel.isWelcome().removeObserver(observer)
        }

    }
}