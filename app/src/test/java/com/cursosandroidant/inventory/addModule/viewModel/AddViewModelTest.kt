package com.cursosandroidant.inventory.addModule.viewModel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import junit.framework.TestCase
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AddViewModelTest : TestCase(){
    @get:Rule//Arquitectura de componentes para las pruebas unitarias
    var instantExcecutorRule = InstantTaskExecutorRule()

    @Test//queremos ver si el valor cambia
    fun addProductTest(){

    }


}